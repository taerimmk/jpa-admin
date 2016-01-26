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
		<c:when test="${not empty board.searchVal }">
			<c:set
				value="/board/${board.board_master_id}/set/${board.pageIndex}/${board.id}/${board.searchKey}/${board.searchVal}"
				var="setUrl" />
			<c:set
				value="/board/${board.board_master_id}/list/${board.pageIndex}/${board.searchKey}/${board.searchVal}"
				var="listUrl" />
			<c:set
				value="/board/del/${board.board_master_id}/${board.pageIndex}/${board.id}/${board.searchKey}/${board.searchVal}"
				var="delUrl" />
		</c:when>
		<c:otherwise>
			<c:set
				value="/board/${board.board_master_id}/set/${board.pageIndex}/${board.id}"
				var="setUrl" />
			<c:set
				value="/board/${board.board_master_id}/list/${board.pageIndex}"
				var="listUrl" />
			<c:set
				value="/board/del/${board.board_master_id}/${board.pageIndex}/${board.id}"
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
			<!-- Main content -->

			<!-- Main content -->
			<div class="content-wrapper">

				<!-- Page header -->
				<div class="page-header">
					<div class="page-header-content">
						<div class="page-title">
							<h4>
								<i class="icon-arrow-left52 position-left"></i> <span
									class="text-semibold">컨텐츠</span> - 컨텐츠 수정
							</h4>
						</div>
					</div>
					<div class="breadcrumb-line">
						<ul class="breadcrumb">
							<li><a href="index.html"><i
									class="icon-home2 position-left"></i> Home</a></li>
							<li><a href="form_inputs_basic.html">컨텐츠</a></li>
							<li class="active">컨텐츠 수정</li>
						</ul>

					</div>
				</div>
				<!-- /page header -->

				<!-- Content area -->
				<div class="content">
					<form class="form-horizontal" action="${setUrl}" method="post"
						id="postFrm" enctype="multipart/form-data">

						<!-- /highlighted tabs -->
						<div class="panel panel-flat">
							<div class="panel-heading">
								<h5 class="panel-title">컨텐츠 info inputs</h5>
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
										<label class="control-label col-lg-2">카테고리선택</label>
										<div class="col-lg-10">
											<select class="form-control" id="board_master_id"
												name="board_master_id">
												<option value="${boardRes.board_master_id}">${boardRes.boardMst.mastername}</option>
												<%-- <option value="${boardRes.board_master_id}">${rData.boardMst.mastername}</option> --%>
												<c:forEach items="${boardMasterList}" var="sData">
													<option value="${sData.id}">${sData.mastername }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">상위메뉴선택</label>
										<div class="col-lg-10">
											<select class="form-control" id="menu_id" name="menu_id">
												<option value="0">최상위</option>
												<c:forEach items="${menuList}" var="sData">
													<option value="${sData.id}"
														<c:if test="${sData.id eq boardRes.menu_id}">selected="selected"</c:if>>${sData.menuLocales[0].name }</option>
												</c:forEach>
											</select>
										</div>
									</div>


									<div class="form-group">
										<label class="control-label col-lg-2">컨텐츠 이름(공통)</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength"
												placeholder="컨텐츠 이름(공통)명을 입력해 주세요" maxlength="30"
												id="boardname" name="boardname"
												value="${boardRes.boardname}" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">썸네일 이미지</label> <input
											type="hidden" name="image" value="${boardRes.image }" />
										<div class="col-lg-10">
											<c:choose>
												<c:when test="${empty boardRes.image}">
													<img src="/assets/images/placeholder.jpg"
														style="width: 52px; height: 52px; border-radius: 2px;"
														alt="">
												</c:when>
												<c:otherwise>
													<img src="${boardRes.image}"
														style="height: 200px; border-radius: 2px;" alt="">
												</c:otherwise>
											</c:choose>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">썸네일 이미지 변경</label>
										<div class="col-lg-10" style="display: block">
											<input type="file" class="file-styled" id="file" name="file"
												style="display: block" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">노출순서</label>
										<div class="col-lg-10">
											<input type="text" class="touchspin-vertical" id="position"
												name="position" placeholder="노출순서를 선택해 주세요"
												value="${boardRes.position}" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">노출여부</label>
										<div class="col-lg-10">
											<label class="radio-inline"> <input type="radio"
												class="styled" name="use_at" value="Y"
												<c:if test="${'Y' eq boardRes.use_at}">checked="checked"</c:if> />
												노출
											</label> <label class="radio-inline"> <input type="radio"
												class="styled" name="use_at" value="N"
												<c:if test="${'N' eq boardRes.use_at}">checked="checked"</c:if> />
												비노출
											</label>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">노출 URL(해당주소를
											복사해서 메뉴관리에 넣어주세요)</label>
										<div class="col-lg-10">
											<input type="text" class="form-control" id="url" name=""
												readonly="readonly" value="/board/${boardRes.id}" />
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
												<c:forEach items="${boardRes.boardLocales}" var="rData"
													varStatus="rStatus">
													<div
														class="tab-pane <c:if test="${'ko' eq rData.locale}">active</c:if>"
														id="highlighted-${rData.locale}">
														<div class="panel-body">
															<div class="form-group">
																<label>이름(${rData.locale}) :</label> <input type="text"
																	class="form-control maxlength"
																	placeholder="이름(${rData.locale}) 입력해 주세요"
																	maxlength="100" id="title_${rData.locale}"
																	name="boardLocales[${rStatus.index }].title"
																	value="${rData.title}" /> <input type="hidden"
																	name="boardLocales[${rStatus.index }].locale"
																	value="${rData.locale}" />
															</div>
															<div class="form-group">
																<label>이름설명(${rData.locale}) :</label> <input
																	type="text" class="form-control maxlength"
																	placeholder="이름설명(${rData.locale}) 입력해 주세요"
																	maxlength="100" id="titleinfo_${rData.locale}"
																	name="boardLocales[${rStatus.index }].titleinfo"
																	value="${rData.titleinfo}" />
															</div>
															<div class="form-group">
																<label>기업설명 상세(${rData.locale}) :</label>
																<div class="summernote" style="height: 500px;"
																	id="summernote_${rData.locale}">${rData.descs}</div>
																<input type="hidden"
																	name="boardLocales[${rStatus.index }].descs"
																	id="descs_${rData.locale}" /> <input type="hidden"
																	name="boardLocales[${rStatus.index }].id"
																	value="${rData.id}" />

															</div>

														</div>
													</div>

												</c:forEach>

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
			var boardname = $("#boardname").val();
			var position = $("#position").val();
			var name_ko = $("#name_ko").val();
			var name_en = $("#name_en").val();
			var name_jp = $("#name_jp").val();
			var name_cn = $("#name_cn").val();
			var name_tw = $("#name_tw").val();

			if (!Boolean(boardname)) {
				alert("제목을 입력해 주세요.");
				$("#boardname").focus();
				return false;
			}
			if (!Boolean(position)) {
				alert("노출순서를 입력해 주세요.");
				$("#position").focus();
				return false;
			}
			/* if (!Boolean(name_ko)) {
				alert("이름(ko)를 입력해 주세요");
				$("#name_ko").focus();
				return false;
			}
			if (!Boolean(name_en)) {
				alert("이름(en)를 입력해 주세요");
				$("#name_en").focus();
				return false;
			}
			if (!Boolean(name_jp)) {
				alert("이름(jp)를 입력해 주세요");
				$("#name_jp").focus();
				return false;
			}
			if (!Boolean(name_cn)) {
				alert("이름(cn)를 입력해 주세요");
				$("#name_cn").focus();
				return false;
			}
			if (!Boolean(name_tw)) {
				alert("이름(tw)를 입력해 주세요");
				$("#name_tw").focus();
				return false;
			} */
			return true;
		}
	</script>

</body>
</html>