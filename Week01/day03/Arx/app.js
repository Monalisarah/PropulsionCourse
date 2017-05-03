var canvas = document.getElementById('canvas');
// var ctx = canvas.getContext('2d');
// var canvasH = canvas.height;
// var canvasW = canvas.width;

var Game = function(canvas) {
  this.canvas = canvas;
  this.ctx = canvas.getContext('2d');
  this.canvasH = canvas.height;
  this.canvasW = canvas.width;
  this.ball = new Ball(10, [100, 100]); // [x, y]
  this.blocks = [];
};


Game.prototype.resetCanvas = function() {
  this.ctx.fillStyle = 'pink';
  this.ctx.fillRect(0, 0, this.canvasW, this.canvasH);
};

Game.prototype.play = function() {
 var that = this;
 var context = this.ctx;
  setInterval(function() {
    that.resetCanvas();
    that.ball.move(that.canvasH, that.canvasW);
    that.ball.render(context);
    // var thus = that;
    // that.blocks.render(that.ctx);
    that.blocks.forEach(function(block){
      block.render(context);
      console.log(block);
    })

  }, 10);
}

Game.prototype.createBlocks = function(){
  var width = 50;
  var height = 20;
  var position = [0,30]; // x,y
  var colors = ["AliceBlue","AntiqueWhite","Aqua","Aquamarine","Azure","Beige","Bisque","Black","BlanchedAlmond","Blue","BlueViolet","Brown","BurlyWood","CadetBlue","Chartreuse","Chocolate","Coral","CornflowerBlue","Cornsilk","Crimson","Cyan","DarkBlue","DarkCyan","DarkGoldenRod","DarkGray","DarkGrey","DarkGreen","DarkKhaki","DarkMagenta","DarkOliveGreen","Darkorange","DarkOrchid","DarkRed","DarkSalmon","DarkSeaGreen","DarkSlateBlue","DarkSlateGray","DarkSlateGrey","DarkTurquoise","DarkViolet","DeepPink","DeepSkyBlue","DimGray","DimGrey","DodgerBlue","FireBrick","FloralWhite","ForestGreen","Fuchsia","Gainsboro","GhostWhite","Gold","GoldenRod","Gray","Grey","Green","GreenYellow","HoneyDew","HotPink","IndianRed","Indigo","Ivory","Khaki","Lavender","LavenderBlush","LawnGreen","LemonChiffon","LightBlue","LightCoral","LightCyan","LightGoldenRodYellow","LightGray","LightGrey","LightGreen","LightPink","LightSalmon","LightSeaGreen","LightSkyBlue","LightSlateGray","LightSlateGrey","LightSteelBlue","LightYellow","Lime","LimeGreen","Linen","Magenta","Maroon","MediumAquaMarine","MediumBlue","MediumOrchid","MediumPurple","MediumSeaGreen","MediumSlateBlue","MediumSpringGreen","MediumTurquoise","MediumVioletRed","MidnightBlue","MintCream","MistyRose","Moccasin","NavajoWhite","Navy","OldLace","Olive","OliveDrab","Orange","OrangeRed","Orchid","PaleGoldenRod","PaleGreen","PaleTurquoise","PaleVioletRed","PapayaWhip","PeachPuff","Peru","Pink","Plum","PowderBlue","Purple","Red","RosyBrown","RoyalBlue","SaddleBrown","Salmon","SandyBrown","SeaGreen","SeaShell","Sienna","Silver","SkyBlue","SlateBlue","SlateGray","SlateGrey","Snow","SpringGreen","SteelBlue","Tan","Teal","Thistle","Tomato","Turquoise","Violet","Wheat","White","WhiteSmoke","Yellow","YellowGreen"];
  var numBlk = this.canvasW/width;
  for (var i = 0; i<= numBlk; i++) {
    for (var j = 0; j < 3; j++){
      var color = colors[Math.floor(Math.random()*colors.length)]
      var block = new Block([position[0]+i*width, position[1]+j*height],height,width,color)
      this.blocks.push(block);
    }

  }

  // var Block = function (position, height, width, color)

};
// Create a Ball class

var Ball = function(radius, initialPosition) {
  this.radius = radius;
  this.initialPosition = initialPosition;
  this.velocity = [3, 3];
};

Ball.prototype.render = function(ctx) {
  ctx.beginPath();
  ctx.arc(this.initialPosition[0], this.initialPosition[1], this.radius, 0, 2 * Math.PI, false);
  ctx.fillStyle = 'red';
  ctx.fill();
};

Ball.prototype.move = function(height, width) {

  var newPositionX = this.initialPosition[0] + this.velocity[0];
  var newPositionY = this.initialPosition[1] + this.velocity[1];

  if (newPositionX > 300 - this.radius) this.velocity[0] = -this.velocity[0];
  if (newPositionX < 0 +this.radius) this.velocity[0] = -this.velocity[0];
  if (newPositionY > 400 - this.radius) this.velocity[1] = -this.velocity[1];
  if (newPositionY < 0 +this.radius) this.velocity[1] = -this.velocity[1];

  this.initialPosition[0] = newPositionX;
  this.initialPosition[1] = newPositionY;
};

var Block = function (position, height, width, color){
  this.position = position;
  this.height = height;
  this.width = width;
  this.color = color;
};

Block.prototype.render = function(ctx){
  ctx.beginPath();
  ctx.rect(this.position[0], this.position[1], this.width, this.height);
  ctx.fillStyle = this.color;
  // ctx.strokeStyle = 'white';
  // ctx.stroke();
  ctx.fill();
};



var block = new Block();


var myGame = new Game(canvas);

myGame.createBlocks();
myGame.play();



// var centerX = canvas.width / 2;
// var centerY = canvas.height / 2;
// var radius = 70;
// ctx.arc(centerX, centerY, radius, 0, 2 * Math.PI, false);


// ctx.beginPath();
// ctx.arc(10, 10, 10, 0, 2 * Math.PI, false);
// ctx.fillStyle = 'red';
// ctx.fill();
