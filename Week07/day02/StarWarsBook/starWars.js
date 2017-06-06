console.log('hello');

$(function() {

  fetch('http://swapi.co/api/films')
    .then(function(response) {
      return response.json();
    })
    .then(function(data) {
      let movies = data.results;
      console.log('This is our data', data); // data from `/books`
      movies.forEach(function(movie) {
        let elementMovie = $('<div class="movie" >');
        let title = $('<h3>').text(movie.title); // create the element
        let description = $('<p>').text(movie.opening_crawl);
        elementMovie.append(title, description);
        $("#film-list").append(elementMovie); // append it to where I want, container has been previously defined.
      });
    });


  // close document ready
})
