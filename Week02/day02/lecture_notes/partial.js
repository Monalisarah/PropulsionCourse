function multiplyFive(a,b,c,d,e){
  return a*b*c*d*e;
}

var res = multiplyFive(2,1,4,3,10);
console.log(res);


// curried Version just an example
// var timesTwo = curriedMultiplier(2);
// var moreSteps = timesTwo(3,4,1);
// var res1 = moreSteps(10);

// function createMultiplier(a,b){
//  var multiplier = function(c,d,e) {
//    return a*b*c*d*e;
//  }
//  return multiplier;
// }
//
// var multiplyThree = createMultiplier(2,1);
// console.log(multiplyThree);
// var res2 = multiplyThree(3,4,10);
// console.log(res);
