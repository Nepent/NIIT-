<!-- created by :-n
created date:-12/9/2018
updated by:-null
updated date:-null -->

<%@page import="com.niit.constants.UrlConstant"%>
<%@page import="com.niit.constants.RequestAttribute"%>
<%@page import="com.niit.constants.ViewConstant"%>
<%@page import="com.niit.service.UserService"%>
<%@page import="java.util.List"%>
<%@page import="com.niit.model.UserModel" %>
<%@page import="com.niit.model.BookModel" %>
<%@page import="com.niit.model.BorrowModel" %>
<%@page import="com.niit.model.ReserveModel" %>
<%@page import="com.niit.model.RequestModel" %>
<%@page import="com.niit.model.ReturnModel" %>
<%@page import="com.niit.model.LostModel" %>
<%@page import="com.niit.service.BookService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
    <!-- shop css -->
    <link href="css/shop.css" type="text/css" rel="stylesheet" media="all">
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
    <link href="css/tab.css" type="text/css" rel="stylesheet">
    
    <style type="text/css">
table.hovertable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
	margin: 40px auto;
}
table.hovertable th {
	background-color:#c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.hovertable tr {
	background-color:#d4e3e5;
}
table.hovertable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
</style>
    
    
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
       
     <div style="height: 800px;">
     
     <div class="comma">
    <div class="" style="width: 100%;margin: 0 auto;">
        <div class="arcile">
            <h1>Admin</h1>
            <div class="info-meu">
                <ul>
                <li onclick="showPanal1(this)">
                        <a href="#panal1">Request</a>
                    </li>
               		<li onclick="showPanal1(this)">
                        <a href="#panal2">Report</a>
                    </li>
                    <li onclick="showPanal1(this)">
                        <a href="#panal3">User Model</a>
                    </li>
                    <li onclick="showPanal1(this)">
                        <a href="#panal4">Book Model</a>
                    </li>
                     <li onclick="showPanal1(this)">
                        <a href="#panal4">News</a>
                    </li>
                </ul>
            </div>

        </div>
        <div class="">
        
        <div class="panal" style="display: block;">
                <div class="tab">
                </div>
                <div class="content">
                   
                       <%List<RequestModel> requestmd=BookService.getAllRequest(); %>
                       <%String msg=(String)request.getAttribute(RequestAttribute.MSG);
                if(msg!=null)
                {%>
                	<h3 style="color: red; margin:0 auto"><%=msg %></h3>
                <%}
                %>
                        <table class="hovertable">
<tr>
<th>SR NO</th>
<th>USER</th>
<th>BOOKNAME</th>
<th>AUTHOR</th>
<th>REMAIN</th>
<th>DATE</th>
<th>REQUEST</th>
<th>AGREE</th>
<th>REFUSE</th>
</tr>
<%int s=1; %>
<%for(RequestModel rq:requestmd){ %>
<tr>
	<td><%=s %></td>
	<td><%=rq.getUser_name() %></td>
	<td><%=rq.getBookname() %></td>
	<td><%=rq.getAuthor() %></td>
	<td><%=rq.getRemain() %></td>
	<td><%=rq.getDate() %></td>
	<td><%=rq.getOp() %></td>
	<td><form action="<%=UrlConstant.BOOK_SERVLET%>" method="post">
	<input type="hidden" name="id" value="<%=rq.getId() %>">
	<input type="hidden" name="bookname" value="<%=rq.getBookname() %>">
	<input type="hidden" name="author" value="<%=rq.getAuthor()%>">
	<input type="hidden" name="remain" value="<%=rq.getRemain()%>">
	<input type="hidden" name="user_name" value="<%=rq.getUser_name()%>">
	<input type="hidden" name="book_id" value="<%=rq.getBook_id() %>">
	<input type="hidden" name="img" value="<%=rq.getImg() %>">
	<input type="hidden" name="operation" value="<%=rq.getOp() %>">
	<button type="submit" name="submit" value="Agree" style="border:none;background:url(images/agree.png) no-repeat;width:30px;height:30px;" ></button>
	</form></td>
	
	
	<td><form action="<%=UrlConstant.BOOK_SERVLET%>" method="post">
	<input type="hidden" name="id" value="<%=rq.getId() %>">
	<input type="hidden" name="bookname" value="<%=rq.getBookname() %>">
	<input type="hidden" name="operation" value="<%=rq.getOp() %>">
	<input type="hidden" name="user_name" value="<%=rq.getUser_name()%>">
	<button type="submit" name="submit" value="Refuse" style="border:none;background:url(images/refuse.png) no-repeat;width:30px;height:30px;" ></button></form></td>	
</tr>
<%s++;
} %>

                        </table>
                </div>
            </div>

