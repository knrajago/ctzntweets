      var map = null;
      var request = null;
      var briberyCount = 0;
      var accidentCount = 0;
      var trafficjamCount = 0;
      var robberyCount = 0;
      var othersCount = 0;
      
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
      		accidentCount = 0;
      		trafficjamCount = 0;
      		briberyCount = 0;
      		robberyCount = 0;
      		othersCount = 0;

      		var jsonObj = JSON.parse(request.responseText);
      		for ( var i=0; i<jsonObj.length ; i++ )
      		{
      			var category = jsonObj[i].Category;
      			//alert(category);
      			switch(category)
      			{
      				case "ACCIDENT":accidentCount++; break;
      				case "TRAFFIC_JAM": trafficjamCount++; break;
      				case "ROBBERY": robberyCount++; break;
      				case "BRIBERY": briberyCount++; break;
      				default: othersCount++; 
      			}
      		}
      		
      		document.getElementById('accident').innerHTML = accidentCount;
      		document.getElementById('trafficjam').innerHTML = trafficjamCount;
      		document.getElementById('bribery').innerHTML = briberyCount;
      		document.getElementById('robbery').innerHTML = robberyCount;
      		document.getElementById('others').innerHTML = othersCount;
      		
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
