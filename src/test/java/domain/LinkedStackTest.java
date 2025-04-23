package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

    @Test
    public void testLinkedStack(){
        LinkedStack linked = new LinkedStack();

        try{
            //uso del metodo push que mete los objetos en el tope
            linked.push("A");
            linked.push("B");
            linked.push("C");

            System.out.println(linked);
            //uso del metodo pop, elimina y muestra el top, y luego muestro la lista actualizada
            System.out.println("Object deleted: \n" + linked.pop());
            System.out.println(linked);

            //metodos que me danel objeto que esta en el tope
            System.out.println("Objeto que esta en el tope: \n" + linked.peek());
            System.out.println("Objeto que esta en el tope: \n" + linked.top());
            //metodo size, que muestras cuantos objetos en la pila hay, me da counter
            System.out.println("Tamaño de la Pila: " + linked.size());

            linked.clear();
            System.out.println("¿Esta limpia la pila? \n" + linked);

            System.out.println("¿Esta vacia la pila? " + linked.isEmpty());

        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }
}