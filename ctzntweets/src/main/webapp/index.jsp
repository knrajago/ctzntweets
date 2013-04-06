<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0; padding: 0 }
      #map-canvas { height: 50% }
    </style>
   <script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDA6yY69rxUy4z8mpROQQ7FGIsQary3lPU&sensor=true">
    </script>
    <script type="text/javascript">
      var map = null;
      
      function showPosition(position)
      {
      	var latLng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
      	var marker = new google.maps.Marker({
                position: latLng,
                map: map
              });
      	map.setCenter(latLng);
      	map.setZoom(15);
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
  </body>
</html>