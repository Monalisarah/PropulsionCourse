const myready = () => {
  // const p fetch('url');
  // console.log(p);
  fetch('url')
  // p.then((res) => {
    .thien((res) => {
    console.log(res); //
    res.json(); //returns a promise (object)
    // const p2 = res.json();
    // console.log(p2);
    return res.json();
  })
  .then((data) =>{
    console.log(data);
    console.log('in da creating elements');
    data.results.forEach((movie)=> {
      const item = $('<li>'). text(movie.title).addClass('movie');
      //create the ul or div in the html file ...
      //if you append an li, the information of the li will also be appended
      $('#movies').append(item)
      console.log(movie.title);
    })
  });
  console.log('before listener !');
  console.log($('.movie'));
  $('#movies').on('click', '.movie',(e)=>{
    // '.movie', second parameter: dynamic listener is going to add a listener to all the elements in the list
    console.log(e.currentTarget);
    console.log('in da click');
  })
}

//
// async function myready(){
//   const res = await fetch ('url');
//   const data = await res.json();
//   data.results.forEach((movie) => {
//     const item = $('<li>').text(movie.title).addClass('movie');
//     $('#movies').append(item);
//   })
// }
//
// $(document).ready(() =>{
//   myready();
// });
