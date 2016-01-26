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
		<c:when test="${not empty promotion.searchVal }">
			<c:set
				value="/promotion/list/${promotion.pageIndex}/${promotion.searchKey}/${promotion.searchVal}"
				var="listUrl" />
		</c:when>
		<c:otherwise>
			<c:set value="/promotion/list/${promotion.pageIndex}" var="listUrl" />
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
			<!-- Main content -->

			<!-- Main content -->
			<div class="content-wrapper">

				<!-- Page header -->
				<div class="page-header">
					<div class="page-header-content">
						<div class="page-title">
							<h4>
								<i class="icon-arrow-left52 position-left"></i> <span
									class="text-semibold">프로모션</span> - 기업 프로모션 입력
							</h4>
						</div>
					</div>
					<div class="breadcrumb-line">
						<ul class="breadcrumb">
							<li><a href="index.html"><i
									class="icon-home2 position-left"></i> Home</a></li>
							<li><a href="form_inputs_basic.html">프로모션</a></li>
							<li class="active">프로모션 inputs</li>
						</ul>

					</div>
				</div>
				<!-- /page header -->

				<!-- Content area -->
				<div class="content">

					<form class="form-horizontal" action="/promotion/put" method="post"
						id="postFrm">

						<!-- /highlighted tabs -->
						<div class="panel panel-flat">
							<div class="panel-heading">
								<h5 class="panel-title">프로모션 info inputs</h5>
								<div class="heading-elements">
									<ul class="icons-list">
										<li><a data-action="collapse"></a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">

								<fieldset class="content-group">
									<legend class="text-bold">기본정보 inputs</legend>

									<div class="form-group">
										<label class="control-label col-lg-2">메뉴명</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength"
												placeholder="프로모션메뉴명을 입력해 주세요" maxlength="30" id="menu"
												name="menu" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">노출순서</label>
										<div class="col-lg-10">
											<input type="text" value="1" class="touchspin-vertical"
												id="position" name="position" />
										</div>
									</div>
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
								<div class="text-right">
									<a href="${listUrl}"><button type="button"
											class="btn btn-defult" id="goList">
											목록 <i class="icon-arrow-right14 position-right"></i>
										</button></a>
									<button type="button" class="btn btn-primary" id="goSave">
										저장 <i class="icon-arrow-right14 position-right"></i>
									</button>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col-md-12">
								<div class="panel panel-flat">
									<div class="panel-heading">
										<h6 class="panel-title">다국어 영역</h6>
										<div class="heading-elements">
											<ul class="icons-list">
												<li><a data-action="collapse"></a></li>
											</ul>
										</div>
									</div>

									<div class="panel-body">
										<div class="tabbable">
											<ul class="nav nav-tabs nav-tabs-highlight nav-justified">
												<li class="active"><a href="#highlighted-ko"
													data-toggle="tab">국문(ko)</a></li>
												<li><a href="#highlighted-en" data-toggle="tab">영문(en)</a></li>
												<li><a href="#highlighted-jp" data-toggle="tab">일문(jp)</a></li>
												<li><a href="#highlighted-cn" data-toggle="tab">중문(cn)</a></li>
												<li><a href="#highlighted-tw" data-toggle="tab">중문(tw)</a></li>
											</ul>

											<div class="tab-content">
												<div class="tab-pane active" id="highlighted-ko">
													<div class="panel-body">
														<div class="form-group">
															<label>이름(ko) :</label> <input type="text"
																class="form-control maxlength"
																placeholder="이름(국문) 입력해 주세요" maxlength="100"
																id="title_ko" name="promotionLocales[0].title" /> <input
																type="hidden" name="promotionLocales[0].locale"
																value="ko" />
														</div>
														<div class="form-group">
															<label>기업설명 상세(ko) :</label>
															<div class="summernote" style="height: 500px;"
																id="summernote_ko"></div>
															<input type="hidden" name="promotionLocales[0].descs"
																id="descs_ko" />

														</div>

														<!-- /basic layout -->

													</div>
												</div>
												<div class="tab-pane" id="highlighted-en">
													<div class="panel-body">
														<div class="form-group">
															<label>이름(en) :</label> <input type="text"
																class="form-control maxlength"
																placeholder="이름(영문) 입력해 주세요" maxlength="100"
																id="title_en" name="promotionLocales[1].title" /> <input
																type="hidden" name="promotionLocales[1].locale"
																value="en" />
														</div>
														<div class="form-group">
															<label>기업설명 상세(en) :</label>
															<div class="summernote" style="height: 500px;"
																id="summernote_en"></div>
															<input type="hidden" name="promotionLocales[1].descs"
																id="descs_en" />

														</div>

													</div>
												</div>
												<div class="tab-pane" id="highlighted-jp">
													<div class="panel-body">
														<div class="form-group">
															<label>이름(jp) :</label> <input type="text"
																class="form-control maxljpgth"
																placeholder="이름(일문) 입력해 주세요" maxlength="100"
																id="title_jp" name="promotionLocales[2].title" /> <input
																type="hidden" name="promotionLocales[2].locale"
																value="jp" />
														</div>
														<div class="form-group">
															<label>기업설명 상세(jp) :</label>
															<div class="summernote" style="height: 500px;"
																id="summernote_jp"></div>
															<input type="hidden" name="promotionLocales[2].descs"
																id="descs_jp" />

														</div>

													</div>
												</div>
												<div class="tab-pane" id="highlighted-cn">
													<div class="panel-body">
														<div class="form-group">
															<label>이름(cn) :</label> <input type="text"
																class="form-control maxlcngth"
																placeholder="이름(중문간체) 입력해 주세요" maxlength="100"
																id="title_cn" name="promotionLocales[3].title" /> <input
																type="hidden" name="promotionLocales[3].locale"
																value="cn" />
														</div>
														<div class="form-group">
															<label>기업설명 상세(cn) :</label>
															<div class="summernote" style="height: 500px;"
																id="summernote_cn"></div>
															<input type="hidden" name="promotionLocales[3].descs"
																id="descs_cn" />

														</div>

													</div>
												</div>
												<div class="tab-pane" id="highlighted-tw">
													<div class="panel-body">
														<div class="form-group">
															<label>이름(tw) :</label> <input type="text"
																class="form-control maxltwgth"
																placeholder="이름(중문번체) 입력해 주세요" maxlength="100"
																id="title_tw" name="promotionLocales[4].title" /> <input
																type="hidden" name="promotionLocales[4].locale"
																value="tw" />
														</div>
														<div class="form-group">
															<label>기업설명 상세(tw) :</label>
															<div class="summernote" style="height: 500px;"
																id="summernote_tw"></div>
															<input type="hidden" name="promotionLocales[4].descs"
																id="descs_tw" />

														</div>

														<!-- /basic layout -->

													</div>
												</div>
											</div>
										</div>
									</div>
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
			$("#goSave").on("click", function() {
				var markup_ko = $('#summernote_ko').code();
				var markup_en = $('#summernote_en').code();
				var markup_jp = $('#summernote_jp').code();
				var markup_cn = $('#summernote_cn').code();
				var markup_tw = $('#summernote_tw').code();
				$("#descs_ko").val(markup_ko);
				$("#descs_en").val(markup_en);
				$("#descs_jp").val(markup_jp);
				$("#descs_cn").val(markup_cn);
				$("#descs_tw").val(markup_tw);
				if (validation()) {
					$("#postFrm").submit();
				}
				return false;
			});
			$('.summernote').summernote({
				height : 400,
				onImageUpload : function(files, editor, welEditable) {
					sendFile(files[0], editor, welEditable);
				}
			});

		});
		var validation = function() {
			var menu = $("#menu").val();
			var position = $("#position").val();
			var title_ko = $("#title_ko").val();
			var title_en = $("#title_en").val();
			var title_jp = $("#title_jp").val();
			var title_cn = $("#title_cn").val();
			var title_tw = $("#title_tw").val();

			if (!Boolean(menu)) {
				alert("메뉴명을 입력해 주세요.");
				$("#menu").focus();
				return false;
			}
			if (!Boolean(position)) {
				alert("노출순서를 입력해 주세요.");
				$("#position").focus();
				return false;
			}
			/* if (!Boolean(title_ko)) {
				alert("이름(ko)를 입력해 주세요");
				$("#title_ko").focus();
				return false;
			}
			if (!Boolean(title_en)) {
				alert("이름(en)를 입력해 주세요");
				$("#title_en").focus();
				return false;
			}
			if (!Boolean(title_jp)) {
				alert("이름(jp)를 입력해 주세요");
				$("#title_jp").focus();
				return false;
			}
			if (!Boolean(title_cn)) {
				alert("이름(cn)를 입력해 주세요");
				$("#title_cn").focus();
				return false;
			}
			if (!Boolean(title_tw)) {
				alert("이름(tw)를 입력해 주세요");
				$("#title_tw").focus();
				return false;
			} */
			return true;
		}
	</script>

</body>
</html>