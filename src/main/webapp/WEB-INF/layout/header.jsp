<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!-- Header Begin 
	================================================== -->
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title>SocialIn</title>
	
	    <!-- Bootstrap core CSS -->
	    <link href="<s:url value="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet">
	    <!-- Bootstrap theme -->
	    <link href="<s:url value="/resources/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" />" rel="stylesheet">
	    
	    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="<s:url value="/resources/homemade/css/ie10-viewport-bug-workaround.css" />" rel="stylesheet">
	
	    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	    <!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
	    
	    
	    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
	    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
	    <script src="<s:url value="/resources/homemade/js/ie-emulation-modes-warning.js" />"></script>
	
	    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	    <!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
	    
	    
	    <!-- Bootstrap core JavaScript
	    ================================================== -->
	    <!-- Placed at the end of the document so the pages load faster -->
	    <script src="<s:url value="/resources/jquery-1.12.4/js/jquery.min.js" />"></script>
	    <script>window.jQuery || document.write('<script src="<s:url value="/resources/jquery-1.12.4/js/jquery.min.js" />"><\/script>')</script>
	    <script src="<s:url value="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js" />"></script>
	    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	    <script src="<s:url value="/resources/homemade/js/ie10-viewport-bug-workaround.js" />"></script>
	    

	
	   <nav class="navbar navbar-inverse navbar-fixed-top">
	   
	     <div class="container">
	       <div class="navbar-header">
	         <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
	           <span class="sr-only">Toggle navigation</span>
	           <span class="icon-bar"></span>
	           <span class="icon-bar"></span>
	           <span class="icon-bar"></span>
	         </button>
	         <a class="navbar-brand" href="user/user">SocialIn</a><!-- class="" This will make this appear in the left of panel-->
	       </div>
	       
	       <div class="navbar-collapse collapse">
	           <ul class="nav navbar-nav">
	            <li > <!-- class="active" --> <a href="<s:url value="home" />" >En/CHN</a></li>
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin <span class="caret"></span>
	              </a>
	             <ul class="dropdown-menu">
	               <li><a href="#">User Management</a></li>
	               <li><a href="#">Permission Management</a></li>
	               <li role="separator" class="divider"></li>
	               <li class="dropdown-header">Group Related</li>
	               <li><a href="#">Group Management</a></li>
	             </ul>
	            </li>
	           </ul>
	  	            
			   <div class="col-sm-3 col-md-3">
			        <form class="navbar-form" role="search">
				        <div class="input-group">
				            <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
				            <div class="input-group-btn">
				                <button class="btn btn-primary" type="submit">  _<i class="glyphicon glyphicon-search"></i> </button> <!--  -->
				            </div>
				        </div>
			        </form>
			  </div>
	  

	        <ul class="nav navbar-nav navbar-right">
	           <li><a href="user/signup"><span class="glyphicon glyphicon-user"></span> Sign Up </a></li>
	           <li><a href="user/signin"><span class="glyphicon glyphicon-log-in"></span> Sign In </a></li>
	       </ul>

	     
	        </div><!--/.nav-collapse -->
	       
	     </div> <!--/.container  -->
	   </nav>
	   
	<!-- Header End 
	================================================== -->