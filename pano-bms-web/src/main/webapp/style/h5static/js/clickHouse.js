function clickHouse(houseSn){
	
	//alert("点击户型进入此方法:"+houseSn);
	var path=window.document.location.href.substring(0, window.document.location.href.indexOf
			(window.document.location.pathname));
	$.ajax({
		url:path+"/usersSide/selectPackage",
		type:"post",
	    data:{"houseSn":houseSn},
	    dataType: "json",
	    success:function(data){
	    	console.log("点击户型图片，返回success");
	    },
	    error:function(xhr,textStatus){
	        console.log('请求错误')
	    }
	});
	
	//------------------------------------------------------
	
	/*alert(packageSn);
	$.ajax({
	    url: "",
	    type:'GET',
	    async:false,
	    timeout:5000,
	    dataType: "json",
	    success:function(data){
	    	
	    },
	    error:function(xhr,textStatus){
	        console.log('请求错误')
	    }
	});*/
	
}