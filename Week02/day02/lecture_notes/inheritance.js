function Person(name, age){
  this.name = name;
  this.isAlive = true;
  this.age = age;
}


Person.prototype.talk = function() {
  console.log('talking');
}


function Singer(name, age) {

  // console.log('in da singer');
  // console.log(this);
  Person.call(this, name, age);
  //  is the same as Person(name,age)
  // is doing return this; but we do not see it
  // to add a property you can do it like this
  this.canSing = true;
}

Singer.prototype = Object.create(Person.prototype);

Singer.prototype.sing = function() {
 console.log('Singing in da rain!');
}
// could also be added as aproperty of the function Singer but you usally
// do not do it because it increases the size of the object


var yusef = new Singer('Yusef', 18);
console.log(yusef);
yusef.sing();
yusef.talk();
console.log(yusef.__proto__);
// prototype of yusef is Singer prototype of Singer is pointing to the Person
console.log(yusef.__proto__.__proto__);
// accessing the prototype of the Singer prototype which is talk
