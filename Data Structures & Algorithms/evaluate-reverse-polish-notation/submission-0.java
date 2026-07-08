class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<tokens.length;i++){
            String token=tokens[i];

            if(isOperator(token)){
                int b=stack.pop();
                int a=stack.pop();
                int result=switch(token){
                    case "+" -> a+b;
                    case "-" -> a-b;
                    case "*" -> a*b;
                    case "/" -> a/b;
                    default -> throw new IllegalArgumentException("bad token"+token);
                };
                stack.push(result);
            }
            else{
                stack.push(Integer.parseInt(token));
            }

        }
        return stack.pop();
    }
        private boolean isOperator(String token){
            return token.equals("+") || token.equals("-") ||token.equals("*") ||token.equals("/"); 
        
    }
}
