<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!-- Loader -->
<div id="loader-wrapper">
	<div class="cube-wrapper">
		<div class="cube-folding">
			<span class="leaf1"></span>
			<span class="leaf2"></span>
			<span class="leaf3"></span>
			<span class="leaf4"></span>
		</div>
	</div>
</div>
<!-- /Loader -->
<!-- Page -->
<div class="page-wrapper">
	<!-- Journal -->
	<div class="overflow">
		<section class="journal">
			<!-- Logo -->
			<div class="logo-center">
				<a href="#">
					<img src="assets/user/images/logo-white.png" alt="#">
				</a>
			</div>
			<!-- /Logo -->
			<article class="journal-category journal-category-left">
				<div class="journal-category journal-category-inner-left">
					<div class="products-grid product-variant-1">
						<div class="title center">
							<h2>featured products</h2>
						</div>

						<c:forEach var="item" items="${index_featuredProduct }">

							<c:url value="/${item.getProductType().getName() }/${item.getSportType().getName() }/${item.getId() }/${fn:replace(item.getName(), '/', '-') }" var="productURL" />
							<!-- Product Item -->
							<div class="product-item large">
								<div class="product-item-inside">
									<!-- Product Label -->
									<div class="product-item-label label-sale">
										<span>-20%</span>
									</div>
									<!-- /Product Label -->
									<div class="product-item-info">
										<!-- Product Photo -->
										<div class="product-item-photo">
											<a href="${fn:replace(productURL, ' ', '-')}">
												<img class="product-image-photo" src='<c:url value = "/assets/user/images/products/${item.getImages()[0].getName()}.jpg"></c:url>' alt="${item.getName()}">
											</a>
										</div>
										<!-- /Product Photo -->
										<!-- Product Details -->
										<div class="product-item-details">
											<div class="product-item-name">
												<a title="#" href="${fn:replace(productURL, ' ', '-')}" class="product-item-link">${item.getName()}</a>
											</div>
											<div class="product-item-description">CS Night Blue Denim - Light Skim Used</div>
											<div class="price-box">
												<span class="price-container">
													<span class="price-wrapper">
														<span class="old-price">$${item.getProductDetails()[0].getPrice()}</span>
														<span class="special-price">$${item.getProductDetails()[0].getPrice()}</span>
													</span>
												</span>
											</div>
											<!-- Product Actions -->
											<div class="product-item-actions">
												<div class="actions-primary">
													<button class="btn btn-sm btn-invert add-to-cart" onclick="addToCart(${item.getId()})">
														<i class="icon icon-cart"></i>
														<span>Add to Cart</span>
													</button>
												</div>
											</div>
											<!-- /Product Actions -->
										</div>
										<!-- /Product Details -->
										<!-- Product Actions -->
										<div class="product-item-actions">
											<div class="actions-secondary">
												<a href="" title="Quick View" class="quick-view-link quick-view-btn">
													<i class="icon icon-eye"></i>
													<span>Quick View</span>
												</a>
											</div>
										</div>
										<!-- /Product Actions -->
									</div>
								</div>
							</div>
							<!-- /Product Item -->
						</c:forEach>
					</div>
				</div>
				<div class="journal-category journal-category-inner">
					<div class="toggle-panel">
						<i class="icon icon-angle-left"></i>
					</div>
					<div class="toggle-panel-mobile">
						<span class="show-icon">
							<i class="icon icon-dots-three-horizontal"></i>
						</span>
						<span class="close-icon">
							<i class="icon icon-close"></i>
						</span>
					</div>
					<div class="irregular-grid">

						<c:forEach var="item" items="${index_listProduct }" begin="0" end="1" varStatus="index">
							<c:url value="/${item.getProductType().getName() }/${item.getSportType().getName() }/${item.getId() }/${fn:replace(item.getName(), '/', '-') }" var="productURL" />
							<div class="product-preview">
								<div class="product-photo">
									<a href="${fn:replace(productURL, ' ', '-')}" class="product-link">
										<img src='<c:url value = "/assets/user/images/products/${item.getImages()[0].getName()}.jpg"></c:url>' alt="${item.getName()}">
									</a>
								</div>
								<div class="product-details">
									<a href="${fn:replace(productURL, ' ', '-')}" class="product-name">${item.getName()}</a>
									<div class="price-box">
										<span class="price-container">
											<span class="price-wrapper">
												<span class="special-price">$${item.getProductDetails()[0].getPrice()}</span>
												<span class="old-price">$290.00</span>
											</span>
										</span>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>
				</div>
			</article>
			<article class="journal-category journal-category-right">
				<div class="journal-category journal-category-inner">
					<div class="toggle-panel">
						<i class="icon icon-angle-right"></i>
					</div>
					<div class="toggle-panel-mobile">
						<span class="show-icon">
							<i class="icon icon-dots-three-horizontal"></i>
						</span>
						<span class="close-icon">
							<i class="icon icon-close"></i>
						</span>
					</div>
					<div class="irregular-grid">

						<c:forEach var="item" items="${index_listProduct }" begin="2" end="3" varStatus="index">
							<c:url value="/${item.getProductType().getName() }/${item.getSportType().getName() }/${item.getId() }/${fn:replace(item.getName(), '/', '-') }" var="productURL" />
							<div class="product-preview">
								<div class="product-photo">
									<a href="${fn:replace(productURL, ' ', '-')}" class="product-link">
										<img src='<c:url value = "/assets/user/images/products/${item.getImages()[0].getName()}.jpg"></c:url>' alt="${item.getName()}">
									</a>
								</div>
								<div class="product-details">
									<a href="${fn:replace(productURL, ' ', '-')}" class="product-name">${item.getName()}</a>
									<div class="price-box">
										<span class="price-container">
											<span class="price-wrapper">
												<span class="special-price">$${item.getProductDetails()[0].getPrice()}</span>
												<span class="old-price">$290.00</span>
											</span>
										</span>
									</div>
								</div>
							</div>
						</c:forEach>


					</div>
				</div>
				<div class="journal-category journal-category-inner-right">
					<div class="products-grid product-variant-1">
						<div class="title center">
							<h2>newest products</h2>
						</div>
						<c:forEach var="item" items="${index_newestProduct }">

							<c:url value="/${item.getProductType().getName() }/${item.getSportType().getName() }/${item.getId() }/${fn:replace(item.getName(), '/', '-') }" var="productURL" />
							<!-- Product Item -->
							<div class="product-item large">
								<div class="product-item-inside">
									<!-- Product Label -->
									<div class="product-item-label label-sale">
										<span>-20%</span>
									</div>
									<!-- /Product Label -->
									<div class="product-item-info">
										<!-- Product Photo -->
										<div class="product-item-photo">
											<a href="${fn:replace(productURL, ' ', '-')}">
												<img class="product-image-photo" src='<c:url value = "/assets/user/images/products/${item.getImages()[0].getName()}.jpg"></c:url>' alt="${item.getName()}">
											</a>
										</div>
										<!-- /Product Photo -->
										<!-- Product Details -->
										<div class="product-item-details">
											<div class="product-item-name">
												<a title="#" href="${fn:replace(productURL, ' ', '-')}" class="product-item-link">${item.getName()}</a>
											</div>
											<div class="product-item-description">CS Night Blue Denim - Light Skim Used</div>
											<div class="price-box">
												<span class="price-container">
													<span class="price-wrapper">
														<span class="old-price">$${item.getProductDetails()[0].getPrice()}</span>
														<span class="special-price">$${item.getProductDetails()[0].getPrice()}</span>
													</span>
												</span>
											</div>
											<!-- Product Actions -->
											<div class="product-item-actions">
												<div class="actions-primary">
													<button class="btn btn-sm btn-invert add-to-cart" onclick="addToCart(${item.getId()})">
														<i class="icon icon-cart"></i>
														<span>Add to Cart</span>
													</button>
												</div>
											</div>
											<!-- /Product Actions -->
										</div>
										<!-- /Product Details -->
										<!-- Product Actions -->
										<div class="product-item-actions">
											<div class="actions-secondary">
												<a href="" title="Quick View" class="quick-view-link quick-view-btn">
													<i class="icon icon-eye"></i>
													<span>Quick View</span>
												</a>
											</div>
										</div>
										<!-- /Product Actions -->
									</div>
								</div>
							</div>
							<!-- /Product Item -->
						</c:forEach>
					</div>
				</div>
			</article>
		</section>
	</div>
	<!-- /Journal -->

	<!-- Page Content -->
