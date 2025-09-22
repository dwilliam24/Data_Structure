public class DS2_Infix_Postfix_Calculator {

    public static void main(String[] args) {

    }
    public static String infixToPostfix(String infix){
        MyStack<String> stack = new MyStack();
        String postfix ="";

        for (int i =0; i<infix.length(); i++){
            String a = ""+infix.charAt(i);
            if ("+-*/^".contains(a)){
                stack.push(a);
            }
            else if(!"() ".contains(a))postfix+=" "+a;
            if (a.equals("("))
            {
                stack.push("(");
            }
            if (a.equals(")")){
                stack.pop();
                while(stack.peek()!="("){
                    String u = stack.pop();
                    if (u.equals("(")){stack.pop();}
                    else postfix+=u;
                }
            }
            System.out.println(stack+"\n");
            System.out.println(postfix);
        }
        while (!stack.isEmpty())
        {
            postfix+=stack.pop();
        }
        return postfix;
    }

}
