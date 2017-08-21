/**
 * 
 */
var WebGL_Container;
var view_list;
var scaler;
var elementName;
var layerName;
var productList;
var productSn;
var index = 0;
var view_index = 0;

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
    init:function(width,height){
        _offset = WebGL_Container.offset();
        scene = new THREE.Scene();
        camera = new THREE.OrthographicCamera(-1*width/2.0,width/2.0,height/2.0,-1*height/2.0,0,1000);
        // camera = new
		// THREE.PerspectiveCamera(45,WebGL_Container.width()/WebGL_Container.height(),0,1000);
        camera.position.set(0,0,1000);
        camera.lookAt(scene.position);
        scene.add(camera);

        this.root = new THREE.Object3D();
        scene.add(this.root);
        // scene.scale.set(scaler,scaler,1);
        this.root.position.set(0,0,0);
        // this.root.scale.set(scaler,scaler,1);

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

                // console.log(this.INTERSECTED.position.z);

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
        var layer = WebGL.root.getObjectByName(layerName);
        if(layer){
            var intersects = raycaster.intersectObjects(layer.children);
            console.log(intersects.length);
            for (var i=0,len = intersects.length;i<len;i++) {
                if(intersects[i].object.name == elementName){
                    // WebGL.reLoadElement(intersects[i].object,)
                    ExchangeProduct(intersects[i].object);
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
    createView:function (parent,data){
        var _texture = this.load_texture(data.url);
        var _plane = new THREE.PlaneGeometry(1,1,1,1);
        var _mat = new THREE.MeshLambertMaterial({map:_texture,transparent:true});
        var mesh = new THREE.Mesh(_plane,_mat);
        mesh.name = "view_"+data.id;
        mesh.scale.set(data.width,data.height,1);
        mesh.scale.multiplyScalar(scaler);
        this.root.add(mesh);
        mesh.position.set(0,0,1);
        return mesh;
    },
    createLayer:function (parent,data){
        // var target = new THREE.Object3D();
        var _plane = new THREE.PlaneGeometry(1,1,1,1);
        var _mat = new THREE.MeshLambertMaterial({transparent:true});
        var target = new THREE.Mesh(_plane,_mat);
        target.name = "layer_"+data.id;
        if(data.layerOrder){
            var order = parseFloat(data.layerOrder);
            target.position.set(0,0,order*20);
        }
        target.scale.set(scaler,scaler,1);
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
            map.wrapS = THREE.RepeatWrapping;
            map.wrapT = THREE.RepeatWrapping;
            map.needsUpdate = true;
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
    }
}

function QueryPerspectiveInfo(){
    var _data = new Object();
    _data["houseStyleSn"] = "1";
    _data["packageTypeSn"] = "1";
    _data["productSn"] = "100000";
    $.ajax({url:"/perspective/QueryPerspectiveByProductSn",
        type: "POST",
        data:_data,
        dataType:"json",
        success:function(data){
            if(data){
                QueryPerspectiveInfoCallback(data);
            }
        }
    });
}

function QueryPerspectiveInfoCallback(data){
    view_index = 0;
    if(data.length!=0){
        view_list = data;
        QueryViewAllProducts(view_list[view_index]);
        if(data.length>1){

        }
    }
}

function QueryViewAllProducts(data){
    elementName = "element_"+data.elementSn;
    layerName = "layer_"+data.layerSn;
    productSn = data.productSn;
    $.ajax({url:"/perspective/QueryViewElementInfo",
        type: "POST",
        data:data,
        dataType:"json",
        success:function(data){
            if(data){
                QueryViewAllProductsCallback(data);
            }
        }
    });
}

function QueryViewAllProductsCallback(data){
    index = 0;
    productList = data.productList;
    if(data.renderList){
        WebGL.clearScene();
        var view_map = new Object();
        var layer_map;
        for(var i=0,len=data.renderList.length;i<len;i++){
            var _data = data.renderList[i];
            var view = view_map[_data.viewId];
            if(view){
                layer_map = view.layer;
            }else{
                var view_data = new Object();
                view_data.id = _data.viewId;
                view_data.name = _data.viewName;
                view_data.mapid = _data.viewMapId;
                view_data.url = _data.viewMapUrl;
                view_data.width = _data.viewMapWidth;
                view_data.height = _data.viewMapHeight;

                view = new Object();
                view.render = WebGL.createView("",view_data);

                view_map[_data.viewId] = view;
                layer_map = new Object();
                view.layer = layer_map;
            }

            if(_data.layerId){
                var layer = layer_map[_data.layerId];
                if(layer){

                }else{
                    var layer_data = new Object();
                    layer_data.id = _data.layerId;
                    layer_data.name = _data.layerName;
                    layer_data.viewSn = _data.viewSn;
                    layer_data.layerOrder = Object.keys(view.layer).length + 1;
                    var layer = new Object();
                    layer.render = WebGL.createLayer(view,layer_data);
                    layer_map[_data.layerId] = layer;
                }

                if(_data.elementId){
                    var element_data = new Object();
                    element_data.elementId = _data.elementId;
                    element_data.elementName = _data.elementName;
                    element_data.elementOrder = layer.render.children.length + 1;
                    element_data.position = _data.position;
                    element_data.scale = _data.scale;
                    element_data.repeating = _data.repeating;
                    element_data.url = _data.elementMapUrl;
                    element_data.width = _data.elementMapWidth;
                    element_data.height = _data.elementMapHeight;
                    WebGL.createElement(layer.render,element_data);
                }
            }
        }
    }
}

function string_to_vec(data){
    var array = data.split(",");
    var vec = new THREE.Vector3(array[0],array[1],1);
    return vec;
}

function ExchangeProduct(element){
    var i = (++index)%productList.length;
    var data = productList[i];
    productSn = data.productSn;
    WebGL.reLoadElement(element,data);
    $.ajax({
    	url:'/userside/upset',
    	data:{"productSn":productSn},
    	Type:'Get',
    		success:function(data){
    			var jsonobj=JSON.parse(data);
    			$("#pna").text(jsonobj.PRODUCT_NAME)
    			$("#bra").text("品牌:"+jsonobj.BRAND);
    			var length = jsonobj.LENGTH;
    			var wide = jsonobj.WIDE;
    			var height = jsonobj.HEIGHT;
    			$("#lwh").text("规格参数:"+length+"*"+wide+"*"+height)
    			$("#rem").text("简介:"+jsonobj.REMARK);
    			var a = jsonobj.LEFT_IMG_SN;
    			var b = jsonobj.DOWN_IMG_SN;
    			var c = jsonobj.FULL_IMG_SN;
    			var d=  jsonobj.BANNER_IMG_SN;
    			var e = jsonobj.FABRIC_IMG_SN;
    			var f = jsonobj.MATERIAL_IMG_SN;
    			var myArray=new Array(a,b,c,d,e,f);

    			for(var i = 0; i < myArray.length; i++){ 
    				var imgsn=parseFloat(myArray[i]);
    				$("#image").attr("src","$!fs.url(imgsn)"); 
    			}
    		}
    })
    
}

function ExchangeView(){
    var i = (++view_index)%view_list.length;
    QueryViewAllProducts(view_list[i]);
}



