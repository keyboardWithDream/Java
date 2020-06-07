package book;

/**
 * @Author: Harlan
 * @Date: 2020/6/6 23:04
 */
public class Book {
    private String bookName;
    private int bookId;
    private double bookPrice;
    private static int count = 0;

    public Book(String bookName, double bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookId = 1001 + count;
        count ++;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookId=" + bookId +
                ", bookPrice=" + bookPrice +
                '}';
    }
}
