<%@page import="com.niit.constants.UrlConstant"%>
<%@page import="com.niit.constants.RequestAttribute"%>
<%@page import="com.niit.constants.ViewConstant"%>
<%@page import="com.niit.service.UserService"%>
<%@page import="java.util.List"%>
<%@page import="com.niit.model.UserModel" %>
<%@page import="com.niit.model.BookModel" %>
<%@page import="com.niit.service.BookService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="zxx">

<head>
	<title>Book Catalogue</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="" />
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!-- Custom Theme files -->
	<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
	<!-- shop css -->
	<link href="css/shop.css" type="text/css" rel="stylesheet" media="all">
	<!-- checkout css -->
	<link href="css/checkout.css" type="text/css" rel="stylesheet" media="all">
	<!-- Range-slider-css -->
	<link rel="stylesheet" type="text/css" href="css/jquery-ui1.css">
	<!-- common-css -->
	<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
	<!-- font-awesome icons -->
	<link href="css/font-awesome.css" rel="stylesheet">

	<!-- //Custom Theme files -->
	<!-- online-fonts -->
	<!-- logo -->
	<link href="http://fonts.googleapis.com/css?family=Fredericka+the+Great" rel="stylesheet">
	<!-- titles -->
	<link href="http://fonts.googleapis.com/css?family=Merriweather+Sans:300,300i,400,400i,700,700i,800,800i" rel="stylesheet">
	<!-- body -->
	<link href="http://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
	<!-- //online-fonts -->
</head>


