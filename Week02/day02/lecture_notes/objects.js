

var Dish = function (name, price, ingredients){
  this.name = name;
  this.price = price;
  this.baseCost = 10;
  this.ingredients = ingredients;
}

console.log('before method', Dish.porototype);

//  prototype for functions

Dish.prototype.profit = function (){
  var ingredientsCost = ingredients.reduce(function(acc,ingredient){
    return ingredient.cost + acc;
  },0);
  return this.price - this.baseCost - ingredientsCost;
}

Dish.prototype.author = 'Yusef'

console.log('later method', Dish.porototype);

var salad = new Dish ('Salad', 15, [
  {cost:2, name:'lettuce'},
  {name:'kale', cost: 3},
  {cname:'lettuce', cost: 1},
]);

console.log(salad.author);
// console.log(salad);
// console.log(salad._proto_);
console.log(salad.__proto__ === Dish.prototype);
// console.log(salad.author);
//  _proto_ for Objects

// console.log(salad._proto_.profit());
// you can not do this because in this example the Context of the .profit is _proto_

console.log(salad.__proto__.profit.call(salad));
