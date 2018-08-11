<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">

<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Blueprint: Multi-Level Menu</title>
	<meta name="description" content="Blueprint: A basic template for a responsive multi-level menu" />
	<meta name="keywords" content="blueprint, template, html, css, menu, responsive, mobile-friendly" />
	<meta name="author" content="Codrops" />
	<link rel="shortcut icon" href="favicon.ico">
	<!-- food icons -->
	<link rel="stylesheet" type="text/css" href="css/organicfoodicons.css" />
	<!-- demo styles -->
	<link rel="stylesheet" type="text/css" href="css/demo.css" />
	<!-- menu styles -->
	<link rel="stylesheet" type="text/css" href="css/component.css" />
	<script src="js/modernizr-custom.js"></script>
</head>

<body>
	<!-- Main container -->
	<div class="container">
		<!-- Blueprint header -->
		<header class="bp-header cf">
			<div class="dummy-logo">
				<div class="dummy-icon foodicon foodicon--coconut"></div>
				<h2 class="dummy-heading">Aarogyam</h2>
			</div>
			<div class="bp-header__main">
				<span class="bp-header__present">Welcome</span>
				<h1 class="bp-header__title"><%=request.getAttribute("userName")%></h1>
				<nav class="bp-nav">
					<a class="bp-nav__item bp-icon bp-icon--prev" href="http://tympanus.net/Blueprints/PageStackNavigation/" data-info="previous Blueprint"><span>Previous Blueprint</span></a>
					<!--a class="bp-nav__item bp-icon bp-icon--next" href="" data-info="next Blueprint"><span>Next Blueprint</span></a-->
					<a class="bp-nav__item bp-icon bp-icon--drop" href="http://tympanus.net/codrops/?p=25521" data-info="back to the Codrops article"><span>back to the Codrops article</span></a>
					<a class="bp-nav__item bp-icon bp-icon--archive" href="http://tympanus.net/codrops/category/blueprints/" data-info="Blueprints archive"><span>Go to the archive</span></a>
				</nav>
			</div>
		</header>
		<button class="action action--open" aria-label="Open Menu"><span class="icon icon--menu"></span></button>
		<nav id="ml-menu" class="menu">
			<button class="action action--close" aria-label="Close Menu"><span class="icon icon--cross"></span></button>
			<div class="menu__wrap">
				<ul data-menu="main" class="menu__level" tabindex="-1" role="menu" aria-label="All">
					<li class="menu__item" role="menuitem"><a class="menu__link" data-submenu="submenu-1" aria-owns="submenu-1" href="#">Registration</a></li>
					<li class="menu__item" role="menuitem"><a class="menu__link" data-submenu="submenu-2" aria-owns="submenu-2" href="#">Update Details</a></li>					
				</ul>
				
				<!-- Submenu 1 -->
				<ul data-menu="submenu-1" id="submenu-1" class="menu__level" tabindex="-1" role="menu" aria-label="Registration">
					<li class="menu__item" role="menuitem"><a class="menu__link" href="registration.jsp">New</a></li>
					<li class="menu__item" role="menuitem"><a class="menu__link" href="#">Roots &amp; Seeds</a></li>
					<li class="menu__item" role="menuitem"><a class="menu__link" href="#">Cabbages</a></li>
					<li class="menu__item" role="menuitem"><a class="menu__link" href="#">Salad Greens</a></li>
					<li class="menu__item" role="menuitem"><a class="menu__link" href="#">Mushrooms</a></li>
					<li class="menu__item" role="menuitem"><a class="menu__link" data-submenu="submenu-1-1" aria-owns="submenu-1-1" href="#">Sale %</a></li>
				</ul>
				
				<!-- Submenu 2 -->
				<ul data-menu="submenu-2" id="submenu-2" class="menu__level" tabindex="-1" role="menu" aria-label="Update Details">
					<li class="menu__item" role="menuitem"><a class="menu__link" data-submenu="submenu-2-1" aria-owns="submenu-2-1" href="#">Self</a></li>
					<li class="menu__item" role="menuitem"><a class="menu__link" data-submenu="submenu-2-2" aria-owns="submenu-2-2" href="#">Others</a></li>
				</ul>
				
				<!-- Submenu 2-1 -->
				<ul data-menu="submenu-2-1" id="submenu-2-1" class="menu__level" tabindex="-1" role="menu" aria-label="Self">
					<li class="menu__item" role="menuitem"><a class="menu__link" href="#">Update Password</a></li>
					<li class="menu__item" role="menuitem"><a class="menu__link" href="#">Update Email</a></li>
					<li class="menu__item" role="menuitem"><a class="menu__link" href="#">Update Telephone Number</a></li>
				</ul>
				<!-- Submenu 2-2 -->
				<ul data-menu="submenu-2-2" id="submenu-2-2" class="menu__level" tabindex="-1" role="menu" aria-label="Others">
					<li class="menu__item" role="menuitem"><a class="menu__link" href="#">Password</a></li>
					<li class="menu__item" role="menuitem"><a class="menu__link" href="#">Email</a></li>
					<li class="menu__item" role="menuitem"><a class="menu__link" href="#">Telephone Number</a></li>
				</ul>
			</div>
		</nav>
		<div class="content">
			<p class="info">Please choose a category</p>
			<!-- Ajax loaded content here -->
		</div>
	</div>
	<!-- /view -->
	<script src="js/classie.js"></script>
	<script src="js/dummydata.js"></script>
	<script src="js/main.js"></script>
	<script>
	(function() {
		var menuEl = document.getElementById('ml-menu'),
			mlmenu = new MLMenu(menuEl, {
				// breadcrumbsCtrl : true, // show breadcrumbs
				// initialBreadcrumb : 'all', // initial breadcrumb text
				backCtrl : false, // show back button
				// itemsDelayInterval : 60, // delay between each menu item sliding animation
				onItemClick: loadDummyData // callback: item that doesn´t have a submenu gets clicked - onItemClick([event], [inner HTML of the clicked item])
			});

		// mobile menu toggle
		var openMenuCtrl = document.querySelector('.action--open'),
			closeMenuCtrl = document.querySelector('.action--close');

		openMenuCtrl.addEventListener('click', openMenu);
		closeMenuCtrl.addEventListener('click', closeMenu);

		function openMenu() {
			classie.add(menuEl, 'menu--open');
			closeMenuCtrl.focus();
		}

		function closeMenu() {
			classie.remove(menuEl, 'menu--open');
			openMenuCtrl.focus();
		}

		// simulate grid content loading
		var gridWrapper = document.querySelector('.content');

		function loadDummyData(ev, itemName) {
			ev.preventDefault();

			closeMenu();
			gridWrapper.innerHTML = '';
			classie.add(gridWrapper, 'content--loading');
			setTimeout(function() {
				classie.remove(gridWrapper, 'content--loading');
				gridWrapper.innerHTML = '<ul class="products">' + dummyData[itemName] + '<ul>';
			}, 700);
		}
	})();
	</script>
</body>

</html>
