$(function() {
 // console.log("clean clean clean");
  fetch('http://swapi.co/api/films')
    .then(function(response) {
      console.log(response);
      return response.json();
    })
    .then(function(data) {
      var movies = data.results;
      movies.forEach(function(movie) {
        var element = $('<div class="movie">');
        element.append('<h3>' + movie.title + '</h3>');
        element.append('<p>' + movie.opening_crawl + '</p>') 
        var list = $('<ul class="list">');
        //inside movies.forEach: 
        movie.starships.forEach(function(ship) {
          var link = $('<li><a href="'+ ship +'"> ' + ship + '</a></li>');
          link.on('click', clickOnStarship); // better do a dynamic event listener next time and outside of fetch
          // list.append(link);
          element.append(link);
        });
        element.append(list);
        $('#film-list').append(element);
      });
    });

  function clickOnStarship(event) {
    event.preventDefault();
    var starShipLink = event.target.getAttribute('href');
    //fetching variable no: ''
    fetch(starShipLink)
      .then(response => response.json())
      .then(function(data) {
        var dataOfShips = data;
        $('#starship').empty();
        for (var key in dataOfShips) {
          var linkElement = $('<div class="selects">');
          var list2 = $('<ul class="list2">');
          if (key === "pilots") {
            linkElement.append('<p>' + key + ':</p>');
            //in for in loop:
            dataOfShips[key].forEach(function(pilot) {
              var link2 = $('<li><a href="' + pilot + '">' + pilot + '</a></li>');
              link2.on('click', clickOnPilot);
              list2.append(link2);
            });
            linkElement.append(list2);
          } else {
            linkElement.append('<p>' + key + ':' + dataOfShips[key] + '</p>')
          }
          $('#starship').append(linkElement);
        }
      });
  }

  function clickOnPilot(event) {
    event.preventDefault();
    var pilotLink = event.target.getAttribute('href');
    fetch(pilotLink)
      .then(response => response.json())
      .then(function(data) {
        var dataOfPilots = data;
        $('#pilot').empty();
        for (var key in dataOfPilots) {
          elementPilot = $('<div class="pilotData">');
          elementPilot.append('<p>' + key + ': ' + dataOfPilots[key] + '</p>')
          $('#pilot').append(elementPilot);
        }
      })
  }
  //Button add to favorites:
  var favorites = $('<ul class="favorite">');
  //#faveButton build in html:
  $('#faveButton').on('click', addFavorites);
  //empty object inst. of array(wont work if push sthig back to faves again!
  var myFavorites = {};

  function addFavorites(event) {
    var name = $('#pilot').find("p:first").text();
    for (var key in myFavorites){
    	if (name === key && myFavorites[name] === true){
    		alert("This pilot is already in favorites!");
        return;
    	}
    }
    myFavorites[name] = true;
    var nameFavorite = '<p>' + name + '</p>';
    var favoriteContainer = $('<div class="favorite">');
    var deleteButton = $("<button>").text("X").addClass("deleteButton");
    favoriteContainer.append(nameFavorite);
    favoriteContainer.append(deleteButton);
    $('#favorites').append(favoriteContainer);

    $('.deleteButton').on('click', deleteFavorite);
  }

  function deleteFavorite(event) {
  	//if html element wrap a $ -->jquery obj & work with it:
  	$(event.target).parent().remove();
  	//delete completely in obj (myFavorites) or still thinks that name in faves & alert pops up
    //bracked notation if we do not know the name of the property we want to access:
  	myFavorites[$(event.target).siblings().html()] = false;
  	// console.log(myFavorites);
  	// console.log($(event.target).siblings().html());
  }

});
