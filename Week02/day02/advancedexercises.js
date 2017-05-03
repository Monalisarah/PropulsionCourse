// Expanded Math Object
console.log('Expanded Math Object')

var myMath = Object.create(Math);
console.log(myMath);
console.log(myMath.__proto__);

myMath.randomInt = function(max) {
  return this.round(this.random() * max);
}



// rAdd reverse method to String object
console.log('Add reverse method to String object')

String.prototype.reverse = function() {
  return this.split('').reverse().join('');
}
console.log('hello'.reverse());


// myEach
console.log('myEach')

function myEach(array, fn) {
  for (var i = 0; i < array.length; i++) {
    fn(array[i], i, array)
  }
}

myEach([1, 2, 5], function(el, index, arr) {
  console.log(el, index, arr);
});



// myMap
console.log('myMap')

function myMap(array, fn) {
  var newArray = [];
  var pushFn = function(element) {
    newArray.push(fn(element))
  }
  myEach(array, pushFn);
  return newArray;
}

var numbers = myMap([2, 4, 6], function(el) {
  return el + 10;
});

console.log(numbers);



// myFilter
console.log('myFilter')

function myFilter(array, fn) {
  var newArray = [];
  var pushFn = function(el, index, arr) {
    if (fn(el, index, arr)) {
      newArray.push((el))
    }
  }
  myEach(array, pushFn);
  return newArray;
}
var filtered = myFilter([2, 8, 5, 15], function(el, index, arr) {
  return el % index === 0;
});

console.log(filtered);


// merge
console.log('merge')

function merge(objectsToMerge) {
  var newObject = {}
  for (var i = 0; i < objectsToMerge.length; i++) {
    var keys = Object.keys(objectsToMerge[i])

    for (var y = 0; y < keys.length; y++) {
      if (keys[y] in newObject === false)
        newObject[keys[y]] = objectsToMerge[i][keys[y]]
    }
  }
  return newObject;
};

var object1 = {
  a: 1,
  b: 2,
  c: 3
}

var object2 = {
  a: 2,
  b: 3,
  c: 4
}

console.log(merge([object1, object2]));
