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




</head>

<body>
	<c:choose>
		<c:when test="${not empty hotCouponsBanner.searchVal }">
			<c:set
				value="/hotCouponsBanner/list/${hotCouponsBanner.pageIndex}/${hotCouponsBanner.searchKey}/${hotCouponsBanner.searchVal}"
				var="listUrl" />
		</c:when>
		<c:otherwise>
			<c:set value="/hotCouponsBanner/list/${hotCouponsBanner.pageIndex}"
				var="listUrl" />
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
									class="text-semibold">인기쿠폰배너관리</span> - 인기쿠폰배너등록
							</h4>
						</div>

					</div>

					<div class="breadcrumb-line">
						<ul class="breadcrumb">
							<li><a href="index.html"><i
									class="icon-home2 position-left"></i> Home</a></li>
							<li><a href="form_layout_vertical.html">인기쿠폰배너관리</a></li>
							<li class="active">인기쿠폰배너등록</li>
						</ul>

					</div>
				</div>
				<!-- /page header -->


				<!-- Content area -->
				<div class="content">
					<form class="" action="/hotCouponsBanner/put" method="post"
						id="postFrm" enctype="multipart/form-data">
						<div class="panel panel-flat">
							<div class="panel-body">
								<fieldset class="content-group">
									<legend class="text-bold">기본정보</legend>

									<div class="form-group">
										<label class="control-label col-lg-2">인기쿠폰배너 이름</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength"
												placeholder="인기쿠폰배너 이름을 입력해 주세요" maxlength="30"
												id="bannername" name="bannername" />
										</div>
									</div>
									<br>
									<div class="form-group">
										<label class="control-label col-lg-2">노출순서</label>
										<div class="col-lg-10">
											<input type="text" class="touchspin-vertical" id="position"
												name="position" value="1" />
										</div>
									</div>
									<br>
									<div class="form-group">
										<label class="control-label col-lg-2">노출여부</label>
										<div class="col-lg-10">
											<label class="radio-inline"> <input type="radio"
												class="styled" name="use_at" value="Y" /> 노출
											</label> <label class="radio-inline"> <input type="radio"
												class="styled" name="use_at" value="N" checked="checked" />
												비노출
											</label>
										</div>
									</div>
								</fieldset>
							</div>
						</div>

						<div class="panel panel-flat">
							<div class="panel-heading">
								<h5 class="panel-title">이미지정보</h5>
								<div class="heading-elements">
									<ul class="icons-list">
										<li><a data-action="collapse"></a></li>
									</ul>
								</div>
							</div>

							<div class="panel-body">
								<fieldset>
									<input type="hidden" name="image_ko"
										value="${hotCouponsBannerRes.image_ko }" /> <input
										type="hidden" name="image_en"
										value="${hotCouponsBannerRes.image_en }" /> <input
										type="hidden" name="image_jp"
										value="${hotCouponsBannerRes.image_jp }" /> <input
										type="hidden" name="image_cn"
										value="${hotCouponsBannerRes.image_cn }" /> <input
										type="hidden" name="image_tw"
										value="${hotCouponsBannerRes.image_tw }" />
									<div class="row">
										<div class="col-md-2 form-group">
											<label>인기쿠폰배너(ko)</label>
											<div class="media no-margin-top">
												<input type="file" class="file-styled" name="file_image_ko" />
											</div>
											<br> <label>인기쿠폰배너(ko) 상단 설명</label>
											<div class="media no-margin-top">
												<input type="text" class="form-control maxlength"
													placeholder="인기쿠폰배너(ko) 상단 설명을 입력해 주세요" maxlength="400"
													id="banner_msg_ko" name="banner_msg_ko" />
											</div>
											<br> <label>인기쿠폰배너(ko) 링크</label>
											<div class="media no-margin-top">
												<input type="text" class="form-control maxlength"
													placeholder="인기쿠폰배너(ko) 링크를 입력해 주세요" maxlength="400"
													id="url_link_ko" name="url_link_ko" />
											</div>
											<br> <label class="display-block">노출여부(ko)</label> <label
												class="radio-inline"> <input type="radio"
												class="styled" name="use_at_ko" value="Y" /> 노출
											</label> <label class="radio-inline"> <input type="radio"
												class="styled" name="use_at_ko" value="N" checked="checked" />
												비노출
											</label>
										</div>
										<div class="col-md-2 form-group">
											<label>인기쿠폰배너(en)</label>
											<div class="media no-margin-top">
												<input type="file" class="file-styled" name="file_image_en" />
											</div>
											<br> <label>인기쿠폰배너(en) 상단 설명</label>
											<div class="media no-margin-top">
												<input type="text" class="form-control maxlength"
													placeholder="인기쿠폰배너(en) 상단 설명을 입력해 주세요" maxlength="400"
													id="banner_msg_en" name="banner_msg_en" />
											</div>
											<br> <label>인기쿠폰배너(en) 링크</label>
											<div class="media no-margin-top">
												<input type="text" class="form-control maxlength"
													placeholder="인기쿠폰배너(en) 링크를 입력해 주세요" maxlength="400"
													id="url_link_en" name="url_link_en" />
											</div>
											<br> <label class="display-block">노출여부(en)</label> <label
												class="radio-inline"> <input type="radio"
												class="styled" name="use_at_en" value="Y" /> 노출
											</label> <label class="radio-inline"> <input type="radio"
												class="styled" name="use_at_en" value="N" checked="checked" />
												비노출
											</label>
										</div>
										<div class="col-md-2 form-group">
											<label>인기쿠폰배너(jp)</label>
											<div class="media no-margin-top">
												<input type="file" class="file-styled" name="file_image_jp" />
											</div>
											<br> <label>인기쿠폰배너(jp) 상단 설명</label>
											<div class="media no-margin-top">
												<input type="text" class="form-control maxlength"
													placeholder="인기쿠폰배너(jp) 상단 설명을 입력해 주세요" maxlength="400"
													id="banner_msg_jp" name="banner_msg_jp" />
											</div>
											<br> <label>인기쿠폰배너(jp) 링크</label>
											<div class="media no-margin-top">
												<input type="text" class="form-control maxlength"
													placeholder="인기쿠폰배너(jp) 링크를 입력해 주세요" maxlength="400"
													id="url_link_jp" name="url_link_jp" />
											</div>
											<br> <label class="display-block">노출여부(jp)</label> <label
												class="radio-inline"> <input type="radio"
												class="styled" name="use_at_jp" value="Y" /> 노출
											</label> <label class="radio-inline"> <input type="radio"
												class="styled" name="use_at_jp" value="N" checked="checked" />
												비노출
											</label>
										</div>
										<div class="col-md-2 form-group">
											<label>인기쿠폰배너(cn)</label>
											<div class="media no-margin-top">
												<input type="file" class="file-styled" name="file_image_cn" />
											</div>
											<br> <label>인기쿠폰배너(cn) 상단 설명</label>
											<div class="media no-margin-top">
												<input type="text" class="form-control maxlength"
													placeholder="인기쿠폰배너(cn) 상단 설명을 입력해 주세요" maxlength="400"
													id="banner_msg_cn" name="banner_msg_cn" />
											</div>
											<br> <label>인기쿠폰배너(cn) 링크</label>
											<div class="media no-margin-top">
												<input type="text" class="form-control maxlength"
													placeholder="인기쿠폰배너(cn) 링크를 입력해 주세요" maxlength="400"
													id="url_link_cn" name="url_link_cn" />
											</div>
											<br> <label class="display-block">노출여부(cn)</label> <label
												class="radio-inline"> <input type="radio"
												class="styled" name="use_at_cn" value="Y" /> 노출
											</label> <label class="radio-inline"> <input type="radio"
												class="styled" name="use_at_cn" value="N" checked="checked" />
												비노출
											</label>
										</div>
										<div class="col-md-2 form-group">
											<label>인기쿠폰배너(tw)</label>
											<div class="media no-margin-top">
												<input type="file" class="file-styled" name="file_image_tw" />
											</div>
											<br> <label>인기쿠폰배너(tw) 상단 설명</label>
											<div class="media no-margin-top">
												<input type="text" class="form-control maxlength"
													placeholder="인기쿠폰배너(tw) 상단 설명을 입력해 주세요" maxlength="400"
													id="banner_msg_tw" name="banner_msg_tw" />
											</div>
											<br> <label>인기쿠폰배너(tw) 링크</label>
											<div class="media no-margin-top">
												<input type="text" class="form-control maxlength"
													placeholder="인기쿠폰배너(tw) 링크를 입력해 주세요" maxlength="400"
													id="url_link_tw" name="url_link_tw" />
											</div>
											<br> <label class="display-block">노출여부(tw)</label> <label
												class="radio-inline"> <input type="radio"
												class="styled" name="use_at_tw" value="Y" /> 노출
											</label> <label class="radio-inline"> <input type="radio"
												class="styled" name="use_at_tw" value="N" checked="checked" />
												비노출
											</label>
										</div>
									</div>
								</fieldset>
								<div class="">
									<a href="${listUrl}"><button type="button"
											class="btn btn-defult" id="goList">
											목록 <i class="icon-arrow-right14 position-right"></i>
										</button></a>
									<button type="button" class="btn btn-primary goSave">
										저장 <i class="icon-arrow-right14 position-right"></i>
									</button>
								</div>
							</div>
						</div>
					</form>

					<!-- Footer -->
					<jsp:include page="../inc/footerContents.jsp" />
					<!-- /footer -->

				</div>
				<!-- /content area -->

			</div>
			<!-- /main content -->

		</div>
		<!-- /page content -->

	</div>
	<!-- /page container -->
	<jsp:include page="../inc/footerResources.jsp" />
	<script type="text/javascript">
		$(function() {
			$(".goSave").on("click", function() {
				/* var markup_ko = $('#summernote_ko').code();
				var markup_en = $('#summernote_en').code();
				var markup_jp = $('#summernote_jp').code();
				var markup_cn = $('#summernote_cn').code();
				var markup_tw = $('#summernote_tw').code();
				$("#hotCouponsBanner_content_ko").val(markup_ko);
				$("#hotCouponsBanner_content_en").val(markup_en);
				$("#hotCouponsBanner_content_jp").val(markup_jp);
				$("#hotCouponsBanner_content_cn").val(markup_cn);
				$("#hotCouponsBanner_content_tw").val(markup_tw); */
				if (validation()) {
					$("#postFrm").submit();
				}
				return false;
			});
			/* $('.summernote').summernote({
				height : 300,
				onImageUpload : function(files, editor, welEditable) {
					sendFile(files[0], editor, welEditable);
				}
			}); */
		});
		var validation = function() {
			var position = $("#position").val();
			var bannername = $("#bannername").val();
			/* var hotCouponsBanner_name_ko_en = $("#hotCouponsBanner_name_ko_en").val();
			var hotCouponsBanner_name_ko_jp = $("#mbannernameainBanner_name_ko_jp").val();
			var hotCouponsBanner_name_ko_cn = $("#hotCouponsBanner_name_ko_cn").val();
			var hotCouponsBanner_name_ko_tw = $("#hotCouponsBanner_name_ko_tw").val(); */

			if (!Boolean(bannername)) {
				alert("인기쿠폰배너 이름을 입력해 주세요");
				$("#bannername").focus();
				return false;
			}
			if (!Boolean(position)) {
				alert("노출순서를 입력해 주세요.");
				$("#position").focus();
				return false;
			}

			/* if (!Boolean(hotCouponsBanner_name_en)) {
				alert("기업명(en)를 입력해 주세요");
				$("#hotCouponsBanner_name_en").focus();
				return false;
			}
			if (!Boolean(hotCouponsBanner_name_jp)) {
				alert("기업명(jp)를 입력해 주세요");
				$("#hotCouponsBanner_name_jp").focus();
				return false;
			}
			if (!Boolean(hotCouponsBanner_name_cn)) {
				alert("기업명(cn)를 입력해 주세요");
				$("#hotCouponsBanner_name_cn").focus();
				return false;
			}
			if (!Boolean(hotCouponsBanner_name_tw)) {
				alert("기업명(tw)를 입력해 주세요");
				$("#hotCouponsBanner_name_tw").focus();
				return false;
			} */
			return true;
		}
	</script>

</body>
</html>