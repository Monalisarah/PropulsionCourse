
// Class Dish
function Dish (name, ingredients){
  this.name = name;
  this.ingredients = ingredients;
}

Dish.prototype.cost = function(){
  var totalCost = 0;
  for (var i=0; i<this.ingredients.length; i++){
    totalCost = totalCost + this.ingredients[i].cost;
  }
  return totalCost;

}


// Class Restaurant
function Restaurant (){
  this.orders = [];
  this.check = [];
}

Restaurant.prototype.orderDish = function(dish){
  this.orders.push(dish);
}

Restaurant.prototype.printOrders = function(){

  for (var i=0; i< this.orders.length; i++)
   console.log('Order#' + i + ': ' + this.orders[i]['name']);
   // ['name'] -> key [name] -> variable called name
   //console.log('Order#' + i + ': ' + this.orders[i].name);
   // with dot notation you can only use keys
}




// Class Ingredient
function Ingredient(name, cost){
  this.name = name;
  this.cost = cost;
}




var myRestaurant = new Restaurant();

var cheese = new Ingredient('cheese', 2);
var tomato = new Ingredient('tomato', 3);
var dough = new Ingredient('dough', 4);
var pepperoni = new Ingredient('pepperoni', 5);
var lettuce = new Ingredient('lettuce', 6);

var pizza = new Dish('Pizza', [cheese, pepperoni, dough]);
var salad = new Dish('Salad', [lettuce, cheese, tomato]);

myRestaurant.orderDish(pizza);
myRestaurant.orderDish(salad);
myRestaurant.orderDish(pizza);
console.log(myRestaurant.orders);
console.log(pizza.cost());




myRestaurant.printOrders();
