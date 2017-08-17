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

var upload_url = "http://139.196.103.164:8018/pano/fs/upload";

var upload_data;

var house_style_sn;

var space_sn;

var edit_element;

var edit_layer;


function createView(data){
    var node = $("<li></li>",{
        id:data.sn,
        class:"click"
    }).on("click",function (){
        query_viewproducts(data.sn);
    });

    var node_name = $("<p>",{
        class:"float_l mar0pad0"
    }).text(data.viewName);

    var _control = $("<p>",{
        class:"float_r mar0pad0",
        hide:true
    });

    var _delete = $("<span>",{
        class:"glyphicon glyphicon-minus-sign mar_l5"
    });

    var _edit = $("<span>",{
        class:"mar_l20 glyphicon glyphicon-plus-sign"
    });

    node.on({
        mouseover:function () {
            _control.show();
        },
        mouseout:function (){
            _control.hide();
        }
    });

    _control.append(_delete);
    _control.append(_edit);
    node.append(node_name);
    node.append(_control);
    node.append($("<div></div>",{
        class:"clr"
    }))
    view_container.append(node);
}

//视角类
function View(data){
    var _this = this;
    _this.data = data;

    var preNode = $("#"+data.id);

	var node = $("<li></li>",{
	    id:_this.data.id,
	    class:"click"
    }).on("click",function (){
        query_viewproducts(data.id);
    });

	this.node_name = $("<p>",{
	    class:"float_l mar0pad0"
	}).text(data.name);

    var _control = $("<p>",{
        class:"float_r mar0pad0",
        hide:true
    });

	var _delete = $("<span>",{
    	class:"glyphicon glyphicon-minus-sign mar_l5",
        click:function(){
    	    event.stopPropagation();
            deleteView(_this.view);
        }
	});

	var _edit = $("<span>",{
        class:"mar_l20 glyphicon glyphicon-plus-sign",
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
                });
            });

            $("#view_entering").modal("show");

        }
	});

    node.on({
		mouseover:function () {
            _control.show();
        },
		mouseout:function (){
            _control.hide();
        }
	});

    _control.append(_delete);
    _control.append(_edit);
	node.append(this.node_name);
	node.append(_control);
	node.append($("<div></div>",{
	    class:"clr"
    }))

	this.view = WebGL.createView("",data.id,data.url,1,data.width,data.height);

    if(preNode.attr("id")){
        preNode.before(node);
        preNode.remove();
    }else{
        view_container.append(node);
    }

    var control = $("<span></span>",{
        class:"float_r glyphicon glyphicon-plus-sign dis_block mar_t10 mar_r10"
    }).on({
        click:function(){
            $("#layer_entering").modal("show");

            $("#layer_save").click(function(){
                updateLayer(_this);
            });
        }
    });


    layer_control.empty();
    layer_container = $("<ul></ul>",{
        id:"layer_container"
    });
    layer_control.append(control);
    layer_control.append($("<div></div>",{
        class:"clr"
    }));
    layer_control.append(layer_container);

	this.layer_list = {};

	if(typeof View._initialized == "undefined"){
        View.prototype.delete = function(){
			for(var _layer in this.layer_list){

			}
        };

        View.prototype.add_layer = function(layerData){
        		var _layer = new Layer(this.view,layerData);
        		//this.layer_list[name] = _layer;
		}

        View.prototype.reLoad = function(data){
            this.node_name.text(data.name);
            WebGL.reLoadElement(this.view,data.url,data.width,data.height);
        }

        View._initialized = true;
	}

	return _this;
}

//层类
function Layer(parent,data){
	var _this = this;
	_this.data = data;
	this.element_list = new Array();

	var node = $("<li></li>",{
	    class:"click",
        click:function(){
            edit_layer = _this.layer;
            query_element(_this);
        }
    });

    var node_name = $("<p></p>",{
        class:"float_l mar0pad0"
    }).text(data.name);

    var control = $("<p></p>",{
        class:"float_r mar0pad0"
    })

    var _delete = $("<span></span>",{
        class:"glyphicon glyphicon-minus-sign mar_l5 mar_r10 mar_t10",
        click:function(){
            deleteLayer();
        }
    });

    var _edit = $("<span></span>",{
        class:"mar_l20 glyphicon glyphicon-plus-sign mart_t10"
    }).on({
    	click:function () {
            queryPackageTypeName(_this);
        }
	});

    control.append(_edit);
    control.append(_delete);
    node.append(node_name);
    node.append(control);
    node.append($("<div></div>",{
        class:"clr"
    }))

    this.layer = WebGL.createLayer(parent,data);
	layer_container.append(node);

	if(typeof Layer._initialized == "undefined"){
        Layer.prototype.delete = function(){

        };
        
        Layer.prototype.add_element = function (data) {
			var _element = new Element(this.layer,data);
        }

        Layer._initialized = true;
    }
}

