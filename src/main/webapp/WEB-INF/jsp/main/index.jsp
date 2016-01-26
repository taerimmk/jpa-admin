<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>

<title>KoreaGrangSale Admin</title>


<!-- /theme JS files -->
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
			<!-- Main content -->
			<div class="content-wrapper">

				<!-- Page header -->
				<div class="page-header">
					<div class="page-header-content">
						<div class="page-title">
							<h4>
								<i class="icon-arrow-left52 position-left"></i> <span
									class="text-semibold">Home</span> - Dashboard
							</h4>
						</div>

						<div class="heading-elements">
							<div class="heading-btn-group">
								<a href="#" class="btn btn-link btn-float has-text"><i
									class="icon-bars-alt text-primary"></i><span>Statistics</span></a>
								<a href="#" class="btn btn-link btn-float has-text"><i
									class="icon-calculator text-primary"></i> <span>Invoices</span></a>
								<a href="#" class="btn btn-link btn-float has-text"><i
									class="icon-calendar5 text-primary"></i> <span>Schedule</span></a>
							</div>
						</div>
					</div>

					<div class="breadcrumb-line">
						<ul class="breadcrumb">
							<li><a href="index.html"><i
									class="icon-home2 position-left"></i> Home</a></li>
							<li class="active">Dashboard</li>
						</ul>

						<ul class="breadcrumb-elements">
							<li><a href="#"><i
									class="icon-comment-discussion position-left"></i> Support</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="icon-gear position-left"></i>
									Settings <span class="caret"></span>
							</a>

								<ul class="dropdown-menu dropdown-menu-right">
									<li><a href="#"><i class="icon-user-lock"></i> Account
											security</a></li>
									<li><a href="#"><i class="icon-statistics"></i>
											Analytics</a></li>
									<li><a href="#"><i class="icon-accessibility"></i>
											Accessibility</a></li>
									<li class="divider"></li>
									<li><a href="#"><i class="icon-gear"></i> All settings</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
				<!-- /page header -->


				<!-- Content area -->
				<div class="content">


					<div class="panel panel-flat">
						<div class="panel-heading">
							<h5 class="panel-title">Combination and connection</h5>
							<div class="heading-elements">
								<ul class="icons-list">
									<li><a data-action="collapse"></a></li>
									<li><a data-action="reload"></a></li>
									<li><a data-action="close"></a></li>
								</ul>
							</div>
						</div>

						<div class="panel-body">
							<div class="row">
								<div class="col-lg-6">
									<div class="chart-container">
										<div class="chart has-fixed-height" id="connect_pie"></div>
									</div>
								</div>

								<div class="col-lg-6">
									<div class="chart-container">
										<div class="chart has-fixed-height" id="connect_column"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /combination and connection -->


					<!-- Line and bar combination -->
					<div class="panel panel-flat" style="display: none;">
						<div class="panel-heading">
							<h5 class="panel-title">Line and bar combination</h5>
							<div class="heading-elements">
								<ul class="icons-list">
									<li><a data-action="collapse"></a></li>
									<li><a data-action="reload"></a></li>
									<li><a data-action="close"></a></li>
								</ul>
							</div>
						</div>

						<div class="panel-body">
							<div class="chart-container">
								<div class="chart has-fixed-height" id="line_bar"></div>
							</div>
						</div>
					</div>
					<!-- /line and bar combination -->


					<!-- Column and pie combination -->
					<div class="panel panel-flat" style="display: none;">
						<div class="panel-heading">
							<h5 class="panel-title">Column and pie combination</h5>
							<div class="heading-elements">
								<ul class="icons-list">
									<li><a data-action="collapse"></a></li>
									<li><a data-action="reload"></a></li>
									<li><a data-action="close"></a></li>
								</ul>
							</div>
						</div>

						<div class="panel-body">
							<div class="chart-container">
								<div class="chart has-fixed-height" id="column_pie"></div>
							</div>
						</div>
					</div>
					<!-- /column and pie combination -->


					<!-- Scatter and pie combination -->
					<div class="panel panel-flat" style="display: none;">
						<div class="panel-heading">
							<h5 class="panel-title">Scatter and pie combination</h5>
							<div class="heading-elements">
								<ul class="icons-list">
									<li><a data-action="collapse"></a></li>
									<li><a data-action="reload"></a></li>
									<li><a data-action="close"></a></li>
								</ul>
							</div>
						</div>

						<div class="panel-body">
							<div class="chart-container">
								<div class="chart has-fixed-height" id="scatter_pie"></div>
							</div>
						</div>
					</div>
					<!-- /scatter and pie combination -->


					<!-- Scatter and line combination -->
					<div class="panel panel-flat" style="display: none;">
						<div class="panel-heading">
							<h5 class="panel-title">Scatter and line combination</h5>
							<div class="heading-elements">
								<ul class="icons-list">
									<li><a data-action="collapse"></a></li>
									<li><a data-action="reload"></a></li>
									<li><a data-action="close"></a></li>
								</ul>
							</div>
						</div>

						<div class="panel-body">
							<div class="chart-container">
								<div class="chart has-fixed-height" id="scatter_line"></div>
							</div>
						</div>
					</div>
					<!-- /scatter and line combination -->


					<!-- Dynamic data -->
					<div class="panel panel-flat" style="display: none;">
						<div class="panel-heading">
							<h5 class="panel-title">Dynamic data</h5>
							<div class="heading-elements">
								<ul class="icons-list">
									<li><a data-action="collapse"></a></li>
									<li><a data-action="reload"></a></li>
									<li><a data-action="close"></a></li>
								</ul>
							</div>
						</div>

						<div class="panel-body">
							<div class="chart-container">
								<div class="chart has-fixed-height" id="candlestick_scatter"
									style="height: 500px;"></div>
							</div>
						</div>
					</div>
					<!-- /dynamic data -->

					<!-- Footer -->
					<jsp:include page="../inc/footerContents.jsp" />

				</div>
				<!-- /content area -->

			</div>
			<!-- /main content -->

		</div>
		<!-- /page content -->

	</div>
	<!-- /page container -->
	<jsp:include page="../inc/footerResources.jsp" />
	<script type="text/javascript"
		src="/assets/js/plugins/visualization/echarts/echarts.js"></script>
	<script type="text/javascript"
		src="/assets/js/charts/echarts/combinations.js"></script>

	<!-- /footer -->

	<script type="text/javascript">
		$(function() {

		});
	</script>
</body>
</html>
