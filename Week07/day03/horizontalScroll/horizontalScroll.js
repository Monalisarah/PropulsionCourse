const myready = () => {

  $('.arrow-left').on('click', () => {
    let positionLeft = $('.horizontal-scroll').position().left;
    let width = $('.horizontal-scroll').width();
    // let positionLastChild = $('.item:last-child').position().left;
    // console.log('lastChild : ', positionLastChild);
    // console.log('width : ' ,width);
    console.log('position Left : ', positionLeft);
    // if (positionLeft === - 0) {
    if (positionLeft >= -700 && ((positionLeft - 820) > -821)) {
      $('.horizontal-scroll').css('transform', 'translateX(' + (positionLeft - 820) + 'px)')
    }
  })
  $('.arrow-right').on('click', () => {
    let positionRight = $('.horizontal-scroll').position().left;
    console.log(positionRight);
    if (positionRight <= -820) {
      $('.horizontal-scroll').css('transform', 'translateX(' + (positionRight + 820) + 'px)')
    }
  })

  //close myready function
}

$(myready);


// not working:
// const myready = () => {
// $(function() {
//   var initialPos = $('.horizontal-scroll').position().left;
//   var width = $('.horizontal-scroll').width();
//   var totalWidth = $('.item:last-child').position().left + $('.item:last-child').width();
//   var lastPage = totalWidth - width;
//
//   $('.arrow-left').on('click', function() {
//     var currentPosition = $('.horizontal-scroll').position().left;
//     console.log("currentPosition",currentPosition);
//     console.log("width ",width);
//     console.log("totalWidth ",totalWidth);
//     console.log("lastPage ", lastPage);
//
//     if (Math.abs(currentPosition) >= lastPage) {
//       var newTranslate = currentPosition - 200;
//       $('.horizontal-scroll').css('transform', 'translateX(' + newTranslate + 'px)');
//     }
//   });
//
//   $('.arrow-right').on('click', function() {
//     var currentPosition = $('.horizontal-scroll').position().left;
//
//     if (currentPosition < initialPos) {
//       var newTranslate = currentPosition + 200;
//       $('.horizontal-scroll').css('transform', 'translateX(' + newTranslate + 'px)');
//     }
//   });
// })
//
// // close myready function
// }
//
// $(myready);
