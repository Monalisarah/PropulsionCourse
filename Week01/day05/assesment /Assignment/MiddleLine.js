var MiddleLine = function(canvasW, canvasH) {
  this.position = [canvasW/2 , canvasH];
  this.color = 'yellow';
}

MiddleLine.prototype.render = function(ctx){
  ctx.beginPath();
  ctx.moveTo(this.position[0], 0);
  ctx.lineTo(this.position[0], this.position[1]);
  ctx.stroke();
  // ctx.fillStyle = this.color;
  // ctx.fill();
};
