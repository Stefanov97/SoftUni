import java.util.*;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> prime = new ArrayList<>();
        prime.add(2);
        prime.add(3);
        prime.add(5);
        prime.add(7);
        prime.add(11);
        prime.add(13);
        prime.add(17);
        prime.add(19);
        prime.add(23);
        prime.add(29);
        prime.add(31);
        prime.add(37);
        prime.add(41);
        prime.add(43);


        String[] input = scanner.nextLine().split("\\s+");
        int times = Integer.parseInt(scanner.nextLine());
        int cycles = 1;
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, input);
        while (queue.size() > 1) {
            for (int i = 1; i < times; i++) {
                queue.offer(queue.poll());
            }
            if (prime.contains(cycles)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());

            }
            cycles++;
        }
        System.out.println("Last is " + queue.poll());
    }
}
