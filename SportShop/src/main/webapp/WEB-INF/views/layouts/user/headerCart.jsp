<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Header Cart -->
<div class="header-link dropdown-link header-cart variant-1">
	<a href='<c:url value="/cart"></c:url>'>
		<i class="icon icon-cart"></i>
		<span class="badge">3</span>
	</a>
	<!-- minicart wrapper -->
	<div class="dropdown-container right">
		<!-- minicart content -->
		<div class="block block-minicart">
			<div class="minicart-content-wrapper">
				<div class="block-title">
					<span>Recently added item(s)</span>
				</div>
				<a class="btn-minicart-close" title="Close">&#10060;</a>
				<div class="block-content">
					<div class="minicart-items-wrapper overflowed">
						<ol class="minicart-items">
							<li class="item product product-item">
								<div class="product">
									<a class="product-item-photo" href="#" title="Long sleeve overall">
										<span class="product-image-container">
											<span class="product-image-wrapper">
												<img class="product-image-photo" src='<c:url value = "/assets/user/images/products/product-16-c1.jpg"></c:url>' alt="Long sleeve overall">
											</span>
										</span>
									</a>
									<div class="product-item-details">
										<div class="product-item-name">
											<a href="#">Long sleeve overall</a>
										</div>
										<div class="product-item-qty">
											<label class="label">Qty</label>
											<input class="item-qty cart-item-qty" maxlength="12" value="1">
											<button class="update-cart-item" style="display: none" title="Update">
												<span>Update</span>
											</button>
										</div>
										<div class="product-item-pricing">
											<div class="price-container">
												<span class="price-wrapper">
													<span class="price-excluding-tax">
														<span class="minicart-price">
															<span class="price">$139.00</span>
														</span>
													</span>
												</span>
											</div>
											<div class="product actions">
												<div class="secondary">
													<a href="#" class="action delete" title="Remove item">
														<span>Delete</span>
													</a>
												</div>
												<div class="primary">
													<a class="action edit" href="#" title="Edit item">
														<span>Edit</span>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</li>

						</ol>
					</div>
					<div class="subtotal">
						<span class="label">
							<span>Subtotal</span>
						</span>
						<div class="amount price-container">
							<span class="price-wrapper">
								<span class="price">$50.00</span>
							</span>
						</div>
					</div>
					<div class="actions">
						<div class="secondary">
							<a href="#" class="btn btn-alt">
								<i class="icon icon-cart"></i>
								<span>View and edit cart</span>
							</a>
						</div>
						<div class="primary">
							<a class="btn" href="#">
								<i class="icon icon-external-link"></i>
								<span>Go to Checkout</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /minicart content -->
	</div>
	<!-- /minicart wrapper -->
</div>
<!-- /Header Cart -->