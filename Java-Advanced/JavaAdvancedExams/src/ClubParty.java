import java.util.*;

public class ClubParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hallsCapacity = Integer.parseInt(scanner.nextLine());

        String[] tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<String> hallsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> peopleQueue = new ArrayDeque<>();
        Map<String, Integer> myMap = new LinkedHashMap<>();
        List<Integer> companies = new ArrayList<>();
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (Character.isDigit(token.charAt(0))) {
                if (!hallsQueue.isEmpty()) {
                    peopleQueue.offer(Integer.parseInt(token));
                    int currentCapacity = myMap.get(hallsQueue.peek());
                    if (currentCapacity - Integer.parseInt(token) >= 0) {
                        myMap.put(hallsQueue.peek(), currentCapacity - Integer.parseInt(token));
                        companies.add(Integer.parseInt(token));
                    } else {
                        String currentHall = hallsQueue.poll();
                        System.out.print(String.format("%s -> ", currentHall));
                        for (int j = 0; j < companies.size(); j++) {
                            if (j == companies.size() - 1) {
                                System.out.print(companies.get(j));
                            } else {
                                System.out.print(companies.get(j) + ", ");
                            }
                        }
                        System.out.println();
                        companies.clear();
                        i++;
                    }
                }
            } else {
                hallsQueue.offer(token);
                myMap.put(token, hallsCapacity);
            }
        }
    }
}
