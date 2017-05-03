function isString(checkValue01) {
  if (typeof checkValue01 === 'string') {
    return true;
  } else {
    return false;
  }
}

console.log(isString('hello'));
console.log(isString(['hello']));
console.log(isString('this is a long sentence'));
console.log(isString({
  a: 2
}));

/*
function isArray (checkValue02){
  if (checkValue02 instanceof Array) {
  return true;
  } else {
  return false;
  }
}

console.log(isArray('hello'));
console.log(isArray(['hello']));
console.log(isArray([2, {}, 10]));
console.log(isArray({ a: 2 }));
*/

function isArray(checkValue02) {
  if (Array.isArray(checkValue02)) {
    return true;
  } else {
    return false;
  }
}

console.log(isArray('hello'));
console.log(isArray(['hello']));
console.log(isArray([2, {}, 10]));
console.log(isArray({
  a: 2
}));


function areSameType(checkValue03) {
  for (var i = 1; i < checkValue03.length; i++) {
    if (typeof checkValue03[i] !== "object") {
      if (typeof checkValue03[i] !== typeof checkValue03[0]) {
        return false;
      }
    } else {
      if (isArray(checkValue03[i]) !== isArray(checkValue03[0])) {
        return false;
      }
    }
  }
  return true;
}


console.log("Are the Same type exercise:");
console.log(areSameType(['hello', 'world', 'long sentence']));
console.log(areSameType([
  ['hello'], 'hello', ['bye']
]));
console.log(areSameType([
  ['hello'],
  [1, 2, 3], {
    a: 2
  }
]));


// Longest Exercise //
console.log("longest string exercice");

function longest(a, b) {
  var concatString = (a.concat(b));
  var newArray = [];

  for (var i = 0; i < concatString.length; i++) {
    if (newArray.indexOf(concatString[i]) === -1) {
      newArray.push(concatString[i]);
    }
  }
  newArray.sort();
  console.log(newArray.join(''));

}

longest("hallo", "du");
longest('abcccaa', 'acddddffzzz')

a = 'xyaabbbccccdefww'
b = 'xxxxyyyyabklmopq'
longest(a, b) // => 'abcdefklmopqwxy'

a = 'abcdefghijklmnopqrstuvwxyz'
longest(a, a) // => 'abcdefghijklmnopqrstuvwxyz'



// Convert number to reversed array of digits //
console.log("Convert number to reversed array of digits");

function convert(inputNumber) {
  var ourString = inputNumber.toString()
    .split('')
    .sort()
    .reverse();

  console.log('our String: ', ourString);

}

convert(9745302);



// Count repetitions
console.log("Count repetitions exercice");
// only bracket notation works with variables!

function countRepetitions(arrayOfStrings) {
  var repetitions = {};
  //  repetitions.Name = "Simona";
  //  var Name = 'name'
  // repetitions[Name] = "Manel";
  console.log(repetitions);




  for (var i = 0; i < arrayOfStrings.length; i++) {
    if (repetitions[arrayOfStrings[i]] === false) {
      repetitions[arrayOfStrings[i]] = 1;
    }
    //else {
    //  repetitions[arrayOfStrings[i]] ++;
    //}
  }
  return repetitions;
}


console.log(countRepetitions(['kerouac', 'fante', 'fante', 'buk', 'hemingway', 'hornby', 'kerouac', 'buk', 'fante']));



// Cat and Mouse
console.log('Cat and Mouse Exercise')

function isCaught(string) {
  var jumpLength = 3;
  for (let i = 0; i < string.length; i++) {
    var char1 = string[i]
    if (char1 === 'C') {
      for (let j = i + 1; j <= i + jumpLength; j++)
        var char2 = string[j]
      if (char2 === 'm') {
        return true;
      }
    }
  }
  return false;
}


console.log(isCaught('C.....m')); // => false
console.log(isCaught('C..m')); // => true
console.log(isCaught('..C..m')); // => true





// Split the bill
console.log('Stplit the bill Exercise')


splitTheBill = function(group) {
  var total = 0
  for (var i in group) {
    total = total + group[i]
  }
  for (var i in group) {
    group[i] = (total / (Object.keys(group).length) - group[i]);
  }
  return group;
}

var group = {
  Amy: 20,
  Bill: 15,
  Chris: 10
}

console.log(splitTheBill(group));
splitTheBill(group); // => { Amy: -5, Bill: 0, Chris: 5 }



// Exponentiation
console.log('Exponentiation Exercise')

function exp(base, num) {
  if (base === 0 && num === 0) {
    return ('error');
  }
  if (num === 0){
    return 1;
  }
  return base * exp(base, num-1);
  }



// function exp(num, base) {
//   if (base === 0) {
//     return 1;
//   }
//
//   return num * exp(num, base - 1);
// }



console.log(exp(2, 4)); // => 16
console.log(exp(5, 1)); // => 5
console.log(exp(6, 0)); // => 1
console.log(exp(1, 0)); // => 1
console.log(exp(1, 1)); // => 1
console.log(exp(0, 0)); // => 1


// factorial
console.log('Factorial Exercise')

function factorial(num) {
  if (num === 0){
    return 1;
  }
  return num * factorial(num-1);
  }


console.log(factorial(5)); // => 120
console.log(factorial(4)); // => 24
console.log(factorial(0));; // => 1



// Fibonacci
console.log('Fibonacci Exercise');

// function fibs(n){
//   var fibonacciRow = [0,1];
//   for (var i= 2; i< n;i++ ){
//     fibonacciRow.push(fibonacciRow[i-2]+fibonacciRow[i-1]);
//   }
//   return fibonacciRow;
//
// }

// console.log(fibs(3)); // => [0, 1, 1]
// console.log(fibs(7)); // => [0, 1, 1, 2, 3, 5, 8]
// console.log(fibs(1)); // => [0]

// Write an recursive approach for this problem.




// Zero Sum
console.log('zeroSum Exercise');
//
// Write a function that expects an array of integers and returns an array of pairs with the indexes of two numbers that sum 0.
//
// zeroSum([1, 5, 0, -5, 3, -1]) // => [[0, 5], [1, 3]]
// zeroSum([1, -1]) // => [[0, 1]]
// zeroSum([0, 4, 3, 5]) // => []
// Do not repeat the pair again in the solution.
