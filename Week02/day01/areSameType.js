
var test = require('tape');

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

function isArray(checkValue02) {
  if (Array.isArray(checkValue02)) {
    return true;
  } else {
    return false;
  }
}

test('test areSameType function', function(t){
  t.test('when passed different types', function(t){
    t.notOk(areSameType([1,2,[3]]), 'should return false')
    t.notOk(areSameType([{},2,[3]]), 'should return false')
    t.notOk(areSameType([false,{},[3]]), 'should return false')
    t.end()
  });
  t.test('when passed same types', function(t){
    t.ok(areSameType([1,2,3,4]), 'should return true')
    t.ok(areSameType([true ,false, false, true]), 'should return true')
    t.ok(areSameType([{a: 'hello'},{b: 'world'},{c: 1},{d:[1]}]), 'should return true')
    t.end()
  });
});
