/**
 * 
 */
var space_container;
var WebGL_Container;
var view_container;
var layer_control;
var layer_container;
var element_control;
var element_container;

var webgl_control;

var _offset;

var upload_url = "http://file.joy-homeplus.com/pano/fs/upload";

var upload_data;

var house_style_sn;

var space_sn;

var view_sn;

var edit_element;

var edit_layer;

var view_validator;

var layer_validator;

function createView(data){
    var _this = this;

    var control = $("<p>",{
        id:"control",
        class:"float_r mar0pad0",
        hide:true
    });

    var node = $("<li></li>",{
        id:"view_"+data.sn,
        class:"click"
    }).on("click",function (control){
        return function () {
            view_sn = data.sn;
            $(this).parent().children().each(function () {
                $(this).find("#control").hide();
                $(this).removeClass("selected");
            })
            control.show();
            $(this).addClass("selected");
            query_viewproducts(data.sn);
        }
    }(control));

    var node_name = $("<p>",{
        class:"float_l mar0pad0"
    }).text(data.viewName);

    var _delete = $("<span>",{
        class:"glyphicon glyphicon-trash mar_l5"
    });

    var _edit = $("<span>",{
        class:"mar_l20 glyphicon glyphicon-pencil"
    });
    /*
    node.on({
        mouseover:function () {
            _control.show();
        },
        mouseout:function (){
            _control.hide();
        }
    });*/

    control.append(_delete);
    control.append(_edit);
    node.append(node_name);
    node.append(control);
    node.append($("<div></div>",{
        class:"clr"
    }))
    view_container.append(node);
}
//视角类
function View(data){
    ControlViewHtmlClear();
    var _this = this;
    _this.data = data;
    this.layer_list = new Array();

    var preNode = $("#view_"+data.id);

	this.node = $("<li></li>",{
	    id:"view_"+_this.data.id,
	    class:"click"
    }).on("click",function (){
        view_sn = data.id;
        $(this).parent().children().each(function () {
            if($(this).attr("id") != _this.node.attr("id")){
                $(this).find("#control").hide();
                $(this).removeClass("selected");
            }
        })
        if(_this.control.is(":hidden")){
            _this.control.show();
            $(this).addClass("selected");
            query_viewproducts(data.id);
        }
    });

	this.node_name = $("<p>",{
	    class:"float_l mar0pad0"
	}).text(data.name);

    this.control = $("<p>",{
        id:"control",
        class:"float_r mar0pad0"
    });

    var _mirror = $("<span>",{
        class:"glyphicon glyphicon-trash mar_l5",
        click:function(){
            event.stopPropagation();
            WebGL.mirror(_this.view);
        }
    });

	var _delete = $("<span>",{
    	class:"glyphicon glyphicon-trash mar_l5",
        click:function(){
    	    event.stopPropagation();
            deleteView(_this);
        }
	});

	var _edit = $("<span>",{
        class:"mar_l20 glyphicon glyphicon-pencil",
        click:function(){
            event.stopPropagation();
            $("#viewName").val( _this.data.name);
            $("#view_pic").attr("src", _this.data.url);
            $("#viewSn").val( _this.data.id);
            $("#view_mapid").val( _this.data.mapid);

            $("#view_save").off("click").on("click",function () {
                updateView(function(data){
                    _this.data = data;
                    _this.reLoad(data);
                    $("#view_entering").modal("hide");
                });
            });
            $("#view_entering").modal("show");
        }
	});
    this.control.append(_mirror);
    this.control.append(_delete);
    this.control.append(_edit);
	this.node.append(this.node_name);
	this.node.append(this.control);
	this.node.append($("<div></div>",{
	    class:"clr"
    }))

	this.view = WebGL.createView("",data.id,data.url,1,data.width,data.height);

    if(preNode.attr("id")){
        preNode.before(this.node);
        preNode.remove();
        this.control.show();
        this.node.addClass("selected");
    }else{
        view_container.append(this.node);
    }

    var inserLayerControl =  $("<span></span>",{
        class:"float_r glyphicon glyphicon-plus-sign dis_block mar_t10 mar_r10 s20"
    }).on({
        click:function(){
            $("#layer_entering").modal("show");
            $("#layer_save").off("click").on("click",function(){
                layer_validator = $("#layer_form").validate();
                if($("#layer_form").valid()){
                    updateLayer(data.id,function (data) {
                        _this.add_layer(data);
                        $("#layer_entering").modal("hide");
                    });
                }
            });
        }
    });

    layer_control.empty();
    layer_container = $("<ul></ul>",{
        id:"layer_container"
    });

    layer_control.append(inserLayerControl).append($("<div></div>",{
        class:"clr"
    }));

    layer_control.append(layer_container);

    layer_control.append($("<div></div>",{
        class:"clr"
    }));


	if(typeof View._initialized == "undefined"){
        View.prototype.delete = function(){
			for(var i=0,len=this.layer_list.length;i<len;i++){
                var layer = this.layer_list[i];
                layer.delete();
			}
            WebGL.clearScene();
            ControlViewHtmlClear();
            this.node.remove();
        };

        View.prototype.add_layer = function(layerData){
            layerData.layerOrder = this.layer_list.length + 1;
            var layer = new Layer(this.view,layerData);
                this.layer_list.push(layer);
        		return layer;
		}

        View.prototype.reLoad = function(data){
            this.node_name.text(data.name);
            WebGL.reLoadElement(this.view,data);
        }

        View._initialized = true;
	}
    this.node.trigger("click");
	return _this;
}
//层类
function Layer(parent,data){
	var _this = this;
	_this.data = data;
	_this.parent = parent;
	this.element_list = new Array();

	this.node = $("<li></li>",{
	    id:"layer_"+_this.data.id,
	    class:"click",
        click:function(){
            $(this).parent().children().each(function () {
                if($(this).attr("id") != _this.node.attr("id")){
                    $(this).find("#control").hide();
                    $(this).removeClass("selected");
                }
            })

            if(_this.control.is(":hidden")){
                _this.control.show();
                $(this).addClass("selected");
                edit_layer = _this.layer;
                WebGL.removeEdge();
                query_element(_this);
            }
        }
    });

    this.node_name = $("<p></p>",{
        class:"float_l mar0pad0"
    }).text(data.name);

    //this.node_name = $("<p></p>").css({width:"200px",height:"36px",line_height:"36px",border:"1px solid green"}).text(data.name);

    this.control = $("<p></p>",{
        id:"control",
        class:"float_r mar0pad0",
        hide:true
    })

    var _delete = $("<span></span>",{
        class:"glyphicon glyphicon-trash mar_l5 mar_r10 mar_t10",
        click:function(){
            deleteLayer(_this);
        }
    });

    var _edit = $("<span></span>",{
        class:"glyphicon glyphicon-pencil mart_t10"
    }).on({
    	click:function () {
    	    event.stopPropagation();
            //queryPackageTypeName(_this);
            $("#layerName").val(_this.data.name);
            $("#layer_sn").val(_this.data.id);
            $("#layer_entering").modal("show");

            $("#layer_save").off("click").on("click",function(){
                layer_validator = $("#layer_form").validate();

                if($("#layer_form").valid()) {
                    updateLayer(data.viewSn, function (data) {
                        _this.reLoad(data);
                        $("#layer_entering").modal("hide");
                    });
                }
            });
        }
	});

    var _up = $("<span></span>",{
        class:"glyphicon glyphicon-arrow-up mart_t10"
    }).on({
        click:function () {
            event.stopPropagation();
            var pre = _this.node.prev();
            if(pre.attr("id")){
                var _data = new Object();
                _data["pre"] = (pre.attr("id").split("layer_"))[1];
                _data["next"] = (_this.node.attr("id").split("layer_"))[1];

                updateLayerOrder(_data);
            }
        }
    });

    var _down = $("<span></span>",{
        class:"glyphicon glyphicon-arrow-down mart_t10 mar_r10"
    }).on({
        click:function () {
            event.stopPropagation();
            var next = _this.node.next();
            if(next.attr("id")){
                var _data = new Object();
                _data["pre"] = (_this.node.attr("id").split("layer_"))[1];
                _data["next"] = (next.attr("id").split("layer_"))[1];
                updateLayerOrder(_data);
            }
        }
    });

    this.control.append(_edit);
    this.control.append(_delete);
    this.control.append(_up);
    this.control.append(_down);
    this.node.append( this.node_name);
    this.node.append(this.control);
    this.node.append($("<div></div>",{
        class:"clr"
    }))

    this.layer = WebGL.createLayer(parent,data);
	layer_container.append(this.node);

	if(typeof Layer._initialized == "undefined"){
        Layer.prototype.delete = function(){
            for(var i=0,len = this.element_list.length;i<len;i++){
                element = this.element_list[i];
                element.delete();
            }
            WebGL.delete(this.parent,this.layer);
            this.node.remove();
            element_control.empty();
        };
        
        Layer.prototype.add_element = function (data) {
            data.elementOrder = this.element_list.length + 1;
            var _element = new Element(this.layer,data);
			this.element_list.push(_element);
			return _element;
        }

        Layer.prototype.reLoad = function (data){
            this.node_name.text(data.name);
            this.data = data;
        }
        Layer._initialized = true;
    }
}
//图元类
function Element(parent,data){
	var _this = this;
	_this.data = data;
	this.parent = parent;

    this.node = $("<li></li>",{
        class:"click",
        id:"element_"+data.elementId,
        click:function(){
            WebGL.addEdge(_this.element);
            $(this).parent().children().each(function () {
                if($(this).attr("id") != _this.node.attr("id")){
                    $(this).find("#control").hide();
                    $(this).removeClass("selected");
                }
            })

            if(_this.control.is(":hidden")) {
                _this.control.show();
                $(this).addClass("selected");
                edit_element = _this.element;
                query_elementProduct(_this);
            }
            /*
            $("#elementPictureClose").data("data",data).off("click").on("click",function(){
                var _data = $(this).data("data");
                WebGL.reLoadElement(element.element,_data.url,_data.width,_data.height);
            })*/
        }
    }).data("package_type_sn",data.packageTypeSn);

    this.node_name = $("<p></p>",{
        class:"float_l mar0pad0"
    }).text(data.name);

    this.control = $("<p></p>",{
        id:'control',
        class:"float_r mar0pad0",
        hide:true
    })

    var _mirror = $("<span></span>",{
        class:"glyphicon glyphicon-trash mar_l5 mar_r10 mar_t10",
        click:function(){
            event.stopPropagation();
            WebGL.mirror(_this.element);
        }
    });

    var _delete = $("<span></span>",{
        class:"glyphicon glyphicon-trash mar_l5 mar_r10 mar_t10",
        click:function(){
            event.stopPropagation();
            deleteElement(_this);
        }
    });

    var _up = $("<span></span>",{
        class:"glyphicon glyphicon-arrow-up mart_t10"
    }).on({
        click:function () {
            event.stopPropagation();
            var pre = _this.node.prev();
            if(pre.attr("id")){
                var _data = new Object();
                _data["pre"] = (pre.attr("id").split("element_"))[1];
                _data["next"] = (_this.node.attr("id").split("element_"))[1];
                _data["layerSn"] = _this.data.layerSn;
                updateElementOrder(_data);
            }
        }
    });

    var _down = $("<span></span>",{
        class:"glyphicon glyphicon-arrow-down mart_t10 mar_r10"
    }).on({
        click:function () {
            event.stopPropagation();
            var next = _this.node.next();
            if(next.attr("id")){
                var _data = new Object();
                _data["pre"] = (_this.node.attr("id").split("element_"))[1];
                _data["next"] = (next.attr("id").split("element_"))[1];
                _data["layerSn"] = _this.data.layerSn;
                updateElementOrder(_data);
            }
        }
    });
    this.control.append(_mirror);
    this.control.append(_delete);
    this.control.append(_up);
    this.control.append(_down);
    this.node.append(this.node_name);
    this.node.append(this.control);
    this.node.append($("<div></div>",{
        class:"clr"
    }));

	element_container.append(this.node);
	this.element = WebGL.createElement(parent,data);

    if(typeof Element._initialized == "undefined"){
        Element.prototype.delete = function(){
        	WebGL.delete(this.parent,this.element);
			this.node.remove();
        };
        Element._initialized = true;
    }
}
//WebGL操作
var WebGL = {
	scene:{},
    root:null,
    edge:null,
	webGLRenderer:{},
	camera:{},
	parent:{},
    INTERSECTED:null,
	pre_pos:null,
    render:function(){
		requestAnimationFrame(WebGL.render);
		webGLRenderer.render(scene, camera);
	},
	init:function(){
        _offset = WebGL_Container.offset();
		scene = new THREE.Scene();
		camera = new THREE.OrthographicCamera(-400,400,290,-290,0,1000);
		//camera = new THREE.PerspectiveCamera(45,WebGL_Container.width()/WebGL_Container.height(),0,1000);
		camera.position.set(0,0,1000);
		camera.lookAt(scene.position);
		scene.add(camera);

		this.root = new THREE.Object3D();
		scene.add(this.root);
		this.root.position.set(0,0,0);

        var ambient_light =  new THREE.AmbientLight(0xffffff);
        ambient_light.intensity = 0.5;
        scene.add(ambient_light);

        var direct_light = new THREE.DirectionalLight(0xcccccc);
        direct_light.position.set(30, 40, 50);
        direct_light.intensity = 0.2;
        scene.add(direct_light);
        
        THREE.ImageUtils.crossOrigin = 'anonymous';

		webGLRenderer = new THREE.CanvasRenderer();
		webGLRenderer.setClearColor(0xFFFFFF,1);
		webGLRenderer.setSize(WebGL_Container.width(),WebGL_Container.height());
        webGLRenderer.shadowMapEnabled = true;

		WebGL_Container.append(webGLRenderer.domElement);

		webGLRenderer.domElement.addEventListener('mousemove',this.onmousemove,false);

        webGLRenderer.domElement.addEventListener('mousedown',this.onmousedown,false);

        webGLRenderer.domElement.addEventListener('mouseup',this.onmouseup,false);

		this.render();
	},
	onmousemove:function(event){
        event.preventDefault();
        if(this.INTERSECTED){
            var x = ((event.clientX - _offset.left) / WebGL_Container.width()) * 2 - 1;
            var y = - ((event.clientY - _offset.top) / WebGL_Container.height()) * 2 + 1;

            var vector = new THREE.Vector3(x,y,1).unproject(camera);

            if(this.pre_pos){
                var offset = vector.sub(this.pre_pos);
                offset.z = 0;
                var pos =  this.INTERSECTED.position;
                var _pos = new THREE.Vector3(parseFloat(pos.x)+parseFloat(offset.x),parseFloat(pos.y)+parseFloat(offset.y),pos.z);

                this.INTERSECTED.position.set(_pos.x,_pos.y,_pos.z);

                //console.log(this.INTERSECTED.position.z);

                this.pre_pos = new THREE.Vector3(x,y,1).unproject(camera);
			}else{
                this.pre_pos = vector;
			}
		}
	},
	onmousedown:function(event){
    	event.preventDefault();
        var x = ((event.clientX + $(document).scrollLeft() - _offset.left) / WebGL_Container.width()) * 2 - 1;
        var y = - ((event.clientY + $(document).scrollTop() - _offset.top) / WebGL_Container.height() ) * 2 + 1;
        var vector  = new THREE.Vector3(x,y,1).unproject(camera);
        var ray = vector.sub(camera.position).normalize();
        var raycaster = new THREE.Raycaster(camera.position,ray);
        if(edit_layer&&edit_element){
            var intersects = raycaster.intersectObjects(edit_layer.children);
            console.log(intersects.length);
            for (var i=0,len = intersects.length;i<len;i++) {
                if(intersects[i].object.name == edit_element.name){
                    this.INTERSECTED = intersects[i].object;
                    break;
                }
            }
        }
    },
	onmouseup:function (event){
        this.INTERSECTED = null;
        this.pre_pos = null;
	},
	load_texture:function(url){
		var _texture = THREE.ImageUtils.loadTexture(url);
		return _texture;
	},
	createView:function (parent,id,url,order,width,height){
		var _texture = this.load_texture(url);
		var _plane = new THREE.PlaneGeometry(1,1,1,1);
		var _mat = new THREE.MeshLambertMaterial({map:_texture,transparent:true});

        var map = _mat.map;
        if(map){
            map.wrapS = THREE.RepeatWrapping;
            map.wrapT = THREE.RepeatWrapping;
            map.needsUpdate = true;
        }

		var mesh = new THREE.Mesh(_plane,_mat);
		mesh.name = "view_"+id;
		mesh.scale.set(width,height,1);
        this.root.add(mesh);
        mesh.position.set(0,0,1);
        return mesh;
    },
    createLayer:function (parent,data){
        var target = new THREE.Object3D();
        target.name = "layer_"+data.id;
        if(data.layerOrder){
            var order = parseFloat(data.layerOrder);
            target.position.set(0,0,order*20);
        }
        this.root.add(target);
        return target;
    },
	createElement:function (parent,data) {
        var mesh;
        mesh = parent.getObjectByName("element_"+data.elementId);

        if(mesh){
            return mesh;
        }

        var _mat;
        if(data.url){
            var _texture = this.load_texture(data.url);
            _mat = new THREE.MeshLambertMaterial({map:_texture,transparent:true});
        }else{
            _mat = new THREE.MeshLambertMaterial({transparent:true});
        }

        var map = _mat.map;
        if(map){
            map.wrapS = THREE.RepeatWrapping;
            map.wrapT = THREE.RepeatWrapping;
            map.needsUpdate = true;
            if(data.repeating){
                var vec = string_to_vec(data.repeating);
                map.repeat.set(vec.x,vec.y);
            }
        }

        var _plane = new THREE.PlaneGeometry(1,1,1,1);

        mesh = new THREE.Mesh(_plane,_mat);
        if(data.width&&data.height&&data.scale){
            var scale = new THREE.Vector3(parseFloat(data.width),parseFloat(data.height),1);
            scale.multiplyScalar(parseFloat(data.scale));
            mesh.scale.set(scale.x,scale.y,1);
        }
        if(data.elementOrder){
            var order = parseFloat(data.elementOrder);
            mesh.position.set(0,0,order);
        }

        if(data.position){
            var pos = string_to_vec(data.position);
            mesh.position.set(pos.x,pos.y,mesh.position.z);
        }

        mesh.name = "element_"+data.elementId;
        parent.add(mesh);

        return mesh;
    },
    reLoadElement:function(element,data){
        var _texture;
        if(data.url){
           _texture = this.load_texture(data.url);
            element.material.map = _texture;
        }

        var map = element.material.map;
        if(map){
            if(data.repeating){
                var vec = string_to_vec(data.repeating);
                map.repeat.set(vec.x,vec.y);
            }
        }

        if(data.width&&data.height){
            if(data.scale){
                var scale = new THREE.Vector3(parseFloat(data.width),parseFloat(data.height),1);
                scale.multiplyScalar(parseFloat(data.scale));
                element.scale.set(scale.x,scale.y,1);
            }else{
                element.scale.set(data.width,data.height,1);
            }
        }else{
            element.scale.set(1,1,1);
        }

        if(data.position){
            var pos = string_to_vec(data.position);
            element.position.set(pos.x,pos.y,element.position.z);
        }
    },
    mirror:function (element) {
        var map = element.material.map;
        if(map){
            var repeatX = parseFloat(map.repeat.x);
            repeatX = -1 * repeatX;
            map.repeat.set(repeatX,1);
        }
    },
    resetScale:function(element,scale){
        element.scale.set(scale.x,scale.y,1);
    },
    clearScene:function(){
        if(this.edge){
            scene.remove(this.edge);
        }
        scene.remove(this.root);
        this.root = new THREE.Object3D();
        scene.add(this.root);
        this.root.position.set(0,0,0);
    },
    addEdge:function(element){
        if(this.edge){
            scene.remove(this.edge);
        }
        this.edge = new THREE.EdgesHelper(element,0x1535f7);
        scene.add(this.edge);
    },
    removeEdge:function () {
        if(this.edge){
            scene.remove(this.edge);
        }
    },
    ExchangeElementOrder:function (data) {
        var layer =  this.root.getObjectByName("layer_"+data.layerSn);
        var pre_element = layer.getObjectByName("element_"+data.pre);
        var next_element = layer.getObjectByName("element_"+data.next);

        var pre_z = pre_element.position.z;
        var next_z = next_element.position.z;

        pre_element.position.set(pre_element.position.x,pre_element.position.y,next_z);
        next_element.position.set(next_element.position.x,next_element.position.y,pre_z);
    },
    ExchangeLayerOrder:function (data) {
        var pre_layer =  this.root.getObjectByName("layer_"+data.pre);
        var next_layer = this.root.getObjectByName("layer_"+data.next);

        var pre_z = pre_layer.position.z;
        var next_z = next_layer.position.z;

        pre_layer.position.set(pre_layer.position.x,pre_layer.position.y,next_z);
        next_layer.position.set(next_layer.position.x,next_layer.position.y,pre_z);
    },
	delete:function(parent,element){
    	parent.remove(element);
        this.removeEdge();
	}
}
//页面默认初始化方法
$(function(){
    view_container = $("#view_container");
    layer_control = $("#layer_control");
    element_control = $("#element_control");

    WebGL_Container = $("#WebGl-Output");
    WebGL.init();

    $.extend($.validator.messages, {
        required: "必填字段",
    });

    $("#view_entering").on('hidden.bs.modal', function () {
        $("#viewName").val("");
        $("#view_pic").attr("src","");
        $("#viewSn").val("");
        $("#view_mapid").val("");
        $("#viewpic_upload").hide();
        $('#progress .progress-bar').css(
            'width', '0%'
        );
        $("#view_save").hide();
        if(view_validator){
            view_validator.resetForm();
        }
    });

    $("#view_entering").on('shown.bs.modal', function(){
        if($("#view_mapid").val()){
            $("#view_save").show();
        }
    });

    $("#layer_entering").on('hidden.bs.modal', function () {
        $("#layerName").val("");
        $("#layer_sn").val("");
        if(layer_validator){
            layer_validator.resetForm();
        }
    });


    $("#view_insert").on("click",function () {
        if(space_sn){
            $("#view_save").off("click").on("click",function () {
                view_validator = $("#view_form").validate();
                if($("#view_form").valid()){
                    updateView(function(data){
                        WebGL.clearScene();
                        ControlViewHtmlClear();
                        var view = new View(data);
                        $("#view_entering").modal("hide");
                    });
                }
            });
            $("#view_entering").modal("show");
        }
    });

    //图元上传插件初始化
    $('#elementupload').fileupload({
        url: upload_url,
        dataType: 'json',
        autoUpload: false,
        acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i,
        maxFileSize: 10485760,
        disableImageResize: /Android(?!.*Chrome)|Opera/
            .test(window.navigator.userAgent),
        previewMaxWidth: 100,
        previewMaxHeight: 100,
        previewCrop: true
    }).on('fileuploaddone', function (e, data) {
        var returnJsonAry = data.result;
        var file_data = new Object();
        $.each(data.result, function (index, file){
            file_data[index] = file;
        });
        $("#product_mapid").val(file_data.fileId);
        $("#elementpic_upload").hide();
        $("#elementProductUpdate").show();
    }).on('fileuploadprogressall', function (e, data) {
        var progress = parseInt(data.loaded / data.total * 100, 10);
        $('#element_progress .progress-bar').css(
            'width',
            progress + '%'
        );
    });

    $('#fileupload').fileupload({
        url: upload_url,
        dataType: 'json',
        autoUpload: false,
        acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i,
        maxFileSize: 10485760,
        disableImageResize: /Android(?!.*Chrome)|Opera/
            .test(window.navigator.userAgent),
        previewMaxWidth: 100,
        previewMaxHeight: 100,
        previewCrop: true
    }).on('fileuploadadd', function (e, data) {
        $.each(data.files, function (index, file) {
            var url = getObjectURL(file);
            $("#view_pic").attr("src",url);
            $("#viewpic_upload").show();
            $("#viewpic_upload").click(function(){
                data.submit();
            })
        })
    }).on('fileuploadprogressall', function (e, data) {
        var progress = parseInt(data.loaded / data.total * 100, 10);
        $('#progress .progress-bar').css(
            'width',
            progress + '%'
        );
    }).on('fileuploaddone', function (e, data) {
        var returnJsonAry = data.result;
        $.each(data.result, function (index, file){
            $("#view_mapid").val(file.fileId);
            $("#viewpic_upload").hide();
            $("#view_save").show();
        });
    }).on('fileuploadfail', function (e, data) {
        $.each(data.files, function (index) {
            var error = $('<span class="text-danger"/>').text('File upload failed.');
            $(data.context.children()[index])
                .append('<br>')
                .append(error);
        });
    }).prop('disabled', !$.support.fileInput)
        .parent().addClass($.support.fileInput ? undefined : 'disabled');
})

