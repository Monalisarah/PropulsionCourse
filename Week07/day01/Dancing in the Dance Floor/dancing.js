console.log('hello');



function grid() {
  for (let i = 0; i < 5; i++) {
    let $row = $("<div class= 'row'></div>");
    for (let j = 0; j < 5; j++) {
      $row.append("<div class= 'square'></div>")
    }
    $(".container").append($row);
  }
}

// let grid = $('<div>').addClass('container');
//
// for(let i = 0; i < 5; i++){
//     let row = $('<div>').addClass('row');
//     grid.append(row);
// }
// $('.container').append(grid);

grid();



$(".square").on('click', (event) => {
  console.log('in da click');
  $(event.currentTarget).toggleClass('active');
});


// // theorie cell und cell acive random dancing:
// let squares = $('.square');
// squares.on('click', (event) => {
//     // ‘active’ greift auf css class zu
//     console.log('in da click')
//     $(event.currentTarget).toggleClass('active');
// });
