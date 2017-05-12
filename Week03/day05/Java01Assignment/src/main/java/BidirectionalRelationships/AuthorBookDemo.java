package BidirectionalRelationships;

import domain.Author;
import domain.Book;

public class AuthorBookDemo {
	
	public static void main(String[] args) {
		Author author = nwe Author("Einstein");
		
		Book book = new Book("Theory of Relativity", author)
		
		System.out.println(author);
	}

}
