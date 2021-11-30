<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Page Content -->
			<main class="page-main">
				<div class="block">
					<div class="container">
						<ul class="breadcrumbs">
							<li><a href='<c:url value="/"></c:url>'><i class="icon icon-home"></i></a></li>
							<li>/<span>Logination</span></li>
						</ul>
					</div>
				</div>
				<div class="block">
					<div class="container">
						<div class="row row-eq-height">
							<div class="col-sm-6">
								<div class="form-card">
									<h4>New Customers</h4>
									<p>By creating an account with our store, you will be able to move through the checkout process faster, store multiple shipping addresses, view and track your orders in your account and more.</p>
									<div><a href='<c:url value="/register"></c:url>' class="btn btn-lg"><i class="icon icon-user"></i><span>Create An Account</span></a></div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-card">
									<h4>Registered Customers</h4>
									<p>If you have an account with us, please log in.</p>
									
									<!-- form login  -->
									
									<form class="account-create" action="#">
										<label>E-mail<span class="required">*</span></label>
										<input type="email" class="form-control input-lg" required>
										<label>Password<span class="required">*</span></label>
										<input type="password" class="form-control input-lg" required>
										<div>
											<button class="btn btn-lg">Login</button><span class="required-text">* Required Fields</span></div>
										<div class="back"><a href="#">Forgot Your Password?</a></div>
									</form>
									
									
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
			<!-- /Page Content -->
