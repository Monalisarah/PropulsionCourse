console.log('hello');

$(function() {
  // code inside the fethc is asyinchronous
  fetch('http://swapi.co/api/films')
    .then(function(response) {
      return response.json();
    })
    .then((data) => {
      let movies = data.results;
      console.log('This is our data', data); // data from `/books`
      movies.forEach((movie) => {
        const movieElement = $('<div class="movie" >');
        const title = $('<h3>').text(movie.title); // create the element
        const description = $('<p>').text(movie.opening_crawl);
        movieElement.append(title, description);
        $("#film-list").append(movieElement); // append it to where I want, container has been previously defined.

        movie.starships.forEach((starship) => {
          const item = $('<li>').text(starship).addClass('starships');
          movieElement.append(item)
        });
      });
    });

  $('#film-list').on('click', '.starships', (e) => {
    let urlLink = $(e.currentTarget).text();
    getStarshipInfo(urlLink);
  })

  function getStarshipInfo(e) {
    fetch(e)
      .then(function(response) {
        return response.json();
      })
      .then((data) => {
        renderStarship(data);
      })
  }

  function renderStarship(data) {
    console.log(data);
    $('#starship').empty();
    const starshipElement = $('<div class="starshipElement" >');
    const starshipName = $('<h3>').text(data.name);
    const starshipTitle = $('<h2>Starship<h2>')
    starshipElement.append(starshipTitle, starshipName);
    $('#starship').append(starshipElement);
    data.pilots.forEach((pilot) => {
      const item = $('<li>').text(pilot).addClass('pilots');
      starshipElement.append(item);
    });
  }

  $('#starship').on('click', '.pilots', (e) => {
    const pilotLink = $(e.currentTarget).text();
    getPilotInfo(pilotLink);
  })

  // const getPilotInfo = function (url) {
  //   console.log('in da function : ' , url);
  // };
  const getPilotInfo = (url) => {
    fetch(url)
      .then(function(response) {
        return response.json();
      })
      .then((data) => {
        renderPilot(data);
      });
  };

  const renderPilot = (data) => {
    console.log(data);
    $('#pilot').empty();
    const pilotElement = $('<div class="pilotElement" >');
    const pilotName = $('<h3>').text(data.name);
    const pilotTitle = $('<h2>Pilot<h2>');
    $('#pilot').append(pilotElement);
    pilotElement.append(pilotTitle, pilotName);
    for (key in data) {
      const item = $('<p>').text(key + ' : ' + data[key]).addClass('pilotAttributes');
      pilotElement.append(item);
    }
    const favButton = $("<button>").text("add to favourites").addClass("favButton");
    pilotElement.append(favButton);
  }

  const myFavorites = {};
  $('#pilot').on('click', '.favButton', (e) => {
    const pilotName = $('#pilot h3');
    console.log(pilotName);
    // addFavourites();
  })

  // const addFavourites = () => {
  //
  // }




  // close document ready
})
