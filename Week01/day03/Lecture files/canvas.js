var canvas = document.getElementById('canvas');
console.log(canvas);
var ctx = canvas.getContext('2d');

var x = 10;
var y = 10;

function render() {
  ctx.fillStyle = 'green';
  ctx.fillRect(x, y, 100, 100);
}

setInterval(function() {
  render();
  x++;
  y++;
}, 10)