<div class="panal">
                <div class="tab">
                    <a href="##" class="on" onclick="showLi(this)">Borrow Book</a>
                    <a href="##" onclick="showLi(this)">Reserve Book</a>
                    <a href="##" onclick="showLi(this)">Return Book</a>
                    <a href="##" onclick="showLi(this)">Lost Book</a>
                    
                </div>
                <div class="content">
               <!--   <form>
                <div style="display:inline-block;">
                    <select name="user_select" style="height:20px;">
	                <option>All users</option>
	                <option>Admin</option>
	                <option>Student</option>
	                </select>
	                </div>
	                <input type="date" name="op_date" style="height:20px; margin-left:20px;">
	                <button type="submit" name="submit" value="submit" style="border:none;background:url(images/lens.png) no-repeat;width:20px;height:20px;" ></button>
                </form>-->
                
                
<ul>
                        <li style="display: block;">
                        <%List<BorrowModel> borrow=BookService.getAllBorrow(); %>
<table class="hovertable">
<tr>
<th>SR NO</th>
<th>User Name</th>
<th>BOOKNAME</th>
<th>AUTHOR</th>
<th>REMAIN</th>
<th>BORROW DATE</th>
<th>Latest Time</th>

</tr>
<%int n=1; %>
<%for(BorrowModel book:borrow){ %>
<tr>
	<td><%=n %></td>
	<td><%=book.getUser_name() %></td>
	<td><%=book.getBookname() %></td>
	<td><%=book.getAuthor() %></td>
	<td><%=book.getRemain() %></td>
	<td><%=book.getDate() %></td>
	<td><%=book.getLatest_time() %></td>
</tr>
<%n++; %>
 <%} %>
 
</table>
                        </li>
                        <li>
                        <%List<ReserveModel> reserve=BookService.getAllReserve(); %>
<table class="hovertable">
<tr>
<th>SR NO</th>
<th>BOOKNAME</th>
<th>AUTHOR</th>
<th>REMAIN</th>
<th>RESERVE DATE</th>
<th>RESERVE USER</th>

</tr>
<%int k=1; %>
<%for(ReserveModel book:reserve){ %>
<tr>
	<td><%=k %></td>
	<td><%=book.getBookname() %></td>
	<td><%=book.getAuthor() %></td>
	<td><%=book.getRemain() %></td>
	<td><%=book.getDate() %></td>
	<td><%=book.getUser_name() %></td>
		
</tr>
<%k++; %>
 <%} %>
 
</table>
                        </li>
                        
                         <li>
                        <%List<ReturnModel> rm=BookService.getAllReturn(); %>
<table class="hovertable">
<tr>
<th>SR NO</th>
<th>BOOKNAME</th>
<th>AUTHOR</th>
<th>REMAIN</th>
<th>RESERVE DATE</th>
<th>RESERVE USER</th>
<th>STATUS</th>
</tr>
<%int i=1; %>
<%for(ReturnModel book:rm){ %>
<tr>
	<td><%=i %></td>
	<td><%=book.getBookname() %></td>
	<td><%=book.getAuthor() %></td>
	<td><%=book.getRemain() %></td>
	<td><%=book.getDate() %></td>
	<td><%=book.getUser_name() %></td>
    <td><%=book.getOp() %></td>
</tr>
<%i++; %>
 <%} %>
 
</table>
                        </li>
                        <li>
                        <%List<LostModel> lost=BookService.getAllLost(); %>
<table class="hovertable">
<tr>
<th>SR NO</th>
<th>BOOKNAME</th>
<th>AUTHOR</th>
<th>REMAIN</th>
<th>RESERVE DATE</th>
<th>RESERVE USER</th>

</tr>
<%int h=1; %>
<%for(LostModel book:lost){ %>
<tr>
	<td><%=k %></td>
	<td><%=book.getBookname() %></td>
	<td><%=book.getAuthor() %></td>
	<td><%=book.getRemain() %></td>
	<td><%=book.getDate() %></td>
	<td><%=book.getUser_name() %></td>
		
</tr>
<%h++; %>
 <%} %>
 
</table>
                        </li>
                        
                    </ul>
                </div>
            </div>


            <div class="panal" >
                <div class="tab">
                </div>
                <div class="content">
                   <%List<UserModel> userList=UserService.getAllUser(); %>
