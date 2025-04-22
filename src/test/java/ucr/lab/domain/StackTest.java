package ucr.lab.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void ArrayStackTest() {
        ArrayStack stack = new ArrayStack(3);;

        try {
            stack.push("A");
            stack.push("B");
            stack.push("C");

            System.out.println(stack);

            System.out.println("OBJECT DELETED: \n" + stack.pop());

            System.out.println("OBJETO EN LA CIMA: \n" + stack.peek());
            System.out.println("OBJETO EN LA CIMA: \n" + stack.top());

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