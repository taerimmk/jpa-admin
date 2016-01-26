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
		<c:when test="${not empty user.searchVal }">
			<c:set
				value="/user/set/${user.pageIndex}/${user.id}/${user.searchKey}/${user.searchVal}"
				var="setUrl" />
			<c:set
				value="/user/list/${user.pageIndex}/${user.searchKey}/${user.searchVal}"
				var="listUrl" />
		</c:when>
		<c:otherwise>
			<c:set value="/user/set/${user.pageIndex}/${user.id}" var="setUrl" />
			<c:set value="/user/list/${user.pageIndex}" var="listUrl" />
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
									class="text-semibold">UserInfo</span> - 기업 관리자 수정
							</h4>
						</div>
					</div>
					<div class="breadcrumb-line">
						<ul class="breadcrumb">
							<li><a href="index.html"><i
									class="icon-home2 position-left"></i> Home</a></li>
							<li><a href="form_inputs_basic.html">UserInfo</a></li>
							<li class="active">UserInfo inputs</li>
						</ul>

					</div>
				</div>
				<!-- /page header -->

				<!-- Content area -->
				<div class="content">
					<!-- Form horizontal -->
					<div class="panel panel-flat">
						<div class="panel-heading">
							<h5 class="panel-title">UserInfo info inputs</h5>
							<div class="heading-elements">
								<ul class="icons-list">
									<li><a data-action="collapse"></a></li>
								</ul>
							</div>
						</div>
						<div class="panel-body">

							<form class="form-horizontal" role="form" id="postFrm"
								action="${setUrl}" method="post">

								<fieldset class="content-group">
									<legend class="text-bold">Basic inputs</legend>
									<div class="form-group">
										<label class="control-label col-lg-2">기업명</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength"
												placeholder="기업명 입력해 주세요" maxlength="30" id="company_name"
												name="company_name" value="${userRes.company_name}" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">아이디</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength"
												placeholder="아이디를 입력해 주세요" maxlength="30" id="user_id"
												name="user_id" value="${userRes.user_id}" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">이름</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength"
												placeholder="이름을 입력해 주세요" maxlength="30" id="name"
												name="name" value="${userRes.name}" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">연락처</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength" id="phone"
												name="phone" value="${userRes.phone}" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">이메일</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength" id="email"
												name="email" value="${userRes.email}" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">휴대폰번호</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength" id="mobile"
												name="mobile" value="${userRes.mobile}" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">부서</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength" id="part"
												name="part" value="${userRes.part}" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">직책</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength" id="degree"
												name="degree" value="${userRes.degree}" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">승인여부</label>
										<div class="col-lg-10">
											<label class="radio-inline"> <input type="radio"
												class="styled" name="status" value="C"
												<c:if test="${'C' eq userRes.status}">checked="checked"</c:if> />
												승인
											</label> <label class="radio-inline"> <input type="radio"
												class="styled" name="status" value="A"
												<c:if test="${'A' eq userRes.status}">checked="checked"</c:if> />
												비승인
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
							</form>
						</div>
					</div>
					<!-- /form horizontal -->


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
				if (validation()) {
					$("#postFrm").submit();
				}
				return false;
			});
		});
		var validation = function() {

			return true;
		}
	</script>

</body>
</html>