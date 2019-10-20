import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        boolean isBalanced = true;
            for (int i = 0; i <input.length() ; i++) {
                char symbol = input.charAt(i);
                if(stack.isEmpty()){
                    if(symbol==')' || symbol == '}' || symbol==']'){
                        isBalanced=false;
                        break;
                    }
                }
                if(symbol=='(' || symbol == '{' || symbol=='['){
                    stack.push(String.valueOf(symbol));
                }else {
                    if(symbol==')' && !stack.pop().equals("(")){
                        isBalanced=false;
                        break;
                    }else if(symbol=='}' && !stack.pop().equals("{")){
                        isBalanced=false;
                        break;
                    }else if(symbol==']' && !stack.pop().equals("[")){
                        isBalanced = false;
                        break;
                    }
                }
            }


        if(isBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
