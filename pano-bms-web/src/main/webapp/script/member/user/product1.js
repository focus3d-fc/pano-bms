     $(function(){
    	 
    	 
	    //上传图片	
	    	 'use strict';
	        // Change this to the location of your server-side upload handler:
	        var url =  'http://file.joy-homeplus.com/pano/fs/upload';
	        var uploadButton = $('<button/>')
	                .addClass('btn btn-primary')
	                .prop('disabled', true)
	                .text('Processing...')
	                .on('click', function () {
	                    var $this = $(this);
	                    var data = $this.data();
	                    $this.off('click')
	    					.text('Abort')
	                        .on('click', function () {
	                            $this.remove();
	                            data.abort();
	                        });
	                    data.submit().always(function () {
	                        $this.remove();
	                    });
	                });
	        $('#fileupload0').fileupload({
	            url: url,
	            dataType: 'json',
	            autoUpload: false,
	            acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i,
	            maxFileSize: 10485760,
	            // Enable image resizing, except for Android and Opera,
	            // which actually support image resizing, but fail to
	            // send Blob objects via XHR requests:
	            disableImageResize: /Android(?!.*Chrome)|Opera/
	                .test(window.navigator.userAgent),
	            previewMaxWidth: 100,
	            previewMaxHeight: 100,
	            previewCrop: true
	        }).on('fileuploadadd', function (e, data) {
	        	$("#files0").children().remove();
	        	$('#progress0 .progress-bar').css(
	    	            'width',
	    	            0 + '%'
	    	        );
	        	
	            data.context = $('<div/>').appendTo('#files0');
	            $.each(data.files, function (index, file) {
	                var node = $('<p/>')
	                        .append($('<span/>').text(file.name));
	                if (!index) {
	                   /* node.append('<br>')
	                        .append(uploadButton.clone(true).data(data));*/
	                }
	                node.appendTo(data.context);
	            });
	            data.submit();
	        }).on('fileuploadprocessalways', function (e, data) {
	            var index = data.index;
	            var file = data.files[index];
	            var node = $(data.context.children()[index]);
	            if (file.preview) {
	                node.prepend('<br>')
	                    .prepend(file.preview);
	            }
	            if (file.error) {
	                node.append('<br>')
	                    .append($('<span class="text-danger"/>').text(file.error));
	            }
	            /*if (index + 1 === data.files.length) {
	                data.context.find('button')
	                    .text('Upload')
	                    .prop('disabled', !!data.files.error);
	            }*/
	        }).on('fileuploadprogressall', function (e, data) {
	            var progress = parseInt(data.loaded / data.total * 100, 10);
	            $('#progress0 .progress-bar').css(
	                'width',
	                progress + '%'
	            );
	        }).on('fileuploaddone', function (e, data) {
	        	$("#resultInfo0").text("");
	        	var returnJsonAry = data.result;
	            $.each(data.result, function (index, file) {
	            	//alert(index + "," + file);
	            	var txt = $("#resultInfo0").text();
	            	//alert(txt);
	            	$("#fullimgsn01").val(txt.substr(1));
	            	$("#resultInfo0").text(txt + "," + file);
	            	
	            });
	            $("#resultInfo0").text("");
	        }).on('fileuploadfail', function (e, data) {
	            $.each(data.files, function (index) {
	                var error = $('<span class="text-danger"/>').text('File upload failed.');
	                $(data.context.children()[index])
	                    .append('<br>')
	                    .append(error);
	            });
	        }).prop('disabled', !$.support.fileInput)
	            .parent().addClass($.support.fileInput ? undefined : 'disabled');
	    	
	            
	    	//第二张上传
	        var uploadButton1 = $('<button/>')
            .addClass('btn btn-primary')
            .prop('disabled', true)
            .text('Processing...')
            .on('click', function () {
                var $this = $(this);
                var data = $this.data();
                $this.off('click')
					.text('Abort')
                    .on('click', function () {
                        $this.remove();
                        data.abort();
                    });
                data.submit().always(function () {
                    $this.remove();
                });
            });
    $('#fileupload01').fileupload({
        url: url,
        dataType: 'json',
        autoUpload: false,
        acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i,
        maxFileSize: 10485760,
        // Enable image resizing, except for Android and Opera,
        // which actually support image resizing, but fail to
        // send Blob objects via XHR requests:
        disableImageResize: /Android(?!.*Chrome)|Opera/
            .test(window.navigator.userAgent),
        previewMaxWidth: 100,
        previewMaxHeight: 100,
        previewCrop: true
    }).on('fileuploadadd', function (e, data) {
    	$("#files01").children().remove();
    	$('#progress01 .progress-bar').css(
	            'width',
	            0 + '%'
	        );
    	
        data.context = $('<div/>').appendTo('#files01');
        $.each(data.files, function (index, file) {
            var node = $('<p/>')
                    .append($('<span/>').text(file.name));
            if (!index) {
               /* node.append('<br>')
                    .append(uploadButton.clone(true).data(data));*/
            }
            node.appendTo(data.context);
        });
        data.submit();
    }).on('fileuploadprocessalways', function (e, data) {
        var index = data.index;
        var file = data.files[index];
        var node = $(data.context.children()[index]);
        if (file.preview) {
            node.prepend('<br>')
                .prepend(file.preview);
        }
        if (file.error) {
            node.append('<br>')
                .append($('<span class="text-danger"/>').text(file.error));
        }
        /*if (index + 1 === data.files.length) {
            data.context.find('button')
                .text('Upload')
                .prop('disabled', !!data.files.error);
        }*/
    }).on('fileuploadprogressall', function (e, data) {
        var progress = parseInt(data.loaded / data.total * 100, 10);
        $('#progress01 .progress-bar').css(
            'width',
            progress + '%'
        );
    }).on('fileuploaddone', function (e, data) {
    	$("#resultInfo01").text("");
    	var returnJsonAry = data.result;
        $.each(data.result, function (index, file) {
        	//alert(index + "," + file);
        	var txt = $("#resultInfo01").text();
        	$("#leftimgsn01").val(txt.substr(1));
        	$("#resultInfo01").text(txt + "," + file);
        });
        $("#resultInfo01").text("");
    }).on('fileuploadfail', function (e, data) {
        $.each(data.files, function (index) {
            var error = $('<span class="text-danger"/>').text('File upload failed.');
            $(data.context.children()[index])
                .append('<br>')
                .append(error);
        });
    }).prop('disabled', !$.support.fileInput)
        .parent().addClass($.support.fileInput ? undefined : 'disabled');
	            
	  
     //第3张上传
    var uploadButton2 = $('<button/>')
    .addClass('btn btn-primary')
    .prop('disabled', true)
    .text('Processing...')
    .on('click', function () {
        var $this = $(this);
        var data = $this.data();
        $this.off('click')
			.text('Abort')
            .on('click', function () {
                $this.remove();
                data.abort();
            });
        data.submit().always(function () {
            $this.remove();
        });
    });
$('#fileupload02').fileupload({
url: url,
dataType: 'json',
autoUpload: false,
acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i,
maxFileSize: 10485760,
// Enable image resizing, except for Android and Opera,
// which actually support image resizing, but fail to
// send Blob objects via XHR requests:
disableImageResize: /Android(?!.*Chrome)|Opera/
    .test(window.navigator.userAgent),
previewMaxWidth: 100,
previewMaxHeight: 100,
previewCrop: true
}).on('fileuploadadd', function (e, data) {
$("#files02").children().remove();
$('#progress02 .progress-bar').css(
        'width',
        0 + '%'
    );

data.context = $('<div/>').appendTo('#files02');
$.each(data.files, function (index, file) {
    var node = $('<p/>')
            .append($('<span/>').text(file.name));
    if (!index) {
       /* node.append('<br>')
            .append(uploadButton.clone(true).data(data));*/
    }
    node.appendTo(data.context);
});
data.submit();
}).on('fileuploadprocessalways', function (e, data) {
var index = data.index;
var file = data.files[index];
var node = $(data.context.children()[index]);
if (file.preview) {
    node.prepend('<br>')
        .prepend(file.preview);
}
if (file.error) {
    node.append('<br>')
        .append($('<span class="text-danger"/>').text(file.error));
}
/*if (index + 1 === data.files.length) {
    data.context.find('button')
        .text('Upload')
        .prop('disabled', !!data.files.error);
}*/
}).on('fileuploadprogressall', function (e, data) {
var progress = parseInt(data.loaded / data.total * 100, 10);
$('#progress02 .progress-bar').css(
    'width',
    progress + '%'
);
}).on('fileuploaddone', function (e, data) {
$("#resultInfo02").text("");
var returnJsonAry = data.result;
$.each(data.result, function (index, file) {
	//alert(index + "," + file);
	var txt = $("#resultInfo02").text();
	$("#downimgsn01").val(txt.substr(1));
	$("#resultInfo02").text(txt + "," + file);
});
$("#resultInfo02").text("");
}).on('fileuploadfail', function (e, data) {
$.each(data.files, function (index) {
    var error = $('<span class="text-danger"/>').text('File upload failed.');
    $(data.context.children()[index])
        .append('<br>')
        .append(error);
});
}).prop('disabled', !$.support.fileInput)
.parent().addClass($.support.fileInput ? undefined : 'disabled');
    
    
           
            //第4张上传
var uploadButton3 = $('<button/>')
.addClass('btn btn-primary')
.prop('disabled', true)
.text('Processing...')
.on('click', function () {
    var $this = $(this);
    var data = $this.data();
    $this.off('click')
		.text('Abort')
        .on('click', function () {
            $this.remove();
            data.abort();
        });
    data.submit().always(function () {
        $this.remove();
    });
});
$('#fileupload03').fileupload({
url: url,
dataType: 'json',
autoUpload: false,
acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i,
maxFileSize: 10485760,
// Enable image resizing, except for Android and Opera,
// which actually support image resizing, but fail to
// send Blob objects via XHR requests:
disableImageResize: /Android(?!.*Chrome)|Opera/
.test(window.navigator.userAgent),
previewMaxWidth: 100,
previewMaxHeight: 100,
previewCrop: true
}).on('fileuploadadd', function (e, data) {
$("#files03").children().remove();
$('#progress03 .progress-bar').css(
    'width',
    0 + '%'
);

data.context = $('<div/>').appendTo('#files03');
$.each(data.files, function (index, file) {
var node = $('<p/>')
        .append($('<span/>').text(file.name));
if (!index) {
   /* node.append('<br>')
        .append(uploadButton.clone(true).data(data));*/
}
node.appendTo(data.context);
});
data.submit();
}).on('fileuploadprocessalways', function (e, data) {
var index = data.index;
var file = data.files[index];
var node = $(data.context.children()[index]);
if (file.preview) {
node.prepend('<br>')
    .prepend(file.preview);
}
if (file.error) {
node.append('<br>')
    .append($('<span class="text-danger"/>').text(file.error));
}
/*if (index + 1 === data.files.length) {
data.context.find('button')
    .text('Upload')
    .prop('disabled', !!data.files.error);
}*/
}).on('fileuploadprogressall', function (e, data) {
var progress = parseInt(data.loaded / data.total * 100, 10);
$('#progress03 .progress-bar').css(
'width',
progress + '%'
);
}).on('fileuploaddone', function (e, data) {
$("#resultInfo03").text("");
var returnJsonAry = data.result;
$.each(data.result, function (index, file) {
//alert(index + "," + file);
var txt = $("#resultInfo03").text();
  $("#mtimgsn01").val(txt.substr(1));
$("#resultInfo03").text(txt + "," + file);
});
    $("#resultInfo03").text("");
}).on('fileuploadfail', function (e, data) {
$.each(data.files, function (index) {
var error = $('<span class="text-danger"/>').text('File upload failed.');
$(data.context.children()[index])
    .append('<br>')
    .append(error);
});
}).prop('disabled', !$.support.fileInput)
.parent().addClass($.support.fileInput ? undefined : 'disabled');            

           
          //第5张上传
var uploadButton4 = $('<button/>')
.addClass('btn btn-primary')
.prop('disabled', true)
.text('Processing...')
.on('click', function () {
    var $this = $(this);
    var data = $this.data();
    $this.off('click')
		.text('Abort')
        .on('click', function () {
            $this.remove();
            data.abort();
        });
    data.submit().always(function () {
        $this.remove();
    });
});
$('#fileupload04').fileupload({
url: url,
dataType: 'json',
autoUpload: false,
acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i,
maxFileSize: 10485760,
// Enable image resizing, except for Android and Opera,
// which actually support image resizing, but fail to
// send Blob objects via XHR requests:
disableImageResize: /Android(?!.*Chrome)|Opera/
.test(window.navigator.userAgent),
previewMaxWidth: 100,
previewMaxHeight: 100,
previewCrop: true
}).on('fileuploadadd', function (e, data) {
$("#files04").children().remove();
$('#progress04 .progress-bar').css(
    'width',
    0 + '%'
);

data.context = $('<div/>').appendTo('#files04');
$.each(data.files, function (index, file) {
var node = $('<p/>')
        .append($('<span/>').text(file.name));
if (!index) {
   /* node.append('<br>')
        .append(uploadButton.clone(true).data(data));*/
}
node.appendTo(data.context);
});
data.submit();
}).on('fileuploadprocessalways', function (e, data) {
var index = data.index;
var file = data.files[index];
var node = $(data.context.children()[index]);
if (file.preview) {
node.prepend('<br>')
    .prepend(file.preview);
}
if (file.error) {
node.append('<br>')
    .append($('<span class="text-danger"/>').text(file.error));
}
/*if (index + 1 === data.files.length) {
data.context.find('button')
    .text('Upload')
    .prop('disabled', !!data.files.error);
}*/
}).on('fileuploadprogressall', function (e, data) {
var progress = parseInt(data.loaded / data.total * 100, 10);
$('#progress04 .progress-bar').css(
'width',
progress + '%'
);
}).on('fileuploaddone', function (e, data) {
$("#resultInfo04").text("");
var returnJsonAry = data.result;
$.each(data.result, function (index, file) {
//alert(index + "," + file);
var txt = $("#resultInfo04").text();
   $("#fbcimgsn01").val(txt.substr(1));
$("#resultInfo04").text(txt + "," + file);
});
  $("#resultInfo04").text("");
}).on('fileuploadfail', function (e, data) {
$.each(data.files, function (index) {
var error = $('<span class="text-danger"/>').text('File upload failed.');
$(data.context.children()[index])
    .append('<br>')
    .append(error);
});
}).prop('disabled', !$.support.fileInput)
.parent().addClass($.support.fileInput ? undefined : 'disabled');

    }); 