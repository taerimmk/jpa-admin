<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>

<script type="text/javascript" src="/assets/js/html2canvas.min.js"></script>
<script type="text/javascript" src="/assets/js/html2canvas.svg.min.js"></script>
<script type="text/javascript" src="/assets/js/FileSaver.min.js"></script>
<style type="text/css">
canvas {
	left: 0px;
}

#download {
	float: left;
	cursor: pointer;
	color: #ccc;
	padding: 3px;
}

#download:hover {
	color: #fff;
}
</style>
</head>

<body>
	<!-- <div style="position: absolute; top: 0px; left: 0px;">
		<img src="/assets/images/coupon_bg-01.png" style="width: 1000px;" />
	</div>
	<div style="position: absolute; font-size: 36px; top: 0px; left: 10px;">test</div> -->
	<div id="testCoupon"
		style="background-image: url('/assets/images/coupon_bg-01-1000.png'); background-size: 1000px 323px; background-repeat: no-repeat; height: 323px; width: 1000px;">
		<div style="color: #fff; padding: 10px; float: left; width: 200px;">
			<p style="font-size: 14px; color: #ffffff;">주요혜택</p>
			<p style="font-size: 14px; color: #ffffff;">${companyRes.companyLocales[0].benefit }asfdasfdasfdasfdasdsdafsafd</p>
		</div>
		<div style="padding: 10px; left: 200px; float: left;">
			<p style="font-size: 14px; color: #000000;">주요혜택</p>
			<p style="font-size: 14px; color: #000000;">${companyRes.companyLocales[0].benefit }</p>
		</div>

	</div>
	<a id="download">Download as image</a>
	<input type="button" id="saveImg" value="저장" />
	<%-- <canvas id="my-canvas"> </canvas> --%>
	<div id="test" style="display: none;"></div>
	<jsp:include page="../inc/footerResources.jsp" />
	<script type="text/javascript">
		/* var canvas = document.getElementById("my-canvas"), ctx = canvas
				.getContext("2d"); */

		html2canvas($("#testCoupon"), {
			onrendered : function(canvas) {
				//document.body.appendChild(canvas);
				$("#test").html(canvas);
			}
		});
		$(function() {
			$("#saveImg").on("click", function() {
				sendBase64Img();
			});
		});
		function downloadCanvas(link, canvasId, filename) {
			link.href = document.getElementsByTagName("canvas")[0].toDataURL();
			link.download = filename;
		}

		document.getElementById('download').addEventListener('click',
				function() {
					downloadCanvas(this, 'canvas', 'test.png');
				}, false);
		function sendBase64Img() {
			var canvas2 = document.getElementsByTagName("canvas")[0];
			var dataURL = canvas2.toDataURL();//이미지 데이터가 base64 문자열로 인코딩된 데이터

			$
					.ajax(
							{
								type : "POST",
								url : "/company/saveCoupon.json",
								contentType : "application/x-www-form-urlencoded; charset=utf-8",
								data : {
									"imgBase64" : dataURL,
									"uuid" : "${companyRes.fileuuid}"
								}
							}).success(function(o) {
						alert('선택영역을 서버의 이미지 파일에 저장했습니다');
					});
		}
	</script>
</body>
</html>