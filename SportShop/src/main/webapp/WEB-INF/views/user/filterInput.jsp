<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:choose>
	<c:when test="${filterList.size() > 0 }">
		<c:set var="div_display" value=" style ='display: block;'"></c:set>
	</c:when>
	<c:otherwise>
		<c:set var="div_display" value=" style ='display: none;'"></c:set>
	</c:otherwise>
</c:choose>

<div class="sidebar-block-top" ${div_display }>
	<h2>Shoping By</h2>
	<ul class="selected-filters">
		<c:forEach var="filterInputItem" items="${filterList }">
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
</div>