import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    static class Message {
        String phrases;
        String events;
        String authors;
        String cities;

        String getPhrases() {
            return phrases;
        }

        String getEvents() {
            return events;
        }

        String getAuthors() {
            return authors;
        }

        String getCities() {
            return cities;
        }

        void setPhrases(String phrases) {
            this.phrases = phrases;
        }

        void setEvents(String events) {
            this.events = events;
        }

        void setAuthors(String authors) {
            this.authors = authors;
        }

        void setCities(String cities) {
            this.cities = cities;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Message> allMessages = new ArrayList<>();

        Message firstMessage = new Message();
        firstMessage.setPhrases("Excellent product.");
        firstMessage.setEvents("Now I feel good.");
        firstMessage.setAuthors("Diana");
        firstMessage.setCities("Burgas");
        allMessages.add(firstMessage);

        Message secondMessage = new Message();
        secondMessage.setPhrases("Such a great product.");
        secondMessage.setEvents("I have succeeded with this product.");
        secondMessage.setAuthors("Petya");
        secondMessage.setCities("Sofia");
        allMessages.add(secondMessage);

        Message thirdMessage = new Message();
        thirdMessage.setPhrases("I always use that product.");
        thirdMessage.setEvents("Makes miracles. I am happy of the results!");
        thirdMessage.setAuthors("Stella");
        thirdMessage.setCities("Plovdiv");
        allMessages.add(thirdMessage);

        Message fourthMessage = new Message();
        fourthMessage.setPhrases("Best product of its category.");
        fourthMessage.setEvents("I cannot believe but now I feel awesome.");
        fourthMessage.setAuthors("Elena");
        fourthMessage.setCities("Varna");
        allMessages.add(fourthMessage);

        Message fifthMessage = new Message();
        fifthMessage.setPhrases("Exceptional product.");
        fifthMessage.setEvents("Try it yourself, I am very satisfied.");
        fifthMessage.setAuthors("Katya");
        fifthMessage.setCities("Ruse");
        allMessages.add(fifthMessage);

        Message sixthMessage = new Message();
        sixthMessage.setPhrases("I can’t live without this product.");
        sixthMessage.setEvents("I feel great!");
        sixthMessage.setAuthors("Iva");
        allMessages.add(sixthMessage);

        Message seventhMessage = new Message();
        seventhMessage.setAuthors("Annie");
        allMessages.add(seventhMessage);

        Message eightMessage = new Message();
        eightMessage.setAuthors("Eva");
        allMessages.add(eightMessage);

        int n = Integer.parseInt(scanner.nextLine());
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(6);
            System.out.print(allMessages.get(randomNumber).getPhrases() + " ");
            System.out.print(allMessages.get(randomNumber).getEvents() + " ");
            int secRandom = random.nextInt(8);
            System.out.print(allMessages.get(secRandom).getAuthors() + " - ");
            int thirdRandom = random.nextInt(5);
            System.out.print(allMessages.get(thirdRandom).getCities());
            System.out.println();

        }


    }
}
