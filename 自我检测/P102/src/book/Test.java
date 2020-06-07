package book;

import book.Book;

/**
 * @Author: Harlan
 * @Date: 2020/6/6 23:08
 */
public class Test {
    public static void main(String[] args) {
        Book java = new Book("java", 99.0);
        System.out.println(Book.getCount());
        Book c = new Book("c",99.0);
        System.out.println(Book.getCount());
        Book python = new Book("python", 99.0);
        System.out.println(Book.getCount());
        System.out.println(java.toString());
        System.out.println(c.toString());
        System.out.println(python.toString());
    }
}
