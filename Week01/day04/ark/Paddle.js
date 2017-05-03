var Paddle = function(canvasW, canvasH) {
  this.height = 10;
  this.width = 70;
  this.position = [canvasW/2 -this.width/2, canvasH-this.height -10];
  this.color = 'yellow';
  this.velocity = [0, 0];
  this.rightLimit = canvasW;
}

Paddle.prototype.render = function(ctx){
  ctx.beginPath();
  ctx.rect(this.position[0], this.position[1], this.width, this.height);
  ctx.fillStyle = this.color;
  ctx.fill();
};

Paddle.prototype.move = function(){
  var newPositionX = this.position[0] + this.velocity[0];
  if (newPositionX > 0 && newPositionX < this.rightLimit-this.width){
  this.position[0] = newPositionX;
  }
};
