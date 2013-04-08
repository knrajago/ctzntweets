<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet">
    <style type="text/css">
        html { height: 100% }
        body { height: 100%; margin: 0; padding: 0 }
        #map-canvas { height: 50% }
        .span2
        {
        	background-image:url('images/circle.png');
        	text-align: center;
        	width: 140px;
        	height: 130px
        }
    </style>
  </head>
  <body> 

    <div id="map-canvas"> </div>
    <div class="container">
    	<br><br>
    	<div class="row">
    		<div class="span2">
    			<br><br>
    			<div id='accident'>0</div>
    			<br><br><br><br>
    			<div>Accident</div>
    		</div>
    		<div class="span2">
    			<br><br>
    			<div id='trafficjam'>0</div>
    			<br><br><br><br>
    			<div>Traffic Jam</div>
    		</div>
    		<div class="span2">
    			<br><br>
    			<div id='robbery'>0</div>
    			<br><br><br><br>
    			<div>Robbery</div>
    		</div>
    		<div class="span2">
    			<br><br>
    			<div id='bribery'>0</div>
    			<br><br><br><br>
    			<div>Bribery</div>
    		</div>
    		<div class="span2">
    			<br><br>
    			<div id='others'>0</div>
    			<br><br><br><br>
    			<div>Others</div>
    		</div>
    	</div>
    </div>
    
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDA6yY69rxUy4z8mpROQQ7FGIsQary3lPU&sensor=true"></script>
    <script type="text/javascript" src="scripts/index.js"></script>
    
  </body>
</html>