function getObjectURL(file) {
    var url = null;
    if (window.createObjectURL != undefined) { // basic
        url = window.createObjectURL(file);
    } else if (window.URL != undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file);
    } else if (window.webkitURL != undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file);
    }
    return url;
}
//查询视角
function query_view(key){
    space_sn = key;
    var _data = {};
    _data["houseStyleSn"] = house_style_sn;
    _data["houseSpaceSn"] = key;
    $.ajax({
        url:"/perspective/viewQuery",
        type: "POST",
        data:_data,
        dataType:"json",
        success:function(data){
            if(data){
                ControlSpaceHtmlClear();
                //view_container.empty();
                for(var i=0,len = data.length; i<len;i++){
                    createView(data[i]);
                }
                view_container.children().first().trigger("click");
            }
        }
    });
}

function query_viewproducts(key){
    var _data = {};
    _data["sn"] = key;
    $.ajax({
        url:"/perspective/QueryViewProducts",
        type: "POST",
        data:_data,
        dataType:"json",
        success:function(data){
            if(data){
                WebGL.clearScene();
                /*
               for(var key in data){
                    var viewInfo = data[key];
                    var view = new View(viewInfo);
                    var layerList = viewInfo.layer;
                    for(var layerKey in layerList){
                        var layerInfo = layerList[layerKey];
                        var layer =  view.add_layer(layerInfo);
                        var elementInfo = layerInfo.element;
                        for(var elementKey in elementInfo){
                            WebGL.createElement(layer.layer,elementInfo[elementKey]);
                        }
                    }
               }*/
                var view_map = new Object();
                var layer_map;
                for(var i=0,len=data.length;i<len;i++){
                    var _data = data[i];
                    var view = view_map[_data.viewId];
                    if(view){
                        layer_map = view_map.layer;
                    }else{
                        var view_data = new Object();
                        view_data.id = _data.viewId;
                        view_data.name = _data.viewName;
                        view_data.mapid = _data.viewMapId;
                        view_data.url = _data.viewMapUrl;
                        view_data.width = _data.viewMapWidth;
                        view_data.height = _data.viewMapHeight;
                        view = new View(view_data);
                        view_map[_data.viewId] = view;
                        layer_map = new Object();
                        view_map.layer = layer_map;
                    }

                    if(_data.layerId){
                        var layer = layer_map[_data.layerId];
                        if(layer){

                        }else{
                            var layer_data = new Object();
                            layer_data.id = _data.layerId;
                            layer_data.name = _data.layerName;
                            layer_data.viewSn = _data.viewSn;
                            layer_data.layerOrder = _data.layerOrder;

                            layer = view.add_layer(layer_data);
                            layer_map[_data.layerId] = layer;
                        }

                        if(_data.elementId){
                            var element_data = new Object();
                            element_data.elementId = _data.elementId;
                            element_data.elementName = _data.elementName;

                            element_data.elementOrder = layer.layer.children.length + 1;
                            element_data.position = _data.position;
                            element_data.scale = _data.scale;
                            element_data.url = _data.elementMapUrl;
                            element_data.width = _data.elementMapWidth;
                            element_data.height = _data.elementMapHeight;

                            WebGL.createElement(layer.layer,element_data);
                        }
                    }
                }
            }
        }
    });
}

