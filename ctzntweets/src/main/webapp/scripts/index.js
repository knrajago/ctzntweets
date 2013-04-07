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
