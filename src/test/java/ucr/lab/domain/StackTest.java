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



}