function Person(name, age) {
  this.name = name;
  this.isAlive = true;
  this.age = age;
}

Person.prototype.talk = function() {
  console.log('talking');
}

function Singer(name, age) {
  Person.call(this, name, age);
  this.canSing = true;
  // this.sing = function() {
  //   console.log('Singing in da rain!');
  // }
  this.constructor = Singer;
  // return this;
}

Singer.prototype = Object.create(Person.prototype);

Singer.prototype.sing = function() {
  console.log('Singing in da rain!');
}

var yusef = new Singer('Yusef', 18);
console.log(Singer.prototype.constructor);
console.log(yusef);
// yusef.sing();
// yusef.talk();
// console.log(yusef.__proto__.__proto__);
