const Console = console;

export default class Game {
  constructor(background, pacman, canvas) {
    this.background = background;
    this.pacman = pacman;
    this.canvas = canvas;
  }
  addListeners() {
    document.addEventListener('keydown', (event) => {
      if (event.keyCode === 38) {
        this.pacman.velocity[1] = -2;
        this.pacman.velocity[0] = 0;
        Console.log('you pressed the up key!', event);
      }
      if (event.keyCode === 40) {
        this.pacman.velocity[1] = 2;
        this.pacman.velocity[0] = 0;
      }
      if (event.keyCode === 39) {
        this.pacman.velocity[0] = 2;
        this.pacman.velocity[1] = 0;
      }
      if (event.keyCode === 37) {
        this.pacman.velocity[0] = -2;
        this.pacman.velocity[1] = 0;
      }
    });
  }
  play() {
    this.addListeners();
    setInterval(() => {
      this.background.render();
      this.pacman.render();
      this.pacman.move();
    }, 10);
  }
}
