var Game = function(canvas) {
  this.canvas = canvas;
  this.ctx = canvas.getContext('2d');
  this.canvasH = canvas.height;
  this.canvasW = canvas.width;
  this.ball = new Ball(10, [200, 200]); // [x, y]
  this.blocks = [];
  this.paddle = new Paddle(this.canvasW, this.canvasH)
  this.createBlocks();
  this.addListeners();
  this.players = [];
};


Game.prototype.resetCanvas = function() {
  this.ctx.fillStyle = 'pink';
  this.ctx.fillRect(0, 0, this.canvasW, this.canvasH);
};

Game.prototype.play = function() {
  var that = this;
  var context = this.ctx;
  var id = setInterval(function() {
    that.checkCollisions();
    that.checkPaddleArea();
    that.resetCanvas();
    var returnedValue = that.ball.move(that.canvasH, that.canvasW);
    if (returnedValue === 'stop') {
      clearInterval(id);
    }
    that.ball.render(context);
    that.paddle.render(context);
    that.paddle.move(); // calling the function but the velocity is set to 0, the velocity is only changed when the key is pressed
    // var thus = that;
    // that.blocks.render(that.ctx);
    that.blocks.forEach(function(block) {
      block.render(context);
    })
  }, 10);
  console.log(id);
}

Game.prototype.createBlocks = function() {
  var width = 50;
  var height = 20;
  var position = [0, 30]; // x,y
  var colors = ["AliceBlue", "AntiqueWhite", "Aqua", "Aquamarine", "Azure", "Beige", "Bisque", "BlanchedAlmond", "Blue", "BlueViolet", "Brown", "BurlyWood", "CadetBlue", "Chartreuse", "Chocolate", "Coral", "CornflowerBlue", "Cornsilk", "Crimson", "Cyan", "DarkBlue", "DarkCyan", "DarkGoldenRod", "DarkGray", "DarkGrey", "DarkGreen", "DarkKhaki", "DarkMagenta", "DarkOliveGreen", "Darkorange", "DarkOrchid", "DarkRed", "DarkSalmon", "DarkSeaGreen", "DarkSlateBlue", "DarkSlateGray", "DarkSlateGrey", "DarkTurquoise", "DarkViolet", "DeepPink", "DeepSkyBlue", "DimGray", "DimGrey", "DodgerBlue", "FireBrick", "FloralWhite", "ForestGreen", "Fuchsia", "Gainsboro", "GhostWhite", "Gold", "GoldenRod", "Gray", "Grey", "Green", "GreenYellow", "HoneyDew", "HotPink", "IndianRed", "Indigo", "Ivory", "Khaki", "Lavender", "LavenderBlush", "LawnGreen", "LemonChiffon", "LightBlue", "LightCoral", "LightCyan", "LightGoldenRodYellow", "LightGray", "LightGrey", "LightGreen", "LightPink", "LightSalmon", "LightSeaGreen", "LightSkyBlue", "LightSlateGray", "LightSlateGrey", "LightSteelBlue", "LightYellow", "Lime", "LimeGreen", "Linen", "Magenta", "Maroon", "MediumAquaMarine", "MediumBlue", "MediumOrchid", "MediumPurple", "MediumSeaGreen", "MediumSlateBlue", "MediumSpringGreen", "MediumTurquoise", "MediumVioletRed", "MidnightBlue", "MintCream", "MistyRose", "Moccasin", "NavajoWhite", "Navy", "OldLace", "Olive", "OliveDrab", "Orange", "OrangeRed", "Orchid", "PaleGoldenRod", "PaleGreen", "PaleTurquoise", "PaleVioletRed", "PapayaWhip", "PeachPuff", "Peru", "Plum", "PowderBlue", "Purple", "Red", "RosyBrown", "RoyalBlue", "SaddleBrown", "Salmon", "SandyBrown", "SeaGreen", "SeaShell", "Sienna", "Silver", "SkyBlue", "SlateBlue", "SlateGray", "SlateGrey", "Snow", "SpringGreen", "SteelBlue", "Tan", "Teal", "Thistle", "Tomato", "Turquoise", "Violet", "Wheat", "White", "WhiteSmoke", "Yellow", "YellowGreen"];
  var numBlk = this.canvasW / width;
  for (var i = 0; i < 3; i++) {
    for (var j = 0; j < numBlk; j++) {
      var color = colors[Math.floor(Math.random() * colors.length)]
      var block = new Block([position[0] + j * width, position[1] + i * height], height, width, color)
      this.blocks.push(block);
    }
  }
  // var Block = function (position, height, width, color)
};

Game.prototype.addListeners = function() {
  var paddle = this.paddle;
  document.addEventListener('keydown', function(event) {
    // console.log('you pressed a key!');
    // console.log(event);
    // console.log('you pressed the key, ' + event.keyCode);
    // if (event.keyCode === 39) {console.log ('go right!')}
    if (event.keyCode === 39) {
      paddle.velocity[0] = 7
    }
    if (event.keyCode === 37) {
      paddle.velocity[0] = -7
    }
  });
  document.addEventListener('keyup', function(event) {
    if (event.keyCode === 39) {
      paddle.velocity[0] = 0
    }
    if (event.keyCode === 37) {
      paddle.velocity[0] = 0
    }
  });
};

Game.prototype.checkCollisions = function() {
  var pBallPlusRadiusV = this.ball.position[1] + this.ball.radius;
  var pBallMinusRadiusV = this.ball.position[1] - this.ball.radius;
  var pBallV = this.ball.position[1];
  var pBallPlusRadiusH = this.ball.position[0] + this.ball.radius; //not needed
  var pBallMinusRadiusH = this.ball.position[0] - this.ball.radius;
  var pBallH = this.ball.position[0];

  var ballVelocity = this.ball.velocity;

  this.blocks.forEach(function(block) {
    if( block.isVisible === false){
      return;
    }
    var pBlockBottom = block.position[1] + block.height;
    var pBlockTop = block.position[1];
    var pBlockLeft = block.position[0];
    var pBlockRight = block.position[0] + block.width;

    if (pBallMinusRadiusV === pBlockBottom &&
      pBallH >= pBlockLeft &&
      pBallH < pBlockRight) {
      block.isVisible = false;
      ballVelocity[1] = -ballVelocity[1];
    }
    if (pBallPlusRadiusV === pBlockTop &&
      pBallH >= pBlockLeft &&
      pBallH < pBlockRight) {
      block.isVisible = false;
      ballVelocity[1] = -ballVelocity[1];
    }
    if (pBallMinusRadiusH === pBlockRight &&
      pBallV >= pBlockTop &&
      pBallV < pBlockBottom) {
      block.isVisible = false;
      ballVelocity[0] = -ballVelocity[0];
    }
    if (pBallPlusRadiusH === pBlockLeft &&
      pBallV >= pBlockTop &&
      pBallV < pBlockBottom) {
      block.isVisible = false;
      ballVelocity[0] = -ballVelocity[0];
    }
  });
}


Game.prototype.checkPaddleArea = function() {
  if (this.ball.position[1] + this.ball.radius >= this.paddle.position[1]) {
    if (this.ball.position[0] + this.ball.radius < this.paddle.position[0] + this.paddle.width &&
      this.ball.position[0] - this.ball.radius > this.paddle.position[0]) {
      console.log('you hit the paddle!!');
      this.ball.velocity[1] = -this.ball.velocity[1];
    }
  }
};
