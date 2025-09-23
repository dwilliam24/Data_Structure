import java.util.IllegalFormatCodePointException;

public class DS2_Infix_Postfix_Calculator {

    public static void main(String[] args) {

    }
    public static String infixToPostfix(String infix){
        MyStack<String> stack = new MyStack();
        String postfix ="";

        for (int i =0; i<infix.length(); i++){
            String a = infix.charAt(i)+"";
            if ("+-*/^".contains(a)){
                stack.push(a);
            }
            if (!"+-*/^()".contains(a)) {
                postfix+=a;

            }
            if ("(".contains(a)) {
                stack.push("(");
            }
            if (")".contains(a)){
                boolean g=true;
                while (g)
                {
                    String f = stack.pop();
                    if (!("(".equals(f))){
                        postfix+=f;
                    }
                    g=false;
                }
            }
        //   ( 10 - 2.5 ) / ( 3 + 1.5 ^ 2 )


            System.out.println(i);
            System.out.println(stack);
            System.out.println(postfix+"\n");
        }
        System.out.println("\n\n\n");
        System.out.println(stack);
        System.out.println(postfix+"\n");
        while (!stack.isEmpty())
        {

            String a = stack.pop();
            if(!"()".contains(a))
            {
                postfix+=" "+a;
            }
        }
        return postfix;
    }

}
