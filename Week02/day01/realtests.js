
var exercises = require('./exercises.js');
var test = require('tape');
var isString = exercises.isString;
var areSameType = exercises.areSameType;




test('test areSameType function', function(t) {
  t.test('when passed an Array on both sides', function(t) {
    t.false(areSameType([1,2,[3]]), 'should return false') //
    t.end()
  });
});
