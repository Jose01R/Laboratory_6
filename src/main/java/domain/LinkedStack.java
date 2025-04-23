package domain;


public class LinkedStack implements Stack {

    private int counter;
    private Node top;

    public LinkedStack() {
        this.counter = 0;
        this.top = null;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public void clear() {
        this.top = null;
        counter = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public Object peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("Stack list is empty");
        }
        return top.data;
    }

    @Override
    public Object top() throws StackException {
        return peek();
    }

    @Override
    public void push(Object element) throws StackException {
        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
        counter++;
    }

    @Override
    public Object pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Stack list is empty");
        }
        Object result = top.data;
        top = top.next;
        counter--;
        return result;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Linked Stack list is empty";

        String result = "Linked Stack list Content\n";
        Node aux = top; //aux para moverme por la lista y no perder el puntero al inicio

        while (aux!=null){
            result+= aux.data + "\n";
            aux = aux.next; // LO muevo AL SIGUIENTE NODO
        }
        return result;
    }
}
