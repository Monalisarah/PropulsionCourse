

var Trivial = function (){
  this.questions = [];
  this.correctAnsCount = 0;
  this.players = [];
  this.currentPlayerindex = 0;

}

Trivial.prototype.askQuestion = function (question){
  // var userAnswer = prompt(question.title + ' ' + question.choices[0]+ ' ' + question.choices[1]);
  if (question.isBinary){
    var userAnswer = confirm(this.players[this.currentPlayerindex]['name'] + ': '  + question.print())
  } else {
  var userAnswer = prompt( this.players[this.currentPlayerindex]['name'] + ': '  + question.print()).toUpperCase();
  }
  if (userAnswer === question.correctAns){
  alert('Congratulations');
    this.players[this.currentPlayerindex].playerScore++;

    var questionCategory = question.category;
    if (questionCategory in this.players[this.currentPlayerindex].playerCategoryScore){
       this.players[this.currentPlayerindex].playerCategoryScore[questionCategory]++;
    } else {
      this.players[this.currentPlayerindex].playerCategoryScore[questionCategory] = 1;
    }

  } else {
    alert('wrong answer');
  }
  this.players[this.currentPlayerindex].questionCount++;
}

var Question = function (title, choices, correctAns, category, isBinary){
  this.title = title;
  this.choices = choices;
  this.correctAns = correctAns;
  this.category = category;
  this.isBinary = isBinary;
}

Question.prototype.print = function() {
  var messageToPrint = this.title
  // for (var i= 0; i < this.choices.length; i++){
    // messageToPrint = messageToPrint + '\n' + this.choices[i];
  // }
  this.choices.forEach(function(q){
    messageToPrint = messageToPrint + '\n' + q;
  })
  return messageToPrint;
}

Trivial.prototype.addQuestion = function (question){
  this.questions.push(question);
}

Trivial.prototype.play = function(){
  this.setPlayer();
  for (var i = 0; i< this.questions.length; i++){
    this.askQuestion(this.questions[i]);
    this.currentPlayerindex++;
    if (this.currentPlayerindex === this.players.length){
        this.currentPlayerindex = 0;
    }
    // for (this.currentPlayerindex = 0; this.currentPlayerindex < this.players.length;  this.currentPlayerindex++;)

  }
  var finalScorePrint = [];
  this.players.forEach(function(w){
  finalScorePrint = finalScorePrint + '\n' + w.name + 's Score is: ' + w.playerScore + ' out of: '+ w.questionCount;
  });

  alert(finalScorePrint);
  this.showWinner();

}

Trivial.prototype.showWinner = function (){
  var topScore = 0;
  var winner = '';
  var tie = [];
  for (var i = 0; i < this.players.length; i++){
    if (this.players[i].playerScore > topScore ){
      topScore = this.players[i].playerScore;
      winner = this.players[i].name;
    } else if (this.players[i].playerScore = topScore ){
      tie.push(this.players[i].name);
      }
  }
  if (tie.length !== 0){
  alert('The game is a tie between: ' + winner + ', ' + tie.toString());
  }
  else {
  alert('The winner is: ' + winner);
  }
}

// Trivial.prototype.showWinner = function (){
//   var topScore = 0;
//   var winner = [];
//   for (var i = 0; i < this.players.length; i++){
//     if (this.players[i].playerScore >= topScore ){
//       topScore = this.players[i].playerScore;
//       winner.push(this.players[i].name);
//     }
//   }
//   if (winner.length !== 1){
//   alert('The game is a tie between: ' + winner[0] + winner[1]);
//   }
//   else {
//   alert('The winner is: ' + winner[0]);
//   }
// }

Trivial.prototype.addPlayer = function (player){
  this.players.push(player);
}

Trivial.prototype.setPlayer = function(){
  var promptAddPlayer = prompt('Please enter your name');
   if (promptAddPlayer !== ''){
     var player = new Player(promptAddPlayer);
     this.addPlayer(player);
     this.setPlayer();
   }
}

var Player = function(name){
  this.name = name;
  this.playerScore = 0;
  this.playerCategoryScore = {};
  this.questionCount = 0;
}









var myTrivial = new Trivial ();
var question1 = new Question ('Capital of France', ['A - Paris', 'B - Rome'], 'A', 'geograpy', false);
var question2 = new Question ('Capital of USA', ['A - New York', 'B - Washington'], 'B', 'geograpy', false);
var question3 = new Question ('Capital of Switzerland', ['A - Bern', 'B - Zurich'], 'A', 'geograpy', false);
var question4 = new Question ('Capital of Spain', ['A - Barcelona', 'B - Madrid'], 'B', 'geograpy', false);
var question5 = new Question ('Autor of Pride and Prejudice', ['A - Jane Austen', 'B - J.K Rowiling'], 'A', 'literature', false);
var question6 = new Question ('Autor of Andorra', ['A - Friedrich Duerrenmatt', 'B - Max Frisch'], 'B', 'literature', false);
var question7 = new Question ('Theory of Relativity', ['A - Albert Einstein', 'B - Isaac Newton'], 'A', 'science', false);
var question8 = new Question ('Law of universal gravitation', ['A - Leonard Euler', 'B - Isaac Newton'], 'B', 'science', false);
var question9 = new Question ('Is the earth flat', ['A - yes, B - no'], false, 'science', true);
// var player1 = new Player('Amy')
// var player2 = new Player('Bob')



myTrivial.addQuestion(question1);
myTrivial.addQuestion(question2);
myTrivial.addQuestion(question3);
myTrivial.addQuestion(question4);
myTrivial.addQuestion(question5);
myTrivial.addQuestion(question6);
myTrivial.addQuestion(question7);
myTrivial.addQuestion(question8);
myTrivial.addQuestion(question9);
// myTrivial.addPlayer(player1);
// myTrivial.addPlayer(player2);

// myTrivial.askQuestion();
myTrivial.play();


console.log(question1);

console.log(question1.choices[1]);

console.log(myTrivial);