//图元类
function Element(parent,data){
	var _this = this;
	_this.data = data;
	this.parent = parent;

    var node = $("<li></li>",{
        class:"click",
        id:data.id,
        click:function(){
            edit_element = _this.element;
            query_elementProduct(_this);
            /*
            $("#elementPictureClose").data("data",data).off("click").on("click",function(){
                var _data = $(this).data("data");
                WebGL.reLoadElement(element.element,_data.url,_data.width,_data.height);
            })*/
        }
    });

    var node_name = $("<p></p>",{
        class:"float_l mar0pad0"
    }).text(data.name);

    var control = $("<p></p>",{
        class:"float_r mar0pad0"
    })

    var _delete = $("<span></span>",{
        class:"glyphicon glyphicon-minus-sign mar_l5 mar_r10 mar_t10"
    });

    var _edit = $("<span></span>",{
        class:"mar_l20 glyphicon glyphicon-plus-sign mart_t10"
    }).on({
        click:function () {
            alert("Hello");
        }
    });

    control.append(_delete);
    control.append(_edit);
    node.append(node_name);
    node.append(control);
    node.append($("<div>"),{
        class:"clr"
    })

	element_container.append(node);
	this.element = WebGL.createElement(parent,data);

    if(typeof Element._initialized == "undefined"){
        Element.prototype.delete = function(){
        	WebGL.delete(this.parent,this.element);
			node.remove();
        };
        Element._initialized = true;
    }
}

//WebGL操作
var WebGL = {
	scene:{},
    root:null,
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
		camera = new THREE.OrthographicCamera(-400,400,290,-290,0,100);
		//alert(WebGL_Container.width());
		//camera = new THREE.PerspectiveCamera(45,WebGL_Container.width()/WebGL_Container.height(),0,1000);
		camera.position.set(0,0,100);
		camera.lookAt(scene.position);
		scene.add(camera);

		root = new THREE.Object3D();
		scene.add(root);
		root.position.set(0,0,0);

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
                this.INTERSECTED.position.add(offset);
                this.pre_pos = new THREE.Vector3(x,y,1).unproject(camera);
			}else{
                this.pre_pos = vector;
			}
		}
	},
	onmousedown:function(event){
    	event.preventDefault();
        var x = ((event.clientX - _offset.left) / WebGL_Container.width()) * 2 - 1;
        var y = - ((event.clientY - _offset.top) / WebGL_Container.height() ) * 2 + 1;

        var vector  = new THREE.Vector3(x,y,1).unproject(camera);
        var ray = vector.sub(camera.position).normalize();
        var raycaster = new THREE.Raycaster(camera.position,ray);
    	var intersects = raycaster.intersectObjects(edit_layer.children);
    	console.log(intersects.length);
        if (intersects.length > 0) {
            this.INTERSECTED = intersects[0].object;
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
		var mesh = new THREE.Mesh(_plane,_mat);
		mesh.name = id;
		mesh.scale.set(width,height,1);
        root.add(mesh);
        mesh.position.set(0,0,0);
        return mesh;
    },
    createLayer:function (parent,data){
        var target = new THREE.Object3D();
        target.name = data.id;
        target.position.set(0,0,5);
        root.add(target);
        return target;
    },
	createElement:function (parent,data) {
        var _mat;
        if(data.url){
            var _texture = this.load_texture(url);
            _mat = new THREE.MeshLambertMaterial({map:_texture,transparent:true});
        }else{
            _mat = new THREE.MeshLambertMaterial({transparent:true});
        }

        var _plane = new THREE.PlaneGeometry(1,1,1,1);

        var mesh = new THREE.Mesh(_plane,_mat);
        if(data.width&&data.height){
            mesh.scale.set(width,height,1);
        }
        mesh.position.set(0,0,1);
        mesh.name = data.id;
        parent.add(mesh);

        return mesh;
    },
    reLoadElement:function(element,url,width,height){
        var _texture = this.load_texture(url);
        var _mat = new THREE.MeshLambertMaterial({map:_texture,transparent:true});
        element.scale.set(width,height,1);
        element.material.map = _texture;
    },
    clearScene:function () {
        scene.remove(root);
        root = new THREE.Object3D();
        scene.add(root);
        root.position.set(0,0,0);
    },
	delete:function(parent,element){
    	parent.remove(element);
	}
}