<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
	<div id="home">
		<!-- header -->
		<!-- navbar -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="main-nav">
				<div class="container">

					<div class="navbar-header page-scroll">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
							<span class="sr-only">Chronicle</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<h1>
							<a class="navbar-brand" href="index.jsp">Chronicle</a>
						</h1>
					</div>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse navbar-ex1-collapse nav-right">
						<ul class="nav navbar-nav navbar-left cl-effect-15">
							<!-- Hidden li included to remove active class from about link when scrolled up past about section -->
							<li class="hidden">
								<a class="page-scroll" href="#page-top"></a>
							</li>
							<li>
								<a href="index.jsp">Home</a>
							</li>
							<li class="active">
								<a href="about.jsp">about us</a>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle effect-3" data-toggle="dropdown">check
									<b class="caret"></b>
								</a>
								<ul class="dropdown-menu">
									<li>
										<a href="book.jsp">book catalog</a>
									</li>
									<li>
										<a href="checkout.jsp">borrow</a>
									</li>
									<li>
                                        <a href="payment.jsp">Payment</a>
                                    </li>
								</ul>
							</li>
							<li>
								<a href="contact.jsp">Contact us</a>
							</li>
							<li>
								<a href="login.jsp" title="SignIn & SignUp">
									<span class="fa fa-user nav-icon" aria-hidden="true"></span>
								</a>
							</li>

						</ul>
						<!-- search-bar -->
						<div class="search-bar-agileits">
							<div class="cd-main-header">
								<ul class="cd-header-buttons">
									<li>
										<a class="cd-search-trigger" href="#cd-search">
											<span></span>
										</a>
									</li>
								</ul>
								<!-- cd-header-buttons -->
							</div>
							<div id="cd-search" class="cd-search">
								<form action="<%=UrlConstant.BOOK_SERVLET %>" method="post">
									<input name="search" type="search" placeholder="Type and Hit Enter...">
									<button  name="submit" type="submit" value="Search" ></button>
								</form>
							</div>
							
						</div>
						<!-- //search-bar ends here -->
					</div>
					<!-- /.navbar-collapse -->
					<div class="clearfix"></div>
				</div>
				<!-- /.container -->
			</div>
		</nav>
		<!-- //navbar ends here -->
		<!-- banner -->
		<div class="banner-bg-inner">
			<!-- banner-text -->
			<div class="banner-text-inner">
				<div class="container">
					<h2 class="title-inner">
						world of reading
					</h2>

				</div>
			</div>
			<!-- //banner-text -->
		</div>
		<!-- //banner -->
		<!-- breadcrumbs -->
		<div class="crumbs text-center">
			<div class="container">
				<div class="row">
					<ul class="btn-group btn-breadcrumb bc-list">
						<li class="btn btn1">
							<a href="index.jsp">
								<i class="glyphicon glyphicon-home"></i>
							</a>
						</li>
						<li class="btn btn2">
							<a href="book.jsp">book catalogue</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!--//breadcrumbs ends here-->
		<!-- Shop -->
		<div class="innerf-pages section">
			<div class="container-cart">
				<!-- product left -->
				<div class="side-bar col-md-3">
					<!--preference -->
					<div class="left-side">
						<h3 class="shopf-sear-headits-sear-head">
							Categories</h3>
						<ul>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">Book</span>
							</li>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">Magazine</span>
							</li>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">CD</span>
							</li>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">Newspaper</span>
							</li>
						</ul>
					</div>
					<!-- // preference -->
					<div class="search-hotel">
						
							
						<form action="<%=UrlConstant.BOOK_SERVLET %>" method="post">
							<input type="search" placeholder="search here" name="search" required="">
							<input type="submit" name="submit" value="Search">
						</form>
					</div>
					<!--preference -->
					<div class="left-side">
						<h3 class="shopf-sear-headits-sear-head">
							<span>latest</span> arrivals</h3>
						<ul>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">last 30 days</span>
							</li>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">last 90 days</span>
							</li>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">last 150 days</span>
							</li>

						</ul>
					</div>
					<!-- // preference -->
					<!-- discounts -->
					<div class="left-side">
						<h3 class="shopf-sear-headits-sear-head">Language</h3>
						<ul>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">English</span>
							</li>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">Spanish</span>
							</li>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">Japanese</span>
							</li>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">German</span>
							</li>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">Korean</span>
							</li>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">Chinese</span>
							</li>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">French</span>
							</li>
						</ul>
					</div>
					<!-- //discounts -->
					<!-- Binding -->
					<div class="left-side">
						<h3 class="shopf-sear-headits-sear-head">Format</h3>
						<ul>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">Hardcover</span>
							</li>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">Board Book</span>
							</li>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">Bundle</span>
							</li>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">Paperback</span>
							</li>
							<li>
								<input type="checkbox" class="checked">
								<span class="span">Audio Book</span>
							</li>
						</ul>
					</div>
					<!-- //Binding -->
					<!-- reviews -->
					<div class="customer-rev left-side">
						<h3 class="shopf-sear-headits-sear-head">Customer Review</h3>
						<ul>
							<li>
								<a href="#">
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star" aria-hidden="true"></i>
									<span>5.0</span>
								</a>
							</li>
							<li>
								<a href="#">
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star-o" aria-hidden="true"></i>
									<span>4.0</span>
								</a>
							</li>
							<li>
								<a href="#">
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star-half-o" aria-hidden="true"></i>
									<i class="fa fa-star-o" aria-hidden="true"></i>
									<span>3.5</span>
								</a>
							</li>
							<li>
								<a href="#">
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star-o" aria-hidden="true"></i>
									<i class="fa fa-star-o" aria-hidden="true"></i>
									<span>3.0</span>
								</a>
							</li>
							<li>
								<a href="#">
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star" aria-hidden="true"></i>
									<i class="fa fa-star-half-o" aria-hidden="true"></i>
									<i class="fa fa-star-o" aria-hidden="true"></i>
									<i class="fa fa-star-o" aria-hidden="true"></i>
									<span>2.5</span>
								</a>
							</li>
						</ul>
					</div>
					<!-- //reviews -->


				</div>
				<!-- //product left -->
				<!-- product right -->
				<%List<BookModel> bookList=BookService.getAllBook(); %>
