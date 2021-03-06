var upload_url = "http://file.joy-homeplus.com/pano/fs/upload"; 
$(function(){
	$('#fileupload').fileupload({
        url: upload_url,
        dataType: 'json',
        maxNumberOfFiles:1,
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
            $("#viewpic_upload").off("click").click(function(){
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
        if($.isArray( returnJsonAry )){
        	 $.each(returnJsonAry, function (index, file){
                 $("#fullimgsn").val(file.fileId);
                 
                 $("#viewpic_upload").hide();
                 $("#view_save").show();
             });
        }else{
        	 $("#fullimgsn").val(returnJsonAry.fileId);
             
             $("#viewpic_upload").hide();
             $("#view_save").show();
        }
       
    }).on('fileuploadfail', function (e, data) {
        $.each(data.files, function (index) {
            var error = $('<span class="text-danger"/>').text('File upload failed.');
            $(data.context.children()[index])
                .append('<br>')
                .append(error);
        });
    }).on("change",function(e, data) { 
        if(data.files.length > 1){ 
            alert("Max 1 files are allowed") 
            return false; 
        } 
    }).on("drop",function(e, data){ 
        if(data.files.length > 1){ 
            alert("Max 1 files are allowed") 
            return false;
        } 
    }).prop('disabled', !$.support.fileInput)
        .parent().addClass($.support.fileInput ? undefined : 'disabled');

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
});