//页面默认初始化方法
$(function(){
    view_container = $("#view_container");
    layer_control = $("#layer_control");
    element_control = $("#element_control");

    WebGL_Container = $("#WebGl-Output");
    WebGL.init();

    $("#view_entering").on('hidden.bs.modal', function () {
        $("#viewName").val("");
        $("#view_pic").attr("src","");
        $("#viewSn").val("");
        $("#view_mapid").val("");
    });

    $("#view_insert").on("click",function () {
        $("#view_save").off("click").on("click",function () {
            updateView(function(data){
                var view = new View(data);
            });
        });
        $("#view_entering").modal("show");
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
        /*
        $('#progress .progress-bar').css('width',0 + '%');
        $('#files').empty();
        data.context = $('<div/>').appendTo('#files');
        $.each(data.files, function (index, file) {
            var node = $('<p/>')
                .append($('<span/>').text(file.name));
            node.appendTo(data.context);
        });
        //upload_data = data;
        $("#view_save").data("data",data);*/
        $.each(data.files, function (index, file) {
            var url = getObjectURL(file);
            $("#view_pic").attr("src",url);
            $("#viewpic_upload").click(function(){
                data.submit();
            })
        })
        //alert();
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
                view_container.empty();
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
                if(view){
                    WebGL.clearScene();
                }

               for(var key in data){
                    var viewInfo = data[key];
                    var view = new View(viewInfo);

                    var layerList = viewInfo.layer;

                    for(var layerKey in layerList){
                        var layerInfo = layerList[layerKey];

                        var layer =  view.add_layer(layerInfo);

                        var elementInfo = layerInfo.element;

                        for(var elementKey in elementInfo){

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
            var insert = $("<span></span>",{
                class:"float_r glyphicon glyphicon-plus-sign dis_block mar_t10 mar_r10"
            }).on({
                click:function(){
                    /*
                    $("#element_entering").modal("show");
                    $("#element_save").click(function(){
                        updateElement(_this);
                    });*/
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
                for(var i=0,len = data.length;i<len;i++){
                    var elementInfo = data[i];
                    layer.add_element(elementInfo);
                }
            }
        }
    });
}

//未使用
function query_elementProductMap(element,product){
    var _data = new Object();
    _data["elementSn"] = element.id;
    _data["productSn"] = product.sn;

    $.ajax({
        url:"/perspective/queryElementProductMap",
        type: "POST",
        data:_data,
        dataType:"json",
        success:function(data){
            if(data){
                var sn = data.sn;
                if(sn){
                    $("#element_pic").attr("src",data.url).load(function(){
                        WebGL.reLoadElement(element.element,data.url,data.width,data.height);
                    })
                }

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
                }).on('fileuploadadd', function (e, data) {
                    $.each(data.files, function (index, file) {
                        var url = getObjectURL(file);
                        $("#element_pic").attr("src",url).load(function(){
                            WebGL.reLoadElement(element.element,url,$(this).width(),$(this).height());
                        })
                        $("#elementPictureSave").click(function(){
                            data.submit();
                        })
                    })
                }).on('fileuploaddone', function (e, data) {
                    var returnJsonAry = data.result;
                    var file_data = new Object();
                    $.each(data.result, function (index, file){
                        file_data[index] = file;
                    });

                    _data = new Object();
                    _data["mapid"] = file_data.fileId;
                    _data["elementSn"] = element.id;
                    _data["productSn"] = product.sn;
                    _data["sn"] = sn;

                    alert(_data["sn"]);

                    $.ajax({
                        url:"/perspective/elementProductUpdate",
                        type: "POST",
                        data:_data,
                        dataType:"json",
                        success:function(data){
                            if(data){
                                alert("Hello");
                            }
                        }
                    })
                });
            }
        }
    })
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

    if(!_data["sn"]){
        _data["viewOrder"] = view_container.children.length;
    }

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

function deleteView(view){
    WebGL.clearScene();
}

//更新或者添加层
function  updateLayer(view) {
    var _data = {};
    $("#layer_form input").each(function(){
        var key = $(this).attr("name");
        if(key){
            _data[key] = $(this).val();
        }
    });
    _data["viewSn"] = view.data.id;
    $.ajax({url:"/perspective/layerUpdate",
        type: "POST",
        data:_data,
        dataType:"json",
        success:function(data){
            if(data){
                var layer = view.add_layer(data.id,data.name,1);
            }
        }
    });

}

/*添加图元功能*/
//查询套餐中分类名称作为图元名称
function queryPackageTypeName(layer){
    var _data = {};
    _data["houseStyleSn"] = house_style_sn;
    _data["houseSpaceSn"] = 100010;

    $.ajax({
        url:"/perspective/queryPackageTypeName",
        type: "POST",
        data:_data,
        dataType:"json",
        success:function(data){
            if(data){
                var container = $("#element_check_container");
                container.empty();
                for(var i=0,len=data.length; i<len;i++){
                    var li = $("<li></li>");
                    var checkbox = $("<div></div>").append($("<label></label>").append($("<input type='checkbox'/>").attr("id",data[i].id)).append($("<text></text>").text(data[i].name)));
                    container.append(checkbox);
                }

                $("#element_entering").modal("show");

                $("#element_save").click(function(){
                        _data = {};
                        $("input[type='checkbox']:checked").each(function(){
                            _data["packageTypeSn"] = $(this).attr("id");
                            _data["elementName"] = $(this).parent().text();
                        });
                        _data["layerSn"] = layer.data.id;
                        updateElement(layer.layer,_data);
                    }
                );
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
    _data["sn"] = element.data.id;
    $.ajax({
        url:"/perspective/queryElementProduct",
        type: "POST",
        data:_data,
        dataType:"json",
        success:function(data){
            if(data){
                initProductResult(element,data);
                $("#elementPictureClose");
            }
        }
    })
}

//构造图元多产品显示结果集
function initProductResult(element,data){
    var _tbody = $("#prodcut_container");
    for(var i=0,len=data.length;i<len;i++){
        var product = data[i];
        var _tr = $("<tr></tr>",{
            id:product.sn,
        }).on("click",function(element,product){
            return function(){
                updateElementProductCallback(element,product);
            }
        }(element,product));
        var order = $("<td></td>").text(i);
        var td_id = $("<td></td>").text(product.id);
        var td_name = $("<td></td>").text(product.name);
        var control = $("<td></td>").append($("<div></div>",{
            class:"btn-group btn-group-sm",
        })).append($("<a></a>",{
            href:"#",
            text:"默认展示",
            class:"btn btn-success",
            click:function(element,elementProductSn){
                return function () {
                    updateElementExhibtionMap(element,elementProductSn);
                }
            }(element,product.elementProductSn)
        }));

        _tr.append(order);
        _tr.append(td_id);
        _tr.append(td_name);
        _tr.append(control);

        _tbody.append(_tr);
    }
}

//切换显示图元中关联各产品图片
function updateElementProductCallback(element,product){
    var url = product.url;
    if(url){
        $("#element_pic").attr("src",url).unbind().bind("load",function(){
            WebGL.reLoadElement(element.element,url,product.width,product.height);
        })
    }else{
        $("#element_pic").attr("src","");
        WebGL.reLoadElement(element.element,"",0,0);
    }

    $('#elementupload').off("fileuploadadd").off("fileuploaddone");

    $('#elementupload').on('fileuploadadd', function (e, data) {
        $.each(data.files, function (index, file) {
            var url = getObjectURL(file);
            $("#element_pic").attr("src",url).unbind().bind("load",function(){
                WebGL.reLoadElement(element.element,url,$(this).width(),$(this).height());
            })
            $("#elementPictureSave").off("click").on("click",function(){
                data.submit();
            })
        })
    }).on('fileuploaddone', function (e, data) {
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
    });
}

//更新图元默认显示图片
function updateElementExhibtionMap(element,elementProductSn){
    event.stopPropagation();
    var _data = new Object();
    _data["elementProductSn"] = elementProductSn;
    _data["sn"] = element.data.id;
    $.ajax({
        url:"/perspective/elementExhibitionMapUpdate",
        type: "POST",
        data:_data,
        dataType:"json",
        success:function(data){
            if(data){
                $("#elementPictureClose").data("data",data).off("click").on("click",function(){
                    var _data = $(this).data("data");
                    WebGL.reLoadElement(element.element,_data.url,_data.width,_data.height);
                })
            }
        }
    })
}

//向量转字符串
function vec_to_string(data){
    return data.x.toFixed(3)+","+data.y.toFixed(3);
}

function string_to_vec(data){
    var array = data.split(",");
    var vec = new THREE.Vector3(array.x,array.y,1);
}

function ClearView(parent,child){
    WebGL.delete(parent,child);
    layer_control.empty();
    element_control.empty();
}