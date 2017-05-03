var test = require('tape');



function isArray(checkValue02) {
  if (Array.isArray(checkValue02)) {
    return true;
  } else {
    return false;
  }
}


// only one test class per file!!!
test('Test isArray function ', function(t) {
  t.test('when passing an Array', function(t){
    t.ok(isArray([]), 'should return true');
    t.ok(isArray([{},{}]), 'should return true');
    t.end();
    });
  t.test('when passing a String', function(t){
    t.notOk(isArray('hello World'), 'should return false');
    t.end();
    });
  t.test('when passing a Number', function(t){
    t.notOk(isArray(4), 'should return false');
    t.end();
    });
  t.test('when passing an Object', function(t){
    t.notOk(isArray({a: 'hello'}), 'should return false');
    t.end();
    });
});
