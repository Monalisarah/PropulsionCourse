
class Pacman {
  constructor(canvas, radius, position) {
    this.canvas = canvas;
    this.canvasH = canvas.height;
    this.canvasW = canvas.width;
    this.ctx = canvas.getContext('2d');
    this.radius = radius;
    this.position = position;
    this.velocity = [0, 0];
  }
  render() {
    this.ctx.beginPath();
    this.ctx.arc(this.position[0], this.position[1], this.radius, (Math.PI/2), 3 * (Math.PI/2), false);
    this.ctx.arc(this.position[0], this.position[1], this.radius, (Math.PI/4), (Math.PI/2), false);
    this.ctx.arc(this.position[0], this.position[1], this.radius, 3* (Math.PI/2),7* (Math.PI/4), false);
    this.ctx.fillStyle = 'palegoldenrod';
    this.ctx.fill();
  }
  move() {
    let newPositionX = this.position[0] + this.velocity[0];
    let newPositionY = this.position[1] + this.velocity[1];
    if (newPositionX > this.canvasW - this.radius) this.velocity[0] = 0;
    if (newPositionX < 0 + this.radius) this.velocity[0] = 0;
    if (newPositionY > this.canvasH - this.radius) this.velocity[1] = 0;
    if (newPositionY < 0 + this.radius) this.velocity[1] = 0;
    this.position[0] = newPositionX;
    this.position[1] = newPositionY;
  }
}

export default Pacman;
