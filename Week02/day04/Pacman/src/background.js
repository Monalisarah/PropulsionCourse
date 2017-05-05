
class Background {
  constructor(canvas) {
    this.canvas = canvas;
    this.ctx = canvas.getContext('2d');
    this.canvasH = canvas.height;
    this.canvasW = canvas.width;
  }
  render() {
    this.ctx.fillStyle = 'steelblue';
    this.ctx.fillRect(0, 0, this.canvasW, this.canvasH);
  }
}


export default Background;
