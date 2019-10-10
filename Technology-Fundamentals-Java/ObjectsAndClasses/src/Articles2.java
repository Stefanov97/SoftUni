import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Articles2 {
    static class Article {
        String title;

        public String getAuthor() {
            return author;
        }

        String content;
        String author;

        public String getContent() {
            return content;
        }

        public String getTitle() {
            return title;
        }

        Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        @Override
        public String toString() {
            return String.format("%s -%s:%s", this.title, this.content, this.author);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split(",");
            String title = commands[0];
            String content = commands[1];
            String author = commands[2];
            Article article = new Article(title, content, author);
            articles.add(article);

        }
        String criteria = scanner.nextLine();
        switch (criteria) {
            case "title":
                articles.sort((s, f) -> s.getTitle().compareTo(f.getTitle()));
                break;
            case "content":
                articles.sort((s, f) -> s.getContent().compareTo(f.getContent()));
                break;
            case "author":
                articles.sort((s, f) -> s.getAuthor().compareTo(f.getAuthor()));
                break;
        }

        for (Article article : articles) {
            System.out.println(article.toString());
        }

    }
}
