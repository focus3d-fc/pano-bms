function addToShopcar(packageSn){
	
	//alert(packageSn);
	var path=window.document.location.href.substring(0, window.document.location.href.indexOf
			(window.document.location.pathname));//path+"/usersSide/addToCar"
	console.log(packageSn);
	var package_Sn=packageSn;
	$.ajax({
		url:path+"/usersSide/addToCar",
		type:"post",
	    data:{"packageSn":package_Sn},
	    success:function(data){
	    	var msg=JSON.parse(result);
	    	alert(msg);
	    	console.log("success");
	    	if(msg=="nologin"){
	    		console.log("未登录");
	    		location.href="/userside/tologin";
	    	}else if(msg=="yeslogin"){
	    		//alert("已登录，进入购物车");
	    		console.log("已登录");
	    		//location.href="/usersSide/tocar";
	    	}
	    	
	    	
	    	
	    	
	    	
	    	
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