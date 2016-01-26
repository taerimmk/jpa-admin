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
		<c:when test="${not empty mainBanner.searchVal }">
			<c:set
				value="/mainBanner/list/${mainBanner.pageIndex}/${mainBanner.searchKey}/${mainBanner.searchVal}"
				var="listUrl" />
			<c:set
				value="/mainBanner/set/${mainBanner.pageIndex}/${mainBanner.id}/${mainBanner.searchKey}/${mainBanner.searchVal}"
				var="setUrl" />
		</c:when>
		<c:otherwise>
			<c:set
				value="/mainBanner/set/${mainBanner.pageIndex}/${mainBanner.id}"
				var="setUrl" />
			<c:set value="/mainBanner/list/${mainBanner.pageIndex}" var="listUrl" />
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
									class="text-semibold">메인배너관리</span> - 메인배너수정
							</h4>
						</div>

					</div>

					<div class="breadcrumb-line">
						<ul class="breadcrumb">
							<li><a href="index.html"><i
									class="icon-home2 position-left"></i> Home</a></li>
							<li><a href="form_layout_vertical.html">메인배너관리</a></li>
							<li class="active">메인배너수정</li>
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
								<fieldset class="content-group">
									<legend class="text-bold">기본정보</legend>

									<div class="form-group">
										<label class="control-label col-lg-2">메인배너 이름</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength"
												placeholder="메인배너 이름을 입력해 주세요" maxlength="30"
												id="bannername" name="bannername"
												value="${ mainBannerRes.bannername}" />
										</div>
									</div>
									<br>
									<div class="form-group">
										<label class="control-label col-lg-2">노출순서</label>
										<div class="col-lg-10">
											<input type="text" class="touchspin-vertical" id="position"
												name="position" value="${ mainBannerRes.position}" />
										</div>
									</div>
									<br>
									<div class="form-group">
										<label class="control-label col-lg-2">노출여부</label>
										<div class="col-lg-10">
											<label class="radio-inline"> <input type="radio"
												class="styled" name="use_at" value="Y"
												<c:if test="${'Y' eq mainBannerRes.use_at}">checked="checked"</c:if> />
												노출
											</label> <label class="radio-inline"> <input type="radio"
												class="styled" name="use_at" value="N"
												<c:if test="${'N' eq mainBannerRes.use_at}">checked="checked"</c:if> />
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
								<div class="row">
									<fieldset>
										<input type="hidden" name="image_ko"
											value="${mainBannerRes.image_ko }" /><input type="hidden"
											name="image_en" value="${mainBannerRes.image_en }" /><input
											type="hidden" name="image_jp"
											value="${mainBannerRes.image_jp }" /> <input type="hidden"
											name="image_cn" value="${mainBannerRes.image_cn }" /> <input
											type="hidden" name="image_tw"
											value="${mainBannerRes.image_tw }" />
										<div class="col-md-2">
											<div class="form-group">
												<label>메인배너(ko)</label>
												<div class="media no-margin-top">
													<div class="media-left">
														<c:choose>
															<c:when test="${empty mainBannerRes.image_ko}">
																<img src="/assets/images/placeholder.jpg"
																	style="width: 52px; height: 52px; border-radius: 2px;"
																	alt="">
															</c:when>
															<c:otherwise>
																<img src="${mainBannerRes.image_ko}"
																	style="width: 52px; height: 52px; border-radius: 2px;"
																	alt="">
															</c:otherwise>
														</c:choose>
													</div>
													<div class="media-body">
														<div class="uploader bg-warning">
															<input type="file" class="file-styled"
																name="file_image_ko" /><span class="action"
																style="-webkit-user-select: none;"><i
																class="icon-googleplus5"></i></span>
														</div>
													</div>
												</div>
												<br> <label>메인배너(ko) 링크</label>
												<div class="media no-margin-top">
													<input type="text" class="form-control maxlength"
														placeholder="메인배너(ko) 링크를 입력해 주세요" maxlength="400"
														id="url_link_ko" name="url_link_ko"
														value="${mainBannerRes.url_link_ko}" />
												</div>
												<br> <label class="display-block">노출여부(ko)</label> <label
													class="radio-inline"> <input type="radio"
													class="styled" name="use_at_ko" value="Y"
													<c:if test="${'Y' eq mainBannerRes.use_at_ko}">checked="checked"</c:if> />
													노출
												</label> <label class="radio-inline"> <input type="radio"
													class="styled" name="use_at_ko" value="N"
													<c:if test="${'N' eq mainBannerRes.use_at_ko}">checked="checked"</c:if> />
													비노출
												</label>
											</div>
										</div>
										<div class="col-md-2">
											<div class="form-group">
												<label>메인배너(en)</label>
												<div class="media no-margin-top">
													<div class="media-left">
														<c:choose>
															<c:when test="${empty mainBannerRes.image_en}">
																<img src="/assets/images/placeholder.jpg"
																	style="width: 52px; height: 52px; border-radius: 2px;"
																	alt="">
															</c:when>
															<c:otherwise>
																<img src="${mainBannerRes.image_en}"
																	style="width: 52px; height: 52px; border-radius: 2px;"
																	alt="">
															</c:otherwise>
														</c:choose>
													</div>
													<div class="media-body">
														<div class="uploader bg-warning">
															<input type="file" class="file-styled"
																name="file_image_en" /><span class="action"
																style="-webkit-user-select: none;"><i
																class="icon-googleplus5"></i></span>
														</div>
													</div>
												</div>
												<br> <label>메인배너(en) 링크</label>
												<div class="media no-margin-top">
													<input type="text" class="form-control maxlength"
														placeholder="메인배너(en) 링크를 입력해 주세요" maxlength="400"
														id="url_link_en" name="url_link_en"
														value="${mainBannerRes.url_link_en}" />
												</div>
												<br>
												<label class="display-block">노출여부(en)</label> <label
													class="radio-inline"> <input type="radio"
													class="styled" name="use_at_en" value="Y"
													<c:if test="${'Y' eq mainBannerRes.use_at_en}">checked="checked"</c:if> />
													노출
												</label> <label class="radio-inline"> <input type="radio"
													class="styled" name="use_at_en" value="N"
													<c:if test="${'N' eq mainBannerRes.use_at_en}">checked="checked"</c:if> />
													비노출
												</label>
											</div>
										</div>
										<div class="col-md-2">
											<div class="form-group">
												<label>메인배너(jp)</label>
												<div class="media no-margin-top">
													<div class="media-left">
														<c:choose>
															<c:when test="${empty mainBannerRes.image_jp}">
																<img src="/assets/images/placeholder.jpg"
																	style="width: 52px; height: 52px; border-radius: 2px;"
																	alt="">
															</c:when>
															<c:otherwise>
																<img src="${mainBannerRes.image_jp}"
																	style="width: 52px; height: 52px; border-radius: 2px;"
																	alt="">
															</c:otherwise>
														</c:choose>
													</div>
													<div class="media-body">
														<div class="uploader bg-warning">
															<input type="file" class="file-styled"
																name="file_image_jp" /><span class="action"
																style="-webkit-user-select: none;"><i
																class="icon-googleplus5"></i></span>
														</div>
													</div>
												</div>
												<br> <label>메인배너(jp) 링크</label>
												<div class="media no-margin-top">
													<input type="text" class="form-control maxlength"
														placeholder="메인배너(jp) 링크를 입력해 주세요" maxlength="400"
														id="url_link_jp" name="url_link_jp"
														value="${mainBannerRes.url_link_jp}" />
												</div>
												<br>
												<label class="display-block">노출여부(jp)</label> <label
													class="radio-inline"> <input type="radio"
													class="styled" name="use_at_jp" value="Y"
													<c:if test="${'Y' eq mainBannerRes.use_at_jp}">checked="checked"</c:if> />
													노출
												</label> <label class="radio-inline"> <input type="radio"
													class="styled" name="use_at_jp" value="N"
													<c:if test="${'N' eq mainBannerRes.use_at_jp}">checked="checked"</c:if> />
													비노출
												</label>
											</div>
										</div>
										<div class="col-md-2">
											<div class="form-group">
												<label>메인배너(cn)</label>
												<div class="media no-margin-top">
													<div class="media-left">
														<c:choose>
															<c:when test="${empty mainBannerRes.image_cn}">
																<img src="/assets/images/placeholder.jpg"
																	style="width: 52px; height: 52px; border-radius: 2px;"
																	alt="">
															</c:when>
															<c:otherwise>
																<img src="${mainBannerRes.image_cn}"
																	style="width: 52px; height: 52px; border-radius: 2px;"
																	alt="">
															</c:otherwise>
														</c:choose>
													</div>
													<div class="media-body">
														<div class="uploader bg-warning">
															<input type="file" class="file-styled"
																name="file_image_cn" /><span class="action"
																style="-webkit-user-select: none;"><i
																class="icon-googleplus5"></i></span>
														</div>
													</div>
												</div>
												<br> <label>메인배너(cn) 링크</label>
												<div class="media no-margin-top">
													<input type="text" class="form-control maxlength"
														placeholder="메인배너(cn) 링크를 입력해 주세요" maxlength="400"
														id="url_link_cn" name="url_link_cn"
														value="${mainBannerRes.url_link_cn}" />
												</div>
												<br>
												<label class="display-block">노출여부(cn)</label> <label
													class="radio-inline"> <input type="radio"
													class="styled" name="use_at_cn" value="Y"
													<c:if test="${'Y' eq mainBannerRes.use_at_cn}">checked="checked"</c:if> />
													노출
												</label> <label class="radio-inline"> <input type="radio"
													class="styled" name="use_at_cn" value="N"
													<c:if test="${'N' eq mainBannerRes.use_at_cn}">checked="checked"</c:if> />
													비노출
												</label>
											</div>
										</div>
										<div class="col-md-2">
											<div class="form-group">
												<label>메인배너(tw)</label>
												<div class="media no-margin-top">
													<div class="media-left">
														<c:choose>
															<c:when test="${empty mainBannerRes.image_tw}">
																<img src="/assets/images/placeholder.jpg"
																	style="width: 52px; height: 52px; border-radius: 2px;"
																	alt="">
															</c:when>
															<c:otherwise>
																<img src="${mainBannerRes.image_tw}"
																	style="width: 52px; height: 52px; border-radius: 2px;"
																	alt="">
															</c:otherwise>
														</c:choose>
													</div>
													<div class="media-body">
														<div class="uploader bg-warning">
															<input type="file" class="file-styled"
																name="file_image_tw" /><span class="action"
																style="-webkit-user-select: none;"><i
																class="icon-googleplus5"></i></span>
														</div>
													</div>
												</div>
												<br> <label>메인배너(tw) 링크</label>
												<div class="media no-margin-top">
													<input type="text" class="form-control maxlength"
														placeholder="메인배너(tw) 링크를 입력해 주세요" maxlength="400"
														id="url_link_tw" name="url_link_tw"
														value="${mainBannerRes.url_link_tw}" />
												</div>
												<br>
												<label class="display-block">노출여부(tw)</label> <label
													class="radio-inline"> <input type="radio"
													class="styled" name="use_at_tw" value="Y"
													<c:if test="${'Y' eq mainBannerRes.use_at_tw}">checked="checked"</c:if> />
													노출
												</label> <label class="radio-inline"> <input type="radio"
													class="styled" name="use_at_tw" value="N"
													<c:if test="${'N' eq mainBannerRes.use_at_tw}">checked="checked"</c:if> />
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
				/* var markup_ko = $('#summernote_ko').code();
				var markup_en = $('#summernote_en').code();
				var markup_jp = $('#summernote_jp').code();
				var markup_cn = $('#summernote_cn').code();
				var markup_tw = $('#summernote_tw').code();
				$("#mainBanner_content_ko").val(markup_ko);
				$("#mainBanner_content_en").val(markup_en);
				$("#mainBanner_content_jp").val(markup_jp);
				$("#mainBanner_content_cn").val(markup_cn);
				$("#mainBanner_content_tw").val(markup_tw); */
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
			/* var mainBanner_name_ko_en = $("#mainBanner_name_ko_en").val();
			var mainBanner_name_ko_jp = $("#mbannernameainBanner_name_ko_jp").val();
			var mainBanner_name_ko_cn = $("#mainBanner_name_ko_cn").val();
			var mainBanner_name_ko_tw = $("#mainBanner_name_ko_tw").val(); */

			if (!Boolean(bannername)) {
				alert("메인배너 이름을 입력해 주세요");
				$("#bannername").focus();
				return false;
			}
			if (!Boolean(position)) {
				alert("노출순서를 입력해 주세요.");
				$("#position").focus();
				return false;
			}

			/* if (!Boolean(mainBanner_name_en)) {
				alert("기업명(en)를 입력해 주세요");
				$("#mainBanner_name_en").focus();
				return false;
			}
			if (!Boolean(mainBanner_name_jp)) {
				alert("기업명(jp)를 입력해 주세요");
				$("#mainBanner_name_jp").focus();
				return false;
			}
			if (!Boolean(mainBanner_name_cn)) {
				alert("기업명(cn)를 입력해 주세요");
				$("#mainBanner_name_cn").focus();
				return false;
			}
			if (!Boolean(mainBanner_name_tw)) {
				alert("기업명(tw)를 입력해 주세요");
				$("#mainBanner_name_tw").focus();
				return false;
			} */
			return true;
		}
	</script>

</body>
</html>