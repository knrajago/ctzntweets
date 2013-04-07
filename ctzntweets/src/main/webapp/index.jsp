<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0; padding: 0 }
      td {text-align: center}
      #map-canvas { height: 50% }
      #circle {
    		width: 50px;
    		height: 50px;
    		-webkit-border-radius: 25px;
    		-moz-border-radius: 25px;
    		border-radius: 25px; 
    		border-style:solid;
    		border-color:red
		}
    </style>
    
   <script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDA6yY69rxUy4z8mpROQQ7FGIsQary3lPU&sensor=true">
    </script>
    <script type="text/javascript">
      var map = null;
      var request = null;
      
      function showPosition(position)
      {
      	var latLng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
      	
      	map.setCenter(latLng);
      	map.setZoom(15);
      	
      	if(window.XMLHttpRequest)
      	{
      		request = new XMLHttpRequest();
      	}
      	request.onreadystatechange = showTweets;
      	request.open("GET","/TweetServlet?latitude="+position.coords.latitude+"&longitude="+position.coords.longitude,true);
      	request.send();
      }
      
      function showTweets()
      {
      	if(request.readyState==4)
      	{
      		var response = request.responseXML;
      		var tweets=response.getElementsByTagName("Tweet");
      		var tweet=tweets[0];
      		var lat=tweet.getElementByTagName("Lat")[0].text;
      		var lng=tweet.getElementByTagName("Lng")[0].text;
      		var latlng= new google.maps.LatLng(lat,lng);
      		var marker = new google.maps.Marker({
                position: latlng,
                map: map
              });
            map.setCenter(latlng);
            map.setZoom(8);
      	}
      }
      
      function handlePositionError(evt) {
      	alert(evt.message);
      }
      
      function initialize() {
        var mapOptions = {
          center: new google.maps.LatLng(-34.397, 150.644),
          zoom: 8,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        map = new google.maps.Map(document.getElementById("map-canvas"),
            mapOptions);
        if (navigator.geolocation)
        {
        	navigator.geolocation.getCurrentPosition(showPosition,handlePositionError);
        }
      }
      google.maps.event.addDomListener(window, 'load', initialize);
    </script>
  </head>
  <body>
    
    <div id="map-canvas"> </div>
    <table>
    	<td> <div class="circle" id="accident"></div></td>
    	<td> <div class="circle" id="trafficjam"></div></td>
    	<td> <div class="circle" id="bribe"></div></td>
    	<td> <div class="circle" id="robbery"></div></td>
    	<td> <div class="circle" id="others"></div></td>
    </table>
    
    
    
  </body>
</html>