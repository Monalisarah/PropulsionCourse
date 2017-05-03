var Ball = function(radius, position) {
  this.radius = radius;
  this.position = position;
  this.velocity = [2, 2];
}


Ball.prototype.render = function(ctx) {
  ctx.beginPath();
  ctx.arc(this.position[0], this.position[1], this.radius, 0, 2 * Math.PI, false);
  ctx.fillStyle = 'FloralWhite'; // 'FloralWhite'
  ctx.fill();
};

Ball.prototype.move = function(height, width) {

  var newPositionX = this.position[0] + this.velocity[0];
  var newPositionY = this.position[1] + this.velocity[1];

  if (newPositionX > width- this.radius) this.velocity[0] = -this.velocity[0];
  // if (newPositionX > width ) {
  //   alert('you lost!')
  //   return;
  // }
  if (newPositionX < 0 + this.radius) this.velocity[0] = -this.velocity[0];
  // if (newPositionX < 0 ) {
  //   alert('you lost!')
  //   return;
  // }

  if (newPositionY > height - this.radius) this.velocity[1] = -this.velocity[1];
  if (newPositionY < 0 + this.radius) this.velocity[1] = -this.velocity[1];

  this.position[0] = newPositionX;
  this.position[1] = newPositionY;
};
