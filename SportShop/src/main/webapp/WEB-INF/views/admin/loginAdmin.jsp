<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<!-- Outer Row -->
<div class="row justify-content-center">

	<div class="col-xl-10 col-lg-12 col-md-9">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-6 d-none d-lg-block"><img src='<c:url value="/assets/themes/img/avatar.jpg"></c:url>' width="100%" height="100%" /></div>
					<div class="col-lg-6">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
							</div>
							<form method="post" class="user" action="loginAdminController">
								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										id="exampleInputEmail" name="username" required="required"
										placeholder="Username...">
								</div>
								<div class="form-group">
									<input type="password" class="form-control form-control-user"
										name="password" required="required" id="exampleInputPassword"
										placeholder="Password">
								</div>
								<hr>
								<button class="btn btn-primary btn-user btn-block" type="submit">Login</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

</div>