<%BookModel bookmodel=(BookModel)session.getAttribute(RequestAttribute.BOOK_SESSION); %>
				<div class="left-ads-display col-md-9">
					<div class="wrapper_top_shop">
						<!-- product-sec1 -->
						<div class="product-sec1">
							<!-- row1-->
							<%int no=1; %>
							<%for(BookModel book:bookList){ %>
							<div class="col-md-3 product-men">
								<div class="product-chr-info chr">
									<div class="thumbnail">
								
											<img src="<%=book.getImg() %>" alt="">
										
									</div>
									<div class="caption">
										<h4><%=book.getBookname() %></h4>
										<p><%=book.getAuthor() %></p>
										<p><%=book.getCategory() %></p>
										<div class="matrlf-mid">
											<p>Price <%=book.getPrice() %></p>
											<p>Remain <%=book.getRemain() %></p>
											<p><%=book.getDescribe() %></p>
											
											<div class="clearfix"> </div>
										</div>
										<form action="<%=UrlConstant.BOOK_SERVLET %>" method="post">
											<input type="hidden" name="cmd" value="_cart">
											<input type="hidden" name="add" value="1">
											<input type="hidden" name="id" value="<%=book.getId() %>" />
											<input type="hidden" name="bookname" value="<%=book.getBookname()%>"/>
											<input type="hidden" name="img" value="<%=book.getImg()%>"/>
											<input type="hidden" name="author" value="<%=book.getAuthor() %>"/>
											<input type="hidden" name="remain" value="<%=book.getRemain()%>">
											<%String button;
											if(book.getRemain().equals("0")){
												button="Reserve";
											}
											else{
												button="Borrow";
											}
											%>
											<input type="submit" name="submit" value="<%=button %>" class="chr-cart pchr-cart"/>
										
											<a href="#" data-toggle="modal" data-target="#myModal1"></a>
										</form>
									</div>
								</div>
							</div>
							
							<%no++; %>
 							<%} %>
							
							<div class="clearfix"></div>

						</div>

						<!-- //product-sec1 -->
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="clearfix"></div>

			</div>
		</div>
		<!--// Shop -->
 <!-- footer -->
 <div class="footer-bottom section">
	<div class="container">
		<!-- footer grids-->
		<div class="footer-cpy">
			<!-- footer-grid1 -->
			<div class="col-md-3 col-sm-6 footer-logo">
				<h3>
					<a href="index.jsp">Chronicle</a>
				</h3>
				<h4>about us</h4>
				<p>Vallis Molestie Arcu Morbi Dapibus Suscipit Ante Sit Efficitur Eu estie Arcu Mor Anestie Ate Vesti.</p>
			</div>
			<!-- //footer-grid1 -->
			<!-- footer-grid2 -->
			<div class="col-md-3 col-sm-6 footer-nav text-center">
				<h4>navigation</h4>
				<ul>
					<li>
						<a href="index.jsp">Home</a>
					</li>
					<li>
						<a href="about.jsp">About us</a>
					</li>
					<li>
						<a href="book.jsp">check</a>
					</li>
					<li>
						<a href="contact.jsp">contact us</a>
					</li>
				</ul>
			</div>
			<!-- //footer-grid2 -->
			<!-- footer-grid3 -->
			<div class="col-md-3 col-sm-6 blog-footer">
				<h4>latest from blog</h4>
				<div class="blog1">
					<div class="col-md-3 col-sm-3 col-xs-2 bl1">
						<a href="#">
							<img src="images/b1.jpg" alt="" class="img-responsive" />
						</a>
					</div>
					<div class="col-md-9 col-sm-9 col-xs-10 bl2">
						<a href="#">Dapibus Suscipit Ante Sit by instagram</a>
						<p>February 15, 2018</p>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="blog1">
					<div class="col-md-3 col-sm-3 col-xs-2 bl1">
						<a href="#">
							<img src="images/b2.jpg" alt="" class="img-responsive" />
						</a>
					</div>
					<div class="col-md-9 col-sm-9 col-xs-10 bl2">
						<a href="#">Dapibus Suscipit Ante Sit by instagram</a>
						<p>February 20, 2018</p>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<!-- //footer-grid3 -->
			<!-- footer-grid4 -->
			<div class="col-md-3 col-sm-6 contact-foot text-right">
				<h4>contact us</h4>
				<ul>
					<li>
						<span class="fa fa-home"></span>
						NIIT Training Center
						<br> NanTong.
					</li>
					<li>
						<span class="fa fa-phone"></span>
						+12 345 678
					</li>
					<li>
						<span class="fa fa-envelope"></span>
						<a href="mailto:info@example.com">ranjin898@hotmail.com</a>
					</li>
				</ul>
			</div>
			<!-- //footer-grid4 -->
			<div class="clearfix"></div>
		</div>
		<!-- //footer-grids -->
	</div>
	<!-- //footer container -->
