console.log('hello world');

var canvas = document.getElementById('canvas');
var Game = function(canvas) {
  this.canvas = canvas;
  this.ctx = canvas.getContext('2d');
  this.canvasH = canvas.height;
  this.canvasW = canvas.width;
  this.ball = new Ball(10, [200, 200]);
  console.log(this);
  this.paddleRight = new Paddle(this.canvasW, this.canvasH, 'right');
  this.paddleLeft = new Paddle(this.canvasW, this.canvasH, 'left');

};

Game.prototype.resetCanvas = function() {
  this.ctx.fillStyle = 'CornflowerBlue';
  this.ctx.fillRect(0, 0, this.canvasW, this.canvasH);
  this.ctx.beginPath();
  this.ctx.moveTo(this.canvasW/2, 0);
  this.ctx.lineTo(this.canvasW/2, this.canvasH);
  this.ctx.lineWidth = 5;
  this.ctx.strokeStyle = 'LightSalmon';
  this.ctx.stroke();
};

Game.prototype.play = function() {
  var that = this;
  var context = this.ctx;
  var player1 = new Player(1);
  var player2 = new Player(2);

  setInterval(function() {
    that.checkPaddleArea();
    that.resetCanvas();
    that.printScores(player1, 'left');
    that.printScores(player2, 'right');

    that.ball.move(that.canvasH, that.canvasW);
    that.ball.render(context);

    that.paddleRight.render(context);
    that.paddleLeft.render(context);

    that.paddleRight.move(that.canvasH);
    that.paddleLeft.move(that.canvasH);

  }, 10);
}


Game.prototype.addListeners = function() {
  var paddleRight = this.paddleRight;
  var paddleLeft = this.paddleLeft;
  document.addEventListener('keydown', function(event) {
    if (event.keyCode === 40) {
      console.log(event);
      paddleRight.velocity[1] = 5;
    }
    if (event.keyCode === 38) {
      paddleRight.velocity[1] = -5;
    }
    if (event.keyCode === 89) {
      paddleLeft.velocity[1] = 5;
    }
    if (event.keyCode === 83) {
      paddleLeft.velocity[1] = -5;
    }
  })
  document.addEventListener('keyup', function(event) {
    if (event.keyCode === 40) {
      console.log(event);
      paddleRight.velocity[1] = 0;
    }
    if (event.keyCode === 38) {
      paddleRight.velocity[1] = 0;
    }
    if (event.keyCode === 89) {
      paddleLeft.velocity[1] = 0;
    }
    if (event.keyCode === 83) {
      paddleLeft.velocity[1] = 0;
    }
  })
};


Game.prototype.checkPaddleArea = function() {
  var ballLeft = this.ball.position[0] - this.ball.radius;
  var ballRight = this.ball.position[0] + this.ball.radius;
  var ballV = this.ball.position[1];
  var paddleRightFront = this.paddleRight.position[0];
  var paddleRightTop = this.paddleRight.position[1];
  var paddleRightBottom = this.paddleRight.position[1] + this.paddleRight.height;
  var paddleLeftFront = this.paddleLeft.position[0] + this.paddleLeft.width;
  var paddleLeftTop = this.paddleLeft.position[1];
  var paddleLeftBottom = this.paddleLeft.position[1] + this.paddleLeft.height;

  if (ballLeft <= paddleLeftFront) {
    if (ballV >= paddleLeftTop &&
      ballV <= paddleLeftBottom) {
      this.ball.velocity[0] = this.ball.velocity[0] * -1;
    }
  }
  if (ballRight >= paddleRightFront) {
    if (ballV >= paddleRightTop &&
      ballV <= paddleRightBottom) {
      this.ball.velocity[0] = this.ball.velocity[0] * -1;
    }
  }
};

Game.prototype.printScores = function (player, position){
  this.ctx.fillStyle = "red";
  this.ctx.font = '20pt Times New Roman';
  if(position ==='left'){
  this.ctx.fillText(player.score + ' ' + player.name , this.canvasW/2 +10, 25);
  }
  if(position ==='right'){
  this.ctx.fillText(player.score + ' ' + player.name , this.canvasW/2 -120, 25);
  }
}

var myGame = new Game(canvas);
myGame.addListeners();
myGame.play();
