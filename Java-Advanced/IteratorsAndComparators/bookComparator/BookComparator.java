import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BookComparator implements Comparator<Book> {


    @Override
    public int compare(Book b1, Book b2) {
        if (b1.getTitle().compareTo(b2.getTitle()) == 0) {
            return b1.getYear() - b2.getYear();
        } else return b1.getTitle().compareTo(b2.getTitle());
    }
}
