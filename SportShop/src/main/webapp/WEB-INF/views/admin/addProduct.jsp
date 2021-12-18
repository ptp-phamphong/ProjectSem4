<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<p>
	<a href='<c:url value = "/admin/product/type/0"></c:url>'>Products</a>
	/ Add new product
</p>
<hr>
<div class="container-fluid">
	<div class="card">
		<div class="card-body">
			<h1>
				<strong>Add new product</strong>
			</h1>
			<hr>
			<div class="row">
				<div class="col-12">
					<form action="addNewProduct" method="post">
						<label for="name"><strong>Product name:</strong></label> <input
							type="text" name="name" class="form-control"
							placeholder="Product name..." /> <br> <label
							for="productType"><strong>Product type:</strong></label> <select
							name="productType" class="form-control">
							<c:forEach items="${ProductTypeList}" var="item">
								<option value="${item.getId() }">${item.getName() }</option>
							</c:forEach>
						</select> <br> <label for="sportType"><strong>Sport
								type:</strong></label> <select name="sportType" class="form-control">
							<c:forEach items="${SportTypeList}" var="item">
								<option value="${item.getId() }">${item.getName() }</option>
							</c:forEach>
							<option value="0">Other</option>
						</select> <br> <label for="details"><strong>Detail:</strong></label>
						<textarea rows="5" type="text" name="details" class="form-control"
							placeholder="Detail..."></textarea>
						<br> <label for="discount"><strong>Discount:</strong></label>
						<input type="number" min="0" max="99" value="0" name="discount"
							class="form-control" placeholder="Discount..." /> <br> <label
							for="image1"><strong>Image 1:</strong></label> <input type="file"
							name="image1" id="image1" class="form-control" /> <label
							for="image2"><strong>Image 2:</strong></label> <input type="file"
							name="image2" id="image2" class="form-control" /> <label
							for="image3"><strong>Image 3:</strong></label> <input type="file"
							name="image3" id="image3" class="form-control" /> <br>
						
						<button type="submit" class="btn btn-primary">Add
							product</button>
					</form>
					<br>
				</div>
			</div>
		</div>
	</div>
	<br>
</div>