function query_layer(){

}

//查询图元
function query_element(layer){
    var _data = {};
    _data["layerSn"] = layer.data.id;
    $.ajax({
        url:"/perspective/queryElement",
        type: "POST",
        data:_data,
        dataType:"json",
        success:function(data){
            $("#elementProductClose").trigger("click");
            var insert = $("<span></span>",{
                class:"float_r glyphicon glyphicon-plus-sign dis_block mar_t10 mar_r10 s20"
            }).off("click").on({
                click:function(){
                    queryPackageTypeName(layer);
                }
            });
            element_control.empty();
            element_container = $("<ul></ul>",{
                id:"element_container"
            });
            element_control.append(insert);
            element_control.append($("<div></div>",{
                class:"clr"
            }));
            element_control.append(element_container);

            if(data){
                ControlElementClear();
                for(var i=0,len = data.length;i<len;i++){
                    var elementInfo = data[i];
                    layer.add_element(elementInfo);
                }
            }
        }
    });
}

//更新或者添加视角
function updateView(callback){
    var _data = {};
    $("#view_form input").each(function(){
        var key = $(this).attr("name");
        if(key){
            _data[key] = $(this).val();
        }
    });

    _data["houseStyleSn"] = house_style_sn;
    _data["houseSpaceSn"] = space_sn;

    $.ajax({url:"/perspective/viewUpdate",
        type: "POST",
        data:_data,
        dataType:"json",
        success:function(data){
            if(data){
               callback(data);
            }
        }
    });
    //$("#view_save").data("data").submit();
}

