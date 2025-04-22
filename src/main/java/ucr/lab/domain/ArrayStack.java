package ucr.lab.domain;

import java.util.Arrays;

public class ArrayStack implements Stack{

    private int n; // CAPACIDAD DE LA PILA
    private int top; // CIMA - TOPE
    private Object[] dataStack;

    public ArrayStack(int n, int top, Object[] dataStack) {
        this.n = n;
        this.top = top;
        this.dataStack = dataStack;
    }

    public ArrayStack(int n) {
        this.n = n;
        this.top = -1;
        this.dataStack = new Object[n];
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }


    public Object[] getDataStack() {
        return dataStack;
    }

    public void setDataStack(Object[] dataStack) {
        this.dataStack = dataStack;
    }


    @Override
    public int size() {
        return top+1;
    }

    @Override
    public void clear() {
        dataStack = new Object[n];
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public Object peek() throws StackException {
        if (isEmpty())
            throw new StackException("Array Stack is empty");

        return dataStack[top];
    }

    @Override
    public Object top() throws StackException {
        return peek();
    }

    @Override
    public void push(Object element) throws StackException {
        if (top == n-1)
            throw new StackException("Array Stack is empty");

        dataStack[++top] = element;
    }

    @Override
    public Object pop() throws StackException {
        if (isEmpty())
            throw new StackException("Array Stack is empty");

        return dataStack[top--];
    }

    @Override
    public String toString() {
        return "ArrayStack: " +
                "dataStack=" + Arrays.toString(dataStack);
    }


}
