import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Articles {

    static class Article {
        String title;
        String content;
        String author;

        String getTitle() {
            return title;
        }

        String getContent() {
            return content;
        }

        String getAuthor() {
            return author;
        }

        void setTitle(String title) {
            this.title = title;
        }

        void setContent(String content) {
            this.content = content;
        }

        void setAuthor(String author) {
            this.author = author;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        List<Article> initial = new ArrayList<>();
        Article article = new Article();
        article.setTitle(input.get(0));
        article.setContent(input.get(1));
        article.setAuthor(input.get(2));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] commands = line.split(": ");
            String toDo = commands[0];

            switch (toDo) {
                case "Edit":
                    article.setContent(commands[1]);
                    break;
                case "ChangeAuthor":
                    article.setAuthor(commands[1]);
                    break;
                case "Rename":
                    article.setTitle(commands[1]);
                    break;
            }
        }
        initial.add(article);
        System.out.printf("%s - %s: %s", article.getTitle(), article.getContent(), article.getAuthor());
    }
}
