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
		<c:when test="${not empty company.searchVal }">
			<c:set
				value="/sub/company/list/${company.pageIndex}/${company.searchKey}/${company.searchVal}"
				var="listUrl" />
		</c:when>
		<c:otherwise>
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
				<div class="content">
					<form class="" action="/sub/company/put" method="post" id="postFrm"
						enctype="multipart/form-data">
						<input type="hidden" name="use_yn" value="Y" />
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
																<option value="${sData.id}">${sData.title}</option>
															</c:forEach>
														</select>
													</div>
												</div>


												<!-- <div class="col-md-6">
													<div class="form-group">
														<label>노출순서</label> <input type="text" value="1"
															class="touchspin-vertical" id="position" name="position" />
													</div>
												</div> -->
											</div>

										</fieldset>
									</div>

									<div class="col-md-3">
										<fieldset>
											<div class="row">
												<!-- <div class="col-md-4">
													<div class="form-group">
														<label>년도</label><select class="select" id="year"
															name="year">
															<option value="2016">2016</option>
															<option value="2017">2017</option>
															<option value="2018">2018</option>
															<option value="2019">2019</option>

														</select>
													</div>
												</div> -->

												<div class="col-md-8">
													<div class="col-md-6">
														<div class="form-group">
															<label>위도</label> <input type="text" placeholder="위도"
																class="form-control" id="lat" name="lat" />
														</div>
													</div>

													<div class="col-md-6">
														<div class="form-group">
															<label>경도</label> <input type="text" placeholder="경도"
																class="form-control" id="lon" name="lon" />
														</div>
													</div>

												</div>

											</div>

										</fieldset>

									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label>등록지점수</label> <input type="text" value="1"
												class="touchspin-vertical" id="brancheCnt" name="brancheCnt" />
										</div>
									</div>
									<div class="col-md-12">
										- 예시) 크롬에서 구글맵 실행→ 주소 검색 후 URL 확인 → @표시 뒷부분이 위도, 경도 <img
											src="/assets/images/ex02.jpg" class="img-responsive"
											width="100%;" />
									</div>

									<!-- <div class="col-md-3">
										<fieldset>
											<div class="row">
												<div class="col-xs-6">
													<div class="form-group">
														<label class="display-block">노출여부</label> <label
															class="radio-inline"> <input type="radio"
															class="styled" name="use_at" value="Y" /> 노출
														</label> <label class="radio-inline"> <input type="radio"
															class="styled" name="use_at" value="N" checked="checked" />
															비노출
														</label>
													</div>
												</div>
												<div class="col-xs-6">
													<div class="form-group">
														<label class="display-block">메인노출여부</label> <label
															class="radio-inline"> <input type="radio"
															class="styled" name="main_view" value="Y" /> 노출
														</label> <label class="radio-inline"> <input type="radio"
															class="styled" name="main_view" value="N" checked="checked" />
															비노출
														</label>
													</div>
												</div>
												<div class="col-xs-6">
													<div class="form-group">
														<label class="display-block">헤드스토어여부</label> <label
															class="radio-inline"> <input type="radio"
															class="styled" name="headstore" value="Y" /> Y
														</label> <label class="radio-inline"> <input type="radio"
															class="styled" name="headstore" value="N"
															checked="checked" /> N
														</label>
													</div>
												</div>
											</div>


										</fieldset>
									</div> -->
									<!-- <div class="col-md-3">
										<fieldset>
											<div class="row">
												<div class="col-xs-12">
													<div class="form-group">
														<label class="display-block">오프시즌 노출여부</label> <label
															class="radio-inline"> <input type="radio"
															class="styled" name="season_off" value="Y" /> 노출
														</label> <label class="radio-inline"> <input type="radio"
															class="styled" name="season_off" value="N"
															checked="checked" /> 비노출
														</label>
													</div>
												</div>
											</div>
										</fieldset>
									</div> -->
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
									<div class="col-md-12" style="color: red;">

										<p>1. 로고이미지 : 로고 이미지 사이즈에 맞춰 등록 (44*26, 184*80 모두 등록 必)</p>
										<p>2. 이미지1~3 : 매장 내외부 사진 등록 (최대 3장)</p>
										<p>3. 썸네일1~3 : 매장 내외부 사진과 동일한 이미지를 52*52 사이즈로 추가 등록 (썸네일로
											활용)</p>
										<p>4. 쿠폰이미지 : 쿠폰이미지는 쿠폰에 반영될 기업 사진으로써 매장 내외부 사진 1장 등록</p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<fieldset>
											<div class="row">
												<div class="col-md-4">
													<div class="col-xs-6">
														<div class="form-group">
															<label>로고이미지1 (44 x 26)</label> <input type="file"
																class="file-styled" name="file_image_main" />
														</div>
													</div>
													<div class="col-xs-6">
														<div class="form-group">
															<label>로고이미지2 (184 x 80)</label> <input type="file"
																class="file-styled" name="file_image_list" />
														</div>
													</div>
												</div>


											</div>
											<div class="row">

												<div class="col-md-4">
													<div class="col-xs-6">
														<div class="form-group">
															<label>이미지1 (380 x 260)</label> <input type="file"
																class="file-styled" name="file_image1_wl" />
														</div>
													</div>
													<div class="col-xs-6">
														<div class="form-group">
															<label>이미지1_썸네일 (52 x 52)</label> <input type="file"
																class="file-styled" name="file_image1_ws" />
														</div>
													</div>
												</div>
												<div class="col-md-4">
													<div class="col-xs-6">
														<div class="form-group">
															<label>이미지2 (380 x 260)</label> <input type="file"
																class="file-styled" name="file_image2_wl" />
														</div>
													</div>
													<div class="col-xs-6">
														<div class="form-group">
															<label>이미지2_썸네일 (52 x 52)</label> <input type="file"
																class="file-styled" name="file_image2_ws" />
														</div>
													</div>
												</div>
												<div class="col-md-4">
													<div class="col-xs-6">
														<div class="form-group">
															<label>이미지3 (380 x 260)</label> <input type="file"
																class="file-styled" name="file_image3_wl" />
														</div>
													</div>
													<div class="col-xs-6">
														<div class="form-group">
															<label>이미지3_썸네일 (52 x 52)</label> <input type="file"
																class="file-styled" name="file_image3_ws" />
														</div>
													</div>
												</div>

											</div>
											<div class="row">
												<!-- <div class="col-md-4">
													<div class="col-xs-6">
														<div class="form-group">
															<label>이미지4 (380 x 260)</label> <input type="file"
																class="file-styled" name="file_image4_wl" />
														</div>
													</div>
													<div class="col-xs-6">
														<div class="form-group">
															<label>이미지4 (52 x 52)</label> <input type="file"
																class="file-styled" name="file_image4_ws" />
														</div>
													</div>
												</div>

												<div class="col-md-4">
													<div class="col-xs-6">
														<div class="form-group">
															<label>이미지5 (380 x 260)</label> <input type="file"
																class="file-styled" name="file_image5_wl" />
														</div>
													</div>
													<div class="col-xs-6">
														<div class="form-group">
															<label>이미지5 (52 x 52)</label> <input type="file"
																class="file-styled" name="file_image5_ws" />
														</div>
													</div> 
												</div> -->
												<div class="col-md-4">
													<div class="col-xs-12">
														<div class="form-group">
															<label>쿠폰이미지 (230 x 186)</label> <input type="file"
																class="file-styled" name="file_image_cp" />
														</div>
													</div>

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

						<!-- /2 columns form -->
						<!-- Vertical form options -->
						<div class="row">
							<div class="col-md-4">

								<!-- Basic layout-->
								<div class="panel panel-flat">
									<div class="panel-heading">
										<h5 class="panel-title">다국어 영역(ko)</h5>
										<div class="heading-elements">
											<ul class="icons-list">
												<li><a data-action="collapse"></a></li>
											</ul>
										</div>
									</div>

									<div class="panel-body">
										<input type="hidden" id="locale"
											name="companyLocales[0].locale" value="ko">
										<div class="form-group">
											<label>이름(ko) :</label> <input type="text"
												class="form-control" placeholder="company_name"
												id="company_name_ko" name="companyLocales[0].company_name">
										</div>

										<div class="form-group">
											<label>지점이름(ko) :</label> <input type="text"
												class="form-control" placeholder="branch_name"
												id="branch_name_ko" name="companyLocales[0].branch_name">
										</div>

										<!-- <div class="form-group">
											<label>혜택(ko) :</label> <input type="text"
												class="form-control" placeholder="benefit" id="benefit_ko"
												name="companyLocales[0].benefit">
										</div>
										
										<div class="form-group">
											<label>할인내용(ko) :</label> <input type="text"
												class="form-control" placeholder="conditions"
												id="conditions_ko" name="companyLocales[0].conditions">
										</div> -->

										<div class="form-group">
											<label>주요 혜택 내용 / 최대 10자 이내(ko): <span
												style="color: red;">* 주요혜택내용/최대 10자이내</span></label>
											<textarea rows="2" cols="5" class="form-control"
												id="benefit_ko" name="companyLocales[0].benefit"
												placeholder="혜택"></textarea>
										</div>

										<div class="form-group">
											<label>상세 혜택 내용 및 쿠폰 사용 조건(ko) <span
												style="color: red;"> * 상세 혜택 내용 및 쿠폰사용 조건</span>:
											</label>
											<textarea rows="5" cols="5" class="form-control"
												id="conditions_ko" name="companyLocales[0].conditions"
												placeholder="할인내용"></textarea>
										</div>
										<div class="form-group">
											<p>상세 혜택 내용 및 쿠폰 사용 조건 입력 예시</p>
											<img src="/assets/images/ex01.jpg" class="img-responsive"
												width="100%;" />
										</div>

										<div class="form-group">
											<label>영업시간(ko) <span style="color: red;"> *
													ex) 09:00~18:00</span>:
											</label> <input type="text" class="form-control"
												placeholder="working_hour" id="working_hour_ko"
												name="companyLocales[0].working_hour">
										</div>
										<div class="form-group">
											<label>휴무일(ko) :</label> <input type="text"
												class="form-control" placeholder="rest_day" id="rest_day_ko"
												name="companyLocales[0].rest_day">
										</div>
										<div class="form-group">
											<label>고객 문의 대표 연락처(ko) :</label> <input type="text"
												class="form-control" placeholder="phone_number"
												id="phone_number_ko" name="companyLocales[0].phone_number">
										</div>
										<div class="form-group">
											<label>홈페이지(ko) :</label> <input type="text"
												class="form-control" placeholder="homepage" id="homepage_ko"
												name="companyLocales[0].homepage">
										</div>
										<div class="form-group">
											<label>판매품목(ko) :</label> <input type="text"
												class="form-control" placeholder="items" id="items_ko"
												name="companyLocales[0].items">
										</div>
										<div class="form-group">
											<label>시/도(ko) :</label> <input type="text"
												class="form-control" placeholder="시/군" id="first_address_ko"
												name="companyLocales[0].first_address">
										</div>
										<div class="form-group">
											<label>구/군(ko) :</label> <input type="text"
												class="form-control" placeholder="구/군"
												id="middle_address_ko"
												name="companyLocales[0].middle_address">
										</div>
										<div class="form-group">
											<label>나머지 상세 주소(ko) :</label> <input type="text"
												class="form-control" placeholder="상세주소" id="last_address_ko"
												name="companyLocales[0].last_address">
										</div>

										<div class="form-group">
											<label>기업 소개(ko) :</label>
											<textarea rows="5" cols="5" class="form-control"
												id="descs_ko" name="companyLocales[0].descs"
												placeholder="기업설명 상세"></textarea>
										</div>
										<!-- <div class="form-group">
											<label>기업시즌오프 컨텐츠(ko) :</label>
											<div class="summernote" style="height: 300px;"
												id="summernote_ko"></div>
											<input type="hidden" name="companyLocales[0].company_content"
												id="company_content_ko" />

										</div> -->

									</div>
								</div>
								<!-- /basic layout -->

							</div>

							<div class="col-md-4">

								<!-- Basic layout-->
								<div class="panel panel-flat">
									<div class="panel-heading">
										<h5 class="panel-title">다국어 영역(en)</h5>
										<div class="heading-elements">
											<ul class="icons-list">
												<li><a data-action="collapse"></a></li>
											</ul>
										</div>
									</div>

									<div class="panel-body">
										<input type="hidden" id="locale"
											name="companyLocales[1].locale" value="en">
										<div class="form-group">
											<label>이름(en) :</label> <input type="text"
												class="form-control" placeholder="company_name"
												id="company_name_en" name="companyLocales[1].company_name">
										</div>

										<div class="form-group">
											<label>지점이름(en) :</label> <input type="text"
												class="form-control" placeholder="branch_name"
												id="branch_name_en" name="companyLocales[1].branch_name">
										</div>
										<!-- <div class="form-group">
											<label>혜택(en) :</label> <input type="text"
												class="form-control" placeholder="benefit" id="benefit_en"
												name="companyLocales[1].benefit">
										</div>
										<div class="form-group">
											<label>할인내용(en) :</label> <input type="text"
												class="form-control" placeholder="conditions"
												id="conditions_en" name="companyLocales[1].conditions">
										</div> -->

										<div class="form-group">
											<label>혜택(en) :</label>
											<textarea rows="5" cols="5" class="form-control"
												id="benefit_en" name="companyLocales[1].benefit"
												placeholder="혜택"></textarea>
										</div>
										<div class="form-group">
											<label>할인내용(en) :</label>
											<textarea rows="2" cols="5" class="form-control"
												id="conditions_en" name="companyLocales[1].conditions"
												placeholder="할인내용"></textarea>
										</div>

										<div class="form-group">
											<label>영업시간(en) :</label> <input type="text"
												class="form-control" placeholder="working_hour"
												id="working_hour_en" name="companyLocales[1].working_hour">
										</div>
										<div class="form-group">
											<label>휴무일(en) :</label> <input type="text"
												class="form-control" placeholder="rest_day" id="rest_day_en"
												name="companyLocales[1].rest_day">
										</div>
										<div class="form-group">
											<label>고객 문의 대표 연락처(en) :</label> <input type="text"
												class="form-control" placeholder="phone_number"
												id="phone_number_en" name="companyLocales[1].phone_number">
										</div>
										<div class="form-group">
											<label>홈페이지(en) :</label> <input type="text"
												class="form-control" placeholder="homepage" id="homepage_en"
												name="companyLocales[1].homepage">
										</div>
										<div class="form-group">
											<label>판매품목(en) :</label> <input type="text"
												class="form-control" placeholder="items" id="items_en"
												name="companyLocales[1].items">
										</div>
										<div class="form-group">
											<label>시/도(en) :</label> <input type="text"
												class="form-control" placeholder="시/도" id="first_address_en"
												name="companyLocales[1].first_address">
										</div>
										<div class="form-group">
											<label>구/군(en) :</label> <input type="text"
												class="form-control" placeholder="구/군"
												id="middle_address_en"
												name="companyLocales[1].middle_address">
										</div>
										<div class="form-group">
											<label>나머지 상세 주소(en) :</label> <input type="text"
												class="form-control" placeholder="상세주소" id="last_address_en"
												name="companyLocales[1].last_address">
										</div>

										<div class="form-group">
											<label>기업 소개(en) :</label>
											<textarea rows="5" cols="5" class="form-control"
												id="descs_en" name="companyLocales[1].descs"
												placeholder="기업설명 상세"></textarea>
										</div>
										<!-- <div class="form-group">
											<label>기업시즌오프 컨텐츠(en) :</label>
											<div class="summernote" style="height: 300px;"
												id="summernote_en"></div>
											<input type="hidden" name="companyLocales[1].company_content"
												id="company_content_en" />

										</div> -->

									</div>
								</div>
								<!-- /basic layout -->

							</div>
							<div class="col-md-4">

								<!-- Basic layout-->
								<div class="panel panel-flat">
									<div class="panel-heading">
										<h5 class="panel-title">다국어 영역(jp)</h5>
										<div class="heading-elements">
											<ul class="icons-list">
												<li><a data-action="collapse"></a></li>
											</ul>
										</div>
									</div>

									<div class="panel-body">
										<input type="hidden" id="locale"
											name="companyLocales[2].locale" value="jp">
										<div class="form-group">
											<label>이름(jp) :</label> <input type="text"
												class="form-control" placeholder="company_name"
												id="company_name_jp" name="companyLocales[2].company_name">
										</div>

										<div class="form-group">
											<label>지점이름(jp) :</label> <input type="text"
												class="form-control" placeholder="branch_name"
												id="branch_name_jp" name="companyLocales[2].branch_name">
										</div>
										<!-- <div class="form-group">
											<label>혜택(jp) :</label> <input type="text"
												class="form-control" placeholder="benefit" id="benefit_jp"
												name="companyLocales[2].benefit">
										</div>
										<div class="form-group">
											<label>할인내용(jp) :</label> <input type="text"
												class="form-control" placeholder="conditions"
												id="conditions_jp" name="companyLocales[2].conditions">
										</div> -->
										<div class="form-group">
											<label>혜택(jp) :</label>
											<textarea rows="2" cols="5" class="form-control"
												id="benefit_jp" name="companyLocales[2].benefit"
												placeholder="혜택"></textarea>
										</div>
										<div class="form-group">
											<label>할인내용(jp) :</label>
											<textarea rows="5" cols="5" class="form-control"
												id="conditions_jp" name="companyLocales[2].conditions"
												placeholder="할인내용"></textarea>
										</div>

										<div class="form-group">
											<label>영업시간(jp) :</label> <input type="text"
												class="form-control" placeholder="working_hour"
												id="working_hour_jp" name="companyLocales[2].working_hour">
										</div>
										<div class="form-group">
											<label>휴무일(jp) :</label> <input type="text"
												class="form-control" placeholder="rest_day" id="rest_day_jp"
												name="companyLocales[2].rest_day">
										</div>
										<div class="form-group">
											<label>고객 문의 대표 연락처(jp) :</label> <input type="text"
												class="form-control" placeholder="phone_number"
												id="phone_number_jp" name="companyLocales[2].phone_number">
										</div>
										<div class="form-group">
											<label>홈페이지(jp) :</label> <input type="text"
												class="form-control" placeholder="homepage" id="homepage_jp"
												name="companyLocales[2].homepage">
										</div>
										<div class="form-group">
											<label>판매품목(jp) :</label> <input type="text"
												class="form-control" placeholder="items" id="items_jp"
												name="companyLocales[2].items">
										</div>
										<div class="form-group">
											<label>시/도(jp) :</label> <input type="text"
												class="form-control" placeholder="시/도" id="first_address_jp"
												name="companyLocales[2].first_address">
										</div>
										<div class="form-group">
											<label>구/군(jp) :</label> <input type="text"
												class="form-control" placeholder="구/군"
												id="middle_address_jp"
												name="companyLocales[2].middle_address">
										</div>
										<div class="form-group">
											<label>나머지 상세 주소(jp) :</label> <input type="text"
												class="form-control" placeholder="상세주소" id="last_address_jp"
												name="companyLocales[2].last_address">
										</div>

										<div class="form-group">
											<label>기업 소개(jp) :</label>
											<textarea rows="5" cols="5" class="form-control"
												id="descs_jp" name="companyLocales[2].descs"
												placeholder="기업설명 상세"></textarea>
										</div>
										<!-- <div class="form-group">
											<label>기업시즌오프 컨텐츠(jp) :</label>
											<div class="summernote" style="height: 300px;"
												id="summernote_jp"></div>
											<input type="hidden" name="companyLocales[2].company_content"
												id="company_content_jp" />

										</div> -->
									</div>
								</div>
								<!-- /basic layout -->

							</div>
						</div>
						<div class="row">
							<div class="col-md-4">

								<!-- Basic layout-->
								<div class="panel panel-flat">
									<div class="panel-heading">
										<h5 class="panel-title">다국어 영역(cn)</h5>
										<div class="heading-elements">
											<ul class="icons-list">
												<li><a data-action="collapse"></a></li>
											</ul>
										</div>
									</div>

									<div class="panel-body">
										<input type="hidden" id="locale"
											name="companyLocales[3].locale" value="cn">
										<div class="form-group">
											<label>이름(cn) :</label> <input type="text"
												class="form-control" placeholder="company_name"
												id="company_name_cn" name="companyLocales[3].company_name">
										</div>

										<div class="form-group">
											<label>지점이름(cn) :</label> <input type="text"
												class="form-control" placeholder="branch_name"
												id="branch_name_cn" name="companyLocales[3].branch_name">
										</div>
										<!-- <div class="form-group">
											<label>혜택(cn) :</label> <input type="text"
												class="form-control" placeholder="benefit" id="benefit_cn"
												name="companyLocales[3].benefit">
										</div>
										<div class="form-group">
											<label>할인내용(cn) :</label> <input type="text"
												class="form-control" placeholder="conditions"
												id="conditions_cn" name="companyLocales[3].conditions">
										</div> -->
										<div class="form-group">
											<label>혜택(cn) :</label>
											<textarea rows="2" cols="5" class="form-control"
												id="benefit_cn" name="companyLocales[3].benefit"
												placeholder="혜택"></textarea>
										</div>
										<div class="form-group">
											<label>할인내용(cn) :</label>
											<textarea rows="5" cols="5" class="form-control"
												id="conditions_cn" name="companyLocales[3].conditions"
												placeholder="할인내용"></textarea>
										</div>
										<div class="form-group">
											<label>영업시간(cn) :</label> <input type="text"
												class="form-control" placeholder="working_hour"
												id="working_hour_cn" name="companyLocales[3].working_hour">
										</div>
										<div class="form-group">
											<label>휴무일(cn) :</label> <input type="text"
												class="form-control" placeholder="rest_day" id="rest_day_cn"
												name="companyLocales[3].rest_day">
										</div>
										<div class="form-group">
											<label>고객 문의 대표 연락처(cn) :</label> <input type="text"
												class="form-control" placeholder="phone_number"
												id="phone_number_cn" name="companyLocales[3].phone_number">
										</div>
										<div class="form-group">
											<label>홈페이지(cn) :</label> <input type="text"
												class="form-control" placeholder="homepage" id="homepage_cn"
												name="companyLocales[3].homepage">
										</div>
										<div class="form-group">
											<label>판매품목(cn) :</label> <input type="text"
												class="form-control" placeholder="items" id="items_cn"
												name="companyLocales[3].items">
										</div>
										<div class="form-group">
											<label>시/도(cn) :</label> <input type="text"
												class="form-control" placeholder="시/도" id="first_address_cn"
												name="companyLocales[3].first_address">
										</div>
										<div class="form-group">
											<label>구/군(cn) :</label> <input type="text"
												class="form-control" placeholder="구/군"
												id="middle_address_cn"
												name="companyLocales[3].middle_address">
										</div>
										<div class="form-group">
											<label>나머지 상세 주소(cn) :</label> <input type="text"
												class="form-control" placeholder="상세주소" id="last_address_cn"
												name="companyLocales[3].last_address">
										</div>

										<div class="form-group">
											<label>기업 소개(cn) :</label>
											<textarea rows="5" cols="5" class="form-control"
												id="descs_cn" name="companyLocales[3].descs"
												placeholder="기업설명 상세"></textarea>
										</div>
										<!-- <div class="form-group">
											<label>기업시즌오프 컨텐츠(cn) :</label>
											<div class="summernote" style="height: 300px;"
												id="summernote_cn"></div>
											<input type="hidden" name="companyLocales[3].company_content"
												id="company_content_cn" />

										</div> -->
									</div>
								</div>
								<!-- /basic layout -->

							</div>
							<div class="col-md-4">

								<!-- Basic layout-->
								<div class="panel panel-flat">
									<div class="panel-heading">
										<h5 class="panel-title">다국어 영역(tw)</h5>
										<div class="heading-elements">
											<ul class="icons-list">
												<li><a data-action="collapse"></a></li>
											</ul>
										</div>
									</div>

									<div class="panel-body">
										<input type="hidden" id="locale"
											name="companyLocales[4].locale" value="tw">
										<div class="form-group">
											<label>이름(tw) :</label> <input type="text"
												class="form-control" placeholder="company_name"
												id="company_name_tw" name="companyLocales[4].company_name">
										</div>

										<div class="form-group">
											<label>지점이름(tw) :</label> <input type="text"
												class="form-control" placeholder="branch_name"
												id="branch_name_tw" name="companyLocales[4].branch_name">
										</div>
										<!-- <div class="form-group">
											<label>혜택(tw) :</label> <input type="text"
												class="form-control" placeholder="benefit" id="benefit_tw"
												name="companyLocales[4].benefit">
										</div>
										<div class="form-group">
											<label>할인내용(tw) :</label> <input type="text"
												class="form-control" placeholder="conditions"
												id="conditions_tw" name="companyLocales[4].conditions">
										</div> -->
										<div class="form-group">
											<label>혜택(tw) :</label>
											<textarea rows="2" cols="5" class="form-control"
												id="benefit_tw" name="companyLocales[4].benefit"
												placeholder="혜택"></textarea>
										</div>
										<div class="form-group">
											<label>할인내용(cn) :</label>
											<textarea rows="5" cols="5" class="form-control"
												id="conditions_tw" name="companyLocales[4].conditions"
												placeholder="할인내용"></textarea>
										</div>
										<div class="form-group">
											<label>영업시간(tw) :</label> <input type="text"
												class="form-control" placeholder="working_hour"
												id="working_hour_tw" name="companyLocales[4].working_hour">
										</div>
										<div class="form-group">
											<label>휴무일(tw) :</label> <input type="text"
												class="form-control" placeholder="rest_day" id="rest_day_tw"
												name="companyLocales[4].rest_day">
										</div>
										<div class="form-group">
											<label>고객 문의 대표 연락처(tw) :</label> <input type="text"
												class="form-control" placeholder="phone_number"
												id="phone_number_tw" name="companyLocales[4].phone_number">
										</div>
										<div class="form-group">
											<label>홈페이지(tw) :</label> <input type="text"
												class="form-control" placeholder="homepage" id="homepage_tw"
												name="companyLocales[4].homepage">
										</div>
										<div class="form-group">
											<label>판매품목(tw) :</label> <input type="text"
												class="form-control" placeholder="items" id="items_tw"
												name="companyLocales[4].items">
										</div>
										<div class="form-group">
											<label>시/도(tw) :</label> <input type="text"
												class="form-control" placeholder="시/도" id="first_address_tw"
												name="companyLocales[4].first_address">
										</div>
										<div class="form-group">
											<label>구/군(tw) :</label> <input type="text"
												class="form-control" placeholder="구/군"
												id="middle_address_tw"
												name="companyLocales[4].middle_address">
										</div>
										<div class="form-group">
											<label>나머지 상세 주소(tw) :</label> <input type="text"
												class="form-control" placeholder="상세주소" id="last_address_tw"
												name="companyLocales[4].last_address">
										</div>

										<div class="form-group">
											<label>기업 소개(tw) :</label>
											<textarea rows="5" cols="5" class="form-control"
												id="descs_tw" name="companyLocales[4].descs"
												placeholder="기업설명 상세"></textarea>
										</div>
										<!-- <div class="form-group">
											<label>기업시즌오프 컨텐츠(tw) :</label>
											<div class="summernote" style="height: 300px;"
												id="summernote_tw"></div>
											<input type="hidden" name="companyLocales[4].company_content"
												id="company_content_tw" />

										</div> -->

									</div>
								</div>
								<!-- /basic layout -->
								<div class="text-right">
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
						<!-- /vertical form options -->


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