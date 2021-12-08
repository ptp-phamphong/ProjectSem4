<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Header Cart -->
<%@include file="/WEB-INF/views/layouts/user/headerCart.jsp"%>
<!-- /Header Cart -->

<!-- Header Links -->
<div class="header-links">
	<!-- Header Account -->
	<c:choose>
		<c:when test="${not empty currentCustomer}">
			<div class="header-link header-account"></div>
			<div class="header-link dropdown-link header-account">
				<a href='<c:url value="/account/${currentCustomer.getId()}"></c:url>'>${currentCustomer.getFullName()}</a>
				<div class="dropdown-container right">
					<div class="title">Hello</div>
					<div class="top-text" style="color: green; font-size: 150%">${currentCustomer.getFullName()}</div>
					<button onclick="location.href='<c:url value="/account/${currentCustomer.getId()}"></c:url>'" class="btn btn-lg">View Account</button>
					<button onclick="location.href='<c:url value="/logoutHandelling"></c:url>'" class="btn btn-lg" data-toggle="modal" data-target="#logOutPopup">Logout</button>
				</div>
			</div>

		</c:when>
		<c:otherwise>
			<div class="header-link dropdown-link header-account">
				<a href='<c:url value="/login"></c:url>'>
					<i class="icon icon-user"></i>
				</a>
				<div class="dropdown-container right">
					<div class="title">Registered Customers</div>
					<div class="top-text">If you have an account with us, please log in.</div>

					<!-- form login  -->

					<c:url var="action_url" value="/loginHandelling" />
					<form:form method="post" class="account-create" action="${action_url }" modelAttribute="customer">


						<label> E-mail <span class="required">*</span>
						</label>
						<form:input path="email" type="email" class="form-control input-lg" required="required" />

						<label> Password <span class="required">*</span>
						</label>
						<form:input path="password" type="password" class="form-control input-lg" required="required" />

						<div>
							<button class="btn btn-lg" type="submit">Login</button>
							<span class="required-text">* Required Fields</span>
						</div>
						<div class="back">
							<a href="#">Forgot Your Password?</a>
						</div>
					</form:form>

					<div class="title">OR</div>
					<div class="bottom-text">
						Create a
						<a href='<c:url value="/register"></c:url>'>New Account</a>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>


	<!-- /Header Account -->
</div>
<!-- /Header Links -->
<!-- Header Search -->
<div class="header-link header-search header-search">
	<div class="exp-search">
		<form>
			<input class="exp-search-input " placeholder="Search here ..." type="text" value="">
			<input class="exp-search-submit" type="submit" value="">
			<span class="exp-icon-search"> <i class="icon icon-magnify"></i>
			</span> <span class="exp-search-close"> <i class="icon icon-close"></i>
			</span>
		</form>
	</div>
</div>
<!-- /Header Search -->

<!-- Mobile Menu -->
<div class="mobilemenu dblclick">
	<div class="mobilemenu-header">
		<div class="title">MENU</div>
		<a href="#" class="mobilemenu-toggle"></a>
	</div>
	<div class="mobilemenu-content">
		<ul class="nav">
			<li>
				<a href='<c:url value="/"></c:url>'">HOME</a>
				<span class="arrow"></span>
			</li>
			<li>
				<a href='<c:url value = "/all-product"></c:url>'>All Products</a>
			</li>
			<li>
				<a href='<c:url value = "/all-product"></c:url>'>Clothes</a>
			</li>
			<li>
				<a href='<c:url value="/all-product"></c:url>'>Equipment</a>
			</li>
		</ul>
	</div>