function ClearViewEnterning(){
    $("#view_entering").modal("hide");
    $("#view_save").data("data",null);
    $("#")
}

//更新或者添加层
function  updateLayer(layer_sn,callback) {
    var _data = {};
    $("#layer_form input").each(function(){
        var key = $(this).attr("name");
        if(key){
            _data[key] = $(this).val();
        }
    });
    _data["viewSn"] = layer_sn;
    _data["sn"] = $("#layer_sn").val();

    $.ajax({url:"/perspective/layerUpdate",
        type: "POST",
        data:_data,
        dataType:"json",
        success:function(data){
            if(data){
               callback(data);
            }
        }
    });
}
/*添加图元功能*/
//查询套餐中分类名称作为图元名称
function queryPackageTypeName(layer){
    var _data = {};
    _data["houseStyleSn"] = house_style_sn;
    _data["houseSpaceSn"] = space_sn;
    _data["sn"] = view_sn;
    $.ajax({
        url:"/perspective/queryPackageTypeName",
        type: "POST",
        data:_data,
        dataType:"json",
        success:function(data){
            var used = data.used;
            var all_data = data.all;
            if(all_data&&Object.keys(all_data).length!=0){
                var container = $("#element_check_container");
                container.empty();
                for(var i=0,len = used.length;i<len;i++){
                    var key = used[i];
                    if(key in all_data){
                        all_data[key].selected = true;
                    }
                }
                for(var key in all_data){
                    var li = $("<li></li>");

                    var parent = $("<div></div>",{
                        class:"packge_name"
                    });

                    var checkbox = $("<input type='checkbox'/>").attr("id",all_data[key].id).off("click").on("click",function () {
                        if($(this).is(":checked")){
                            $("#element_check_container input:enabled:checked").prop("checked",false);
                            $(this).prop("checked",true);
                        }
                    });

                    if(all_data[key].selected){
                        checkbox.attr("checked",true).attr('disabled',true);
                    }
                    parent.append(checkbox).append($("<text></text>").text(all_data[key].name));

                    container.append(parent);
                }

                $("#element_entering").modal("show");
                $("#element_save").off("click").on("click",function() {
                     _data = {};
                     $("#element_check_container input:enabled:checked").each(function(){
                         _data["packageTypeSn"] = $(this).attr("id");
                         _data["elementName"] = $(this).parent().text();
                     });
                     _data["layerSn"] = layer.data.id;
                     //_data["elementOrder"] = element_container.children().length;
                     updateElement(layer.layer,_data);
                });
            }
        }
    })
}
//更新或者添加图元
function updateElement(layer,data){
    $.ajax({
        url:"/perspective/elementUpdate",
        type: "POST",
        data:data,
        dataType:"json",
        success:function(data){
            if(data){
                //createElementContainer();
                var element = new Element(layer,data);
                $("#element_entering").modal("hide");
            }
        }
    });
}

