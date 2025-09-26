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
                boolean p = false;
                if (!stack.isEmpty()&&!"(".contains(stack.peek())&&(("^".contains(stack.peek())&&"^*/+-".contains(a)) || ("*/".contains(stack.peek())&&"*/+-".contains(a)) || ("+-".contains(stack.peek())&&"+-".contains(a))))
                {
                    postfix += stack.pop()+" ";
                    if (!stack.isEmpty()&&!"(".contains(stack.peek())&&(("^".contains(stack.peek())&&"^*/+-".contains(a)) || ("*/".contains(stack.peek())&&"*/+-".contains(a)) || ("+-".contains(stack.peek())&&"+-".contains(a))))
                    {
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
                while (g)
                {
                    String f = stack.pop();
                    if (!("(".contains(f))){
                        postfix+=f+" ";

                    }
                    else g=false;
                }
                System.out.println("\n"+stack+"\n");
            }

        //  5 ( 2.5 + 1.5 ) ^ 2 - 10 / ( 4 ^ 2.0 ) + 7 * 0.3


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
