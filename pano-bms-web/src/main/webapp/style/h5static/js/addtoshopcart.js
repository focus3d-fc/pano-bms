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
	    	//alert("success!");
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