function createElementContainer(){
    if(element_container){
        element_container.empty();
    }else{
        element_container = $("<ul></ul>",{
            id:"#element_container"
        });
        element_control.append(element_container);
    }
}

//查询图元即套餐分类下的所有关联产品
function query_elementProduct(element){
    var _data = {};
    _data["sn"] = element.data.elementId;
    $.ajax({
        url:"/perspective/queryElementProduct",
        type: "POST",
        data:_data,
        dataType:"json",
        success:function(data){
            if(data){
                initProductResult(element,data);
            }
        }
    })
}

//构造图元多产品显示结果集
function initProductResult(element,data){
    $("#elementProductClose").trigger("click");
    ControlElementClear();
    var _tbody = $("#prodcut_container");
    for(var i=0,len=data.length;i<len;i++){
        var product = data[i];
        var _tr = $("<tr></tr>",{
            id:"product_"+product.sn,
        }).data("data",product);

        _tr.on("click",function (element,product) {
                return function(){
                    var _this = $(this);
                    $(this).parent().children().each(function () {
                        if($(this).attr("id") != _this.attr("id")){
                            $(this).removeClass("selected");
                        }
                    });
                    if(!_this.hasClass("selected")){
                        $(this).addClass("selected")
                    }
                    updateElementProductCallback(element,product);
                }
        }(element,_tr));

        var order = $("<td></td>").text(i);
        var td_id = $("<td></td>").text(product.id);
        var td_name = $("<td></td>").text(product.name);

        var check_box = $("<input type='checkbox'/>").attr("disabled","disabled").on("click",function (element,product_tr,elementProductSn) {
            return function () {
                event.stopPropagation();
                if($(this).is(":checked")){
                    $("#prodcut_container input:checked").prop("checked",false);
                    $(this).prop("checked",true);
                }
                var _elementProductSn = "";
                if($(this).is(":checked")){
                    _elementProductSn = elementProductSn;
                }
                updateElementExhibtionMap(element,product_tr,_elementProductSn);
            }
        }(element,_tr,product.elementProductSn));

        if(product.elementProductSn){
            check_box.removeAttr("disabled");
        }
        if(element.data.elementProductSn == product.elementProductSn){
            check_box.prop("checked",true);
        }
        var control =  $("<td></td>").append(check_box);
        _tr.append(order);
        _tr.append(td_id);
        _tr.append(td_name);
        _tr.append(control);

        _tbody.append(_tr);
    }
    ResultExhibtion();
}

