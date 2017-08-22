/**
 * 全景热点点击回调打开产品详情页
 * 
 */
//var pano_remote_domain = "http://139.196.103.164:8038"
var pano_remote_domain = "http://pano.joy-homeplus.com"
$(function(){
	//风格id
	var styleId = $("#styleId").val();
	$.ajax({
	    url: pano_remote_domain + "/rm-pano/" + styleId + "/houses",
	    type:'GET',
	    async:false,
	    timeout:5000,
	    dataType: "jsonp",
	    jsonp: "jsoncallback", 
	    success:function(data){
	    	$("#scrollArea").children().remove();
	    	for(var i in data){
	    		var encryptSn = data[i].encryptSn;
	    		var hosueName = data[i].houseName;
	    		var houseImg = data[i].houseImg;
	    		var panoId = data[i].panoId;
	    		var img = $("<img/>").attr("src", houseImg).attr("height", 80).attr("width", 80).css("margin-left", 10).attr("pano_id", panoId).attr("encryptSn", encryptSn).appendTo($("#scrollArea"));
	    		img.hide();
	    	}
	    	//户型sn
	    	var houseSn = $("#scrollArea").find("img:eq(0)").attr("encryptSn");
	    	//设置当前选中的户型sn
	    	$("#houseId").val(houseSn);
	    	//默认打开一个户型全景
	    	var defaultPanoId = $("#scrollArea").find("img:eq(0)").attr("pano_id");
	    	$("#panoId").val(defaultPanoId);
	    	if(defaultPanoId){
	    		$.ajax({
	    		    url: pano_remote_domain + "/rm-pano/" + defaultPanoId,
	    		    type:'GET',
	    		    async:false,
	    		    timeout:5000,
	    		    dataType: "jsonp",
	    		    jsonp: "jsoncallback", 
	    		    success:function(data){
	    		    	var xmlUrl = data.xmlUrl;
	    		    	var panoDomain = data.panoDomain;
	    		    	var skinVersion = data.skinVersion;
	    		    	var apiVersion = data.apiVersion;
	    		    	embedpano({id:"krpanoSWFObject", xml:xmlUrl, target:"pano", html5:"auto", initvars:{pano_domain:panoDomain,skin_version:skinVersion,api_version:apiVersion}, mobilescale:1.0, passQueryParameters:true,consolelog:true});
	    		    },
	    		    error:function(xhr,textStatus){
	    		        console.log('请求错误')
	    		    }
	    		});
	    	}
	    },
	    error:function(xhr,textStatus){
	        console.log('请求错误')
	    }
	});
	


	
});

