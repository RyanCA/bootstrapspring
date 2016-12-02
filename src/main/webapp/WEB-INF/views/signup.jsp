
       
       <!-- The taglib must put here even though the same line already in header.jsp
            otherwise the following link href will not get the right value -->
            
        <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>	   
	    <!-- Custom styles for this template -->
	    <link href="<s:url value="/resources/homemade/css/signin.css" />" rel="stylesheet">
	    
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
	   
	    <div class="container">
<!-- 
	      <form class="form-signin">
	        <h2 class="form-signin-heading">Join App today</h2>
	        
	        <label for="firstName" class="sr-only">First Name</label>
	        <input type="text" id="firstName" class="form-control" placeholder="First name" required autofocus>
	        
	        <label for="lastName" class="sr-only">Last name</label>
	        <input type="text" id="lastName" class="form-control" placeholder="Last name">
	        
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
	      
-->
	      
			<!-- commandName mapping to the the key of spitter in controller model -->
			<!-- Special attributes of Spring form JSP tag: 1. path: Path to property for data binding -->
			<!-- Special attributes of Spring form JSP tag: 2. cssClass: Equivalent to "class" HTML Optional Attribute -->
			<!-- sf:errors Path to errors object for data binding -->
			<!-- html style: (required autofocus); sf:html style: (required="required" autofocus="autofocus") -->
			
			<!-- commandName="user" used to associate the UI model with form fields, please also define it in controller class -->
		    <sf:form method="POST" commandName="user" cssClass="form-signin"> 
		             
		             <h2 class="form-signin-heading">Join App today</h2>
			        
			        <sf:label for="firstname" path="firstname" cssClass="sr-only">First Name</sf:label>
			        <sf:input type="text" path="firstname" cssClass="form-control" placeholder="First name" required="required" autofocus="autofocus" /> 
			        <sf:errors path="firstname" cssClass="error" />
			        
			        <sf:label for="lastname" path="lastname" cssClass="sr-only">Last name</sf:label>
			        <sf:input type="text" path="lastname" cssClass="form-control" placeholder="Last name" />
			        <sf:errors path="lastname" cssClass="error" />
			        
			        <sf:label for="account" path="account" cssClass="sr-only">Account</sf:label>
			        <sf:input type="text" path="account" cssClass="form-control" placeholder="Account"/>
			        <sf:errors path="account" cssClass="error" />
			        
			        <sf:label for="email" path="email" cssClass="sr-only">Email address</sf:label>
			        <sf:input type="email" path="email" cssClass="form-control" placeholder="Email address" />
			        <sf:errors path="email" cssClass="error" />
			        
			        <sf:label for="password" path="password" cssClass="sr-only">Password</sf:label>
			        <sf:input type="password" path="password" cssClass="form-control" placeholder="Password" required="required" />
			        <sf:errors path="password" cssClass="error" />
			        
			        <div class="checkbox">
			          <label>
			            <input type="checkbox" value="remember-me"> Remember me
			          </label>
			        </div>
			        
			        <button class="btn btn-lg btn-primary btn-block" type="submit" value="signup">Sign up</button>
		             
		    </sf:form>
	
	    </div> <!-- /container -->
	   
      