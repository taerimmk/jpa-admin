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
		<c:when test="${not empty theme.searchVal }">
			<c:set
				value="/theme/list/${theme.pageIndex}/${theme.searchKey}/${theme.searchVal}"
				var="listUrl" />
		</c:when>
		<c:otherwise>
			<c:set value="/theme/list/${theme.pageIndex}" var="listUrl" />
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
									class="text-semibold">Theme</span> - 기업 테마 입력
							</h4>
						</div>
					</div>
					<div class="breadcrumb-line">
						<ul class="breadcrumb">
							<li><a href="index.html"><i
									class="icon-home2 position-left"></i> Home</a></li>
							<li><a href="form_inputs_basic.html">Theme</a></li>
							<li class="active">Theme inputs</li>
						</ul>

					</div>
				</div>
				<!-- /page header -->

				<!-- Content area -->
				<div class="content">
					<!-- Form horizontal -->
					<div class="panel panel-flat">
						<div class="panel-heading">
							<h5 class="panel-title">Theme info inputs</h5>
							<div class="heading-elements">
								<ul class="icons-list">
									<li><a data-action="collapse"></a></li>
								</ul>
							</div>
						</div>
						<div class="panel-body">
							<form class="form-horizontal" action="/theme/put" method="post"
								id="postFrm">
								<fieldset class="content-group">
									<legend class="text-bold">Basic inputs</legend>

									<div class="form-group">
										<label class="control-label col-lg-2">제목</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength"
												placeholder="테마제목을 입력해 주세요" maxlength="30" id="title"
												name="title" />
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
										<label class="control-label col-lg-2">이름(ko)</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength"
												placeholder="이름(국문) 입력해 주세요" maxlength="100" id="name_ko"
												name="themeLocales[0].name" /> <input type="hidden"
												name="themeLocales[0].locale" value="ko" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">이름(en)</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength"
												placeholder="이름(영문) 입력해 주세요" maxlength="100" id="name_en"
												name="themeLocales[1].name" /> <input type="hidden"
												name="themeLocales[1].locale" value="en" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">이름(jp)</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength"
												placeholder="이름(일문) 입력해 주세요" maxlength="100" id="name_jp"
												name="themeLocales[2].name" /> <input type="hidden"
												name="themeLocales[2].locale" value="jp" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">이름(zh_cn)</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength"
												placeholder="이름(중문간체) 입력해 주세요" maxlength="100" id="name_cn"
												name="themeLocales[3].name" /> <input type="hidden"
												name="themeLocales[3].locale" value="cn" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">이름(zh_tw)</label>
										<div class="col-lg-10">
											<input type="text" class="form-control maxlength"
												placeholder="이름(중문번체) 입력해 주세요" maxlength="100" id="name_tw"
												name="themeLocales[4].name" /> <input type="hidden"
												name="themeLocales[4].locale" value="tw" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2">상위테마선택</label>
										<div class="col-lg-10">
											<select class="form-control" id="parent_id" name="parent_id">
												<option value="0">최상위</option>
												<c:forEach items="${themeList}" var="sData">
													<option value="${sData.id}">${sData.title}</option>
												</c:forEach>
											</select>
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
			var title = $("#title").val();
			var position = $("#position").val();
			var name_ko = $("#name_ko").val();
			var name_en = $("#name_en").val();
			var name_jp = $("#name_jp").val();
			var name_cn = $("#name_cn").val();
			var name_tw = $("#name_tw").val();

			if (!Boolean(title)) {
				alert("제목을 입력해 주세요.");
				$("#title").focus();
				return false;
			}
			if (!Boolean(position)) {
				alert("노출순서를 입력해 주세요.");
				$("#position").focus();
				return false;
			}
			if (!Boolean(name_ko)) {
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
			}
			return true;
		}
	</script>

</body>
</html>