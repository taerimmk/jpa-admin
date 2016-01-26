
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
<title>Limitless - Responsive Web Application Kit by Eugene
	Kopyov</title>

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
<script type="text/javascript"
	src="/assets/js/plugins/forms/styling/uniform.min.js"></script>

<script type="text/javascript" src="/assets/js/core/app.js"></script>
<script type="text/javascript" src="/assets/js/pages/login.js"></script>
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

					<!-- Registration form -->
					<form action="/register/registerUser" method="post" id="postFrm">
						<div class="row">
							<div class="col-lg-6 col-lg-offset-3">
								<div class="panel registration-form">
									<div class="panel-body">
										<div class="text-center">
											<div class="icon-object border-success text-success">
												<i class="icon-plus3"></i>
											</div>
											<h5 class="content-group-lg">
												Create account <small class="display-block">All
													fields are required</small>
											</h5>
										</div>

										<div class="form-group has-feedback">
											<input type="text" class="form-control"
												placeholder="기업명을 입력해 주세요" id="company_name"
												name="company_name">
											<div class="form-control-feedback">
												<i class="icon-user-plus text-muted"></i>
											</div>
										</div>

										<div class="row">
											<div class="col-md-6">
												<div class="form-group has-feedback">
													<input type="text" class="form-control"
														placeholder="아이디를 입력해 주세요" id="user_id" name="user_id">
													<div class="form-control-feedback">
														<i class="icon-user-check text-muted"></i>
													</div>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group has-feedback">
													<input type="text" class="form-control"
														placeholder="담당자명을 입력해 주세요" id="name" name="name">
													<div class="form-control-feedback">
														<i class="icon-user-check text-muted"></i>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<div class="form-group has-feedback">
													<input type="text" class="form-control"
														placeholder="부서를 입력해 주세요" id="part" name="part">
													<div class="form-control-feedback">
														<i class="icon-user-check text-muted"></i>
													</div>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group has-feedback">
													<input type="text" class="form-control"
														placeholder="직책을 입력해 주세요" id="degree" name="degree">
													<div class="form-control-feedback">
														<i class="icon-user-check text-muted"></i>
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-6">
												<div class="form-group has-feedback">
													<input type="password" class="form-control"
														placeholder="비밀번호를 입력해 주세요" id="password" name="password">
													<div class="form-control-feedback">
														<i class="icon-user-lock text-muted"></i>
													</div>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group has-feedback">
													<input type="password" class="form-control"
														placeholder="비밀번호를 다시한번 입력해 주세요" id="passwordct"
														name="passwordct">
													<div class="form-control-feedback">
														<i class="icon-user-lock text-muted"></i>
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-6">
												<div class="form-group has-feedback">
													<input type="email" class="form-control"
														placeholder="이메일을 입력해 주세요" id="email" name="email">
													<div class="form-control-feedback">
														<i class="icon-mention text-muted"></i>
													</div>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group has-feedback">
													<input type="text" class="form-control"
														placeholder="연락처를 입력해 주세요" id="phone" name="phone">
													<div class="form-control-feedback">
														<i class="icon-mention text-muted"></i>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12">
												<div class="form-group has-feedback">
													<input type="email" class="form-control"
														placeholder="휴대폰번호를 입력해 주세요" id="mobile" name="mobile">
													<div class="form-control-feedback">
														<i class="icon-mention text-muted"></i>
													</div>
												</div>
											</div>
											
										</div>
										

										<!-- <div class="form-group">
											<div class="checkbox">
												<label> <input type="checkbox" class="styled"
													checked="checked"> Send me <a href="#">test
														account settings</a>
												</label>
											</div>

											<div class="checkbox">
												<label> <input type="checkbox" class="styled"
													checked="checked"> Subscribe to monthly newsletter
												</label>
											</div>

											<div class="checkbox">
												<label> <input type="checkbox" class="styled">
													Accept <a href="#">terms of service</a>
												</label>
											</div>
										</div> -->

										<div class="text-right">
											<button type="button" id="goSave"
												class="btn bg-teal-400 btn-labeled btn-labeled-right ml-10">
												<b><i class="icon-plus3"></i></b> 가입신청
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form>
					<!-- /registration form -->


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
			var regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
			var regPass = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,20}$/;

			var user_id = $("#user_id").val();
			var name = $("#name").val();
			var company_name = $("#company_name").val();
			var email = $("#email").val();
			var phone = $("#phone").val();
			var password = $("#password").val();
			var passwordct = $("#passwordct").val();

			if (!Boolean(user_id)) {
				alert("아이디를 입력해 주세요.");
				$("#user_id").focus();
				return false;
			}
			if (!Boolean(name)) {
				alert("담당자명을 입력해 주세요.");
				$("#name").focus();
				return false;
			}
			if (!Boolean(company_name)) {
				alert("기업명을 입력해 주세요.");
				$("#company_name").focus();
				return false;
			}
			if (!Boolean(email)) {
				alert("이메일을 입력해 주세요.");
				$("#email").focus();
				return false;
			}
			if (!regEmail.test(email)) {
				alert("올바른 이메일 형식이 아닙니다.");
				return false;
			}
			if (!Boolean(phone)) {
				alert("전화번호를 입력해 주세요.");
				$("#phone").focus();
				return false;
			}
			if (!Boolean(password)) {
				alert("비밀번호를 입력해 주세요.");
				$("#password").focus();
				return false;
			}
			if (!Boolean(passwordct)) {
				alert("비밀번호 확인을 입력해 주세요.");
				$("#passwordct").focus();
				return false;
			}
			if (password != passwordct) {
				alert("비밀번호를 확인해 주세요.");
				$("#password").focus();
				return false;
			}
			if (!regPass.test(password)) {
				alert("비밀번호는 6~20자리의 영문,숫자 및 특수문자가 포함되어있어여 합니다..");
				return false;
			}
			return true;
		}
	</script>
	<c:if test="${'98' eq result}">
		<script type="text/javascript">
			$(function() {
				alert("이미존재하는 아이디 입니다.");
			});
		</script>
	</c:if>
</body>
</html>