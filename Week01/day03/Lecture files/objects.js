
function yell(msg) {
  console.log(msg.toUpperCase());
  console.log(this === newCtx);
}

// Function style
// yell('aaahhh');

var bogdan = {
  name: 'Bogdan',
  complain: yell
}

// method style
// console.log('method style');
// bogdan.complain('aahh');

// constructor style
// console.log('constructor style');
// var res = new yell('aahh');
// console.log(res);

// indirect invocation
// console.log('indirect style');
// var newCtx = { a: 2 };
// yell.call(newCtx, 'aahh');

var Writer = function(name, books) {
  this.name = name;
  this.books = books;
}

Writer.prototype.printBook = function (book) {
  console.log(this);
  console.log(this.name + ' wrote ' + book);
}

Writer.prototype.printBooks = function() {
  console.log('books from: ' + this.name);
  // function printBook(book) {
  //   console.log(this);
  //   console.log(this.name + ' wrote ' + book);
  // }
  // var writer = this;
  // var boundPrint = printBook.bind(this);
  this.books.forEach(this.printBook.bind(this));
}

var fante = new Writer('John Fante', ['wait til the spring bandini', 'Hollywood']);
fante.printBooks();