//切换显示图元中关联各产品图片
function updateElementProductCallback(element,product){
    ElementUploadHide();

    var productInfo = product.data("data");
    $("#product_mapid").val(productInfo.mapid);
    var url = productInfo.url;

    var _element_size = new Object();

    if(url){
        $("#element_pic").width("auto").height("auto").attr("src",url).unbind().bind("load",function(){
            _element_size.x = $(this).width();
            _element_size.y = $(this).height();
            CaculatePicContainerWidth($(this));
            WebGL.reLoadElement(element.element,productInfo);
        })
    }else{
        $("#element_pic").attr("src","");
        WebGL.reLoadElement(element.element,new Object());
    }

    var scale = parseFloat(productInfo.scale);
    if(scale){
        $("#product_scale").val(scale*100);
    }else{
        scale = 1;
        $("#product_scale").val(scale*100);
    }

    $('#elementupload').off("fileuploadadd").on('fileuploadadd', function (e, data) {
        $("#product_scale").val(100);
        $.each(data.files, function (index, file) {
            var url = getObjectURL(file);
            $("#element_pic").width("auto").height("auto").attr("src",url).unbind().bind("load",function(){
                var _data = new Object();
                _data.url = url;
                _element_size.x = _data.width = $(this).width();
                _element_size.y = _data.height = $(this).height();
                _data.scale = 1;
                CaculatePicContainerWidth($(this));
                WebGL.reLoadElement(element.element,_data);
            })

            $("#elementpic_upload").off("click").on("click",function(){
                data.submit();
            })

            $('#element_progress .progress-bar').css(
                'width', '0%'
            );
            $("#elementpic_upload").show();
        })
    });

    $("#elementProductUpdate").off("click").on("click",function () {
        _data = new Object();
        _data["mapid"] = $("#product_mapid").val();
        _data["elementSn"] = element.data.elementId;
        _data["productSn"] = productInfo.sn;
        _data["sn"] = productInfo.elementProductSn;
        _data["position"] = vec_to_string(element.element.position);
        _data["scale"] = (parseFloat($("#product_scale").val())/100.0).toFixed(2).toString();
        var map = element.element.material.map;
        if(map){
            _data["repeating"] = vec_to_string(map.repeating);
        }
        $.ajax({
            url:"/perspective/elementProductUpdate",
            type: "POST",
            data:_data,
            dataType:"json",
            success:function(data){
                if(data){
                    $.extend(element.data,data);
                    product.find("input[type='checkbox']").removeAttr("disabled");
                    $("#product_"+data.sn).data("data",data);
                }
            }
        })
    })

    $("#elementProductClose").off("click").on("click",function () {
        var data = element.data;
        WebGL.reLoadElement(element.element,data);
        ElementUploadHide();
    })

    $("#product_scale").off("input").on("input",function(){
        var value = ($(this).val()/100.0).toFixed(2);
        var x = parseFloat(_element_size.x).toFixed(2)*value;
        var y = parseFloat(_element_size.y).toFixed(2)*value;
        var _scale = new THREE.Vector3(x,y,1);
        WebGL.resetScale(element.element,_scale);
    })

    ElementUploadExhibtion();
    /*
    if(url){
        $("#element_pic").attr("src",url).unbind().bind("load",function(){
            WebGL.reLoadElement(element.element,url,product.width,product.height);
        })
    }else{
        $("#element_pic").attr("src","");
        WebGL.reLoadElement(element.element,"",0,0);
    }*/

    /*
    $('#elementupload').off("fileuploadadd").on('fileuploadadd', function (e, data) {
        $.each(data.files, function (index, file) {
            var url = getObjectURL(file);
            $("#element_pic").attr("src",url).unbind().bind("load",function(){
                WebGL.reLoadElement(element.element,url,$(this).width(),$(this).height());
            })
            $("#elementPictureSave").off("click").on("click",function(){
                data.submit();
            })
        })
    });*/

    /*
    on('fileuploaddone', function (e, data) {
        var returnJsonAry = data.result;
        var file_data = new Object();
        $.each(data.result, function (index, file){
            file_data[index] = file;
        });

        _data = new Object();
        _data["mapid"] = file_data.fileId;
        _data["elementSn"] = element.data.id;
        _data["productSn"] = product.sn;
        _data["sn"] = product.elementProductSn;
        _data["position"] = vec_to_string(element.element.position);
        _data["scale"] = vec_to_string(element.element.scale);

        $.ajax({
            url:"/perspective/elementProductUpdate",
            type: "POST",
            data:_data,
            dataType:"json",
            success:function(data){
                if(data){
                    $("#"+data.sn).off("click").on("click",function(){
                        updateElementProductCallback(element,data);
                    });
                }
            }
        })
    });*/
}