</div>
<!-- //footer -->
<div class="cpy-right">
	<p>Copyright &copy; 2018.Company name All rights reserved.
	</p>
</div>
</div>
<!-- //home -->
	<!-- js -->
	<!-- Common js -->
	<script src="js/jquery-2.2.3.min.js"></script>
	<!--// Common js -->
	<!-- cart-js -->
    <script src="js/minicart.js"></script>
	<!-- <script>
		chr.render();

		chr.cart.on('new_checkout', function (evt) {
			var items, len, i;

			if (this.subtotal() > 0) {
				items = this.items();

				for (i = 0, len = items.length; i < len; i++) {}
			}
		});
	</script>  -->
	<!-- //cart-js -->
	<!-- price range (top products) -->
	<script src="js/jquery-ui.js"></script>
	<script>
		//<![CDATA[ 
		$(window).load(function () {
			$("#slider-range").slider({
				range: true,
				min: 0,
				max: 9000,
				values: [50, 6000],
				slide: function (event, ui) {
					$("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
				}
			});
			$("#amount").val("$" + $("#slider-range").slider("values", 0) + " - $" + $("#slider-range").slider("values", 1));

		}); //]]>
	</script>
	<!-- //price range (top products) -->

	<!-- dropdown nav -->
	<script>
		$(document).ready(function () {
			$(".dropdown").hover(
				function () {
					$('.dropdown-menu', this).stop(true, true).slideDown("fast");
					$(this).toggleClass('open');
				},
				function () {
					$('.dropdown-menu', this).stop(true, true).slideUp("fast");
					$(this).toggleClass('open');
				}
			);
		});
	</script>
	<!-- //dropdown nav -->
	<!--search jQuery-->
	<script src="js/main.js"></script>
	<!--search jQuery-->

	<!-- Scrolling Nav JavaScript -->
	<script src="js/scrolling-nav.js"></script>
	<!-- //fixed-scroll-nav-js -->
	<!--//scripts-->

	<script src="js/bootstrap.js"></script>
	<!-- start-smoth-scrolling -->
	<script src="js/move-top.js"></script>
	<script src="js/easing.js"></script>
	<script>
		jQuery(document).ready(function ($) {
			$(".scroll").click(function (event) {
				event.preventDefault();
				$('html,body').animate({
					scrollTop: $(this.hash).offset().top
				}, 1000);
			});
		});
	</script>
	<!-- start-smoth-scrolling -->
	<!-- here stars scrolling icon -->
	<script>
		$(document).ready(function () {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/

			$().UItoTop({
				easingType: 'easeOutQuart'
			});

		});
	</script>
	<!-- //here ends scrolling icon -->
	<!-- smoothscroll -->
	<script src="js/SmoothScroll.min.js"></script>
	<!-- //smoothscroll -->

</body>

</html>