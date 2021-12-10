<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
					/
					<a href='<c:url value="/category"></c:url>'>Women</a>
				</li>
				<li>
					/<span>${productDetails.getName() }</span>
				</li>

				<c:url value="/${prevProduct.getProductType().getName() }/${prevProduct.getSportType().getName() }/${prevProduct.getId()}/${fn:replace(prevProduct.getName(), '/', '-') }" var="prevURL" />
				<c:url value="/${nextProduct.getProductType().getName() }/${nextProduct.getSportType().getName() }/${nextProduct.getId()}/${fn:replace(nextProduct.getName(), '/', '-') }" var="nextURL" />

				<li class="product-nav">
					<i class="icon icon-angle-left"></i>
					<a href="${fn:replace(prevURL, ' ', '-')}" class="product-nav-prev">
						prev product <span class="product-nav-preview"> <span class="image"><img src='<c:url value="/assets/user/images/products/${prevProduct.getImages()[0].getName()}.jpg"></c:url>' alt=""><span
								class="price">$100 <!-- {prevProduct.getPrice() } -->
							</span></span> <span class="name">${prevProduct.getName() }</span>
						</span>
					</a>
					/
					<a href=${fn:replace(nextURL, ' ', '-')} class="product-nav-next">
						next product <span class="product-nav-preview"> <span class="image"><img src='<c:url value="/assets/user/images/products/${nextProduct.getImages()[0].getName()}.jpg"></c:url>' alt=""><span
								class="price">$100 <%-- ${nextProduct.getPrice() } --%></span></span> <span class="name">${nextProduct.getName() }</span>
						</span>
					</a>
					<i class="icon icon-angle-right"></i>
				</li>
			</ul>
		</div>
	</div>
	<div class="block product-block fullwidth full-nopad">
		<div class="container">
			<!-- Product Slider -->
			<div class="product-slider-wrapper">
				<div class="product-creative-slider">


					<c:forEach items="${productDetails.getImages()}" var="imageName" varStatus="indexImage">
						<c:choose>
							<c:when test="${imageName.getName() != '' }">
								<div class="item">
									<img src='<c:url value="/assets/user/images/products/${imageName.getName()}.jpg"></c:url>' class="inner-zoom"
										data-zoom-image='<c:url value = "/assets/user/images/products/large/product-creative-2.jpg"></c:url>' alt="">
								</div>
							</c:when>
							<c:otherwise>
								<div class="item">
									<img src='<c:url value = "/assets/user/images/products/product-creative-2.jpg"></c:url>' class="inner-zoom"
										data-zoom-image='<c:url value = "/assets/user/images/products/large/product-creative-2.jpg"></c:url>' alt="">
								</div>
							</c:otherwise>
						</c:choose>
					</c:forEach>

				</div>
				<div class="product-creative-slider-control"></div>
				<div class="dblclick-text">
					<span>Double click for enlarge</span>
				</div>
			</div>
			<!-- /Product Slider -->
		</div>
	</div>
	<div class="block product-block fullboxed bg white">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-push-2">
					<div class="product-info-block creative">

						<h1 class="product-name">${productDetails.getName() }</h1>
						<div class="product-meta">
							<span class="product-labels"> <span class="product-label sale">SALE</span> <span class="product-label new">NEW</span>
							</span> <span class="availability">Availability: <b>In stock</b></span> <span class="rating"><i class="icon icon-star fill"></i> <i class="icon icon-star fill"></i> <i
									class="icon icon-star fill"></i> <i class="icon icon-star fill"></i> <i class="icon icon-star"></i><span class="count">248</span></span> <span><a href="#">
									<i class="icon icon-heart"></i>
									Add to wishlist
								</a></span> <span class="product-sku">SKU: <span>Stock Keeping Unit</span></span>

						</div>
						<div class="product-description">
							<p>Quisque sollicitudin nulla felis, vel sollicitudin felis mollis in. Cras mauris ligula, pharetra a consectetur a, interdum sit amet. Nunc dui nulla, efficitur a tempor non, euismod id
								libero.</p>
						</div>
						<!-- remove class more-options if less than three -->
						<div class="product-options more-options">
							<div class="product-size swatches">
								<span class="option-label">Size:</span>
								<div class="select-wrapper-sm">
									<select class="form-control input-sm size-variants">
										<option value="36">36 - $114.00 USD</option>
										<option value="38" selected>38 - $114.00 USD</option>
										<option value="40">40 - $114.00 USD</option>
										<option value="42">42 - $114.00 USD</option>
									</select>
								</div>
								<ul class="size-list">
									<li>
										<a href="#" data-value='36'>
											<span class="value">36</span>
										</a>
									</li>
									<li>
										<a href="#" data-value='38'>
											<span class="value">38</span>
										</a>
									</li>
									<li>
										<a href="#" data-value='40'>
											<span class="value">40</span>
										</a>
									</li>
									<li>
										<a href="#" data-value='42'>
											<span class="value">42</span>
										</a>
									</li>
								</ul>
							</div>

						</div>
						<div class="product-qty">
							<span class="option-label">Qty:</span>
							<div class="qty qty-changer">
								<fieldset>
									<input type="button" value="&#8210;" class="decrease">
									<input type="text" class="qty-input" value="2" data-min="0">
									<input type="button" value="+" class="increase">
								</fieldset>
							</div>
						</div>
						<div class="clearfix"></div>
						<div class="product-actions">
							<div class="countdown-circle">
								<div class="countdown-wrapper">
									<div class="countdown" data-promoperiod="604800000"></div>
									<div class="countdown-text">
										<div class="text1">Discount 20% OFF</div>
										<div class="text2">
											Hurry, there are only <span>14</span> item(s) left!
										</div>
									</div>
								</div>
							</div>
							<div class="actions">
								<div class="price">
									<span class="old-price"><span>$140.00</span></span> <span class="special-price"><span>$114.00</span></span>
								</div>
								<button data-loading-text='<i class="icon icon-spinner spin"></i><span>Add to cart</span>' class="btn btn-loading">
									<i class="icon icon-cart"></i>
									<span>Add to cart</span>
								</button>
								<a href="#" class="btn product-details">
									<i class="icon icon-external-link"></i>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="block">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<!-- Blog Carousel -->
					<div class="title">
						<h2>Benefits of choosing us</h2>
						<div class="carousel-arrows"></div>
					</div>
					<div class="col-md-6 col-lg-10 hidden-quickview">
						<div class="box-icon-row">
							<div class="box-left-icon-bg">
								<div class="box-icon">
									<i class="icon icon-gift"></i>
								</div>
								<div class="box-text">
									<div class="title">Special offer: 1+2=4</div>
									Get a gift!
								</div>
							</div>
							<div class="box-left-icon-bg">
								<div class="box-icon">
									<i class="icon icon-dollar-bills"></i>
								</div>
								<div class="box-text">
									<div class="title">Free Reward Card</div>
									Worth $10, $50, $100
								</div>
							</div>
							<div class="box-left-icon-bg">
								<div class="box-icon">
									<i class="icon icon-undo"></i>
								</div>
								<div class="box-text">
									<div class="title">Order return</div>
									Returns within 5 days
								</div>
							</div>
						</div>
					</div>
				</div>


				<div class="col-md-6">
					<!-- Deal Carousel -->
					<div class="title">
						<h2 class="custom-color">Deal of the day</h2>
						<div class="toggle-arrow"></div>
						<div class="carousel-arrows"></div>
					</div>
					<div class="collapsed-content">
						<div class="deal-carousel-2 products-grid product-variant-5">
							<!-- Product Item -->
							<div class="product-item previews-3 large">
								<div class="product-item-inside">
									<div class="product-item-info">
										<!-- Product Photo -->
										<div class="product-item-photo">
											<!-- Product Label -->
											<div class="product-item-label label-new">
												<span>New</span>
											</div>
											<div class="product-item-label label-sale">
												<span>-20%</span>
											</div>
											<!-- /Product Label -->
											<!-- product main photo -->
											<div class="product-item-gallery-main">
												<a href="#">
													<img class="product-image-photo" src='<c:url value = "/assets/user/images/products/product-11-1.jpg"></c:url>' alt="">
												</a>
												<a href="quick-view.html" title="Quick View" class="quick-view-link quick-view-btn">
													<i class="icon icon-eye"></i>
													<span>Quick View</span>
												</a>
											</div>
											<!-- /product main photo  -->
											<!-- Product Actions -->
											<a href="#" title="Add to Wishlist" class="no_wishlist">
												<i class="icon icon-heart"></i>
												<span>Add to Wishlist</span>
											</a>
											<div class="product-item-actions">
												<div class="share-button toBottom">
													<span class="toggle"></span>
													<ul class="social-list">
														<li>
															<a href="#" class="icon icon-google google"></a>
														</li>
														<li>
															<a href="#" class="icon icon-fancy fancy"></a>
														</li>
														<li>
															<a href="#" class="icon icon-pinterest pinterest"></a>
														</li>
														<li>
															<a href="#" class="icon icon-twitter-logo twitter"></a>
														</li>
														<li>
															<a href="#" class="icon icon-facebook-logo facebook"></a>
														</li>
													</ul>
												</div>
											</div>
											<!-- /Product Actions -->
											<!-- product carousel -->
											<div class="product-item-gallery-previews-wrapper">
												<div class="product-item-gallery-previews">
													<div class="item">
														<a href="#">
															<img src='<c:url value = "/assets/user/images/products/product-11.jpg"></c:url>' alt="">
														</a>
													</div>
													<div class="item">
														<a href="#">
															<img src='<c:url value = "/assets/user/images/products/product-11-1.jpg"></c:url>' alt="">
														</a>
													</div>
													<div class="item">
														<a href="#">
															<img src='<c:url value = "/assets/user/images/products/product-11-2.jpg"></c:url>' alt="">
														</a>
													</div>
												</div>
												<div class="carousel-arrows"></div>
											</div>
											<!-- /product carousel -->
										</div>
										<!-- /Product Photo -->
										<!-- Product Details -->
										<div class="product-item-details">
											<div class="product-item-name">
												<a title="Boyfriend Shorts Denim" href="product.html" class="product-item-link">Boyfriend Shorts Denim</a>
											</div>
											<div class="product-item-description">Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia nonkdni numquam eius modi tempora incidunt
												ut labore</div>
											<div class="price-box">
												<span class="price-container"> <span class="price-wrapper"> <span class="old-price">$190.00</span> <span class="special-price">$149.00</span>
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
											<button class="btn add-to-cart" data-product="789123">
												<i class="icon icon-cart"></i>
												<span>Add to Cart</span>
											</button>
										</div>
										<!-- /Product Details -->
									</div>
								</div>
							</div>
							<!-- /Product Item -->
							<!-- Product Item -->
							<div class="product-item large">
								<div class="product-item-inside">
									<div class="product-item-info">
										<!-- Product Photo -->
										<div class="product-item-photo">
											<!-- product main photo -->
											<div class="product-item-gallery-main">
												<a href="#">
													<img class="product-image-photo" src='<c:url value = "/assets/user/images/products/product-19.jpg"></c:url>' alt="">
												</a>
												<a href="quick-view.html" title="Quick View" class="quick-view-link quick-view-btn">
													<i class="icon icon-eye"></i>
													<span>Quick View</span>
												</a>
											</div>
											<!-- /product main photo  -->
											<!-- Product Label -->
											<div class="product-item-label label-new">
												<span>New</span>
											</div>
											<!-- /Product Label -->
											<!-- Product Actions -->
											<a href="#" title="Add to Wishlist" class="wishlist active">
												<i class="icon icon-heart"></i>
												<span>Add to Wishlist</span>
											</a>
											<div class="product-item-actions">
												<div class="share-button toBottom">
													<span class="toggle"></span>
													<ul class="social-list">
														<li>
															<a href="#" class="icon icon-google google"></a>
														</li>
														<li>
															<a href="#" class="icon icon-fancy fancy"></a>
														</li>
														<li>
															<a href="#" class="icon icon-pinterest pinterest"></a>
														</li>
														<li>
															<a href="#" class="icon icon-twitter-logo twitter"></a>
														</li>
														<li>
															<a href="#" class="icon icon-facebook-logo facebook"></a>
														</li>
													</ul>
												</div>
											</div>
											<!-- /Product Actions -->
											<!-- product carousel -->
											<div class="product-item-gallery-previews-wrapper">
												<div class="product-item-gallery-previews">
													<div class="item">
														<a href="#">
															<img src='<c:url value = "/assets/user/images/products/product-19.jpg"></c:url>' alt="">
														</a>
													</div>
													<div class="item">
														<a href="#">
															<img src='<c:url value = "/assets/user/images/products/product-19-1.jpg"></c:url>' alt="">
														</a>
													</div>
													<div class="item">
														<a href="#">
															<img src='<c:url value = "/assets/user/images/products/product-19-2.jpg"></c:url>' alt="">
														</a>
													</div>
													<div class="item">
														<a href="#">
															<img src='<c:url value = "/assets/user/images/products/product-19-3.jpg"></c:url>' alt="">
														</a>
													</div>
												</div>
												<div class="carousel-arrows"></div>
											</div>
											<!-- /product carousel -->
											<ul class="color-swatch hidden-xs">
												<li class="active">
													<a data-image='<c:url value = "/assets/user/images/products/product-19.jpg"></c:url>' href="#">
														<img src='<c:url value = "/assets/user/images/colorswatch/color-yellow.png"></c:url>' alt="Yellow">
													</a>
												</li>
												<li>
													<a data-image='<c:url value = "/assets/user/images/products/product-19-c1.jpg"></c:url>' href="#">
														<img src='<c:url value = "/assets/user/images/colorswatch/color-blue.png"></c:url>' alt="Blue">
													</a>
												</li>
												<li>
													<a data-image='<c:url value = "/assets/user/images/products/product-19-c2.jpg"></c:url>' href="#">
														<img src='<c:url value = "/assets/user/images/colorswatch/color-red.png"></c:url>' alt="Red">
													</a>
												</li>
												<li>
													<a data-image='<c:url value = "/assets/user/images/products/product-19-c3.jpg"></c:url>' href="#">
														<img src='<c:url value = "/assets/user/images/colorswatch/color-grey.png"></c:url>' alt="Grey">
													</a>
												</li>
												<li>
													<a data-image='<c:url value = "/assets/user/images/products/product-19-c4.jpg"></c:url>' href="#">
														<img src='<c:url value = "/assets/user/images/colorswatch/color-green.png"></c:url>' alt="Green">
													</a>
												</li>
												<li>
													<a data-image='<c:url value = "/assets/user/images/products/product-19-c5.jpg"></c:url>' href="#">
														<img src='<c:url value = "/assets/user/images/colorswatch/color-violet.png"></c:url>' alt="Violet">
													</a>
												</li>
											</ul>
										</div>
										<!-- /Product Photo -->
										<!-- Product Details -->
										<div class="product-item-details">
											<div class="product-item-name">
												<a title="Cover up tunic" href="product.html" class="product-item-link">Cover up tunic</a>
											</div>
											<div class="product-item-description">Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia nonkdni numquam eius modi tempora incidunt
												ut labore</div>
											<div class="price-box">
												<span class="price-container"> <span class="price-wrapper"> <span class="price">$110.00</span></span>
												</span>
											</div>
											<div class="product-item-rating">
												<i class="icon icon-star-fill"></i>
												<i class="icon icon-star-fill"></i>
												<i class="icon icon-star-fill"></i>
												<i class="icon icon-star-fill"></i>
												<i class="icon icon-star-fill"></i>
											</div>
											<button class="btn add-to-cart" data-product="789123">
												<i class="icon icon-cart"></i>
												<span>Add to Cart</span>
											</button>
										</div>
										<!-- /Product Details -->
									</div>
								</div>
							</div>
							<!-- /Product Item -->
							<!-- Product Item -->
							<div class="product-item large">
								<div class="product-item-inside">
									<div class="product-item-info">
										<!-- Product Photo -->
										<div class="product-item-photo">
											<!-- Product Label -->
											<div class="product-item-label label-new">
												<span>New</span>
											</div>
											<!-- /Product Label -->
											<div class="product-item-gallery">
												<!-- product main photo -->
												<div class="product-item-gallery-main">
													<a href="#">
														<img class="product-image-photo" src='<c:url value = "/assets/user/images/products/product-13.jpg"></c:url>' alt="">
													</a>
													<a href="quick-view.html" title="Quick View" class="quick-view-link quick-view-btn">
														<i class="icon icon-eye"></i>
														<span>Quick View</span>
													</a>
												</div>
												<!-- /product main photo  -->
											</div>
											<!-- Product Actions -->
											<a href="#" title="Add to Wishlist" class="no_wishlist">
												<i class="icon icon-heart"></i>
												<span>Add to Wishlist</span>
											</a>
											<div class="product-item-actions">
												<div class="share-button toBottom">
													<span class="toggle"></span>
													<ul class="social-list">
														<li>
															<a href="#" class="icon icon-google google"></a>
														</li>
														<li>
															<a href="#" class="icon icon-fancy fancy"></a>
														</li>
														<li>
															<a href="#" class="icon icon-pinterest pinterest"></a>
														</li>
														<li>
															<a href="#" class="icon icon-twitter-logo twitter"></a>
														</li>
														<li>
															<a href="#" class="icon icon-facebook-logo facebook"></a>
														</li>
													</ul>
												</div>
											</div>
											<!-- /Product Actions -->
										</div>
										<!-- /Product Photo -->
										<!-- Product Details -->
										<div class="product-item-details">
											<div class="product-item-name">
												<a title="Style Dome Men's Solid Red Color" href="product.html" class="product-item-link">Style Dome Men's Solid Red Color</a>
											</div>
											<div class="product-item-description">Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia nonkdni numquam eius modi tempora incidunt
												ut labore</div>
											<div class="price-box">
												<span class="price-container"> <span class="price-wrapper"><span class="price">$359.00</span> </span>
												</span>
											</div>
											<div class="product-item-rating">
												<i class="icon icon-star-fill"></i>
												<i class="icon icon-star-fill"></i>
												<i class="icon icon-star-fill"></i>
												<i class="icon icon-star-fill"></i>
												<i class="icon icon-star-fill"></i>
											</div>
											<button class="btn add-to-cart" data-product="789123">
												<i class="icon icon-cart"></i>
												<span>Add to Cart</span>
											</button>
										</div>
										<!-- /Product Details -->
									</div>
								</div>
							</div>
							<!-- /Product Item -->
						</div>
					</div>
					<!-- /Deal Carousel -->
				</div>
			</div>
		</div>
	</div>
</main>
<!-- /Page Content -->


<!-- Footer -->
<footer class="page-footer variant2 fullboxed">
	<div class="footer-top">
		<div class="container">
			<!-- newsletter -->
			<div class="newsletter variant2 row">
				<div class="col-sm-3">
					<a href='<c:url value="/"></c:url>' title="Logo">
						<img src='<c:url value="/assets/user/images/logo-footer.png"></c:url>' alt class="img-responsive" />
					</a>
				</div>
				<div class="col-sm-9">
					<!-- input-group -->
					<form action="#">
						<div class="input-group">
							<input type="text" class="form-control">
							<span class="input-group-btn">
								<button class="btn btn-default" type="submit">
									<i class="icon icon-close-envelope"></i>
								</button>
							</span>
						</div>
					</form>
					<!-- /input-group -->
				</div>
			</div>
			<!-- /newsletter -->
		</div>
	</div>
</footer>
<!-- /Footer -->