<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet">
    <style type="text/css">
        html { height: 100% }
        body { height: 100%; margin: 0; padding: 0 }
        #map-canvas { height: 50% }
    </style>
  </head>
  <body> 
    <div id="map-canvas"> </div>
    <div class="container">
    	<div class="row">
    		<div class="span2">
    		<svg xmlns="http://www.w3.org/2000/svg" version="1.1">
  				<circle cx="100" cy="100" r="60" stroke="black" stroke-width="2" fill="blue" fill-opacity="0.2"/>
  				<text x="100" y="100" fill="black" id="accident">5</text>
  				<text x="80" y="180" fill="black">Accident</text>
			</svg>
    		</div>
    		<div class="span2">
    		<svg xmlns="http://www.w3.org/2000/svg" version="1.1">
  				<circle cx="100" cy="100" r="60" stroke="black" stroke-width="2" fill="blue" fill-opacity="0.2"/>
  				<text x="100" y="100" fill="black" id="trafficjam">5</text>
 				<text x="80" y="180" fill="black">Traffic Jam</text>
			</svg>
    		</div>
    		<div class="span2">
    		<svg xmlns="http://www.w3.org/2000/svg" version="1.1">
  				<circle cx="100" cy="100" r="60" stroke="black" stroke-width="2" fill="blue" fill-opacity="0.2"/>
  				<text x="100" y="100" fill="black" id="robbery">5</text>
 				<text x="80" y="180" fill="black">Robbery</text>
			</svg>
    		</div>
    		<div class="span2">
    		<svg xmlns="http://www.w3.org/2000/svg" version="1.1">
  				<circle cx="100" cy="100" r="60" stroke="black" stroke-width="2" fill="blue" fill-opacity="0.2"/>
  				<text x="100" y="100" fill="black" id="bribe">5</text>
 				<text x="80" y="180" fill="black">Bribe</text>
			</svg>
    		</div>
    		<div class="span2">
    		<svg xmlns="http://www.w3.org/2000/svg" version="1.1">
  				<circle cx="100" cy="100" r="60" stroke="black" stroke-width="2" fill="blue" fill-opacity="0.2"/>
  				<text x="100" y="100" fill="black" id="others">5</text>
 				<text x="80" y="180" fill="black">Others</text>
			</svg>
    		</div>
    	</div>
    </div>
    
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDA6yY69rxUy4z8mpROQQ7FGIsQary3lPU&sensor=true"></script>
    <script type="text/javascript" src="scripts/index.js"></script>
    
  </body>
</html>