@SuppressWarnings("unchecked")
public class InfixToPostfixConverter<T> implements ExpressionConverterInterface {
    private StackInterface stack;

    public InfixToPostfixConverter(){
        stack = new LinkedStack<>();
    }
    public InfixToPostfixConverter(StackInterface stack){
        this.stack = stack;
    }

    /**
     * The convert method converts one type of expression format to another
     *
     * @param expression The expression to be converted
     * @return The expression in the new format
     * @throws InvalidExpressionException If the expression to be converted has syntax errors
     */
    @Override
    public String convert(String expression) throws InvalidExpressionException {
        String input = expression.toLowerCase();
        StringBuilder outputString = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            //Assigned input.charAt(i) to x for ease
            char x = input.charAt(i);
            if((x >= 97) && (x <= 122)){
                outputString.append(x);
            }
            else if(x == '^'){ //ASCII 94
                stack.push(x);
            }//ASCII 43, 45, 42, 47
            else if((x == '+') || (x == '-') || (x == '*') || (x == '/')){
                boolean done = false;
                char peeked = ' ';
                while(!done) {
                    if(!stack.isEmpty()){
                        peeked = (char) stack.peek();
                    }
                    if((stack.isEmpty()) || (priority(peeked) < priority(x))) {
                        done = true;
                        continue;
                    }
                    else{
                        outputString.append(stack.pop());
                    }
                }
                stack.push(x);
            }
            else if(x == '('){
                stack.push(x);
            }
            else if(x == ')'){
                while(!stack.isEmpty() ){
                    char popped = (char) stack.pop();
                    if(popped != '('){
                        outputString.append(popped);
                    }else{
                        continue;
                    }
                }
            }
            else if(x == ' '){
                continue;
            }
            else{
                throw new InvalidExpressionException();
            }
        }

        while(!stack.isEmpty()){
            char popped = (char) stack.pop();
            if(popped == '('){
                throw new InvalidExpressionException();
            }
            else{
                outputString.append(popped);
            }
        }
        return outputString.toString();
    }

    public int priority(char x){
        switch(x){
            case('+'):
            case('-'):
                return 0;
            case('*'):
            case('/'):
                return 1;
            case('^'):
                return 2;
            default:
                return -1;
        }
    }
}

class InvalidExpressionException extends RuntimeException{
}
