package ucr.lab.domain;

import domain.ArrayStack;
import domain.StackException;
import org.junit.jupiter.api.Test;

class StackTest {

    @Test
    void ArrayStackTest() {
        ArrayStack stack = new ArrayStack(10);;
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
            System.out.println(isBalanced("([])"));   // true
            System.out.println(isBalanced("{[(])}")); // false
        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }

    // METODO BALANCEO
    public boolean isBalanced(String expression) throws StackException {
        ArrayStack stack = new ArrayStack(expression.length());

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




}