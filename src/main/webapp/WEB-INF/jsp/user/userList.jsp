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
tr.odd {
	background-color: #fcfcfc;
}
</style>
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
									class="text-semibold">UserInfo</span> - 기업 관리자 리스트
							</h4>
						</div>
					</div>

					<div class="breadcrumb-line">
						<ul class="breadcrumb">
							<li><a href="index.html"><i
									class="icon-home2 position-left"></i> Home</a></li>
							<li><a href="datatable_basic.html">UserInfo</a></li>
							<li class="active">UserInfo List</li>
						</ul>
					</div>
				</div>
				<!-- /page header -->

				<!-- Content area -->
				<div class="content">

					<!-- Input group buttons -->
					<div class="panel panel-flat">

						<div class="panel-body">

							<form class="form-horizontal" action="#">

								<div class="">
									<div class="col-lg-6">
										<div class="input-group">
											<div class="input-group-btn">

												<select name="searchKey" id="searchKey"
													class="btn btn-default dropdown-toggle"
													style="height: 36px;">
													<option value=""
														<c:if test="${user.searchKey == '' }">selected="selected"</c:if>>전체</option>
													<option value="001"
														<c:if test="${user.searchKey == '001' }">selected="selected"</c:if>>이름</option>
												</select>
											</div>
											<input type="text" class="form-control"
												placeholder="Type to filter..." name="searchVal"
												id="searchVal" value="${user.searchVal }"> <span
												class="input-group-btn">
												<button class="btn btn-default" type="button" id="goSearch">검색</button>
											</span>
										</div>
									</div>
								</div>



							</form>
						</div>
					</div>
					<!-- /input group buttons -->

					<div class="panel panel-flat">

						<div class="panel-heading">
							<h5 class="panel-title">UserInfos Info</h5>
							<div class="heading-elements">
								<ul class="icons-list">
									<li><a data-action="collapse"></a></li>
								</ul>
							</div>
						</div>
						<div id="DataTables_Table_4_wrapper"
							class="dataTables_wrapper no-footer">

							<div class="datatable-scroll">
								<table class="table datatable-basic table-bordered table-hover">
									<thead>
										<tr>
											<th class="text-center" width="10%">순번</th>
											<th class="text-center" width="20%">아이디</th>
											<th class="text-center" width="30%">이름</th>
											<th class="text-center" width="10%">연락처</th>
											<th class="text-center" width="20%">이메일</th>
											<th class="text-center" width="10%">상태: ${user.totalCnt }</th>
										</tr>
									</thead>
									<tbody>
										<c:choose>
											<c:when test="${not empty users}">
												<c:forEach items="${users}" var="rData" varStatus="rStatus">
													<tr class="odd">
														<td class="text-center">${(user.totalCnt - (user.pageSize * (user.pageIndex-1))) - (rStatus.index) }</td>
														<td>${rData.user_id}</td>
														<td><c:choose>
																<c:when test="${not empty user.searchVal }">
																	<a
																		href="/user/${user.pageIndex}/${rData.id}/${user.searchKey}/${user.searchVal}">${rData.name }</a>
																</c:when>
																<c:otherwise>
																	<a href="/user/${user.pageIndex}/${rData.id}">${rData.name }</a>
																</c:otherwise>
															</c:choose></td>
														<td class="text-center">${rData.phone}</td>
														<td>${rData.email}</td>
														<td><c:choose>
																<c:when test="${'C' eq rData.status }">
																	<span class="label label-success">ACTIVE</span>
																</c:when>
																<c:otherwise>
																	<span class="label label-danger">INACTIVE</span>
																</c:otherwise>
															</c:choose></td>
													</tr>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<tr>
													<td colspan="5" class="text-center">데이터가 없습니다.</td>
												</tr>
											</c:otherwise>
										</c:choose>

									</tbody>
								</table>
							</div>
							<div class="datatable-footer">
								<div class="dataTables_info paginationClass" id="pagination">
								</div>
								<div class="dataTables_info paginationClass"
									style="float: right;">
									<a href="/user/excelList.xls"><button type="button"
											class="btn btn-default">
											관리자엑셀다운로드 <i class="icon-arrow-right14 position-right"></i>
										</button></a>
								</div>
							</div>
						</div>
					</div>

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

			$('#pagination').bootpag({
				total : '${user.totalPageUnit}',
				page : '${user.pageIndex}',
				maxVisible : 10,
				href : "/user/list/{{number}}",
				leaps : true,
				next : '→',
				prev : '←'
			}).on('page', function(event, num) {
				movePage(num);
			});
			$("body").on("keyup keydown", ".searchInput", function(e) {
				var keyPressed = event.keyCode || event.which;

				if (keyPressed == 13) {
					movePage(1);
					keyPressed = null;
				} else {
					return false;
				}
				return false;
			});
			$("body").on("click", "#goSearch", function(e) {
				movePage(1);
				return false;
			});

		});
		var movePage = function(page) {
			var url = "/user/list/" + page;
			var searchKey = $("#searchKey").val();
			var searchVal = $("#searchVal").val();
			if (Boolean(searchKey)) {
				if (!Boolean(searchVal)) {
					alert("검색어를 입력해 주세요");
					return false;
				}
				url = "/user/list/" + page + "/" + searchKey + "/" + searchVal;
			}
			location.href = url;
			return false;
		};
	</script>


</body>
</html>
