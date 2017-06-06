console.log('hello');

$(function() {

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


  // close document ready
})
