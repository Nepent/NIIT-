<%@page import="com.niit.constants.UrlConstant"%>
<%@page import="com.niit.constants.MessageConstant" %>
<%@page import="com.niit.constants.RequestAttribute"%>
<%@page import="com.niit.constants.ViewConstant"%>
<%@page import="com.niit.service.UserService"%>
<%@page import="java.util.List"%>
<%@page import="com.niit.model.UserModel" %>
<%@page import="com.niit.model.BookModel" %>
<%@page import="com.niit.model.BorrowModel" %>
<%@page import="com.niit.service.BookService"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <title>Borrow</title>
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
                            <li>
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
									<button style="dispaly: none;" name="submit" type="submit" value="Search" ></button>
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
                            <a href="book.jsp">User Report</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!--//breadcrumbs ends here-->
        <!--checkout-->
        <div class="innerf-pages section">
            <div class="container">
                <div class="privacy about">
                    <h4 class="rad-txt">
                        <span class="abtxt1"><a href="waitfor.jsp">request book</a></span>
                        <span class="abtext"><a href="checkout.jsp">borrow book</a></span>
                        <span class="abtxt1"><a href="reserve.jsp">reserve book</a></span>
                        <span class="abtext"><a href="return.jsp">return book</a></span>
                    </h4>
                    <%String user_name=(String)request.getSession().getAttribute(RequestAttribute.LOGIN_SESSION); %>
                   <%List<BorrowModel> bookList=BookService.getAllBook2(user_name); %>
                            <%if(bookList!=null && !bookList.isEmpty()){ %>
                            
                    <%String msg=(String)request.getAttribute(RequestAttribute.MSG);
                if(msg!=null)
                {%>
                	<h3 style="color: red; margin:0 auto"><%=msg %></h3>
                <%}
                %>
                    <br>
                    <div class="creditly-card-form shopf-sear-headinfo_form">
                    <div class="checkout-right">
                        <table class="timetable_sub table-responsive">
                            <thead>
                                <tr>
                                    <th>SL No.</th>
                                    <th>Product</th>
                                    
                                    <th>Book Name</th>
                                    <th>Author</th>
                                    <th>Remain</th>
                                    <th>Borrow Time</th>
                                    <th>Return Book</th>
                                    <th>Lost</th>
                                </tr>
                            </thead>
                            
                            <tbody>
                            
                            
                            <%int no=1; %>
                            <%for(BorrowModel model: bookList){ %>
                           
                                <tr class="rem1">
                                    <td class="invert"><%=no %></td>
                                    <td class="invert-image">
                                        <img src="<%=model.getImg() %>" alt=" " class="img-responsive">
                                    </td>
                                    <td class="invert"> <%=model.getBookname() %></td>
                                    <td class="invert"><%=model.getAuthor() %></td>
                                    <td class="invert"><%=model.getRemain() %></td>
                                    <td class="invert"><%=model.getDate() %></td>
                                     
                                    <td class="invert">
                                   
                                        <div class="rem">
                                         <form action="<%=UrlConstant.BOOK_SERVLET %>" method="post">
                                          <input type="hidden" name="id" value="<%=model.getId() %>" />
                                          <input type="hidden" name="book_id" value="<%=model.getBook_id() %>">
									      <input type="hidden" name="bookname" value="<%=model.getBookname()%>"/>
									      <input type="hidden" name="img" value="<%=model.getImg()%>"/>
									      <input type="hidden" name="author" value="<%=model.getAuthor() %>"/>
									      <input type="hidden" name="remain" value="<%=model.getRemain()%>">
									      <input type="hidden" name="date" value="<%=model.getDate()%>"/>
                                          <input type="submit" name="submit" value="Return"  class="chr-cart pchr-cart"/>
                                         </form>
                                        </div>
                                       
                                    </td>
                                     <td class="invert">
                                   
                                        <div class="rem">
                                         <form action="<%=UrlConstant.BOOK_SERVLET %>" method="post">
                                          <input type="hidden" name="id" value="<%=model.getId() %>" />
                                          <input type="hidden" name="book_id" value="<%=model.getBook_id() %>">
									      <input type="hidden" name="bookname" value="<%=model.getBookname()%>"/>
									      <input type="hidden" name="img" value="<%=model.getImg()%>"/>
									      <input type="hidden" name="author" value="<%=model.getAuthor() %>"/>
									      <input type="hidden" name="remain" value="<%=model.getRemain()%>">
									      <input type="hidden" name="date" value="<%=model.getDate()%>"/>
                                          <input type="submit" name="submit" value="Book Lost"  class="chr-cart pchr-cart"/>
                                         </form>
                                        </div>
                                       
                                    </td>
                                    
                                </tr>
                                <%no++; %>
 							<%}%>
 

                            </tbody>
                        </table>
                    </div>
                        </div>
                        <%}else{  %>
                         <h3 style="color:red">You haven't borrowed any books yet.</h3><br>
		                 
                        <%} %>
                        <div class="clearfix"> </div>
                        <br>
                        <br>
                        <h3><a href="book.jsp">Go to borrow books!</a></h3>
                    </div>

                </div>

            </div>
        </div>
        <!--//checkout-->
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

    <!-- Common js -->
    <script src="js/jquery-2.2.3.min.js"></script>
    <!--// Common js -->
    <!-- cart-js -->
    <script src="js/minicart.js"></script>
    <script>
        chr.render();

        chr.cart.on('new_checkout', function (evt) {
            var items, len, i;

            if (this.subtotal() > 0) {
                items = this.items();

                for (i = 0, len = items.length; i < len; i++) {}
            }
        });
    </script>
    <!-- //cart-js -->
    <!--quantity-->
    <script>
        $('.value-plus').on('click', function () {
            var divUpd = $(this).parent().find('.value'),
                newVal = parseInt(divUpd.text(), 10) + 1;
            divUpd.text(newVal);
        });

        $('.value-minus').on('click', function () {
            var divUpd = $(this).parent().find('.value'),
                newVal = parseInt(divUpd.text(), 10) - 1;
            if (newVal >= 1) divUpd.text(newVal);
        });
    </script>
    <!--quantity-->
    <!-- FadeOut-Script -->
    <script>
        $(document).ready(function (c) {
            $('.close1').on('click', function (c) {
                $('.rem1').fadeOut('slow', function (c) {
                    $('.rem1').remove();
                });
            });
        });
    </script>
    <script>
        $(document).ready(function (c) {
            $('.close2').on('click', function (c) {
                $('.rem2').fadeOut('slow', function (c) {
                    $('.rem2').remove();
                });
            });
        });
    </script>
    <script>
        $(document).ready(function (c) {
            $('.close3').on('click', function (c) {
                $('.rem3').fadeOut('slow', function (c) {
                    $('.rem3').remove();
                });
            });
        });
    </script>
    <!--// FadeOut-Script -->

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
    <!-- start-smooth-scrolling -->
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
    <!-- //end-smooth-scrolling -->
    <!-- smooth-scrolling-of-move-up -->
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
    <script src="js/SmoothScroll.min.js"></script>
    <!-- //smooth-scrolling-of-move-up -->
    <!-- Bootstrap core JavaScript
 ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.js"></script>
</body>

</html>