$(function() {

	// 上传图片
	'use strict';
	// Change this to the location of your server-side upload handler:
	var url = 'http://139.196.103.164:8018/pano/fs/upload';
	var uploadButton = $('<button/>').addClass('btn btn-primary').prop(
			'disabled', true).text('Processing...').on('click', function() {
		var $this = $(this);
		var data = $this.data();
		$this.off('click').text('Abort').on('click', function() {
			$this.remove();
			data.abort();
		});
		data.submit().always(function() {
			$this.remove();
		});
	});
	$('#fileupload').fileupload(
			{
				url : url,
				dataType : 'json',
				autoUpload : false,
				acceptFileTypes : /(\.|\/)(gif|jpe?g|png)$/i,
				maxFileSize : 10485760,
				// Enable image resizing, except for Android and Opera,
				// which actually support image resizing, but fail to
				// send Blob objects via XHR requests:
				disableImageResize : /Android(?!.*Chrome)|Opera/
						.test(window.navigator.userAgent),
				previewMaxWidth : 100,
				previewMaxHeight : 100,
				previewCrop : true
			}).on('fileuploadadd', function(e, data) {
		$("#files").children().remove();
		$('#progress .progress-bar').css('width', 0 + '%');

		data.context = $('<div/>').appendTo('#files');
		$.each(data.files, function(index, file) {
			var node = $('<p/>').append($('<span/>').text(file.name));
			if (!index) {
				/*
				 * node.append('<br>')
				 * .append(uploadButton.clone(true).data(data));
				 */
			}
			node.appendTo(data.context);
		});
		data.submit();
	}).on(
			'fileuploadprocessalways',
			function(e, data) {
				var index = data.index;
				var file = data.files[index];
				var node = $(data.context.children()[index]);
				if (file.preview) {
					node.prepend('<br>').prepend(file.preview);
				}
				if (file.error) {
					node.append('<br>').append(
							$('<span class="text-danger"/>').text(file.error));
				}
				/*
				 * if (index + 1 === data.files.length) {
				 * data.context.find('button') .text('Upload') .prop('disabled',
				 * !!data.files.error); }
				 */
			}).on('fileuploadprogressall', function(e, data) {
		var progress = parseInt(data.loaded / data.total * 100, 10);
		$('#progress .progress-bar').css('width', progress + '%');
	}).on('fileuploaddone', function(e, data) {
		$("#resultInfo").text("");
		var returnJsonAry = data.result;
		$.each(data.result, function(index, file) {
			// alert(index + "," + file);
			var txt = $("#resultInfo").text();
			// alert(txt);
			$("#fullimgsn").val(txt.substr(1));
			$("#resultInfo").text(txt + "," + file);

		});
		$("#resultInfo").text("");
	}).on(
			'fileuploadfail',
			function(e, data) {
				$.each(data.files, function(index) {
					var error = $('<span class="text-danger"/>').text(
							'File upload failed.');
					$(data.context.children()[index]).append('<br>').append(
							error);
				});
			}).prop('disabled', !$.support.fileInput).parent().addClass(
			$.support.fileInput ? undefined : 'disabled');

});