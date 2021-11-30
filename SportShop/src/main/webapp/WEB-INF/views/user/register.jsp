<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Page Content -->
			<main class="page-main">
				<div class="block">
					<div class="container">
						<ul class="breadcrumbs">
							<li><a href='<c:url value="/"></c:url>'><i class="icon icon-home"></i></a></li>
							<li>/<span>Faq</span></li>
						</ul>
					</div>
				</div>
				<div class="block">
					<div class="container">
						<div class="form-card">
							<h3>Personal Information</h3>
							
							
							<form class="account-create" action="#">
								<label>E-mail<span class="required">*</span></label>
								<input type="email" class="form-control input-lg" required>
								<label>Password<span class="required">*</span></label>
								<input type="password" class="form-control input-lg" required>
								<label>Full Name</label>
								<input type="text" class="form-control input-lg">
								<label>Phone</label>
								<input type="text" class="form-control input-lg">
								<label>Address</label>
								<input type="text" class="form-control input-lg">
								<div>
									<button type="submit" class="btn btn-lg">Create</button><span class="required-text">* Required Fields</span></div>
								<div class="back">or <a href="#">Return to Store <i class="icon icon-undo"></i></a></div>
							</form>
							
							
							
						</div>
					</div>
				</div>
			</main>
			<!-- /Page Content -->
