<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<h2>Shoping By</h2>
<ul class="selected-filters">
	<c:forEach var="filterInputItem" items="filterList">
		<li>
			<a href="#">
				<span>${filterInputItem }</span>
				<span class="remove">
					<i class="icon icon-close"></i>
				</span>
			</a>
			<div class="bg-striped"></div>
		</li>
	</c:forEach>
</ul>