





function randomColor() {
  let letters = '0123456789ABCDEF'.split('');
  let color = '#';
  for (let i= 0; i<6; i++){
    color += letters[Math.floor(Math.random()*16)];
  }
  return color;
};

let interval = setInterval(function () {
  let grid = $('.square');
  grid.each((index, cell) => {
    $(cell).css('background', randomColor());
  })

}, 2000);


// // theorie cell und cell acive random dancing:
// let squares = $('.square');
// squares.on('click', (event) => {
//     // ‘active’ greift auf css class zu
//     console.log('in da click')
//     $(event.currentTarget).toggleClass('active');
// });
