<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"  %>

<%@ page session="false" %>



      
	<!-- Body 
	================================================== -->
		    
    <!-- Custom styles for this template -->
    <link href="<s:url value="/resources/homemade/css/carousel.css" />" rel="stylesheet">
    <!-- Just to make our placeholder images work. If there is no image there -->
    <script src="<s:url value="/resources/homemade/js/holder.min.js" />"></script>
    
    
     <!-- Override properties of css file -->

<!-- 
     <style>
		body {
		     background-color: #eee;
		}
		.carousel {
		    height: 554px;
		    margin-bottom: 20px;
		}
		.carousel .item {
		    height: 554px;
		}
		.carousel-inner > .item > img {
		  height: 554px;
		}
		
		.marketing .col-lg-4 {
		  margin-bottom: 20px;
		}

	 </style>
 -->


    
    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="<s:url value="/resources/homemade/img/slide1.png" />" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Example headline I</h1>
              <p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide" src="<s:url value="/resources/homemade/img/slide2.png" />" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Example headline II</h1>
              <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide" src="<s:url value="/resources/homemade/img/slide3.png" />" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Example headline III</h1>
              <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->



      <!-- START THE FEATURETTES
      ================================================= -->

     <!-- Wrap the rest of the page in another container to center all the content. -->
     <div class="container marketing">
	      <hr class="featurette-divider">
	
	      <div class="row featurette">
	        <div class="col-md-7">
	          <h2 class="featurette-heading">First featurette heading. <span class="text-muted">It'll blow your mind.</span></h2>
	          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
	        </div>
	        <div class="col-md-5">
	          <img class="featurette-image img-responsive center-block" src="<s:url value="/resources/homemade/img/story1.png" />" alt="Generic placeholder image">
	        </div>
	      </div>
	
	      <hr class="featurette-divider">
	
	      <div class="row featurette">
	        <div class="col-md-7 col-md-push-5">
	          <h2 class="featurette-heading">Oh yeah, it's that good. <span class="text-muted">See for yourself.</span></h2>
	          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
	        </div>
	        <div class="col-md-5 col-md-pull-7">
	          <img class="featurette-image img-responsive center-block" src="<s:url value="/resources/homemade/img/story2.png" />" alt="Generic placeholder image">
	        </div>
	      </div>
	
	      <hr class="featurette-divider">
	
	      <div class="row featurette">
	        <div class="col-md-7">
	          <h2 class="featurette-heading">And lastly, this one. <span class="text-muted">Checkmate.</span></h2>
	          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
	        </div>
	        <div class="col-md-5">
	          <img class="featurette-image img-responsive center-block" src="<s:url value="/resources/homemade/img/story3.png" />" alt="Generic placeholder image">
	        </div>
	      </div>
	
	      <hr class="featurette-divider">
      
      </div><!-- ./container marketing -->