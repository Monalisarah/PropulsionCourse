var modules = require('./index.js');
var sumFn = modules.sumFn;
var Dish = modules.Dish;
var test = require('tape');

var createPizza = function(ingredients) {
  return new Dish('Pizza', 20, ingredients);
}

test('Dish Class', function(t) {
  t.test('constructor', function(t) {
    var pizza = createPizza(['pasta', 'mozzarella', 'sausage']);
    var expectedPizza = {
      name: 'Pizza',
      price: 20,
      baseCost: 10,
      ingredients: ['pasta', 'mozzarella', 'sausage']
    };
    t.deepEqual(pizza, expectedPizza, 'Should build a pizza');
    t.end();
  });

  t.test('profit method', function(t) {
    var ingredients = [
      { cost: 2 },
      { cost: 1 }
    ];
    var pizza = createPizza(ingredients);
    var expectedProfit = 20 - 10 - 3;
    t.equal(pizza.profit(), expectedProfit, 'should return profit');
    t.end();
  })
});

test('sum function', function(t) {
  t.test('when passing two integers', function(t) {
    t.equal(sumFn(3, 7), 10, 'sums two integers');
    t.end();
  });

  t.test('when passing one integer', function(t) {
    t.equal(sumFn(3), 3, 'returns the same number');
    t.end();
  });
})
