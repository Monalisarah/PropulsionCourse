var test = require('tape');


function longest(a, b) {
  var concatString = (a+b);
  var newArray = [];

  for (var i = 0; i < concatString.length; i++) {
    if (newArray.indexOf(concatString[i]) === -1) {
      newArray.push(concatString[i]);
    }
  }
  return newArray.sort().join('');
}


test('longest function',function(t){
  t.test('with different strings', function(t){
      let a = 'ab';
      let b = 'cd';
    t.equal(longest(a,b),'abcd', 'should return true');
    t.end();
  })
})
