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
									class="text-semibold">메인관리</span> - 메인화면관리
							</h4>
						</div>

					</div>

					<div class="breadcrumb-line">
						<ul class="breadcrumb">
							<li><a href="index.html"><i
									class="icon-home2 position-left"></i> Home</a></li>
							<li><a href="form_layout_vertical.html">메인관리</a></li>
							<li class="active">메인화면관리</li>
						</ul>

					</div>
				</div>
				<!-- /page header -->


				<!-- Content area -->
				<div class="content">


					<div class="row">
						<div class="col-md-6">

							<!-- Basic layout-->
							<form class="form-horizontal" action="/main/config" method="post"
								id="postFrm">
								<input type="hidden" value="${main.id}" name="id" />
								<div class="panel panel-flat">
									<div class="panel-heading">
										<h5 class="panel-title">시즌오프 관리</h5>
										<div class="heading-elements">
											<ul class="icons-list">
												<li><a data-action="collapse"></a></li>
											</ul>
										</div>
									</div>

									<div class="panel-body">

										<div class="form-group">
											<label class="col-lg-3 control-label">시즌오프: </label>
											<div class="col-lg-9">
												<label class="radio-inline"> <input type="radio"
													value="Y" class="styled" name="season_off"
													<c:if test="${'Y' eq main.season_off}">checked="checked"</c:if>>
													오프
												</label> <label class="radio-inline"> <input type="radio"
													value="N" class="styled" name="season_off"
													<c:if test="${'N' eq main.season_off}">checked="checked"</c:if>>
													온
												</label>
											</div>
										</div>

										<div class="form-group">
											<label>내용(ko) :</label> <input type="text"
												class="form-control" placeholder="contents_ko"
												id="contents_ko" name="contents_ko" value="${main.contents_ko}"> 
										</div>
										<div class="form-group">
											<label>내용(en) :</label> <input type="text"
												class="form-control" placeholder="contents_en"
												id="contents_en" name="contents_en" value="${main.contents_en}">
										</div>
										<div class="form-group">
											<label>내용(jp) :</label> <input type="text"
												class="form-control" placeholder="contents_jp"
												id="contents_jp" name="contents_jp" value="${main.contents_jp}">
										</div>
										<div class="form-group">
											<label>내용(cn) :</label> <input type="text"
												class="form-control" placeholder="contents_cn"
												id="contents_cn" name="contents_cn" value="${main.contents_cn}">
										</div>
										<div class="form-group">
											<label>내용(tw) :</label> <input type="text"
												class="form-control" placeholder="contents_tw"
												id="contents_tw" name="contents_tw" value="${main.contents_tw}">
										</div>
										<div class="text-right">
											<button type="submit" class="btn btn-primary">
												저장 <i class="icon-arrow-right14 position-right"></i>
											</button>
										</div>
									</div>
								</div>
							</form>
							<!-- /basic layout -->
						</div>


					</div>
					<!-- /vertical form options -->



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

		});
	</script>

</body>
</html>