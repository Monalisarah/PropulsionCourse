
console.log(h)

if (true){
  var h = 'hello'
}
console.log(h);


// no hoisting with let and const yo can not use it before you define it
// with var you can do that
// if (true){
//   console.log(h)
//   let h = 'hello'
//   console.log(h);
// }


var yell1 = (msg) => {
  console.log(msg.toUpperCase);
}
yell1('hello world')


function yell2(msg){
  console.log(msg.toUpperCase);
}
yell2('hello world')


// const yell3 = (msg) => {
//   return msg.toUpperCase();
// }

// const yell4 = (msg) => return msg.toUpperCase();
// console.log(yell4('hello world'));


const filtered = [2,4,10]
.map(num => num * num)
.filter(num => num > 10)
console.log(filtered);


const newFiltered = filtered
newFiltered.push(200);
console.log(newFiltered);
console.log(filtered);


// const writer = {
//   name: 'Hornby',
//   books: ['Funny Girl', 'High Fidelity']
//   printBooks: function (){
//     var that = this;
//     this.books.forEach(function(book){
//       console.log(that.name + 'has written ' + book);
//     })
//   }
// }
//
// writer.printBooks();


// const writer = {
//   name: 'Hornby',
//   books: ['Funny Girl', 'High Fidelity']
//   printBooks: function (){
//     this.books.forEach((book) => {
//       console.log(this.name + 'has written ' + book);
//     });
//   }
// }
//
// writer.printBooks();


const writer = {
  name: 'Hornby',
  books: ['Funny Girl', 'High Fidelity'],
  printBooks(){
    const printBook =(book) =>{
      console.log(this.name + 'has written ' + book);
    };
    this.books.forEach(printBook);
  }
}

writer.printBooks();


const {books,name} = writer;
console.log(books);
