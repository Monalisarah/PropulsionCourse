var Block = function(position, height, width, color) {
  this.position = position;
  this.height = height;
  this.width = width;
  this.color = color;
  this.isVisible = true;
};

Block.prototype.render = function(ctx) {
  if( this.isVisible === false){
    return;
  }
  ctx.beginPath();
  ctx.rect(this.position[0], this.position[1], this.width, this.height);
  ctx.fillStyle = this.color;
  // ctx.strokeStyle = 'white';
  // ctx.stroke();
  ctx.fill();
};
