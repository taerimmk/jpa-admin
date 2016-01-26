<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../inc/headerResources.jsp" />



<style type="text/css">
.media-left, .media>.pull-left {
	padding-right: 10px;
}
</style>
</head>

<body>
	<c:choose>
		<c:when test="${not empty company.searchVal }">
			<c:set
				value="/company/list/${company.pageIndex}/${company.searchKey}/${company.searchVal}"
				var="listUrl" />
			<c:set
				value="/company/set/${company.pageIndex}/${company.id}/${company.searchKey}/${company.searchVal}"
				var="setUrl" />
			<c:set
				value="/company/del/${company.pageIndex}/${company.id}/${company.searchKey}/${company.searchVal}"
				var="delUrl" />
		</c:when>
		<c:otherwise>
			<c:set value="/company/set/${company.pageIndex}/${company.id}"
				var="setUrl" />
			<c:set value="/company/list/${company.pageIndex}" var="listUrl" />
			<c:set value="/company/del/${company.pageIndex}/${company.id}"
				var="delUrl" />
		</c:otherwise>
	</c:choose>
	<!-- Main navbar -->
	<jsp:include page="../inc/headerContents.jsp" />
	<!-- /main navbar -->


	<!-- Page container -->
	<div class="page-container">

		<!-- Page content -->
		<div class="page-content">

			<!-- Main sidebar -->
			<jsp:include page="../inc/sideContents.jsp" />
			<!-- /main sidebar -->


			<!-- Main content -->
			<div class="content-wrapper">

				<!-- Page header -->
				<div class="page-header">
					<div class="page-header-content">
						<div class="page-title">
							<h4>
								<i class="icon-arrow-left52 position-left"></i> <span
									class="text-semibold">참여기업관리</span> - 기업쿠폰생성
							</h4>
						</div>

					</div>

					<div class="breadcrumb-line">
						<ul class="breadcrumb">
							<li><a href="index.html"><i
									class="icon-home2 position-left"></i> Home</a></li>
							<li><a href="form_layout_vertical.html">참여기업관리</a></li>
							<li class="active">기업쿠폰생성</li>
						</ul>

					</div>
				</div>
				<!-- /page header -->


				<!-- Content area -->
				<form class="" action="${setUrl}" method="post" id="postFrm"
					enctype="multipart/form-data">
					<div class="content">

						<div class="panel panel-flat">
							<div class="panel-heading">
								<h5 class="panel-title">기본정보</h5>
								<div class="heading-elements">
									<ul class="icons-list">
										<li><a data-action="collapse"></a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-3">
										<fieldset class="text-semibold">
											<div class="row">
												<div class="col-md-12">
													<div id="testCoupon"
														style="background-image: url('/assets/images/coupon_bg-01-1000.png'); background-size: 1000px 323px; background-repeat: no-repeat; height: 323px; width: 1000px;">
														<div
															style="color: #fff; padding: 10px; float: left; width: 200px;">
															<p style="font-size: 14px; color: #ffffff;">주요혜택</p>
															<p style="font-size: 14px; color: #ffffff;">${companyRes.companyLocales[0].benefit }asfdasfdasfdasfdasdsdafsafd</p>
														</div>
														<div style="padding: 10px; left: 200px; float: left;">
															<p style="font-size: 14px; color: #000000;">주요혜택</p>
															<p style="font-size: 14px; color: #000000;">${companyRes.companyLocales[0].benefit }</p>
														</div>

													</div>
												</div>


												<div class="col-md-12">
													<div class="form-group">
														<label>노출순서</label> <input type="text"
															value="${ companyRes.position}"
															class="touchspin-vertical" id="position" name="position" />
													</div>
												</div>
											</div>

										</fieldset>
									</div>


								</div>

							</div>
						</div>

					</div>
					<!-- /basic layout -->
				</form>
				<jsp:include page="../inc/footerContents.jsp" />
			</div>
			<!-- /vertical form options -->


			<!-- Footer -->

			<!-- /footer -->
		</div>
	</div>
	<!-- /content area -->

	<!-- /main content -->

	<!-- /page content -->

	<!-- /page container -->
	<jsp:include page="../inc/footerResources.jsp" />
	<script type="text/javascript">
		$(function() {
			$(".goSave").on("click", function() {
				var markup_ko = $('#summernote_ko').code();
				var markup_en = $('#summernote_en').code();
				var markup_jp = $('#summernote_jp').code();
				var markup_cn = $('#summernote_cn').code();
				var markup_tw = $('#summernote_tw').code();
				$("#company_content_ko").val(markup_ko);
				$("#company_content_en").val(markup_en);
				$("#company_content_jp").val(markup_jp);
				$("#company_content_cn").val(markup_cn);
				$("#company_content_tw").val(markup_tw);

				if (validation()) {
					$("#postFrm").submit();
				}
				return false;
			});
			$('.summernote').summernote({
				height : 300,
				onImageUpload : function(files, editor, welEditable) {
					sendFile(files[0], editor, welEditable);
				}
			});

			$(".delImg").on(
					"click",
					function() {
						$(this).next("input").val("");
						$(this).parent(".media-body").prev(".media-left").find(
								"img").attr("src",
								"/assets/images/placeholder.jpg");
						return false;
					});

		});
		var validation = function() {
			var position = $("#position").val();
			var company_name_ko = $("#company_name_ko").val();
			var company_name_ko_en = $("#company_name_ko_en").val();
			var company_name_ko_jp = $("#company_name_ko_jp").val();
			var company_name_ko_cn = $("#company_name_ko_cn").val();
			var company_name_ko_tw = $("#company_name_ko_tw").val();

			if (!Boolean(position)) {
				alert("노출순서를 입력해 주세요.");
				$("#position").focus();
				return false;
			}
			if (!Boolean(company_name_ko)) {
				alert("기업명(ko)를 입력해 주세요");
				$("#company_name_ko").focus();
				return false;
			}
			if (!Boolean(company_name_en)) {
				alert("기업명(en)를 입력해 주세요");
				$("#company_name_en").focus();
				return false;
			}
			if (!Boolean(company_name_jp)) {
				alert("기업명(jp)를 입력해 주세요");
				$("#company_name_jp").focus();
				return false;
			}
			if (!Boolean(company_name_cn)) {
				alert("기업명(cn)를 입력해 주세요");
				$("#company_name_cn").focus();
				return false;
			}
			if (!Boolean(company_name_tw)) {
				alert("기업명(tw)를 입력해 주세요");
				$("#company_name_tw").focus();
				return false;
			}
			return true;
		}
	</script>

</body>
</html>