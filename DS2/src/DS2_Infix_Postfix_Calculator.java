import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DS2_Infix_Postfix_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an equation in infix form (separating values and operators with spaces): ");
        String input = scanner.nextLine();
        String postfix = infixToPostfix(input);
        System.out.println("Postfix Form: "+ postfix);
        System.out.printf("Result: %.2f", solvePostfix(postfix));
    }

    public static String infixToPostfix(String infix){
        Stack<String> stack2 = new Stack<>();
        MyStack<String> stack = new MyStack();
        String postfix ="";
        String[] split = infix.split(" ");
        for (int i =0; i< split.length; i++){
            String a = split[i];

            if ("+-*/^".contains(a)){
                boolean p = false;
                if (!stack.isEmpty()&&!"(".contains(stack.peek())&&(("^".contains(stack.peek())&&"^*/+-".contains(a)) || ("*/".contains(stack.peek())&&"*/+-".contains(a)) || ("+-".contains(stack.peek())&&"+-".contains(a)))) {
                    postfix += stack.pop()+" ";
                    if (!stack.isEmpty()&&!"(".contains(stack.peek())&&(("^".contains(stack.peek())&&"^*/+-".contains(a)) || ("*/".contains(stack.peek())&&"*/+-".contains(a)) || ("+-".contains(stack.peek())&&"+-".contains(a)))) {
                        postfix += stack.pop()+" ";
                        stack.push(a);
                        p=true;
                    }
                    if(!p)stack.push(a);
                }
                else stack.push(a);
            }
            else if (!"+-*/^()".contains(a)) {
                postfix+=a+" ";

            }
            else if ("(".contains(a)) {
                stack.push("(");
            }
            else if (")".contains(a)){
                boolean g=true;
                while (g) {
                    String f = stack.pop();
                    if (!("(".contains(f))){
                        postfix+=f+" ";

                    }
                    else g=false;
                }
            }
        }
        while (!stack.isEmpty()) {

            String a = stack.pop();
            if(!"()".contains(a)) {
                postfix+=a+" ";
            }
        }
        String fix = postfix;
        if (" ".contains(postfix.charAt(postfix.length()-1)+"")) fix=postfix.substring(0,postfix.length()-1);
        return fix;
    }

    public static double solvePostfix(String postfix){
        MyStack<Double> stack = new MyStack<>();
        String[] split = postfix.split(" ");
        for (int i =0; i< split.length; i++){
            String a = split[i];
            if ("^*/+-".contains(a)) {
                double temp1 = stack.pop();
                double temp2 = stack.pop();
                if (a.equals("^")) stack.push(Math.pow(temp2,temp1));
                else if (a.equals("*")) stack.push(temp2*temp1);
                else if (a.equals("/")) stack.push(temp2/temp1);
                else if (a.equals("+")) stack.push(temp2+temp1);
                else if (a.equals("-")) stack.push(temp2-temp1);
            } else if (!"^*/+-".contains(a)) {
                stack.push(Double.parseDouble(a));
            }
        }
        return stack.pop();
    }

}
