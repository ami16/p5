package edu.cursor.model;

import edu.cursor.constants.Defined;
import javax.persistence.*;


@Entity(name = Defined.Tables.BOOKS)
public class Book {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(name="isbn")
   private int isbn;

   @Column(name="title")
   private String title;

   @Column(name="author")
   private String author;

   public Book() {}

   public Book(int isbn, String title, String author) {
      this.isbn = isbn;
      setIsbn(isbn);
      this.title = title;
      this.author = author;
   }

   public int getIsbn() {
      return isbn;
   }

   public Book setIsbn(int isbn) {
      this.isbn = isbn;
      return this;
   }

   public String getTitle() {
      return title;
   }

   public Book setTitle(String title) {
      this.title = title;
      return this;
   }

   public String getAuthor() {
      return author;
   }

   public Book setAuthor(String author) {
      this.author = author;
      return this;
   }


   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Book)) return false;

      Book book = (Book) o;

      if (getIsbn() != book.getIsbn()) return false;
      if (!getTitle().equals(book.getTitle())) return false;
      return getAuthor().equals(book.getAuthor());

   }

   @Override
   public int hashCode() {
      int result = getIsbn();
      result = 31 * result + getTitle().hashCode();
      result = 31 * result + getAuthor().hashCode();
      return result;
   }
}