<%UserModel usermodel=(UserModel)session.getAttribute(RequestAttribute.USER_SESSION); %>
<table class="hovertable">
<tr>
<th>SR NO</th>
<th>USERNAME</th>
<th>PASSWORD</th>
<th>EMAIL</th>
<th>IDENTITY</th>
<th>PHONE NO</th>
<th>STATUS</th>
<th>CREATED DATE</th>
<th>EDIT</th>
<th>DELETE</th>
<th>BLOCK/ACTIVE</th>
</tr>
<%int srno=1; %>
<%for(UserModel user:userList){ %>
<tr>
	<td><%=srno %></td>
	<td><%=user.getUsername() %></td>
	<td><%=user.getPassword() %></td>
	<td><%=user.getEmail() %></td>
	<td><%=user.getIdentity() %></td>
	<td><%=user.getPhone() %></td>
	<td><%if(user.getFlag()==1){ %>ACTIVE<%}else{ %>BLOCK<%} %>	</td>
	<td><%=user.getDate() %></td>
	<td><form action="<%=UrlConstant.ADMIN_SERVLET%>" method="post">
	<input type="hidden" name="id" value="<%=user.getId()%>" />
	<button type="submit" name="submit" value="Edit" style="border:none;background:url(images/edit.png) no-repeat;width:30px;height:30px;" ></button>
	</form> </td>
	
	<td><form action="<%=UrlConstant.ADMIN_SERVLET%>" method="post">
	<input type="hidden" name="id" value="<%=user.getId()%>" />
	<button type="submit" name="submit" value="Delete" style="border:none;background:url(images/delete.png) no-repeat;width:30px;height:30px;" ></button>
	</form> </td>
	
	<%if(user.getFlag()==1){ %>
	<td><form action="<%=UrlConstant.ADMIN_SERVLET%>" method="post">
	<input type="hidden" name="id" value="<%=user.getId() %>" />
	<button type="submit" name="submit" value="Block" style="border:none;background:url(images/lock.png) no-repeat;width:30px;height:30px;" ></button>
	</form></td>
	<%}else{%>
		<td><form action="<%=UrlConstant.ADMIN_SERVLET%>" method="post">
		<input type="hidden" name="id" value="<%=user.getId() %>" />
		<button type="submit" name="submit" value="Active" style="border:none;background:url(images/unlock.png) no-repeat;width:30px;height:30px;" ></button>
		</form></td>
		
	<% } %>
</tr>
<%srno++; %>
 <%} %>
 
</table>
                </div>
            </div>

            <div class="panal">
                <div class="tab">
                    
                </div>
                <div class="content">
                   <%List<BookModel> bookList=BookService.getAllBook(); %>
<%BookModel bookmodel=(BookModel)session.getAttribute(RequestAttribute.BOOK_SESSION); %> <a href="addbook.jsp">ADD BOOKS</a>
<table class="hovertable">
<tr>
<th>SR NO</th>
<th>BOOKNAME</th>
<th>IMAGE</th>
<th>AUTHOR</th>
<th>PRESS</th>
<th>DESCRIBE</th>
<th>REMAIN</th>
<th>PRICE($)</th>
<th>CATEGORY</th>
<th>CREATED DATE</th>
<th>EDIT</th>
<th>DELETE</th>

</tr>
<%int no=1; %>
<%for(BookModel book:bookList){ %>
<tr>
	<td><%=no %></td>
	<td><%=book.getBookname() %></td>
	<td><%=book.getImg() %></td>
	<td><%=book.getAuthor() %></td>
	<td><%=book.getPress() %></td>
	<td><%=book.getDescribe() %></td>
	<td><%=book.getRemain() %></td>
	<td><%=book.getPrice() %>
	<td><%=book.getCategory() %></td>
	<td><%=book.getDate() %></td>
	<td><form action="<%=UrlConstant.BOOK_SERVLET%>" method="post">
	<input type="hidden" name="id" value="<%=book.getId() %>" />
	<button type="submit" name="submit" value="Edit" style="border:none;background:url(images/edit.png) no-repeat;width:30px;height:30px;" ></button>
	</form> </td>
	
	<td><form action="<%=UrlConstant.BOOK_SERVLET%>" method="post">
	<input type="hidden" name="id" value="<%=book.getId() %>" />
	<button type="submit" name="submit" value="Delete" style="border:none;background:url(images/delete.png) no-repeat;width:30px;height:30px;" ></button>
	</form> </td>
		
</tr>
<%no++; %>
 <%} %>
 
</table>
                </div>
            </div>
            
            <div class="panal">
                <div class="tab">
                    
                </div>
                <div class="content">
                  <div style="width:500px;margin:30px auto;">
                  <h4>60 seconds to read the world</h4>
                  <br>
                  <h5>You can write news about today here!</h5>
                  <br>
                  <br>
                        <form action="<%=UrlConstant.BOOK_SERVLET%>" method="post">
                        <textarea name="news" rows="10" cols="50" style="border: 2px solid #34C663;"></textarea>
<button type="submit" name="submit" value="ok" style="border:none;background:url(images/agree.png) no-repeat;width:30px;height:30px;" ></button>
                        </form>
                        
                  </div>
                        
                      
                </div>
            </div>

        </div>
    </div>

</div>

</div>

    
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
        <p>Copyright &copy; 2018.Company name All rights reserved.</p>
    </div>
<!-- //home -->
</div>
<script>
function showLi(obj) {
    $(obj).addClass('on').siblings().removeClass('on');
    var index = $(obj).index();
    //console.log($(obj).parent().parent())
    $(obj).parent().parent().find('.content li').hide();
    $(obj).parent().parent().find('.content li:eq(' + index + ')').show();
}

function showPanal1(obj) {
    $(obj).addClass('bag').siblings().removeClass('bag');
    var _index = $(obj).index();
    $('.panal').eq(_index).show('fast').siblings().hide('fast');
}
</script>
    <!-- js -->
    <script src="js/jquery-2.2.3.min.js"></script>
    <!-- //js -->
    <!--search jQuery-->
    <script src="js/main.js"></script>
    <!--search jQuery-->
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

    <!-- Scrolling Nav JavaScript -->
    <script src="js/scrolling-nav.js"></script>
    <!-- //fixed-scroll-nav-js -->
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