
// Expanded Math Object
console.log('Expanded Math Object');

var myMath = Object.create(Math);
console.log(myMath);
console.log(myMath.__proto__);

myMath.randomInt = function(numMax, numMin=0){
  let max = numMax + 1
  let min = numMin
  return Math.floor(Math.random() * (max - min)) + min;
}

// console.log(myMath.randomInt(5)); // 3 for example
// console.log(myMath.randomInt(10)); // 10 for example
// console.log(myMath.random());
// console.log(myMath.round(0.5));
// console.log(myMath.randomInt(10, -4)); // -3 for example



// Add reverse method to String Object
console.log('Add reverse method to String Object');

String.prototype.reverse = function(){
  let originalString = this;
  let newString = ''
  for (var i = this.length-1; i >=0; i--) {
    newString = newString + this[i]
  }
  return newString;
}

console.log('hello'.reverse());
















// myEach
console.log('myEach');

myEach = function (array, fn){
  for (let i=0; i< array.length; i++){
    fn(array[i], i, array);
  }
};

myEach([1,2,3], function(element, index) {
  console.log(element *2);
});


// myMap
console.log('myMap');


// myMap = function (array, fn){
//   let newArray = []
//   for (let i=0; i< array.length; i++){
//     newArray.push(fn(array[i], i, array));
// }
// return newArray;
// }

myMap = function (array, fn){
  let newArray = [];
  let pushFn = function(element){ newArray.push(fn(element))}
  myEach(array, pushFn)
  return newArray;
}

var newArray2 = myMap([1,2,3], function(value, index, array){
  return value + 10;
})

console.log(newArray2);

// Map function reference
// var newArray = [1,2,3].map(function(value, index, array){
//   return value +10;
// })


// myFilter
console.log('myFilter');


myFilter = function (array, fn){
  let newArray = [];

}


// we only push if the condition is true 

function isBigEnough(value) {
  return value >= 10;
}
var filtered = [12, 5, 8, 130, 44].filter(isBigEnough);
// filtered is [12, 130, 44]