//显示热点
function showHotspot(data){
	for(var i in data){
		var name = data[i].name;
		var ath = data[i].ath;
		var atv = data[i].atv;
		var styleId = data[i].styleId;
		var type = data[i].type;
		var targetId = data[i].targetId;
		var targetName = data[i].targetName;
		var extend = data[i].extend;
		var imgType = data[i].imgType;
		editorKrpano().call("addhotspot(" + name + ")");
		editorKrpano().call("set(hotspot[" + name + "].ath," + ath + ")");
		editorKrpano().call("set(hotspot[" + name + "].atv," + atv + ")");
		editorKrpano().call("set(hotspot[" + name + "].htType," + type + ")");
		editorKrpano().call("hotspot[" + name + "].loadstyle(" + styleId + ")");
		if(type === "1"){
			editorKrpano().call("set(hotspot[" + name + "].linkedscene," + targetId + ")");
		}
		if(type === "2"){
			editorKrpano().call("set(hotspot[" + name + "].openwin," + targetId + ")");
			editorKrpano().call("set(hotspot[" + name + "].extendf1," + extend + ")");
		}
		if(imgType === "4"){
			editorKrpano().call("add_hotspot_headtitle_4(" + name + "," + targetName + ")");
		} else {
			editorKrpano().call("add_hotspot_headtitle(" + name + "," + targetName + ")");
		}
	}
}
//点击户型按钮
function getHouse(){
	$("#hx-swiper-wrapper").children().remove();
	var styleId = $("#styleId").val();
	$.ajax({
	    url: pano_remote_domain + "/rm-pano/" + styleId + "/houses",
	    type:'GET',
	    async:false,
	    timeout:5000,
	    dataType: "jsonp",
	    jsonp: "jsoncallback", 
	    success:function(data){
	    	$("#debugger").children().remove();
	    	for(var i in data){
	    		var encryptSn = data[i].encryptSn;
	    		var hosueName = data[i].houseName;
	    		var houseImg = data[i].houseImg;
	    		var panoId = data[i].panoId;
	    		 var img = $("<img/>").attr("src", houseImg).attr("pano_id",panoId).attr("encryptSn", encryptSn);
	    		 $("<div/>").addClass("bd-r2").addClass("swiper-slide" + (i == 0 ? " bd-r " : "")).append($("<div/>").append(img).append($("<p/>").text(hosueName))).appendTo($("#hx-swiper-wrapper"));
	    		//绑定点击户型图片事件，切换户型全景
	    		img.bind("click", function(){
	    			var houseSn = $(this).attr("encryptSn");
	    			clickHouse(houseSn);
	    			//alert("户型sn:"+houseSn);
	    			
	    			//设置当前选中的户型sn
	    			$("#houseId").val(houseSn);
	    			var panoId = $(this).attr("pano_id");
	    			$("#panoId").val(panoId);
	    			$.ajax({
	    			    url: pano_remote_domain + "/rm-pano/" + panoId,
	    			    type:'GET',
	    			    async:false,
	    			    timeout:5000,
	    			    dataType: "jsonp",
	    			    jsonp: "jsoncallback", 
	    			    success:function(data){
	    			    	var xmlUrl = data.xmlUrl;
	    			    	var panoDomain = data.panoDomain;
	    			    	var skinVersion = data.skinVersion;
	    			    	var apiVersion = data.apiVersion;
	    			    	$("#pano").children().remove();
	    			       	embedpano({id:"krpanoSWFObject", xml:xmlUrl, target:"pano", html5:"auto", initvars:{pano_domain:panoDomain,skin_version:skinVersion,api_version:apiVersion}, mobilescale:1.0, passQueryParameters:true});
	    			    },
	    			    error:function(xhr,textStatus){
	    			        console.log('请求错误')
	    			    }
	    			});
	    		});
	    	}
	    },
	    error:function(xhr,textStatus){
	        console.log('请求错误')
    }
	});
}
//点击房间按钮
function getFjshow(panoId){
	$("#hx-swiper-wrapper").children().remove();
	$.ajax({
	    url: pano_remote_domain + "/rm-pano/" + panoId + "/scenes",
	    type:'GET',
	    async:false,
	    timeout:5000,
	    dataType: "jsonp",
	    jsonp: "jsoncallback", 
	    success:function(data){
	    	$("#scrollArea").children().remove();
	    	for(var i in data){
	    		var sceneId = data[i].sceneId;
	    		var sceneName = data[i].sceneName;
	    		var sceneThumb = data[i].sceneThumb;
	    		
	    		var img = $("<img/>").attr("src", sceneThumb).attr("scene_id",sceneId);
	    		 $("<div/>").addClass("bd-r2").addClass("swiper-slide" + (i == 0 ? " bd-r " : "")).append($("<div/>").append(img).append($("<p/>").text(sceneName))).appendTo($("#hx-swiper-wrapper"));
	    		
	    		//点击房间图片，切换场景
	    		img.bind("click", function(){
	    			editorKrpano().call("loadscene(" + $(this).attr("scene_id") + ",null, MERGE, OPENBLEND(0.5, 0.0, 0.75, 0.05, linear))");
	    		});
	    	}
	    },
	    error:function(xhr,textStatus){
	        console.log('请求错误')
	    }
	});
};
//点击套餐按钮
function getTcshow(houseId){
	$("#tc-swiper-wrapper").children().remove();
	//风格id
	var styleId = $("#styleId").val();
	//户型id
	$.ajax({
	    url: pano_remote_domain + "/rm-pano/" + styleId + "/" + houseId + "/packages",
	    type:'GET',
	    async:false,
	    timeout:5000,
	    dataType: "jsonp",
	    jsonp: "jsoncallback", 
	    success:function(data){
	    	for(var i in data){
	    		var sn = data[i].sn;
	    		var name = data[i].name;
	    		var imgUrl = data[i].imgUrl;
	    		var img = $("<img/>").attr("src", imgUrl).attr("package_sn",sn);
	    		$("<div/>").addClass("bd-r1").addClass("swiper-slide" + (i == 0 ? " bd-r " : "")).append($("<div/>").append(img).append($("<p/>").text(name))).appendTo($("#tc-swiper-wrapper"));
//	    		img.css({'width','.65rem'},
//	    				{'height','.65rem'})
	    		
	    		
	    		img.bind("click", function(){
	    			//显示热点
	    			//全景id
	    			var panoId = $("#panoId").val();
	    			//场景id
	    			var sceneId = editorKrpano().get("xml.scene");
	    			//套餐sn
	    			var packageSn = $(this).attr("package_sn");
	    			addToShopcar(packageSn);
	    			//获取当前场景下的套餐下所有类别的热点
	    			$.ajax({
	    			    url: pano_remote_domain + "/rm-pano/hotspots",
	    			    type:'GET',
	    			    async:false,
	    			    timeout:5000,
	    			    data:{
	    			    	panoId : panoId,
	    			    	sceneId : sceneId,
	    			    	packageSn : packageSn
	    			    },
	    			    dataType: "jsonp",
	    			    jsonp: "jsoncallback", 
	    			    success:function(data){
	    			    	showHotspot(data);
	    			    },
	    			    error:function(xhr,textStatus){
	    			        console.log('请求错误')
	    			    }
	    			});
	    		});
	    	}
	    	
	    },
	    error:function(xhr,textStatus){
	        console.log('请求错误')
	    }
	});
};
/**
 * 
 * 点击全景产品热点回调方法
 * packageSn：套餐sn
 * productSn：产品sn
 */