//更新图元默认显示图片
function updateElementExhibtionMap(element,product,elementProductSn){
    event.stopPropagation();
    var _data = new Object();
    _data["elementProductSn"] = elementProductSn;
    var nameN = product.data("data");
    _data["sn"] = element.data.elementId;
    _data["elementName"] = element.data.name;
    $.ajax({
        url:"/perspective/elementExhibitionMapUpdate",
        type: "POST",
        data:_data,
        dataType:"json",
        success:function(data){
            if(data){
                product.find("input[type='checkbox']").removeAttr("disabled");
                $.extend(element.data,data);
                var data = element.data;
                WebGL.reLoadElement(element.element,data);
            }
        }
    })
}
//向量转字符串
function vec_to_string(data){
    return parseFloat(data.x).toFixed(3)+","+parseFloat(data.y).toFixed(3);
}

function string_to_vec(data){
    var array = data.split(",");
    var vec = new THREE.Vector3(array[0],array[1],1);
    return vec;
}

function ClearView(parent,child){
    WebGL.delete(parent,child);
    layer_control.empty();
    element_control.empty();
}

function deleteElement(element){
    _data = new Object();
    _data["sn"] = element.data.elementId;
    $.ajax({url:"/perspective/deleteElement",
        type: "POST",
        data:_data,
        dataType:"json",
        success:function(data){
            if(data){
                element.delete();
            }
        }
    });
}

