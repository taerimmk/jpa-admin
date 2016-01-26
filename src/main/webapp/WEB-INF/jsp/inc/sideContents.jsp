<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="sidebar sidebar-main">
	<div class="sidebar-content">

		<!-- User menu -->
		<div class="sidebar-user">
			<div class="category-content">
				<div class="media">
					<a href="#" class="media-left"><img
						src="/assets/images/logo_main_top.png" class="img-circle img-sm"
						alt=""></a>
					<div class="media-body">
						<span class="media-heading text-semibold">Korea Grand Sale</span>
						<div class="text-size-mini text-muted">
							<i class="icon-pin text-size-small"></i> &nbsp;Korea
						</div>
					</div>

					<div class="media-right media-middle">
						<ul class="icons-list">
							<li><a href="#"><i class="icon-cog3"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- /user menu -->
		<!-- Main navigation -->
		<div class="sidebar-category sidebar-category-visible">
			<div class="category-content no-padding">
				<ul class="navigation navigation-main navigation-accordion">

					<!-- Main -->
					<li class="navigation-header"><span>Main</span> <i
						class="icon-menu" title="Main pages"></i></li>
					<li <c:if test="${'0' eq sideMenu}" >class="active"</c:if>><a
						href="/"><i class="icon-home4"></i> <span>Dashboard</span></a></li>
					<li <c:if test="${'1' eq sideMenu}" >class="active"</c:if>><a
						href="#"><i class="icon-width"></i> <span>메인관리</span></a>
						<ul>
							<li
								<c:if test="${'1' eq sideMenu && '1' eq sideMenuSub}" >class="active"</c:if>><a
								href="/main/config">메인화면관리(시즌오프)</a></li>
							<li
								<c:if test="${'1' eq sideMenu && '2' eq sideMenuSub}" >class="active"</c:if>><a
								href="/menu/list/1">메뉴관리</a></li>
							<%-- <li
								<c:if test="${'1' eq sideMenu && '2' eq sideMenuSub}" >class="active"</c:if>><a
								href="/main/banner">메인배너관리</a></li> --%>

						</ul></li>
					<li <c:if test="${'5' eq sideMenu}" >class="active"</c:if>><a
						href="#"><i class="icon-film"></i> <span>배너관리</span></a>
						<ul>
							<li
								<c:if test="${'5' eq sideMenu && '1' eq sideMenuSub}" >class="active"</c:if>><a
								href="/mainBanner/list/1">메인배너관리</a></li>
							<li
								<c:if test="${'5' eq sideMenu && '2' eq sideMenuSub}" >class="active"</c:if>><a
								href="/sideBanner/list/1">사이드배너관리</a></li>
							<li
								<c:if test="${'5' eq sideMenu && '3' eq sideMenuSub}" >class="active"</c:if>><a
								href="/hotCouponsBanner/list/1">인기쿠폰배너관리</a></li>
							<li
								<c:if test="${'5' eq sideMenu && '4' eq sideMenuSub}" >class="active"</c:if>><a
								href="/upcomingEventsBanner/list/1">이벤트정보배너관리</a></li>
							<li
								<c:if test="${'5' eq sideMenu && '5' eq sideMenuSub}" >class="active"</c:if>><a
								href="/footerBanner/list/1">하단배너관리</a></li>
						</ul></li>
					<li <c:if test="${'2' eq sideMenu}" >class="active"</c:if>><a
						href="#"><i class="icon-stack2"></i> <span>참여기업관리</span></a>
						<ul>
							<li
								<c:if test="${'2' eq sideMenu && '1' eq sideMenuSub}" >class="active"</c:if>><a
								href="/company/list/1">기업관리</a></li>
							<li
								<c:if test="${'2' eq sideMenu && '2' eq sideMenuSub}" >class="active"</c:if>><a
								href="/company/list/1?use_at=N">미승인업체관리</a></li>
							<li
								<c:if test="${'2' eq sideMenu && '3' eq sideMenuSub}" >class="active"</c:if>><a
								href="/theme/list/1">테마관리</a></li>
						</ul></li>
					<li <c:if test="${'3' eq sideMenu}" >class="active"</c:if>><a
						href="#"><i class="icon-pencil7"></i> <span>게시판관리</span></a>
						<ul>
							<li
								<c:if test="${'3' eq sideMenu && '1' eq sideMenuSub}" >class="active"</c:if>><a
								href="/promotion/list/1">프로모션관리</a></li>
							<li
								<c:if test="${'3' eq sideMenu && '2' eq sideMenuSub}" >class="active"</c:if>><a
								href="/event/list/1">이벤트관리</a></li>
							<li
								<c:if test="${'3' eq sideMenu && '3' eq sideMenuSub}" >class="active"</c:if>><a
								href="/boardMaster/list/1">카테고리관리</a></li>
							<li
								<c:if test="${'3' eq sideMenu && '4' eq sideMenuSub}" >class="active"</c:if>><a
								href="/board/0/list/1">컨텐츠관리</a></li>
							<li
								<c:if test="${'3' eq sideMenu && '5' eq sideMenuSub}" >class="active"</c:if>><a
								href="#" class="has-ul">홍보마당</a>
								<ul class="hidden-ul">
									<li
										<c:if test="${'3' eq sideMenu && '5' eq sideMenuSub }" >class="active"</c:if>><a
										href="#" class="has-ul">새소식</a>
										<ul class="hidden-ul">
											<li
												<c:if test="${'3' eq sideMenu && '5' eq sideMenuSub}" >class="active"</c:if>><a
												href="/board/6/list/1">공지</a></li>
											<li
												<c:if test="${'3' eq sideMenu && '5' eq sideMenuSub}" >class="active"</c:if>><a
												href="/board/7/list/1">보도자료</a></li>
										</ul></li>
									<li
										<c:if test="${'3' eq sideMenu && '5' eq sideMenuSub}" >class="active"</c:if>><a
										href="/board/8/list/1">홍보자료</a></li>
									<li
										<c:if test="${'3' eq sideMenu && '5' eq sideMenuSub}" >class="active"</c:if>><a
										href="/board/9/list/1">포토갤러리</a></li>
									<li
										<c:if test="${'3' eq sideMenu && '5' eq sideMenuSub}" >class="active"</c:if>><a
										href="/board/10/list/1">쇼핑칼럼</a></li>
								</ul></li>

						</ul></li>
					<!-- <li><a href="#"><i class="icon-stack2"></i> <span>참여기업테마관리</span></a>
						<ul>
							<li><a href="/themes/1">테마리스트</a></li>
							<li><a href="/theme/put">테마등록</a></li>
						</ul></li> -->
					<li <c:if test="${'4' eq sideMenu}" >class="active"</c:if>><a
						href="#"><i class="icon-users2"></i> <span>기업관리자관리</span></a>
						<ul>
							<li
								<c:if test="${'4' eq sideMenu && '1' eq sideMenuSub}" >class="active"</c:if>><a
								href="/user/list/1">관리자관리</a></li>
							<li
								<c:if test="${'4' eq sideMenu && '2' eq sideMenuSub}" >class="active"</c:if>><a
								href="/user/list/1?status=A">미승인관리자관리</a></li>

						</ul></li>
				</ul>
			</div>
		</div>
		<!-- /main navigation -->
	</div>
</div>
<!-- /main sidebar -->

