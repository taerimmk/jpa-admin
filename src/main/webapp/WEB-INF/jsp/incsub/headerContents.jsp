<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="navbar navbar-inverse">
	<div class="navbar-header">
		<a class="navbar-brand" href="index.html"><img
			src="/assets/images/logo_light.png" alt=""></a>

		<ul class="nav navbar-nav visible-xs-block">
			<li><a data-toggle="collapse" data-target="#navbar-mobile"><i
					class="icon-tree5"></i></a></li>
			<li><a class="sidebar-mobile-main-toggle"><i
					class="icon-paragraph-justify3"></i></a></li>
		</ul>
	</div>

	<div class="navbar-collapse collapse" id="navbar-mobile">
		<ul class="nav navbar-nav">
			<li><a class="sidebar-control sidebar-main-toggle hidden-xs"><i
					class="icon-paragraph-justify3"></i></a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown dropdown-user"><a class="dropdown-toggle"
				data-toggle="dropdown"> <img
					src="/assets/images/placeholder.jpg" alt=""> <span>Victoria</span>
					<i class="caret"></i>
			</a>
				<ul class="dropdown-menu dropdown-menu-right">
					<li><a href="#"><i class="icon-cog5"></i> Account settings</a></li>
					<li><a href="<c:url value="/logout" />"><i
							class="icon-switch2"></i> Logout</a></li>
				</ul></li>
		</ul>
	</div>
</div>