function deleteLayer(layer){
    _data = new Object();
    _data["sn"] = layer.data.id;
    $.ajax({url:"/perspective/deleteLayer",
        type: "POST",
        data:_data,
        dataType:"json",
        success:function(data){
            if(data){
                layer.delete();
            }
        }
    });
}

function deleteView(view){
    _data = new Object();
    _data["sn"] = view.data.id;
    $.ajax({url:"/perspective/deleteView",
        type: "POST",
        data:_data,
        dataType:"json",
        success:function(data){
            if(data){
                view.delete();
            }
        }
    });
}

function updateElementOrder(data){
    $.ajax({url:"/perspective/updateElementOrder",
        type: "POST",
        data:data,
        dataType:"json",
        success:function(data){
            if(data){
                WebGL.ExchangeElementOrder(data);
                var pre = $("#element_"+data.pre);
                var next = $("#element_"+data.next);
                next.after(pre);
            }
        }
    });
}

function updateLayerOrder(data){
    $.ajax({url:"/perspective/updateLayerOrder",
        type: "POST",
        data:data,
        dataType:"json",
        success:function(data){
            if(data){
                WebGL.ExchangeLayerOrder(data);
                var pre = $("#layer_"+data.pre);
                var next = $("#layer_"+data.next);
                next.after(pre);
            }
        }
    });
}

function ControlSpaceHtmlClear(){
    ControlViewHtmlClear();
    view_container.empty();
    WebGL.clearScene();
}

function ControlViewHtmlClear(){
    layer_control.empty();
    ControlLayerHtmlClear();
}

function ControlLayerHtmlClear(){
    element_control.empty();
    ControlElementClear();
}

function ControlElementClear(){
    ResultHide();
    ElementUploadHide();
}

function ElementUploadHide(){
    $("#product_scale").val(100);
    $("#element_pic").attr("url","");
    $("#elementpic_upload").hide();
    $("#elementProductUpdate").hide();
    $("#product_mapid").val("");
    $("#element_upload").hide();
    $('#element_progress .progress-bar').css(
        'width', '0%'
    );
}

function ElementUploadExhibtion(){
    if($("#product_mapid").val()){
        $("#elementProductUpdate").show();
    }
    $("#element_upload").show();
}

function ResultExhibtion(){
    $("#result").show();
}

function ResultHide(){
    $("#result").hide();
    $("#prodcut_container").empty();
}

function CaculatePicContainerWidth(pic){
    var width = pic.parent().width();
    var height = pic.parent().height();

    var rate = width/height;

    var pic_width = pic.width();
    var pic_height = pic.height();
    var pic_rate = pic_width/pic_height;

    if(pic_rate > rate){
        var c_height = width / pic_rate;

        pic.width(width);
        pic.height(c_height);
    }else if(pic_rate <rate){
        var c_width = height*pic_rate;
        pic.width(c_width);
        pic.height(height);
    }else{
        pic.width(width);
        pic.height(height);
    }
}