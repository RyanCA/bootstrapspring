      
       <!-- The taglib must put here even though the same line already in header.jsp
            otherwise the following link href will not get the right value -->
            
        <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>	
	    <!-- Custom styles for this template -->
	    <link href="<s:url value="/resources/homemade/css/signin.css" />" rel="stylesheet">

	    <div class="container">

	      <form class="form-signin">
	        <h2 class="form-signin-heading">Sign in</h2>
	        
	        <label for="inputEmail" class="sr-only">Email address</label>
	        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" >
	        
	        <label for="inputPassword" class="sr-only">Password</label>
	        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
	        
	        <div class="checkbox">
	          <label>
	            <input type="checkbox" value="remember-me"> Remember me
	          </label>
	        </div>
	        
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
	      </form>
	
	    </div> <!-- /container -->
	   