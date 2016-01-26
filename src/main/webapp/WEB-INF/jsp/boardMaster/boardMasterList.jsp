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
									class="text-semibold">BoardMaster</span> - 카테고리 리스트
							</h4>
						</div>
					</div>

					<div class="breadcrumb-line">
						<ul class="breadcrumb">
							<li><a href="index.html"><i
									class="icon-home2 position-left"></i> Home</a></li>
							<li><a href="datatable_basic.html">BoardMaster</a></li>
							<li class="active">BoardMaster List</li>
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
														<c:if test="${boardMaster.searchKey == '' }">selected="selected"</c:if>>전체</option>
													<option value="001"
														<c:if test="${boardMaster.searchKey == '001' }">selected="selected"</c:if>>카테고리</option>
												</select>
											</div>
											<input type="text" class="form-control"
												placeholder="Type to filter..." name="searchVal"
												id="searchVal" value="${boardMaster.searchVal }"> <span
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
							<h5 class="panel-title">BoardMasters Info</h5>
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
											<th class="text-center" width="20%">순번</th>
											<th class="text-center" width="80%">카테고리</th>
										</tr>
									</thead>
									<tbody>
										<c:choose>
											<c:when test="${not empty boardMasters}">
												<c:forEach items="${boardMasters}" var="rData"
													varStatus="rStatus">
													<tr class="odd">
														<td class="text-center">${(boardMaster.totalCnt - (boardMaster.pageSize * (boardMaster.pageIndex-1))) - (rStatus.index) }</td>
														<td><c:choose>
																<c:when test="${not empty boardMaster.searchVal }">
																	<a
																		href="/boardMaster/${boardMaster.pageIndex}/${rData.id}/${boardMaster.searchKey}/${boardMaster.searchVal}">${rData.mastername }</a>
																</c:when>
																<c:otherwise>
																	<a href="/boardMaster/${boardMaster.pageIndex}/${rData.id}">${rData.mastername }</a>
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
									<a href="/boardMaster/put"><button type="button"
											class="btn btn-primary">
											카테고리 등록 <i class="icon-arrow-right14 position-right"></i>
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
				total : '${boardMaster.totalPageUnit}',
				page : '${boardMaster.pageIndex}',
				maxVisible : 5,
				href : "/boardMaster/list/{{number}}",
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
			var url = "/boardMaster/list/" + page;
			var searchKey = $("#searchKey").val();
			var searchVal = $("#searchVal").val();
			if (Boolean(searchKey)) {
				if (!Boolean(searchVal)) {
					alert("검색어를 입력해 주세요");
					return false;
				}
				url = "/boardMaster/list/" + page + "/" + searchKey + "/"
						+ searchVal;
			}
			location.href = url;
			return false;
		};
	</script>


</body>
</html>
