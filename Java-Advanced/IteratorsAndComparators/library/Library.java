import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new Iterator<Book>() {
            int index;

            @Override
            public boolean hasNext() {
                return index < books.length;
            }

            @Override
            public Book next() {
                return books[index++];
            }
        };
    }
}
