<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>



<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SEIKO eCommerce HTML 5 Template</title>
<meta name="author" content="BigSteps">
<meta name="viewport"
	content="width=device-width, minimum-scale=1, maximum-scale=1">
<link rel="shortcut icon" href="assets/user/images/favicon.ico">

<!-- Vendor -->
<link href="./assets/user/js/vendor/bootstrap/bootstrap.min.css"
	rel="stylesheet">
<link href="./assets/user/js/vendor/slick/slick.css" rel="stylesheet">
<link href="./assets/user/js/vendor/swiper/swiper.min.css"
	rel="stylesheet">
<link
	href="./assets/user/js/vendor/magnificpopup/dist/magnific-popup.css"
	rel="stylesheet">
<link href="./assets/user/js/vendor/nouislider/nouislider.css"
	rel="stylesheet">
<link href="./assets/user/js/vendor/darktooltip/dist/darktooltip.css"
	rel="stylesheet">
<link href="./assets/user/css/animate.css" rel="stylesheet">

<!-- Custom -->
<link href="./assets/user/css/style.css" rel="stylesheet" />
<link href="./assets/user/css/megamenu.css" rel="stylesheet">

<!-- Color Schemes -->
<!-- your style-color.css here  -->

<!-- Icon Font -->
<link href="./assets/user/fonts/icomoon-reg/style.css" rel="stylesheet">

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css?family=Oswald:300,400,700|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i|Roboto:300,300i,400,400i,500,500i,700,700i,900,900i"
	rel="stylesheet">

</head>
<!-- header -->



<body class="boxed">



	<!-- Loader -->
	<div id="loader-wrapper">
		<div class="cube-wrapper">
			<div class="cube-folding">
				<span class="leaf1"></span> <span class="leaf2"></span> <span
					class="leaf3"></span> <span class="leaf4"></span>
			</div>
		</div>
	</div>
	<!-- /Loader -->

	<div class="fixed-btns">
		<!-- Back To Top -->
		<a href="#" class="top-fixed-btn back-to-top"><i
			class="icon icon-arrow-up"></i></a>
		<!-- /Back To Top -->
	</div>


	<div id="wrapper">
		<!-- Page -->
		<div class="page-wrapper">

			<%@include file="/WEB-INF/views/layouts/user/header_main.jsp"%>
			<decorator:body />
			<%@include file="/WEB-INF/views/layouts/user/footer_main.jsp"%>
		</div>
		<!-- Page Content -->
	</div>
	
	
	<!-- ProductStack -->
	<div class="productStack disable hide_on_scroll"> <a href="#" class="toggleStack"><i class="icon icon-cart"></i> (2) items</a>
		<div class="productstack-content">
			<div class="products-list-wrapper">
				<ul class="products-list">
					<li>
						<a href="product.html" title="Product Name Long Name"><img class="product-image-photo" src="assets/user/images/products/product-10.jpg" alt=""></a> <span class="item-qty">3</span>
						<div class="actions"> <a href="#" class="action edit" title="Edit item"><i class="icon icon-pencil"></i></a> <a class="action delete" href="#" title="Delete item"><i class="icon icon-trash-alt"></i></a>
							<div class="edit-qty">
								<input type="number" value="3">
								<button type="button" class="btn">Apply</button>
							</div>
						</div>
					</li>
					
					<li>
						<a href="product.html" title="Product Name Long Name"><img class="product-image-photo" src="assets/user/images/products/product-14.jpg" alt=""></a> <span class="item-qty">3</span>
						<div class="actions"> <a class="action edit" href="#" title="Edit item"><i class="icon icon-pencil"></i></a> <a class="action delete" href="#" title="Delete item"><i class="icon icon-trash-alt"></i></a>
							<div class="edit-qty">
								<input type="number" value="3">
								<button type="button" class="btn">Apply</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<div class="action-cart">
				<button type="button" class="btn" title="Checkout"> <span>Checkout</span> </button>
				<button type="button" class="btn" title="Go to Cart"> <span>Go to Cart</span> </button>
			</div>
			<div class="total-cart">
				<div class="items-total">Items <span class="count">6</span></div>
				<div class="subtotal">Subtotal <span class="price">2.150</span></div>
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
<script src="./assets/user/js/vendor/jquery/jquery.js"></script>
<script src="./assets/user/js/vendor/bootstrap/bootstrap.min.js"></script>
<script src="./assets/user/js/vendor/swiper/swiper.min.js"></script>
<script src="./assets/user/js/vendor/slick/slick.min.js"></script>
<script src="./assets/user/js/vendor/parallax/parallax.js"></script>
<script src="./assets/user/js/vendor/isotope/isotope.pkgd.min.js"></script>
<script
	src="./assets/user/js/vendor/magnificpopup/dist/jquery.magnific-popup.js"></script>
<script src="./assets/user/js/vendor/countdown/jquery.countdown.min.js"></script>
<script src="./assets/user/js/vendor/nouislider/nouislider.min.js"></script>
<script src="./assets/user/js/vendor/ez-plus/jquery.ez-plus.js"></script>
<script src="./assets/user/js/vendor/tocca/tocca.min.js"></script>
<script
	src="./assets/user/js/vendor/bootstrap-tabcollapse/bootstrap-tabcollapse.js"></script>
<script
	src="./assets/user/js/vendor/scrollLock/jquery-scrollLock.min.js"></script>
<script
	src="./assets/user/js/vendor/darktooltip/dist/jquery.darktooltip.js"></script>
<script
	src="./assets/user/js/vendor/imagesloaded/imagesloaded.pkgd.min.js"></script>
<script src="./assets/user/js/vendor/instafeed/instafeed.min.js"></script>
<script src="./assets/user/js/megamenu.min.js"></script>
<script src="./assets/user/js/app.js"></script>
</html>





