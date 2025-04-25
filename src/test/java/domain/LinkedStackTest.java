package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

    @Test
    public void testLinkedStack(){
        LinkedStack stack = new LinkedStack();;
        try {

            for (int i = 0; i < 10; i++) {
                int value = util.Utility.random(30);
                System.out.println("Value [" +value+ "] pushed");
                stack.push(value);
            }

            System.out.println(stack);

            System.out.println(stack); // llamo de nuevo al toString

            System.out.println("OBJECT DELETED: \n" + stack.pop());

            System.out.println("OBJETO EN LA CIMA: " + stack.peek());
            System.out.println("OBJETO EN LA CIMA: " + stack.top());

            System.out.println("SIZE: \n" + stack.size());

            stack.clear();
            System.out.println("IS CLEAR? \n" + stack);

            System.out.println("IS EMPTY? " + stack.isEmpty());

        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void isBalanceTest(){
        // PROBAMOS ISBALANCED
        try {
            System.out.println(isBalanced("({[]})"));   // true
            System.out.println(isBalanced("([])")); // true
            System.out.println(isBalanced("([)]")); // false
            System.out.println(isBalanced("((()))")); // true
            System.out.println(isBalanced("{[}")); // false
            System.out.println(isBalanced("]")); // false
            System.out.println(isBalanced("")); // true
        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void decimalToBinary(){
            try {
                int[] numbers = {0, 3, 4, 5, 6, 7, 9, 10, 15, 17, 23, 32, 255, 1023, 1025, 4192, 8586};
                for (int value : numbers) {
                    System.out.println("Decimal: " + value + " → Binary: " + decimalToBinary(value));
                }
            } catch (StackException e) {
                throw new RuntimeException(e);
            }

    }

    @Test
    public void infixToPosfixTest(){
        try {
            System.out.println("infix: ((a-b)*(a+c)) to posfix: " + util.Utility.infixToPostfixConverter("(2*(1+((4*(2+1))+3)))"));
        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void postfixToInfixTest(){
        try {
            System.out.println("posFix: 21421+*3++* to infix: " + util.Utility.postfixToInfixConverter("21421+*3++*"));
        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void infixToPrefixTest(){
        try {
            System.out.println("infix: ((a-b)*(a+c)) to prefix: " + util.Utility.infixToPrefix("((a-b)*(a+c))"));
        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }

    // METODO BALANCEO
    public boolean isBalanced(String expression) throws StackException {
        LinkedStack stack = new LinkedStack();

        for (char character : expression.toCharArray()){
            if (character == '(' || character == '[' || character == '{') {  // CORRECCIÓN AQUÍ
                stack.push(character);
            } else if (character == ')' || character == ']' || character == '}'){
                if (stack.isEmpty())
                    return false;
                char last = (char)stack.pop();

                if ((character == ')' && last != '(') ||  // CORRECCIÓN AQUÍ
                        (character == ']' && last != '[') ||
                        (character == '}' && last != '{')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public String decimalToBinary(int number) throws StackException {
        LinkedStack linkedStack = new LinkedStack();
        String result = "";
        int resto;

        if (number == 0) return "0";

        while (number>0) {
            resto = number%2;
            number = number/2;

            linkedStack.push(Integer.toString(resto));
        }

        if (linkedStack.isEmpty()) return "Linked Stack is empty";

        while (!linkedStack.isEmpty()){
            result+=linkedStack.pop() + "";
        }

        return result;
    }

}