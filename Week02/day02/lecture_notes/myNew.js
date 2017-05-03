function Person () {
  console.log('in da Person');
  console.log(this);
  this.name = 'Manel'
}

var manel = new Person();
console.log(manel);

var manel = 


function myNew(ConstructorFn){
  console.log('in da myNew');
  var obj = {a: 2};
//  2 ways for creating an empty object:
//  var obj = Object.create({}); you can already set the prototype when you create the Object
//  var obj ={}
var obj = Object.create(ConstructorFn.prototype);
  ConstructorFn.call(obj);
// Set obje.__proto__ to be Singer.prototype
// Object.setPrototypeOf(obj, ConstructorFn.prototype); not needed anymore because the prototype is set in the Object.create
  return obj;
}

// console.log('creating Person');
// var manel = myNew(Person);
// console.log(manel);


function Singer(){
  console.log('in da Singer');
  console.log(this);
  this.name = 'Yusef'
}

Singer.prototype.sing = function() {
  console.log('Singing in the rain');
}


var yusef = myNew(Singer);
// var yusef = new Singer();
console.log(yusef);
console.log(yusef.__proto__);
yusef.sing();