function openHotspotWin(packageSn, packageTypeSn){
	//alert("这里通过套餐sn:" + packageSn +  " 分类sn：" + packageTypeSn + " 查询下面的产品信息");
	//产品详情页
	$.ajax({
	    url: pano_remote_domain + "/rm-pano/products",
	    type:'GET',
	    async:false,
	    timeout:5000,
	    data : {
	    	packageSn : packageSn,
	    	packageTypeSn : packageTypeSn
	    },
	    dataType: "jsonp",
	    jsonp: "jsoncallback", 
	    success:function(data){
	    	var spaceSn = data.spaceSn;//空间sn
	    	var houseStyleSn = data.houseStyleSn;//户型风格sn
	    	var packageSn = data.packageSn;//户型风格套餐sn
	    	var packageTypeSn = data.packageTypeSn;//套餐类别sn
	    	var productAry = data.products;
	    	for(var i in productAry){
	    		var product = productAry[i];
	    		//名称
	    		var name = product.name;
	    		//材质
	    		var materialName = product.materialName;
	    		//颜色
	    		var materialColor = product.materialColor;
	    		//参数
	    		var parameter = product.parameter;
	    		//货号
	    		var model = product.model;
	    		//图片
	    		var imgUrl = product.imgUrl;
	    		//显示产品信息
	    		try{
	    			var nameP = $("<p/>").text("产品：").append($("<span/>").text(name));
	    			var materialNameP = $("<p/>").text("材质：").append($("<span/>").text(materialName));
	    			var materialColorP = $("<p/>").text("颜色：").append($("<span/>").text(materialColor));
	    			var parameterP = $("<p/>").text("参数：").append($("<span/>").text(parameter));
	    			var modelP = $("<p/>").text("货号：").append($("<span/>").text(model));
	    			var imgHt = $("<img/>").attr("src", imgUrl);
	    			var aHt = $("<a/>").addClass("shopDetail").attr("href", "/perspective/QueryPerspective").text("查看详情");
	    			$("<div/>").addClass("swiper-slide").append(nameP).append(materialNameP).append(materialColorP).append(modelP).append(imgHt).append(aHt).appendTo($("#product-swiper-wrapper"));
	    			
	    		}catch (e) {debugger;
					// TODO: handle exception
				}
	    	}
	    	$(".rd-show").show();
	    },
	    error:function(xhr,textStatus){
	        console.log('请求错误')
	    }
	});
}

/**
 * 全景客户端
 */
function editorKrpano() 
{
	return document.getElementById("krpanoSWFObject");
}