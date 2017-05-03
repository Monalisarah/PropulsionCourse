var Dish = function(name, price, ingredients) {
  this.name = name;
  this.price = price;
  this.baseCost = 10;
  this.ingredients = ingredients;
}

// console.log('Before method', Dish.prototype);

Dish.prototype.profit = function() {
  var ingredientsCost = this.ingredients.reduce(function(acc, ingredient) {
    return ingredient.cost + acc;
  }, 0);

  return this.price - this.baseCost - ingredientsCost;
}

Dish.prototype.author = 'Yusef';

// console.log('after method', Dish.prototype);

var salad = new Dish('Salad', 15, [
  { cost: 2, name: 'lettuce' },
  { name: 'kale', cost: 3 },
  { name:'nuts', cost: 1 }
]);
console.log(salad.author);
console.log(salad.__proto__ === Dish.prototype);

console.log(salad.profit());

// salad.profit = function() {
//   console.log('hacked!');
// }
Dish.prototype.profit = function() {
  console.log('hacked');
}

console.log(salad.__proto__.profit.call(salad));
