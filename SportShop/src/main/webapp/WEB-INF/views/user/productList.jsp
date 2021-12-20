<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<!-- Page Content -->
<main class="page-main">
	<div class="block">
		<div class="container">
			<ul class="breadcrumbs">
				<li>
					<a href='<c:url value="/"></c:url>'>
						<i class="icon icon-home"></i>
					</a>
				</li>
				<li>
					/ <span>All Products</span>
				</li>
			</ul>
		</div>
	</div>
	<div class="container">
		<!-- Two columns -->
		<div class="row row-table">
		
			<div id="filter_productList"  class="col-md-3 filter-col fixed aside">
				<%@include file="/WEB-INF/views/user/productList_Filter.jsp"%>
			</div>
			
			
			<!-- Center column -->
			<div class="col-md-9 aside">
				<!-- Filter Row -->
				<div class="filter-row">
					<div class="row">
						<div class="col-xs-8 col-sm-7 col-lg-5 col-left">
							<div class="filter-button">
								<a href="#" class="btn filter-col-toggle">
									<i class="icon icon-filter"></i>
									<span>FILTER</span>
								</a>
							</div>
							<div class="form-label">Sort by:</div>
							<div class="select-wrapper-sm">
								<select class="form-control input-sm">
									<option value="featured">Featured</option>
									<option value="rating">Rating</option>
									<option value="price">Price</option>
								</select>
							</div>
							<div class="directions">
								<a href="#">
									<i class="icon icon-arrow-down"></i>
								</a>
								<a href="#">
									<i class="icon icon-arrow-up"></i>
								</a>
							</div>
						</div>
						<div class="col-sm-2 col-lg-2 hidden-xs">
							<div class="view-mode">
								<a href="#" class="grid-view">
									<i class="icon icon-th"></i>
								</a>
								<a href="#" class="list-view">
									<i class="icon icon-th-list"></i>
								</a>
							</div>
						</div>
						<div class="col-xs-4 col-sm-3 col-lg-5 col-right">
							<div class="form-label">Show:</div>
							<div class="select-wrapper-sm">
								<select class="form-control input-sm">
									<option value="featured">12</option>
									<option value="rating">36</option>
									<option value="price">100</option>
								</select>
							</div>
						</div>
					</div>
					<div class="bg-striped"></div>
				</div>
				<!-- /Filter Row -->
				<!-- Total -->
				<div class="items-total">Items 1 to 15 of 28 total</div>
				<!-- /Total -->
				<!-- Products Grid -->
				<div class="products-grid three-in-row product-variant-5">

					<c:forEach items="${listProduct}" var="item" varStatus="index">
						<!-- Vòng lặp ở đây -->
						<!-- Product Item -->
						<div class="product-item large category2" id="Product${index.index+1 }" style="display: none;">
							<div class="product-item-inside">
								<div class="product-item-info">
									<!-- Product Photo -->
									<div class="product-item-photo">
										<!-- Product Label -->
										<div class="product-item-label label-sale">
											<span>${index.index + 1 }</span>
										</div>
										<!-- /Product Label -->
										<div class="product-item-gallery">
											<!-- product main photo -->
											
											<c:url value ="/${item.getProductType().getName() }/${item.getSportType().getName() }/${item.getId() }/${fn:replace(item.getName(), '/', '-') }" var="productURL"/>
											
											
											<!-- Mấy tấm hình ở đây  -->
											<!-- product inside carousel -->
											<div class="carousel-inside slide" data-ride="carousel">
												<div class="carousel-inner" role="listbox">
												<c:forEach items="${item.getImages()}" var="imageName" varStatus="indexImage">
												<c:if test="${indexImage.index == 0 }">
													<div class="item active">
												</c:if>
												<c:if test="${indexImage.index != 0 }">
													<div class="item">
												</c:if>
														<a href="${fn:replace(productURL, ' ', '-')}">
															<img class="product-image-photo" src='<c:url value = "/assets/user/images/products/${imageName.getName()}.jpg"></c:url>' alt="${imageName.getName()}">
														</a>
													</div>	
												</c:forEach>
												</div>
												<a class="carousel-control next"></a>
												<a class="carousel-control prev"></a>
											</div>
											<!-- /product inside carousel -->
											<!-- Xong mấy tấm hình -->
											
											<a href="quick-view.html" title="Quick View" class="quick-view-link quick-view-btn">
												<i class="icon icon-eye"></i>
												<span>Quick View</span>
											</a>
											<!-- /product main photo  -->
										</div>
										<!-- <div class="countdown-box hidden-xs">
										<div class="countdown-wrapper">
											<div class="countdown-title">special price expires in</div>
											<div class="countdown" data-promoperiod="100000000"></div>
										</div>
									</div> -->
										<!-- Product Actions -->
										<!-- Product Actions -->
										<a href="#" title="Add to Wishlist" class="no_wishlist">
											<i class="icon icon-heart"></i>
											<span>Add to Wishlist</span>
										</a>
										<!-- /Product Actions -->
									</div>
									<!-- /Product Photo -->
									<!-- Product Details -->
									<div class="product-item-details">
										<div class="product-item-name">
											<a href="${fn:replace(productURL, ' ', '-')}" class="product-item-link">${item.getName() }</a>
										</div>
										<div class="product-item-description">Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia nonkdni numquam eius modi tempora incidunt
											ut labore</div>
										<div class="price-box">
											<span class="price-container"> <span class="price-wrapper"> <span class="old-price">$300.00</span> <span class="special-price">$249.00</span>
											</span>
											</span>
										</div>
										<div class="product-item-rating">
											<i class="icon icon-star-fill"></i>
											<i class="icon icon-star-fill"></i>
											<i class="icon icon-star-fill"></i>
											<i class="icon icon-star-fill"></i>
											<i class="icon icon-star-fill"></i>
										</div>
										<button class="btn add-to-cart" onclick="addToCart(${item.getId()})" >
											<i class="icon icon-cart"></i>
											<span>Add to Cart</span>
										</button>
									</div>
									<!-- /Product Details -->
								</div>
							</div>
						</div>
						<!-- /Product Item -->
						<!-- Kết thúc Vòng lặp-->
					</c:forEach>
				</div>
				<!-- Cái này dùng để biết là có bao nhiêu sản phẩm, đéo hiểu sao dùng dưới js format lại nó cứ lỗi hoài, đcm cs luôn  -->
				<input type="hidden" id="numberProduct" value="${listProduct.size() }">


				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center" id="pagination">
					</ul>
				</nav>
				<!-- Hết danh sách rồi đm trang xong -->

				<!--có 1 cái input hidden ở đây để biết đang ở trang nào-->
				<input type="hidden" id="currentPage" value="1">


				<!-- /Products Grid -->

			</div>
			<!-- /Center column -->
		</div>
		<div class="ymax"></div>
		<!-- /Two columns -->
	</div>
</main>
<!-- /Page Content -->

<!-- <h1 id="Test">Test</h1>
<button onclick="test()">abc</button> -->



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>













