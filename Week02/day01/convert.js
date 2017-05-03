var test = require('tape');


function convert(inputNumber) {
  var ourString = inputNumber.toString()
    .split('')
    .sort()
    .reverse();
}
convert(9745302);

test('Testing convert function', function(t){
  t.test('converting numbers', function(t){
    t.equal(convert(1234),[4,3,2,1],'Should return true')
    t.end();
  })
})


// test fails!!!!
