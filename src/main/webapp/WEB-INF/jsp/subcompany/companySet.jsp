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
				value="/sub/company/list/${company.pageIndex}/${company.searchKey}/${company.searchVal}"
				var="listUrl" />
			<c:set
				value="/sub/company/set/${company.pageIndex}/${company.id}/${company.searchKey}/${company.searchVal}"
				var="setUrl" />
		</c:when>
		<c:otherwise>
			<c:set value="/sub/company/set/${company.pageIndex}/${company.id}"
				var="setUrl" />
			<c:set value="/sub/company/list/${company.pageIndex}" var="listUrl" />
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
			<jsp:include page="../incsub/sideContents.jsp" />
			<!-- /main sidebar -->


			<!-- Main content -->
			<div class="content-wrapper">

				<!-- Page header -->
				<div class="page-header">
					<div class="page-header-content">
						<div class="page-title">
							<h4>
								<i class="icon-arrow-left52 position-left"></i> <span
									class="text-semibold">참여기업관리</span> - 기업등록
							</h4>
						</div>

					</div>

					<div class="breadcrumb-line">
						<ul class="breadcrumb">
							<li><a href="index.html"><i
									class="icon-home2 position-left"></i> Home</a></li>
							<li><a href="form_layout_vertical.html">참여기업관리</a></li>
							<li class="active">기업등록</li>
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
												<div class="col-md-6">
													<div class="form-group">
														<label>테마선택</label><select class="select" id="theme_id"
															name="theme_id">
															<option value="0">없음</option>
															<c:forEach items="${themeList}" var="sData">
																<option value="${sData.id}"
																	<c:if test="${sData.id eq companyRes.theme_id}">selected="selected"</c:if>>${sData.title}</option>
															</c:forEach>
														</select>
													</div>
												</div>


												<%-- <div class="col-md-6">
													<div class="form-group">
														<label>노출순서</label> <input type="text"
															value="${ companyRes.position}"
															class="touchspin-vertical" id="position" name="position" />
													</div>
												</div> --%>
											</div>

										</fieldset>
									</div>

									<div class="col-md-3">
										<fieldset>
											<div class="row">
												<%-- <div class="col-md-4">
													<div class="form-group">
														<label>년도</label><select class="select" id="year"
															name="year">
															<option value="2016"
																<c:if test="${'2016' eq companyRes.year}">selected="selected"</c:if>>2016</option>
															<option value="2017"
																<c:if test="${'2017' eq companyRes.year}">selected="selected"</c:if>>2017</option>
															<option value="2018"
																<c:if test="${'2017' eq companyRes.year}">selected="selected"</c:if>>2018</option>
															<option value="2019"
																<c:if test="${'2017' eq companyRes.year}">selected="selected"</c:if>>2019</option>

														</select>
													</div>
												</div> --%>

												<div class="col-md-8">
													<div class="col-md-6">
														<div class="form-group">
															<label>위도</label> <input type="text" placeholder="위도"
																class="form-control" id="lat" name="lat"
																value="${companyRes.lat}" />
														</div>
													</div>

													<div class="col-md-6">
														<div class="form-group">
															<label>경도</label> <input type="text" placeholder="경도"
																class="form-control" id="lon" name="lon"
																value="${companyRes.lon}" />
														</div>
													</div>
												</div>

											</div>

										</fieldset>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label>등록지점수</label> <input type="text"
												class="touchspin-vertical" id="brancheCnt" name="brancheCnt"
												value="${companyRes.brancheCnt}" />
										</div>
									</div>
									<%-- <div class="col-md-3">
										<fieldset>
											<div class="row">
												<div class="col-xs-6">
													<div class="form-group">
														<label class="display-block">노출여부</label> <label
															class="radio-inline"> <input type="radio"
															class="styled" name="use_at" value="Y"
															<c:if test="${'Y' eq companyRes.use_at}">checked="checked"</c:if> />
															노출
														</label> <label class="radio-inline"> <input type="radio"
															class="styled" name="use_at" value="N"
															<c:if test="${'N' eq companyRes.use_at}">checked="checked"</c:if> />
															비노출
														</label>
													</div>
												</div>
												<div class="col-xs-6">
													<div class="form-group">
														<label class="display-block">메인노출여부</label> <label
															class="radio-inline"> <input type="radio"
															class="styled" name="main_view" value="Y"
															<c:if test="${'Y' eq companyRes.main_view}">checked="checked"</c:if> />
															노출
														</label> <label class="radio-inline"> <input type="radio"
															class="styled" name="main_view" value="N"
															<c:if test="${'N' eq companyRes.main_view}">checked="checked"</c:if> />
															비노출
														</label>
													</div>
												</div>
												<div class="col-xs-6">
													<div class="form-group">
														<label class="display-block">헤드스토어여부</label> <label
															class="radio-inline"> <input type="radio"
															class="styled" name="headstore" value="Y"
															<c:if test="${'Y' eq companyRes.headstore}">checked="checked"</c:if> />
															Y
														</label> <label class="radio-inline"> <input type="radio"
															class="styled" name="headstore" value="N"
															<c:if test="${'N' eq companyRes.headstore}">checked="checked"</c:if> />
															N
														</label>
													</div>
												</div>
											</div>


										</fieldset>
									</div> --%>
									<%-- <div class="col-md-3">
										<fieldset>
											<div class="row">
												<div class="col-xs-12">
													<div class="form-group">
														<label class="display-block">오프시즌 노출여부</label> <label
															class="radio-inline"> <input type="radio"
															class="styled" name="season_off" value="Y"
															<c:if test="${'Y' eq companyRes.season_off}">checked="checked"</c:if> />
															노출
														</label> <label class="radio-inline"> <input type="radio"
															class="styled" name="season_off" value="N"
															<c:if test="${'N' eq companyRes.season_off}">checked="checked"</c:if> />
															비노출
														</label>
													</div>
												</div>
											</div>
										</fieldset>
									</div> --%>
								</div>

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
									<div class="col-md-12">
										<fieldset>
											<%-- <input type="hidden" name="image1_wl"
												value="${companyRes.image1_wl }" /> <input type="hidden"
												name="image1_ws" value="${companyRes.image1_ws }" /> <input
												type="hidden" name="image2_wl"
												value="${companyRes.image2_wl }" /> <input type="hidden"
												name="image2_ws" value="${companyRes.image2_ws }" /> <input
												type="hidden" name="image3_wl"
												value="${companyRes.image3_wl }" /> <input type="hidden"
												name="image3_ws" value="${companyRes.image3_ws }" /> <input
												type="hidden" name="image4_wl"
												value="${companyRes.image4_wl }" /> <input type="hidden"
												name="image4_ws" value="${companyRes.image4_ws }" /> <input
												type="hidden" name="image5_wl"
												value="${companyRes.image5_wl }" /> <input type="hidden"
												name="image5_ws" value="${companyRes.image5_ws }" /> <input
												type="hidden" name="image_cp"
												value="${companyRes.image_cp }" /> <input type="hidden"
												name="image_main" value="${companyRes.image_main }" /> <input
												type="hidden" name="image_list"
												value="${companyRes.image_list }" /> --%>
											<input type="hidden" name="use_yn"
												value="${companyRes.use_yn }" />
											<div class="row">
												<div class="col-md-6">
													<div class="col-xs-6">
														<div class="form-group">
															<label>로고이미지1 (44 x 26)</label>
															<div class="media no-margin-top">
																<div class="media-left">
																	<c:choose>
																		<c:when test="${empty companyRes.image_main}">
																			<img src="/assets/images/placeholder.jpg"
																				style="width: 100px; height: 72px; border-radius: 2px;"
																				alt="">
																		</c:when>
																		<c:otherwise>
																			<img src="${companyRes.image_main}"
																				style="width: 100px; height: 72px; border-radius: 2px;"
																				alt="">
																		</c:otherwise>
																	</c:choose>
																</div>

																<div class="media-body">
																	<div class="uploader bg-warning">
																		<input type="file" class="file-styled"
																			name="file_image_main" /><span class="action"
																			style="-webkit-user-select: none;"><i
																			class="icon-googleplus5"></i></span>
																	</div>
																	<button type="button" class="btn btn-danger">
																		삭제 <i class="icon-arrow-right14 position-right delImg"></i>
																	</button>
																	<input type="hidden" name="image_main"
																		value="${companyRes.image_main }" />
																</div>
															</div>
														</div>
													</div>
													<div class="col-xs-6">
														<div class="form-group">
															<label>로고이미지2 (184 x 80)</label>
															<div class="media no-margin-top">
																<div class="media-left">
																	<c:choose>
																		<c:when test="${empty companyRes.image_list}">
																			<img src="/assets/images/placeholder.jpg"
																				style="width: 100px; height: 72px; border-radius: 2px;"
																				alt="">
																		</c:when>
																		<c:otherwise>
																			<img src="${companyRes.image_list}"
																				style="width: 100px; height: 72px; border-radius: 2px;"
																				alt="">
																		</c:otherwise>
																	</c:choose>
																</div>

																<div class="media-body">
																	<div class="uploader bg-warning">
																		<input type="file" class="file-styled"
																			name="file_image_list" /><span class="action"
																			style="-webkit-user-select: none;"><i
																			class="icon-googleplus5"></i></span>
																	</div>
																	<button type="button" class="btn btn-danger">
																		삭제 <i class="icon-arrow-right14 position-right delImg"></i>
																	</button>
																	<input type="hidden" name="image_list"
																		value="${companyRes.image_list }" />

																</div>
															</div>
														</div>
													</div>
												</div>

											</div>
											<div class="row">
												<div class="col-md-6">
													<div class="col-xs-6">
														<div class="form-group">
															<label>이미지1 (380 x 260)</label>
															<div class="media no-margin-top">
																<div class="media-left">
																	<c:choose>
																		<c:when test="${empty companyRes.image1_wl}">
																			<img src="/assets/images/placeholder.jpg"
																				style="width: 100px; height: 72px; border-radius: 2px;"
																				alt="">
																		</c:when>
																		<c:otherwise>
																			<img src="${companyRes.image1_wl}"
																				style="width: 100px; height: 72px; border-radius: 2px;"
																				alt="">
																		</c:otherwise>
																	</c:choose>
																</div>

																<div class="media-body">
																	<div class="uploader bg-warning">
																		<input type="file" class="file-styled"
																			name="file_image1_wl" /><span class="action"
																			style="-webkit-user-select: none;"><i
																			class="icon-googleplus5"></i></span>
																	</div>
																	<button type="button" class="btn btn-danger">
																		삭제 <i class="icon-arrow-right14 position-right delImg"></i>
																	</button>
																	<input type="hidden" name="image1_wl"
																		value="${companyRes.image1_wl }" />
																</div>
															</div>
														</div>
													</div>
													<div class="col-xs-6">
														<div class="form-group">
															<label>이미지1_썸네일 (52 x 52)</label>
															<div class="media no-margin-top">
																<div class="media-left">
																	<c:choose>
																		<c:when test="${empty companyRes.image1_ws}">
																			<img src="/assets/images/placeholder.jpg"
																				style="width: 100px; height: 72px; border-radius: 2px;"
																				alt="">
																		</c:when>
																		<c:otherwise>
																			<img src="${companyRes.image1_ws}"
																				style="width: 100px; height: 72px; border-radius: 2px;"
																				alt="">
																		</c:otherwise>
																	</c:choose>
																</div>

																<div class="media-body">
																	<div class="uploader bg-warning">
																		<input type="file" class="file-styled"
																			name="file_image1_ws" /><span class="action"
																			style="-webkit-user-select: none;"><i
																			class="icon-googleplus5"></i></span>
																	</div>
																	<button type="button" class="btn btn-danger">
																		삭제 <i class="icon-arrow-right14 position-right delImg"></i>
																	</button>
																	<input type="hidden" name="image1_ws"
																		value="${companyRes.image1_ws }" />
																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="col-md-6">
													<div class="col-xs-6">
														<div class="form-group">
															<label>이미지2 (380 x 260)</label>
															<div class="media no-margin-top">
																<div class="media-left">
																	<c:choose>
																		<c:when test="${empty companyRes.image2_wl}">
																			<img src="/assets/images/placeholder.jpg"
																				style="width: 100px; height: 72px; border-radius: 2px;"
																				alt="">
																		</c:when>
																		<c:otherwise>
																			<img src="${companyRes.image2_wl}"
																				style="width: 100px; height: 72px; border-radius: 2px;"
																				alt="">
																		</c:otherwise>
																	</c:choose>
																</div>

																<div class="media-body">
																	<div class="uploader bg-warning">
																		<input type="file" class="file-styled"
																			name="file_image2_wl" /><span class="action"
																			style="-webkit-user-select: none;"><i
																			class="icon-googleplus5"></i></span>
																	</div>
																	<button type="button" class="btn btn-danger">
																		삭제 <i class="icon-arrow-right14 position-right delImg"></i>
																	</button>
																	<input type="hidden" name="image2_wl"
																		value="${companyRes.image2_wl }" />
																</div>
															</div>
														</div>
													</div>
													<div class="col-xs-6">
														<div class="form-group">
															<label>이미지2_썸네일 (52 x 52)</label>
															<div class="media no-margin-top">
																<div class="media-left">
																	<c:choose>
																		<c:when test="${empty companyRes.image2_ws}">
																			<img src="/assets/images/placeholder.jpg"
																				style="width: 100px; height: 72px; border-radius: 2px;"
																				alt="">
																		</c:when>
																		<c:otherwise>
																			<img src="${companyRes.image2_ws}"
																				style="width: 100px; height: 72px; border-radius: 2px;"
																				alt="">
																		</c:otherwise>
																	</c:choose>
																</div>

																<div class="media-body">
																	<div class="uploader bg-warning">
																		<input type="file" class="file-styled"
																			name="file_image2_ws" /><span class="action"
																			style="-webkit-user-select: none;"><i
																			class="icon-googleplus5"></i></span>
																	</div>
																	<button type="button" class="btn btn-danger">
																		삭제 <i class="icon-arrow-right14 position-right delImg"></i>
																	</button>
																	<input type="hidden" name="image2_ws"
																		value="${companyRes.image2_ws }" />
																</div>
															</div>
														</div>
													</div>
												</div>

											</div>
											<div class="row">
												<div class="col-md-6">
													<div class="col-xs-6">
														<div class="form-group">
															<label>이미지3 (380 x 260)</label>
															<div class="media no-margin-top">
																<div class="media-left">
																	<c:choose>
																		<c:when test="${empty companyRes.image3_wl}">
																			<img src="/assets/images/placeholder.jpg"
																				style="width: 100px; height: 72px; border-radius: 2px;"
																				alt="">
																		</c:when>
																		<c:otherwise>
																			<img src="${companyRes.image3_wl}"
																				style="width: 100px; height: 72px; border-radius: 2px;"
																				alt="">
																		</c:otherwise>
																	</c:choose>
																</div>

																<div class="media-body">
																	<div class="uploader bg-warning">
																		<input type="file" class="file-styled"
																			name="file_image3_wl" /><span class="action"
																			style="-webkit-user-select: none;"><i
																			class="icon-googleplus5"></i></span>
																	</div>
																	<button type="button" class="btn btn-danger">
																		삭제 <i class="icon-arrow-right14 position-right delImg"></i>
																	</button>
																	<input type="hidden" name="image3_wl"
																		value="${companyRes.image3_wl }" />

																</div>
															</div>
														</div>
													</div>
													<div class="col-xs-6">
														<div class="form-group">
															<label>이미지3_썸네일 (52 x 52)</label>
															<div class="media no-margin-top">
																<div class="media-left">
																	<c:choose>
																		<c:when test="${empty companyRes.image3_ws}">
																			<img src="/assets/images/placeholder.jpg"
																				style="width: 100px; height: 72px; border-radius: 2px;"
																				alt="">
																		</c:when>
																		<c:otherwise>
																			<img src="${companyRes.image3_ws}"
																				style="width: 100px; height: 72px; border-radius: 2px;"
																				alt="">
																		</c:otherwise>
																	</c:choose>
																</div>

																<div class="media-body">
																	<div class="uploader bg-warning">
																		<input type="file" class="file-styled"
																			name="file_image3_ws" /><span class="action"
																			style="-webkit-user-select: none;"><i
																			class="icon-googleplus5"></i></span>
																	</div>
																	<button type="button" class="btn btn-danger">
																		삭제 <i class="icon-arrow-right14 position-right delImg"></i>
																	</button>
																	<input type="hidden" name="image3_ws"
																		value="${companyRes.image3_ws }" />

																</div>
															</div>
														</div>
													</div>
												</div>

											</div>

											<div class="row">
												<div class="col-md-6">
													<div class="col-xs-6">
														<div class="form-group">
															<label>쿠폰이미지 (230 x 186)</label>
															<div class="media no-margin-top">
																<div class="media-left">
																	<c:choose>
																		<c:when test="${empty companyRes.image_cp}">
																			<img src="/assets/images/placeholder.jpg"
																				style="width: 100px; height: 72px; border-radius: 2px;"
																				alt="">
																		</c:when>
																		<c:otherwise>
																			<img src="${companyRes.image_cp}"
																				style="width: 100px; height: 72px; border-radius: 2px;"
																				alt="">
																		</c:otherwise>
																	</c:choose>
																</div>

																<div class="media-body">
																	<div class="uploader bg-warning">
																		<input type="file" class="file-styled"
																			name="file_image_cp" /><span class="action"
																			style="-webkit-user-select: none;"><i
																			class="icon-googleplus5"></i></span>
																	</div>
																	<button type="button" class="btn btn-danger">
																		삭제 <i class="icon-arrow-right14 position-right delImg"></i>
																	</button>
																	<input type="hidden" name="image_cp"
																		value="${companyRes.image_cp }" />

																</div>
															</div>
														</div>
													</div>
												</div>

											</div>

											<div class="">
												<a href="${listUrl}"><button type="button"
														class="btn btn-defult" id="goList">
														목록 <i class="icon-arrow-right14 position-right"></i>
													</button></a>
												<button type="button" class="btn btn-primary goSave">
													저장 <i class="icon-arrow-right14 position-right"></i>
												</button>
												<c:if test="${0 eq companyRes.parent_id }">
													<a
														href="/sub/company/copy/${companyRes.pageIndex}/${companyRes.id}"><button
															type="button" class="btn btn-primary putBranch">
															지점등록 <i class="icon-arrow-right14 position-right"></i>
														</button></a>
													<p style="color: red; padding-top: 10px;">[ 지점등록 방법 ]</p>
													<p style="color: red;">대표지점 등록 -> 지점등록 클릭 -> 대표지점 정보가
														그대로 복사된 페이지가 생성 됨 -> 지점에따라 바뀌는 정보 입력 후 저장 -> 목록에서 등록된 지점
														확인 가능</p>
												</c:if>
											</div>
										</fieldset>



									</div>
								</div>
							</div>
						</div>

						<!-- /2 columns form -->
						<!-- Vertical form options -->
						<div class="row">
							<c:forEach items="${companyRes.companyLocales}" var="rData"
								varStatus="rStatus">

								<div class="col-md-4">

									<!-- Basic layout-->
									<div class="panel panel-flat">
										<div class="panel-heading">
											<h5 class="panel-title">다국어 영역(${rData.locale})</h5>
											<div class="heading-elements">
												<ul class="icons-list">
													<li><a data-action="collapse"></a></li>
												</ul>
											</div>
										</div>

										<div class="panel-body">
											<input type="hidden" id="locale"
												name="companyLocales[${rStatus.index}].locale"
												value="${rData.locale}">
											<div class="form-group">
												<label>이름(${rData.locale}) :</label> <input type="text"
													class="form-control" placeholder="company_name"
													id="company_name_${rData.locale}"
													name="companyLocales[${rStatus.index}].company_name"
													value="${rData.company_name}" />
											</div>

											<div class="form-group">
												<label>지점이름(${rData.locale}) :</label> <input type="text"
													class="form-control" placeholder="branch_name"
													id="branch_name_${rData.locale}"
													name="companyLocales[${rStatus.index}].branch_name"
													value="${rData.branch_name}" />
											</div>
											<%-- <div class="form-group">
												<label>benefit(${rData.locale}) :</label> <input type="text"
													class="form-control" placeholder="benefit"
													id="benefit_${rData.locale}"
													name="companyLocales[${rStatus.index}].benefit"
													value="${rData.benefit}" />
											</div>
											<div class="form-group">
												<label>conditions(${rData.locale}) :</label> <input
													type="text" class="form-control" placeholder="conditions"
													id="conditions_${rData.locale}"
													name="companyLocales[${rStatus.index}].conditions"
													value="${rData.conditions}" />
											</div> --%>
											<div class="form-group">
												<label>benefit(${rData.locale}) :</label>
												<textarea rows="2" cols="5" class="form-control"
													id="benefit_${rData.locale}"
													name="companyLocales[${rStatus.index}].benefit"
													placeholder="혜택">${rData.benefit}</textarea>
											</div>
											<div class="form-group">
												<label>conditions(${rData.locale}) :</label>
												<textarea rows="5" cols="5" class="form-control"
													id="conditions_${rData.locale}"
													name="companyLocales[${rStatus.index}].conditions"
													placeholder="할인내용">${rData.conditions}</textarea>
											</div>
											<div class="form-group">
												<label>working_hour(${rData.locale}) :</label> <input
													type="text" class="form-control" placeholder="working_hour"
													id="working_hour_${rData.locale}"
													name="companyLocales[${rStatus.index}].working_hour"
													value="${rData.working_hour}" />
											</div>
											<div class="form-group">
												<label>rest_day(${rData.locale}) :</label> <input
													type="text" class="form-control" placeholder="rest_day"
													id="rest_day_${rData.locale}"
													name="companyLocales[${rStatus.index}].rest_day"
													value="${rData.rest_day}" />
											</div>
											<div class="form-group">
												<label>고객 문의 대표 연락처(${rData.locale}) :</label> <input
													type="text" class="form-control" placeholder="phone_number"
													id="phone_number_${rData.locale}"
													name="companyLocales[${rStatus.index}].phone_number"
													value="${rData.phone_number}" />
											</div>
											<div class="form-group">
												<label>homepage(${rData.locale}) :</label> <input
													type="text" class="form-control" placeholder="homepage"
													id="homepage_${rData.locale}"
													name="companyLocales[${rStatus.index}].homepage"
													value="${rData.homepage}" />
											</div>
											<div class="form-group">
												<label>items(${rData.locale}) :</label> <input type="text"
													class="form-control" placeholder="items"
													id="items_${rData.locale}"
													name="companyLocales[${rStatus.index}].items"
													value="${rData.items}" />
											</div>
											<div class="form-group">
												<label>시/도(${rData.locale}) :</label> <input type="text"
													class="form-control" placeholder="first_address"
													id="first_address_${rData.locale}"
													name="companyLocales[${rStatus.index}].first_address"
													value="${rData.first_address}" />
											</div>
											<div class="form-group">
												<label>구/군(${rData.locale}) :</label> <input type="text"
													class="form-control" placeholder="middle_address"
													id="middle_address_${rData.locale}"
													name="companyLocales[${rStatus.index}].middle_address"
													value="${rData.middle_address}" />
											</div>
											<div class="form-group">
												<label>나머지 상세 주소(${rData.locale}) :</label> <input
													type="text" class="form-control" placeholder="last_address"
													id="last_address_${rData.locale}"
													name="companyLocales[${rStatus.index}].last_address"
													value="${rData.last_address}" />
											</div>

											<div class="form-group">
												<label>기업소개(${rData.locale}) :</label>
												<textarea rows="5" cols="5" class="form-control"
													id="descs_${rData.locale}"
													name="companyLocales[${rStatus.index}].descs"
													placeholder="기업설명 상세">${rData.descs}</textarea>
											</div>
											<%-- <div class="form-group">
												<label>기업시즌오프 컨텐츠(${rData.locale}) :</label>
												<div class="summernote" style="height: 300px;"
													id="summernote_${rData.locale}">${rData.company_content}</div>
												<input type="hidden"
													name="companyLocales[${rStatus.index}].company_content"
													id="company_content_${rData.locale}" />

											</div> --%>
											<div class="text-right">

												<button type="button" class="btn btn-primary goSave">
													저장 <i class="icon-arrow-right14 position-right"></i>
												</button>
												<a href="/coupon/${rData.locale}/${companyRes.id}"
													target="_blank"> 쿠폰생성 <i
													class="icon-arrow-right14 position-right"></i>
												</a>
											</div>

										</div>
										<!-- /basic layout -->

									</div>

								</div>

							</c:forEach>

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
					alert("저장되었습니다.");
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

			/* if (!Boolean(position)) {
				alert("노출순서를 입력해 주세요.");
				$("#position").focus();
				return false;
			} */
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