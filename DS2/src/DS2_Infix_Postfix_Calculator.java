import java.util.IllegalFormatCodePointException;

public class DS2_Infix_Postfix_Calculator {

    public static void main(String[] args) {

    }
    public static String infixToPostfix(String infix){
        MyStack<String> stack = new MyStack();
        String postfix ="";
        String[] split = infix.split(" ");
        for (int i =0; i< split.length; i++){
            String a = split[i];
            if ("+-*/^".contains(a)){
                stack.push(a);
            }
            if (!"+-*/^()".contains(a)) {
                postfix+=a+" ";

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
                        postfix+=f+" ";
                    }
                    g=false;
                }
            }
        //   ( 2.5 + 1.5 ) ^ 2 - 10 / ( 4 ^ 2.0 ) + 7 * 0.3


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
                postfix+=a+" ";
            }
        }
        String fix = postfix;
        if (" ".contains(postfix.charAt(postfix.length()-1)+"")) fix=postfix.substring(0,postfix.length()-1);
        return fix;
    }

}
