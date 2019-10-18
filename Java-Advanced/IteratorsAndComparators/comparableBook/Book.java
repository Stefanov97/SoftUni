import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... args) {
        this.title = title;
        this.year = year;
        this.authors = Arrays.asList(args);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthors(String... authors) {
        this.authors = Arrays.asList(authors);
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return this.getTitle();
    }

    @Override
    public int compareTo(Book o) {
        String b1 = this.getTitle();
        String b2 = o.getTitle();
        if (b1.compareTo(b2) == 0) {
            return this.getYear() - o.getYear();
        }
        return b1.compareTo(b2);
    }
}
