function Tab(){
	this.nav;
	this.body;
	this.skip_value;
	this.index = 1;
	this.navigation = -1;
	this.autoskip = true;
	this.exhibitionNum = 5;
	this.total = 0;
	this.total_navigation = 0;
	this.method;
}

Tab.prototype={
	create:function(container,param){
		var _this = this;
		$.extend(this,param);
		this.total_navigation = parseInt((this.total - 1)/this.exhibitionNum);
		this.nav = $("<div></div>").css({
			"width":"auto"
		});
		
		this.body = $("<ul></ul>",{
			class:"pagination"
		}).css({
			"margin":"0px",
			"padding":"0px"
		});
		
		container.append(this.nav);
		
		var pre = $("<div></div>").text("《").on("click",function(){
			_this.pre();
		}).css({
			"height":"34px",
			"line-height":"34px",
			"text-align":"center",
			"width":"34px",	
			"float":"left",
			"border":"1px solid #ddd",
			"border-right":"0px",
			"border-radius":"4px"
		});
		
		var next = $("<div></div>").text("》").on("click",function(){
			_this.next();
		}).css({
			"height":"34px",
			"line-height":"34px",
			"text-align":"center",
			"width":"34px",	
			"float":"left",
			"border":"1px solid #ddd",
			"border-left":"0px",
			"border-radius":"4px"
		});
		
		this.skip_value = $("<input type='text'>").attr("id","skip_index").css({
			"border":"1px solid #ddd",
	    	"border-radius":"4px",
	    	"text-align":"center",
	    	"width":"40px",
	    	"height":"34px",	    
			"line-height":"34px",
			"margin-left":"10px",
			"margin-right":"10px"
		});
		
		var skip = $("<a></a>").text("跳转").on("click",function(){
			_this.skip(_this.skip_value.val());
		})
		
		this.nav.append(pre);
		this.nav.append($("<div></div>").css({"float":"left"}).append(this.body));
		var navigation = parseInt((this.index-1)/this.exhibitionNum);
		this.reload(navigation,this.index);
		this.nav.append(next);
		this.nav.append(this.skip_value).append(skip);
	},
	reload:function(navigation,index){
		if(navigation!=this.navigation){
			this.navigation = navigation;
			if(index!=null&&index!=undefined&&index!=""){
				this.index = index;
			}else{
				this.index = this.navigation * this.exhibitionNum + 1;
			}
			
			var _this = this;
			this.body.empty();
			var start = this.navigation * this.exhibitionNum + 1;
			for(var i=start;i<(start+this.exhibitionNum)&&i<=this.total;i++){
				var element = $("<a></a>").text(i).on("click",function(index){
					return function(){
						_this.index = index;
						_this.body.children().each(function(){
							$(this).removeClass("active");
						})
						$(this).parent().addClass("active");
						if(_this.method!=undefined&&_this.method!=null){
							_this.method();
						}
					}
				}(i));
				this.body.append($("<li></li>").attr("id",i).append(element));
			}
			this.body.find("#"+_this.index).addClass("active");
		}
		//this.body.find("a").first().trigger("click");
	},
	setExhibtionNum:function(value){
		this.exhibitionNum = value;
	},
	pre:function(){
		if(this.navigation > 0){
			var navigation = this.navigation - 1;
			this.reload(navigation,"");
			this.execute();
		}
	},
	next:function(){
		if(this.navigation < this.total_navigation){
			var navigation = this.navigation + 1;
			this.reload(navigation,"");
			this.execute();
		}
	},
	getIndex:function(){
		return this.index;
	},
	setIndex:function(index){
		this.index = index;
	},
	skip:function(index){
		if(!isNaN(index)&&parseInt(index)<=this.total){
			this.index = index;
			var navigation = parseInt((this.index-1)/this.exhibitionNum);
			//this.body.find("a").first().trigger("click");
			this.reload(navigation,this.index);
			this.execute();
		}
		this.skip_value.val("");
	},
	execute:function(){
		$("#"+this.index+">a").trigger("click");
		this.body.find("#"+this.index).addClass("active");
	},
	setStyle:function(param){
		this.nav;
		debugger;
		this.nav.css(param);
		
	}
}