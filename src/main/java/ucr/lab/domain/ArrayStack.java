package ucr.lab.domain;

public class ArrayStack implements Stack{

    private int n;
    private int top;
    private int[] dataStack;

    public ArrayStack(int n, int top, int[] dataStack) {
        this.n = n;
        this.top = top;
        this.dataStack = dataStack;
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

    public int[] getDataStack() {
        return dataStack;
    }

    public void setDataStack(int[] dataStack) {
        this.dataStack = dataStack;
    }


    @Override
    public int size() {
        return top+1;
    }

    @Override
    public void clear() {
        dataStack = new int[n];
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object peek() throws StackException {
        return null;
    }

    @Override
    public Object top() throws StackException {
        return null;
    }

    @Override
    public void push(Object element) throws StackException {

    }

    @Override
    public Object pop() throws StackException {
        return null;
    }


    public

}
