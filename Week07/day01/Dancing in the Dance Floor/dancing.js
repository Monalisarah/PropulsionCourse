console.log('hello');

function grid() {
  for (let i = 0; i < 5; i++) {
    let $row = $("<div class= 'row'>");
    for (let j = 0; j < 5; j++) {
      let square = $("<div class= 'square'>").attr("id", i+1+ "-" +(j+1))
      $row.append(square)

      // $row.append("<div class= 'square'>").attr("id", i+1+ "-" +(j+1) );
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


// let selected =
$(".square").on('click', (event) => {
    console.log('in da click');
    $(event.currentTarget).toggleClass('active');
});

// console.log(selected);





$(document).on('keypress', (event) => {
  if (event.key === 'w'){
    console.log('in da keypress : '+ event.key);
  }
});
