function sum(a, b = 0) {
  return a + b;
}

console.log('in da index.js');

var Dish = function(name, price, ingredients) {
  this.name = name;
  this.price = price;
  this.baseCost = 10;
  this.ingredients = ingredients;
}

Dish.prototype.profit = function() {
  var ingredientsCost = this.ingredients.reduce(function(acc, ingredient) {
    return ingredient.cost + acc;
  }, 0);

  return this.price - this.baseCost - ingredientsCost;
}

module.exports = {
  sumFn: sum,
  Dish: Dish,
};
