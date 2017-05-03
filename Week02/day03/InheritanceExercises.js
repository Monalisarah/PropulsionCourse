// People!


function Person(firstName, lastName) {
  this.firstName = firstName;
  this.lastName = lastName;
  this.isAlive = true;
}

Person.prototype.greet = function() {
  console.log('Hello, this is ' + this.firstName + ' ' + this.lastName);
}


Writer
console.log('------Writer------');

function Writer(firstName, lastName, isAlive) {
  Person.call(this, firstName, lastName)
  this.isAlive = isAlive;
  this.pseudonym = (firstName.split('').reverse().join('') + lastName.split('').reverse().join(''));
  this.signBook = function() {
    console.log(this.pseudonym);
  }
}

Writer.prototype = Object.create(Person.prototype);
var Jane = new Writer('Jane', 'Austen', false)

console.log(Jane);
Jane.greet();


// Developer
console.log('------Developer------');

function Developer(firstName, lastName, codename) {
  Person.call(this, firstName, lastName)
  this.codename = codename;
}
Developer.prototype = Object.create(Person.prototype);

Developer.prototype.impress = function() {
  for (let i = 0; i < 5; i++) {
    console.log('0101010101')
  }
  console.log(this.codename);
}

var manel = new Developer('Manel', 'Pavon', 'Ping Pong King')
manel.impress();
manel.greet();


Singer
console.log('------Singer------');

function Singer(firstName, lastName, melody) {
  Person.call(this, firstName, lastName)
  this.melody = melody;
  this.artisticName = 'Fancy' + firstName + 'Fancy' + lastName
}
Singer.prototype = Object.create(Person.prototype);

Singer.prototype.sing = function() {
  for (let i = 0; i < 3; i++) {
    console.log(this.melody)
  }
}

var Annakin = new Singer('AnnKathrin', 'Luethi', 'Will you recognize the songs that reflect your light')
  console.log(Annakin);
  Annakin.sing();
  Annakin.greet();



// JuniorDeveloper
// console.log('------Junior Developer------');
//
// function JuniorDeveloper(firstName, lastName, codename) {
//   Developer.call(this, firstName, lastName)
// }
//
//
// var earlyManel = new JuniorDeveloper('Manel', 'Pavon', 'Pong Prince')
