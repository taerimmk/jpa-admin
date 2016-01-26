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
		<c:when test="${not empty boardMaster.searchVal }">
			<c:set
				value="/boardMaster/set/${boardMaster.pageIndex}/${boardMaster.id}/${boardMaster.searchKey}/${boardMaster.searchVal}"
				var="setUrl" />
			<c:set
				value="/boardMaster/list/${boardMaster.pageIndex}/${boardMaster.searchKey}/${boardMaster.searchVal}"
				var="listUrl" />
		</c:when>
		<c:otherwise>
			<c:set
				value="/boardMaster/set/${boardMaster.pageIndex}/${boardMaster.id}"
				var="setUrl" />
			<c:set value="/boardMaster/list/${boardMaster.pageIndex}"
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
			<!-- Main content -->

			<!-- Main content -->
			<div class="content-wrapper">

				<!-- Page header -->
				<div class="page-header">
					<div class="page-header-content">
						<div class="page-title">
							<h4>
								<i class="icon-arrow-left52 position-left"></i> <span
									class="text-semibold">카테고리</span> - 카테고리 수정
							</h4>
						</div>
					</div>
					<div class="breadcrumb-line">
						<ul class="breadcrumb">
							<li><a href="index.html"><i
									class="icon-home2 position-left"></i> Home</a></li>
							<li><a href="form_inputs_basic.html">카테고리</a></li>
							<li class="active">카테고리 수정</li>
						</ul>

					</div>
				</div>
				<!-- /page header -->

				<!-- Content area -->
				<div class="content">
					<form class="form-horizontal" action="${setUrl}" method="post"
						id="postFrm">

						<!-- /highlighted tabs -->
						<div class="panel panel-flat">
							<div class="panel-heading">
								<h5 class="panel-title">카테고리 info inputs</h5>
								<div class="heading-elements">
									<ul class="icons-list">
										<li><a data-action="collapse"></a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">

								<fieldset class="content-group">
									<!-- <legend class="text-bold">기본정보 inputs</legend> -->

									<div class="form-group">
										<label class="control-label col-lg-2">카테고리 이름</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength"
												placeholder="프로모션 이름을 입력해 주세요" maxlength="30" id="mastername"
												name="mastername" value="${boardMasterRes.mastername}" />
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
			var menu = $("#mastername").val();
			var position = $("#position").val();
			var name_ko = $("#name_ko").val();
			var name_en = $("#name_en").val();
			var name_jp = $("#name_jp").val();
			var name_cn = $("#name_cn").val();
			var name_tw = $("#name_tw").val();

			if (!Boolean(menu)) {
				alert("카테고리 이름을 입력해 주세요.");
				$("#mastername").focus();
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