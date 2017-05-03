var test = require('tape');

function isString(checkValue01) {
  if (typeof checkValue01 === 'string') {
    return true;
  } else {
    return false;
  }
}


test('Test isString function ', function(t) {
  t.test('when passed a string', function(t) {
    t.ok(isString('hello'), 'should return true');
    t.ok(isString('hello form the other side'), 'should return true');
    t.end();
  });
  t.test('when passing a number', function(t){
    t.notOk(isString(5), 'should return false');
    t.end();
  });
  t.test('when passing an Array', function(t){
    t.notOk(isString(['hello']), 'should return false');
    t.end();
  });
  t.test('when passing an Object', function(t){
    t.notOk(isString({a: 'hello'}), 'should return false');
    t.end();
  });
});
