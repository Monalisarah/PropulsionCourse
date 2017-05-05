import Game from './game';
import Background from './background';
import Pacman from './pacman';

const canvas = document.getElementById('canvas');

const background = new Background(canvas);
const pacman = new Pacman(canvas, 20, [100, 100]);
const game = new Game(background, pacman, canvas);

// background.render();
// pacman.render();
// game.addListeners();


game.play();
