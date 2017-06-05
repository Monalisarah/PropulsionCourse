function randomColor(){
	var color = "";
	for (var i = 0; i < 6; i++) {
		color = "#"+ Math.floor(Math.random() * 16777215).toString(16);
	}
	return color;
}

// var interval = setInterval(function() {
// 	$(".square").each(function() {
// 	    $(this).css("background-color", randomColor());
// 	});
// },1000);

// setTimeout(function(){
// 	clearInterval(interval);
// },3000);

$('.square').on('click', function(e) {
  $(this).css("background-color", randomColor());
});