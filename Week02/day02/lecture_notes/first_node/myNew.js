function Person(name) {
  this.name = name;
}

function myNew(ConstrucorFn) {
  // var obj = {};
  // Create and set obj.__proto__ to be Singer.prototype
  var obj = Object.create(ConstrucorFn.prototype);
  ConstrucorFn.call(obj);
  // Set obj.__proto__ to be Singer.prototype
  // Object.setPrototypeOf(obj, ConstrucorFn.prototype);

  return obj;
}

console.log('creating Person');
var manel = myNew(Person, 'Manel');
console.log(manel);

// function Singer() {
//   this.name = 'Yusef'
// }
//
// Singer.prototype.sing = function() {
//   console.log('Singing in da rain!');
// }
//
// var yusef = myNew(Singer);
// // var yusef = new Singer();
// console.log(yusef.__proto__);
// yusef.sing()
