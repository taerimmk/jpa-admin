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
									class="text-semibold">Menu</span> - 업체 메뉴 리스트
							</h4>
						</div>
					</div>

					<div class="breadcrumb-line">
						<ul class="breadcrumb">
							<li><a href="index.html"><i
									class="icon-home2 position-left"></i> Home</a></li>
							<li><a href="datatable_basic.html">Menu</a></li>
							<li class="active">Menu List</li>
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
														<c:if test="${menu.searchKey == '' }">selected="selected"</c:if>>전체</option>
													<option value="001"
														<c:if test="${menu.searchKey == '001' }">selected="selected"</c:if>>타이틀</option>
												</select>
											</div>
											<input type="text" class="form-control"
												placeholder="Type to filter..." name="searchVal"
												id="searchVal" value="${menu.searchVal }"> <span
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
							<h5 class="panel-title">Menus Info</h5>
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
											<th class="text-center" width="50%">타이틀</th>
											<th class="text-center" width="10%">순서</th>
											<th class="text-center" width="20%">작성일</th>
											<th class="text-center" width="10%">상태</th>
										</tr>
									</thead>
									<tbody>
										<c:choose>
											<c:when test="${not empty menuList}">
												<c:forEach items="${menuList}" var="rData"
													varStatus="rStatus">
													<tr class="odd">
														<td class="text-center">${(menu.totalCnt - (menu.pageSize * (menu.pageIndex-1))) - (rStatus.index) }</td>
														<td>
															<%-- <c:if test="${ '0' ne rData.parent_id}">
																<i class="icon-arrow-right16"></i>
															</c:if> --%> <c:choose>
																<c:when test="${not empty menu.searchVal }">
																	<a
																		href="/menu/${menu.pageIndex}/${rData.id}/${menu.searchKey}/${menu.searchVal}">${rData.menuLocales[0].name }</a>
																</c:when>
																<c:otherwise>
																	<a href="/menu/${menu.pageIndex}/${rData.id}">${rData.menuLocales[0].name }</a>
																</c:otherwise>
															</c:choose>
														</td>
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
													<c:if test="${not empty rData.menuSub}">
														<c:forEach items="${rData.menuSub}" var="sData"
															varStatus="rStatus">
															<tr class="">
																<td class="text-center">Sub</td>
																<td><i class="icon-arrow-right16"></i> <c:choose>
																		<c:when test="${not empty menu.searchKey }">
																			<a
																				href="/menu/${menu.pageIndex}/${sData.id}/${menu.searchKey}/${menu.searchVal}">${sData.menuLocales[0].name }</a>
																		</c:when>
																		<c:otherwise>
																			<a href="/menu/${menu.pageIndex}/${sData.id}">${sData.menuLocales[0].name }</a>
																		</c:otherwise>
																	</c:choose></td>
																<td class="text-center">${sData.position}</td>
																<td><joda:format value="${sData.created_at}"
																		pattern="yyyy년 MM월 dd일" /></td>
																<td><c:choose>
																		<c:when test="${'Y' eq sData.use_at }">
																			<span class="label label-success">ACTIVE</span>
																		</c:when>
																		<c:otherwise>
																			<span class="label label-danger">INACTIVE</span>
																		</c:otherwise>
																	</c:choose></td>
															</tr>
														</c:forEach>
													</c:if>
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
									<a href="/menu/put"><button type="button"
											class="btn btn-primary">
											메뉴등록 <i class="icon-arrow-right14 position-right"></i>
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
				total : '${menu.totalPageUnit}',
				page : '${menu.pageIndex}',
				maxVisible : 5,
				href : "/menu/list/{{number}}",
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
			var url = "/menu/list/" + page;
			var searchKey = $("#searchKey").val();
			var searchVal = $("#searchVal").val();
			if (Boolean(searchKey)) {
				if (!Boolean(searchVal)) {
					alert("검색어를 입력해 주세요");
					return false;
				}
				url = "/menu/list/" + page + "/" + searchKey + "/" + searchVal;
			}
			location.href = url;
			return false;
		};
	</script>


</body>
</html>
