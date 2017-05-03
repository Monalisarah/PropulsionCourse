var test = require('tape');

function isString(checkValue01) {
  if (typeof checkValue01 === 'string') {
    return true;
  } else {
    return false;
  }
}
module.exports.isString = isString;



function isArray(checkValue02) {
  if (Array.isArray(checkValue02)) {
    return true;
  } else {
    return false;
  }
}
module.exports.isArray = isArray;


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
module.exports.areSameType = areSameType;


// Longest Exercise //
function longest(a, b) {
  var concatString = (a.concat(b));
  var newArray = [];

  for (var i = 0; i < concatString.length; i++) {
    if (newArray.indexOf(concatString[i]) === -1) {
      newArray.push(concatString[i]);
    }
  }
  newArray.sort();
}

longest("hallo", "du");
longest('abcccaa', 'acddddffzzz')
a = 'xyaabbbccccdefww'
b = 'xxxxyyyyabklmopq'
longest(a, b) // => 'abcdefklmopqwxy'
a = 'abcdefghijklmnopqrstuvwxyz'
longest(a, a) // => 'abcdefghijklmnopqrstuvwxyz'

module.exports.longest = longest;



// Convert number to reversed array of digits //
function convert(inputNumber) {
  var ourString = inputNumber.toString()
    .split('')
    .sort()
    .reverse();
}
module.exports.convert = convert;




// Count repetitions
// only bracket notation works with variables!

function countRepetitions(arrayOfStrings) {
  var repetitions = {};
  //  repetitions.Name = "Simona";
  //  var Name = 'name'
  // repetitions[Name] = "Manel";

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
module.exports.countRepetitions = countRepetitions;



// Cat and Mouse
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
module.exports.isCaught = isCaught;



// Split the bill
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




// Exponentiation
function exp(base, num) {
  if (base === 0 && num === 0) {
    return ('error');
  }
  if (num === 0){
    return 1;
  }
  return base * exp(base, num-1);
  }



// factorial
function factorial(num) {
  if (num === 0){
    return 1;
  }
  return num * factorial(num-1);
  }





//
// module.exports = {
//   isString: isString,
//   isArray: isArray,
//   areSameType: areSameType,
//   longest: longest,
//   convert: convert,
//   countRepetitions: countRepetitions,
//   isCaught: isCaught,
//   splitTheBill: splitTheBill,
//   exp: exp,
//   factorial: factorial
// }
