<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>



<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SEIKO eCommerce HTML 5 Template</title>
<meta name="author" content="BigSteps">
<meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1">
<link rel="shortcut icon" href='<c:url value = "/assets/user/images/favicon.ico"></c:url>'>

<!-- Vendor -->

<link href='<c:url value = "/assets/user/js/vendor/bootstrap/bootstrap.min.css"></c:url>' rel="stylesheet">
<link href='<c:url value = "/assets/user/js/vendor/slick/slick.css"></c:url>' rel="stylesheet">
<link href='<c:url value = "/assets/user/js/vendor/swiper/swiper.min.css"></c:url>' rel="stylesheet">
<link href='<c:url value = "/assets/user/js/vendor/magnificpopup/dist/magnific-popup.css"></c:url>' rel="stylesheet">
<link href='<c:url value = "/assets/user/js/vendor/nouislider/nouislider.css"></c:url>' rel="stylesheet">
<link href='<c:url value = "/assets/user/js/vendor/darktooltip/dist/darktooltip.css"></c:url>' rel="stylesheet">
<link href='<c:url value = "/assets/user/css/animate.css"></c:url>' rel="stylesheet">

<!-- Custom -->
<link href='<c:url value = "/assets/user/css/style.css"></c:url>' rel="stylesheet" />
<link href='<c:url value = "/assets/user/css/megamenu.css"></c:url>' rel="stylesheet">

<!-- Color Schemes -->
<!-- your style-color.css here  -->

<!-- Icon Font -->
<link href='<c:url value = "/assets/user/fonts/icomoon-reg/style.css"></c:url>' rel="stylesheet">

<!-- Google Font -->
<link href="https://fonts.googleapis.com/css?family=Oswald:300,400,700|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i|Roboto:300,300i,400,400i,500,500i,700,700i,900,900i"
	rel="stylesheet">

</head>
<!-- header -->



<body class="boxed">

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

	<div class="fixed-btns">
		<!-- Back To Top -->
		<a href="#" class="top-fixed-btn back-to-top">
			<i class="icon icon-arrow-up"></i>
		</a>
		<!-- /Back To Top -->
	</div>


	<div id="wrapper">
		<!-- Page -->
		<div class="page-wrapper">
			<!-- Header -->
			<header class="page-header variant-2 fullboxed sticky smart">
				<div class="navbar">
					<div class="container">
						<!-- Logo -->
						<div class="header-logo">
							<a href='<c:url value="/"></c:url>' title="Logo">
								<img src='<c:url value = "/assets/user/images/logo.png"></c:url>' alt="Logo" />
							</a>
						</div>
						<!-- /Logo -->
						<%@include file="/WEB-INF/views/layouts/user/header.jsp"%>
					</div>
				</div>
			</header>
			<!-- /Header -->
			<decorator:body />
			<%@include file="/WEB-INF/views/layouts/user/footer_main.jsp"%>
		</div>
		<!-- Page Content -->
	</div>


	<!-- ProductStack -->
	<div class="productStack disable hide_on_scroll">
		<a href="#" class="toggleStack">
			<i class="icon icon-cart"></i>
			(2) items
		</a>
		<div class="productstack-content">
			<div class="products-list-wrapper">
				<ul class="products-list">
					<li>
						<a href="product.html" title="Product Name Long Name">
							<img class="product-image-photo" src='<c:url value = "/assets/user/images/products/product-10.jpg"></c:url>' alt="">
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
							<img class="product-image-photo" src='<c:url value = "/assets/user/images/products/product-14.jpg"></c:url>' alt="">
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
	<!-- /Modal Quick View -->



</body>


<!-- jQuery Scripts  -->
<script src='<c:url value = "/assets/user/js/vendor/jquery/jquery.js"></c:url>'></script>
<script src='<c:url value = "/assets/user/js/vendor/bootstrap/bootstrap.min.js"></c:url>'></script>
<script src='<c:url value = "/assets/user/js/vendor/swiper/swiper.min.js"></c:url>'></script>
<script src='<c:url value = "/assets/user/js/vendor/slick/slick.min.js"></c:url>'></script>
<script src='<c:url value = "/assets/user/js/vendor/parallax/parallax.js"></c:url>'></script>
<script src='<c:url value = "/assets/user/js/vendor/isotope/isotope.pkgd.min.js"></c:url>'></script>
<script src='<c:url value = "/assets/user/js/vendor/magnificpopup/dist/jquery.magnific-popup.js"></c:url>'></script>
<script src='<c:url value = "/assets/user/js/vendor/countdown/jquery.countdown.min.js"></c:url>'></script>
<script src='<c:url value = "/assets/user/js/vendor/nouislider/nouislider.min.js"></c:url>'></script>
<script src='<c:url value = "/assets/user/js/vendor/ez-plus/jquery.ez-plus.js"></c:url>'></script>
<script src='<c:url value = "/assets/user/js/vendor/tocca/tocca.min.js"></c:url>'></script>
<script src='<c:url value = "/assets/user/js/vendor/bootstrap-tabcollapse/bootstrap-tabcollapse.js"></c:url>'></script>
<script src='<c:url value = "/assets/user/js/vendor/scrollLock/jquery-scrollLock.min.js"></c:url>'></script>
<script src='<c:url value = "/assets/user/js/vendor/darktooltip/dist/jquery.darktooltip.js"></c:url>'></script>
<script src='<c:url value = "/assets/user/js/vendor/imagesloaded/imagesloaded.pkgd.min.js"></c:url>'></script>
<script src='<c:url value = "/assets/user/js/vendor/instafeed/instafeed.min.js"></c:url>'></script>
<script src='<c:url value = "/assets/user/js/megamenu.min.js"></c:url>'></script>
<script src='<c:url value = "/assets/user/js/app.js"></c:url>'></script>
</html>





