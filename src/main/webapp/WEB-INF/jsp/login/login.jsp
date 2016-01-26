
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>KGS Admin</title>

<!-- Global stylesheets -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900"
	rel="stylesheet" type="text/css">
<link href="/assets/css/icons/icomoon/styles.css" rel="stylesheet"
	type="text/css">
<link href="/assets/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="/assets/css/core.min.css" rel="stylesheet" type="text/css">
<link href="/assets/css/components.min.css" rel="stylesheet"
	type="text/css">
<link href="/assets/css/colors.min.css" rel="stylesheet" type="text/css">
<!-- /global stylesheets -->

<!-- Core JS files -->
<script type="text/javascript"
	src="/assets/js/plugins/loaders/pace.min.js"></script>
<script type="text/javascript"
	src="/assets/js/core/libraries/jquery.min.js"></script>
<script type="text/javascript"
	src="/assets/js/core/libraries/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/assets/js/plugins/loaders/blockui.min.js"></script>
<!-- /core JS files -->


<!-- Theme JS files -->
<script type="text/javascript" src="/assets/js/core/app.js"></script>
<!-- /theme JS files -->

</head>

<body>

	<!-- Main navbar -->
	<div class="navbar navbar-inverse">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.html"><img
				src="/assets/images/logo_light.png" alt=""></a>

			<ul class="nav navbar-nav pull-right visible-xs-block">
				<li><a data-toggle="collapse" data-target="#navbar-mobile"><i
						class="icon-tree5"></i></a></li>
			</ul>
		</div>

		<div class="navbar-collapse collapse" id="navbar-mobile">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"> <i class="icon-display4"></i> <span
						class="visible-xs-inline-block position-right"> Go to
							website</span>
				</a></li>

				<li><a href="#"> <i class="icon-user-tie"></i> <span
						class="visible-xs-inline-block position-right"> Contact
							admin</span>
				</a></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown"> <i class="icon-cog3"></i> <span
						class="visible-xs-inline-block position-right"> Options</span>
				</a></li>
			</ul>
		</div>
	</div>
	<!-- /main navbar -->


	<!-- Page container -->
	<div class="page-container login-container">

		<!-- Page content -->
		<div class="page-content">

			<!-- Main content -->
			<div class="content-wrapper">

				<!-- Content area -->
				<div class="content">

					<!-- Simple login form -->
					<form action="/login" id="signin-form_id" method="POST">
						<div class="panel panel-body login-form">
							<div class="text-center">
								<div class="icon-object border-slate-300 text-slate-300">
									<i class="icon-reading"></i>
								</div>
								<h5 class="content-group">
									Login to your account <small class="display-block">Enter
										your credentials below</small>
								</h5>
							</div>

							<div class="form-group has-feedback has-feedback-left">
								<input type="text" class="form-control" placeholder="Username"
									name="ssoId">
								<div class="form-control-feedback">
									<i class="icon-user text-muted"></i>
								</div>
							</div>

							<div class="form-group has-feedback has-feedback-left">
								<input type="password" class="form-control"
									placeholder="Password" name="password">
								<div class="form-control-feedback">
									<i class="icon-lock2 text-muted"></i>
								</div>
							</div>

							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-block">
									Sign in <i class="icon-circle-right2 position-right"></i>
								</button>
							</div>

							<div class="text-center">
								<a href="/register/registerUser">기업등록</a>
							</div>
							<p>*본 페이지는 크롬에 최적화되어 있습니다.</p>
						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						
					</form>
					<!-- /simple login form -->


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

</body>
</html>