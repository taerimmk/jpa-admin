<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- Core JS files -->
<script type="text/javascript"
	src="/assets/js/plugins/loaders/pace.min.js"></script>
<script type="text/javascript"
	src="/assets/js/core/libraries/jquery.min.js"></script>
<script type="text/javascript"
	src="/assets/js/core/libraries/jquery_ui/core.min.js"></script>

<script type="text/javascript"
	src="/assets/js/core/libraries/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/assets/js/plugins/loaders/blockui.min.js"></script>
<!-- /core JS files -->

<!-- Theme JS files -->
<script type="text/javascript"
	src="/assets/js/core/libraries/jasny_bootstrap.min.js"></script>
<script type="text/javascript"
	src="/assets/js/plugins/forms/styling/uniform.min.js"></script>
<script type="text/javascript"
	src="/assets/js/plugins/forms/inputs/autosize.min.js"></script>
<script type="text/javascript"
	src="/assets/js/plugins/forms/inputs/formatter.min.js"></script>
<script type="text/javascript"
	src="/assets/js/plugins/forms/inputs/passy.js"></script>
<script type="text/javascript"
	src="/assets/js/plugins/forms/inputs/maxlength.min.js"></script>

<script type="text/javascript"
	src="/assets/js/pages/form_controls_extended.js"></script>


<!-- <script type="text/javascript"
	src="/assets/js/plugins/notifications/jgrowl.min.js"></script> -->
<script type="text/javascript"
	src="/assets/js/plugins/ui/moment/moment.min.js"></script>
<script type="text/javascript"
	src="/assets/js/plugins/pickers/daterangepicker.js"></script>

<!-- <script type="text/javascript"
	src="/assets/js/plugins/pickers/anytime.min.js"></script> -->
<!-- <script type="text/javascript"
	src="/assets/js/plugins/pickers/pickadate/picker.js"></script>
<script type="text/javascript"
	src="/assets/js/plugins/pickers/pickadate/picker.date.js"></script>
<script type="text/javascript"
	src="/assets/js/plugins/pickers/pickadate/picker.time.js"></script>
<script type="text/javascript"
	src="/assets/js/plugins/pickers/pickadate/legacy.js"></script> -->

<script type="text/javascript" src="/assets/js/core/app.js"></script>

<!-- <script type="text/javascript" src="/assets/js/pages/picker_date.js"></script> -->
<!-- /theme JS files -->

<script type="text/javascript"
	src="/assets/js/plugins/forms/styling/switchery.min.js"></script>
<script type="text/javascript"
	src="/assets/js/plugins/forms/inputs/touchspin.min.js"></script>
<script type="text/javascript"
	src="/assets/js/pages/form_input_groups.js"></script>

<script type="text/javascript"
	src="/assets/js/plugins/editors/summernote/summernote.min.js"></script>
<script type="text/javascript"
	src="/assets/js/plugins/pagination/bootpag.min.js"></script>
<script type="text/javascript"
	src="/assets/js/plugins/forms/selects/select2.min.js"></script>
<script type="text/javascript" src="/assets/js/pages/form_layouts.js"></script>

<!-- <script type="text/javascript"
	src="/assets/js/plugins/summernote/summernote.min.js"></script> -->
<script type="text/javascript">
	function sendFile(file, editor, welEditable) {
		data = new FormData();
		data.append("file", file);
		$.ajax({
			data : data,
			type : "POST",
			url : "/common/ajax/saveimage.json",
			cache : false,
			contentType : false,
			processData : false,
			dataType : "json",
			success : function(data) {
				var url = data.url;
				editor.insertImage(welEditable, url);
			}
		});
	}
</script>