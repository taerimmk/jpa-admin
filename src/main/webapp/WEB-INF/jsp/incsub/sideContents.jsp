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
						src="/assets/images/placeholder.jpg" class="img-circle img-sm"
						alt=""></a>
					<div class="media-body">
						<span class="media-heading text-semibold">Victoria Baker</span>
						<div class="text-size-mini text-muted">
							<i class="icon-pin text-size-small"></i> &nbsp;Santa Ana, CA
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
					<li <c:if test="${'2' eq sideMenu}" >class="active"</c:if>><a
						href="#"><i class="icon-stack2"></i> <span>참여기업관리</span></a>
						<ul>
							<li
								<c:if test="${'2' eq sideMenu && '1' eq sideMenuSub}" >class="active"</c:if>><a
								href="/sub/company/list/1">기업관리</a></li>

						</ul></li>

				</ul>
			</div>
		</div>
		<!-- /main navigation -->
	</div>
</div>
<!-- /main sidebar -->

