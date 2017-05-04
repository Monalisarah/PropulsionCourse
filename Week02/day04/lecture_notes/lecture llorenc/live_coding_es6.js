const writer = {
  name: 'Hornby',
  books: ['Funny Girl', 'High Fidelity'],
  printBooks(editorial = 'Anagrama') {
    // var that = this;
    const printBook = (book) => {
      // console.log(this.name + ' has written ' + book);
      console.log(`${this.name}
        has written ${book}
        by ${editorial}`);
    };
    this.books.forEach(printBook);
  }
}

writer.printBooks();

const { books, name, printBooks } = writer;

console.log(printBooks === writer.printBooks);

// printBooks();

const goodWriter = {
  name: 'Fante',
  books: ['Wait til spring', 'Hollywood']
}

goodWriter.print = printBooks;
goodWriter.print();