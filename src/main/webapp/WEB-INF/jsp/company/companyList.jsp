<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>

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
			<!-- Main content -->
			<div class="content-wrapper">
				<!-- Page header -->
				<div class="page-header">
					<div class="page-header-content">
						<div class="page-title">
							<h4>
								<i class="icon-arrow-left52 position-left"></i> <span
									class="text-semibold">Company</span> - 기업 리스트
							</h4>
						</div>
					</div>

					<div class="breadcrumb-line">
						<ul class="breadcrumb">
							<li><a href="index.html"><i
									class="icon-home2 position-left"></i> Home</a></li>
							<li><a href="datatable_basic.html">Company</a></li>
							<li class="active">Company List</li>
						</ul>
					</div>
				</div>
				<!-- /page header -->

				<!-- Content area -->
				<div class="content">
					<div class="panel panel-flat">

						<div class="panel-body">

							<form class="form-horizontal" action="#">

								<div class="">
									<div class="col-lg-6">
										<div class="input-group">
											<div class="input-group-btn">
												<!-- <button type="button"
													class="btn btn-default dropdown-toggle"
													data-toggle="dropdown">
													Action <span class="caret"></span>
												</button>
												<ul class="dropdown-menu">
													<li><a href="#">Action</a></li>
													<li><a href="#">Another action</a></li>
													<li><a href="#">Something else here</a></li>
													<li><a href="#">One more line</a></li>
												</ul> -->
												<select name="searchKey" id="searchKey"
													class="btn btn-default dropdown-toggle"
													style="height: 36px;">
													<option value=""
														<c:if test="${company.searchKey == '' }">selected="selected"</c:if>>전체</option>
													<option value="001"
														<c:if test="${company.searchKey == '001' }">selected="selected"</c:if>>타이틀</option>
												</select>
											</div>
											<input type="text" class="form-control"
												placeholder="Type to filter..." name="searchVal"
												id="searchVal" value="${company.searchVal }"> <span
												class="input-group-btn">
												<button class="btn btn-default" type="button" id="goSearch">검색</button>
											</span>
										</div>
									</div>
								</div>



							</form>
						</div>
					</div>
					<div class="panel panel-flat">

						<div class="panel-heading">
							<h5 class="panel-title">Company Info</h5>
							<div class="heading-elements">
								<ul class="icons-list">
									<li><a data-action="collapse"></a></li>
								</ul>
							</div>
						</div>
						<div id="DataTables_Table_4_wrapper"
							class="dataTables_wrapper no-footer">
							<div class="datatable-scroll">
								<table
									class="table datatable-basic table-bordered table-striped table-hover">
									<thead>
										<tr>
											<th class="text-center" width="10%">순번</th>
											<th class="text-center" width="30%">타이틀</th>
											<th class="text-center" width="10%">기업명</th>
											<th class="text-center" width="10%">담당자</th>
											<th class="text-center" width="10%">담당자연락처</th>
											<th class="text-center" width="10%">순서</th>
											<th class="text-center" width="10%">작성일</th>
											<th class="text-center" width="10%">상태</th>
										</tr>
									</thead>
									<tbody>
										<c:choose>
											<c:when test="${not empty companyList}">
												<c:forEach items="${companyList}" var="rData"
													varStatus="rStatus">
													<tr>
														<td class="text-center">${(company.totalCnt - (company.pageSize * (company.pageIndex-1))) - (rStatus.index) }</td>
														<td><c:choose>
																<c:when test="${not empty company.searchKey }">
																	<a
																		href="/company/${company.pageIndex}/${rData.id}/${company.searchKey}/${company.searchVal}">${rData.companyLocales[0].company_name }</a>
																</c:when>
																<c:otherwise>
																	<a href="/company/${company.pageIndex}/${rData.id}">${rData.companyLocales[0].company_name }</a>
																</c:otherwise>
															</c:choose></td>
														<td class="text-center">${rData.userInfo.company_name}</td>
														<td class="text-center">${rData.userInfo.name}</td>
														<td class="text-center">${rData.userInfo.phone}</td>
														<td class="text-center">${rData.position}</td>
														<td><joda:format value="${rData.created_at}"
																pattern="yyyy년 MM월 dd일" /></td>
														<td><c:choose>
																<c:when test="${'Y' eq rData.use_at }">
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
									<a href="/company/excelList.xls"><button type="button"
											class="btn btn-default">
											기업엑셀다운로드 <i class="icon-arrow-right14 position-right"></i>
										</button></a> <a href="/company/put"><button type="button"
											class="btn btn-primary">
											기업등록 <i class="icon-arrow-right14 position-right"></i>
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
				total : '${company.totalPageUnit}',
				page : '${company.pageIndex}',
				maxVisible : 10,
				href : "/company/list/{{number}}",
				leaps : true,
				next : '→',
				prev : '←'
			}).on('page', function(event, num) {
				movePage(num);
			});

			$("body").on("keyup", ".searchInput", function(e) {
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
			var url = "/company/list/" + page;
			var searchKey = $("#searchKey").val();
			var searchVal = $("#searchVal").val();
			if (Boolean(searchKey)) {
				if (!Boolean(searchVal)) {
					alert("검색어를 입력해 주세요");
					return false;
				}
				url = "/company/list/" + page + "/" + searchKey + "/"
						+ searchVal;
			}
			location.href = url;
			return false;
		};
	</script>


</body>
</html>
