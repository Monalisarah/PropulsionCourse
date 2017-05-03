
var Paddle = function(canvasW, canvasH, position) {
  this.height = 150;
  this.width = 15;
  if (position === 'right') {
    this.position = [canvasW - this.width - 10, canvasH / 2 - this.height / 2];
  }
  if (position === 'left') {
    this.position = [10, canvasH / 2 - this.height / 2];
  }
  this.color = 'tomato'
  this.velocity = [0,0]
  this.bottomLimit = canvasH;
}

Paddle.prototype.render = function(ctx) {
  ctx.beginPath();
  ctx.rect(this.position[0], this.position[1], this.width, this.height);
  ctx.fillStyle = this.color;
  ctx.fill();
};

Paddle.prototype.move = function (){
  var newPositionY = this.position[1] + this.velocity[1];
  if (newPositionY <= this.bottomLimit-this.height &&
      newPositionY >= 0)
  this.position[1]= newPositionY
}


// var Paddle = function(canvasW, canvasH) {
// this.height = 150;
// this.width = 15;
// this.position.right = [canvasW -this.width-10, canvasH/2-this.height/2];
// this.position.left =  [10, canvasH/2-this.height/2];
// this.color = 'tomato'
// }
//

// var Paddle = function(position) { // and key)
//   this.height = 150;
//   this.width = 15;
//   this.position = position;
//   this.color = 'tomato'
// }
