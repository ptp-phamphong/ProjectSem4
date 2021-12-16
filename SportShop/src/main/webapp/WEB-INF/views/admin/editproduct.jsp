<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<p>
	<a href='<c:url value = "/admin/product/type/0"></c:url>'>Products</a>
	/ <a
		href='<c:url value = "/admin/product/type/${Product.getProductType().getId() }"></c:url>'>${Product.getProductType().getName() }</a>
	/ <a
		href='<c:url value = "/admin/product/sport/${Product.getSportType().getId() }"></c:url>'>${Product.getSportType().getName() }</a>
	/ ${Product.getName() }
</p>
<hr>
<div class="container-fluid">
	<div class="card">
		<div class="card-body">
			<h1>
				<strong>Detail</strong>
			</h1>
			<h8>${Product.getName() }</h8>
			<hr>
			<div class="row">
				<form >
					
				</form>
			</div>
		</div>
	</div>
</div>