</div>
<!-- Mobile Menu -->
<!-- Mega Menu -->
<div class="megamenu fadein blackout">
	<ul class="nav">
		<li>
			<a href='<c:url value = "/"></c:url>'>HOME</a>
		</li>
		<li>
			<a href='<c:url value = "/all-product"></c:url>'>All Product</a>
		</li>
		<li class="mega-dropdown">
			<a href='<c:url value = "/all-product"></c:url>'>
				Clothes <span class="menu-label">-15%</span>
			</a>
			<div class="sub-menu">
				<div class="container">
					<div class="megamenu-categories column-4">
						<!-- megamenu column -->
						<div class="col">
							<a class="category-image" href="#">
								<img src='<c:url value = "/assets/user/images/category/megamenu-category-03.jpg"></c:url>' alt />
							</a>
							<div class="category-title">
								<a href="#">Only New</a>
							</div>
							<ul class="category-links">
								<li>
									<a href="#">New In Clothing</a>
								</li>
								<li>
									<a href="#">New In Shoes</a>
								</li>
								<li>
									<a href="#">New In Accessories</a>
								</li>
							</ul>
						</div>
						<!-- /megamenu column -->
						<!-- megamenu column -->
						<div class="col">
							<a class="category-image" href="#">
								<img src='<c:url value = "/assets/user/images/category/megamenu-category-04.jpg"></c:url>' alt />
							</a>
							<div class="category-title">
								<a href="#">Only Sale</a>
							</div>
							<ul class="category-links">
								<li>
									<a href="#">Sale Clothing</a>
								</li>
								<li>
									<a href="#">
										<b>Sale Shoes</b>
										<span class="menu-label">THREE DAYS ONLY!</span>
									</a>
								</li>
								<li>
									<a href="#">Sale Accessories</a>
								</li>
							</ul>
						</div>
						<!-- /megamenu column -->
						<!-- megamenu column -->
						<div class="col">
							<a class="category-image" href="#">
								<img src='<c:url value = "/assets/user/images/category/megamenu-category-05.jpg"></c:url>' alt />
							</a>
							<div class="category-title">
								<a href="#">Top</a>
								<span class="menu-label-alt">NEW</span>
							</div>
							<ul class="category-links">
								<li>
									<a href="#">T-Shirts & Vests</a>
								</li>
								<li>
									<a href="#">Jumpers & Cardigans</a>
								</li>
								<li>
									<a href="#">Coats & Jackets</a>
								</li>
							</ul>
						</div>
						<!-- /megamenu column -->
						<!-- megamenu column -->
						<div class="col">
							<a class="category-image" href="#">
								<img src='<c:url value = "/assets/user/images/category/megamenu-category-06.jpg"></c:url>' alt />
							</a>
							<div class="category-title">
								<a href="#">Bottom</a>
							</div>
							<ul class="category-links">
								<li>
									<a href="#">Shorts</a>
								</li>
								<li>
									<a href="#">Pants</a>
								</li>
								<li>
									<a href="#">Denim</a>
								</li>
							</ul>
						</div>
						<!-- /megamenu column -->
					</div>
				</div>
			</div>
		</li>
		<li class="mega-dropdown">
			<a href='<c:url value = "/all-product"></c:url>'>
				Equipments <span class="menu-label-alt">NEW</span>
			</a>
			<div class="sub-menu">
				<div class="container">
					<div class="megamenu-right width-25">
						<div class="banner style-1 autosize-text" data-fontratio="4.2">
							<img src='<c:url value = "/assets/user/images/banners/banner-1.jpg"></c:url>' alt="Banner">
							<div class="banner-caption vertb">
								<div class="vert-wrapper">
									<div class="vert">
										<div class="text-1">WOMEN 2016</div>
										<div class="text-2">collections sale</div>
										<div class="text-3">SAVE UP TO 40% OF</div>
										<a href="#buttonlink" class="banner-btn-wrap">
											<div class="banner-btn text-hoverslide" data-hcolor="#f82e56">
												<span> <span class="text">SHOP NOW</span> <span class="hoverbg"></span>
												</span>
											</div>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="megamenu-categories column-2">
						<!-- megamenu column 1 -->
						<div class="col">
							<a class="category-image" href="#">
								<img src='<c:url value = "/assets/user/images/category/megamenu-category-01.jpg"></c:url>' alt />
							</a>
							<div class="category-title title-border">
								<a href='<c:url value = "/all-product"></c:url>'>
									ACCESSORIES <span class="menu-label">HOT</span>
								</a>
							</div>
							<ul class="category-links column-count-2">
								<li>
									<a href="#">New In</a>
								</li>
								<li>
									<a href="#">Belt Buckles</a>
								</li>
								<li>
									<a href="#">Collar Tips</a>
								</li>
								<li>
									<a href="#">
										Fascinators & Headpieces <span class="menu-label">HOT PRICE</span>
									</a>
								</li>
								<li>
									<a href="#">Gloves & Mittens</a>
								</li>
								<li>
									<a href="#">Hair Accessories</a>
								</li>
								<li>
									<a href="#">Handkerchiefs</a>
								</li>
								<li>
									<a href="#">ID & Document Holders</a>
								</li>
								<li>
									<a href="#">T-Shirts & Vests</a>
								</li>
								<li>
									<a href="#">Rings & Finders</a>
								</li>
								<li>
									<a href="#">Day Planners</a>
								</li>
								<li>
									<a href="#">Scarves & Wraps</a>
								</li>
								<li>
									<a href="#">Wallets</a>
								</li>
								<li>
									<a href="#">Umbrellas</a>
								</li>
							</ul>
						</div>
						<!-- /megamenu column 1 -->
						<!-- megamenu column 2 -->
						<div class="col">
							<a class="category-image" href="#">
								<img src='<c:url value = "/assets/user/images/category/megamenu-category-02.jpg"></c:url>' alt />
							</a>
							<div class="category-title title-border">
								<a href="#">
									CLOTHING <span class="menu-label-alt">NEW</span>
								</a>
							</div>
							<ul class="category-links column-count-2">
								<li>
									<a href="#">New In</a>
								</li>
								<li>
									<a href="#">T-Shirts & Vests</a>
								</li>
								<li>
									<a href="#">Jumpers & Cardigans</a>
								</li>
								<li>
									<a href="#">
										Hoodies & Sweats <span class="menu-label">-15%</span>
									</a>
								</li>
								<li>
									<a href="#">Coats & Jackets</a>
								</li>
								<li>
									<a href="#">Joggers & Tracksuits</a>
								</li>
								<li>
									<a href="#">Shorts</a>
								</li>
								<li>
									<a href="#">Athletic Apparel</a>
								</li>
								<li>
									<a href="#">Intimates & Sleep</a>
								</li>
								<li>
									<a href="#">Outerwear</a>
								</li>
								<li>
									<a href="#">Swimwear</a>
								</li>
								<li>
									<a href="#">Denim Collection</a>
								</li>
								<li>
									<a href="#">Tops & Blouses</a>
								</li>
								<li>
									<a href="#">Shorts</a>
								</li>
							</ul>
						</div>
						<!-- /megamenu column 2 -->
						<!-- megamenu bottom -->
						<div class="megamenu-bottom">
							<a href="#">
								<img class="img-responsive" src='<c:url value = "/assets/user/images/banners/banner-megamenu.jpg"></c:url>' alt="megamenu banner">
							</a>
						</div>
						<!-- /megamenu bottom -->
					</div>
				</div>
			</div>
		</li>
	</ul>
</div>
<!-- /Mega Menu -->