</div>


<!-- ProductStack -->
<div class="productStack disable hide_on_scroll">
	<a href="#" class="toggleStack">
		<i class="icon icon-cart"></i>
		(6) items
	</a>
	<div class="productstack-content">
		<div class="products-list-wrapper">
			<ul class="products-list">
				<li>
					<a href="product.html" title="Product Name Long Name">
						<img class="product-image-photo" src="assets/user/images/products/product-10.jpg" alt="">
					</a>
					<span class="item-qty">3</span>
					<div class="actions">
						<a href="#" class="action edit" title="Edit item">
							<i class="icon icon-pencil"></i>
						</a>
						<a class="action delete" href="#" title="Delete item">
							<i class="icon icon-trash-alt"></i>
						</a>
						<div class="edit-qty">
							<input type="number" value="3">
							<button type="button" class="btn">Apply</button>
						</div>
					</div>
				</li>
				<li>
					<a href="product.html" title="Product Name Long Name">
						<img class="product-image-photo" src="assets/user/images/products/product-11.jpg" alt="">
					</a>
					<span class="item-qty">3</span>
					<div class="actions">
						<a class="action edit" href="#" title="Edit item">
							<i class="icon icon-pencil"></i>
						</a>
						<a class="action delete" href="#" title="Delete item">
							<i class="icon icon-trash-alt"></i>
						</a>
						<div class="edit-qty">
							<input type="number" value="3">
							<button type="button" class="btn">Apply</button>
						</div>
					</div>
				</li>
				<li>
					<a href="product.html" title="Product Name Long Name">
						<img class="product-image-photo" src="assets/user/images/products/product-12.jpg" alt="">
					</a>
					<span class="item-qty">3</span>
					<div class="actions">
						<a class="action edit" href="#" title="Edit item">
							<i class="icon icon-pencil"></i>
						</a>
						<a class="action delete" href="#" title="Delete item">
							<i class="icon icon-trash-alt"></i>
						</a>
						<div class="edit-qty">
							<input type="number" value="3">
							<button type="button" class="btn">Apply</button>
						</div>
					</div>
				</li>
				<li>
					<a href="product.html" title="Product Name Long Name">
						<img class="product-image-photo" src="assets/user/images/products/product-13.jpg" alt="">
					</a>
					<span class="item-qty">3</span>
					<div class="actions">
						<a class="action edit" href="#" title="Edit item">
							<i class="icon icon-pencil"></i>
						</a>
						<a class="action delete" href="#" title="Delete item">
							<i class="icon icon-trash-alt"></i>
						</a>
						<div class="edit-qty">
							<input type="number" value="3">
							<button type="button" class="btn">Apply</button>
						</div>
					</div>
				</li>
				<li>
					<a href="product.html" title="Product Name Long Name">
						<img class="product-image-photo" src="assets/user/images/products/product-14.jpg" alt="">
					</a>
					<span class="item-qty">3</span>
					<div class="actions">
						<a class="action edit" href="#" title="Edit item">
							<i class="icon icon-pencil"></i>
						</a>
						<a class="action delete" href="#" title="Delete item">
							<i class="icon icon-trash-alt"></i>
						</a>
						<div class="edit-qty">
							<input type="number" value="3">
							<button type="button" class="btn">Apply</button>
						</div>
					</div>
				</li>
				<li>
					<a href="product.html" title="Product Name Long Name">
						<img class="product-image-photo" src="assets/user/images/products/product-15.jpg" alt="">
					</a>
					<span class="item-qty">3</span>
					<div class="actions">
						<a class="action edit" href="#" title="Edit item">
							<i class="icon icon-pencil"></i>
						</a>
						<a class="action delete" href="#" title="Delete item">
							<i class="icon icon-trash-alt"></i>
						</a>
						<div class="edit-qty">
							<input type="number" value="3">
							<button type="button" class="btn">Apply</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
		<div class="action-cart">
			<button type="button" class="btn" title="Checkout">
				<span>Checkout</span>
			</button>
			<button type="button" class="btn" title="Go to Cart">
				<span>Go to Cart</span>
			</button>
		</div>
		<div class="total-cart">
			<div class="items-total">
				Items
				<span class="count">6</span>
			</div>
			<div class="subtotal">
				Subtotal
				<span class="price">2.150</span>
			</div>
		</div>
	</div>
</div>
<!-- /ProductStack -->
<a class="back-to-top back-to-top-mobile" href="#">
	<i class="icon icon-angle-up"></i>
	To Top
</a>

<!-- Modal Quick View -->
<div class="modal quick-view zoom" id="quickView">
	<div class="modal-dialog">
		<div class="modalLoader-wrapper">
			<div class="modalLoader bg-striped"></div>
		</div>
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">&#10006;</button>
		</div>
		<div class="modal-content">
			<iframe></iframe>
		</div>
	</div>
</div>
<!--function location: quickView app.js -->
<!-- /Modal Quick View -->





