package com.util;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/4/17 10:41.
 * @motto : To be, or not to be.
 */
public class Book {
    public int Id_B;
    public String BookName;
    public String ISBN;
    public String Price;
    public String Author;

    public int getId_B() {
        return Id_B;
    }

    public void setId_B(int id_B) {
        Id_B = id_B;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id_B=" + Id_B +
                ", BookName='" + BookName + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", Price='" + Price + '\'' +
                ", Author='" + Author + '\'' +
                '}';
    }
}
