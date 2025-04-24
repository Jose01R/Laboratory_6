package ucr.lab.domain;

import domain.ArrayStack;
import domain.Person;
import domain.StackException;
import org.junit.jupiter.api.Test;

class StackTest {


    @Test
    public void ArrayStackTest(){
        ArrayStack stack = new ArrayStack(15); // Capacidad suficiente

        try {
            // Agregar personas
            stack.push(new Person(1, "Alana", 18));
            stack.push(new Person(2, "Pablo", 20));
            stack.push(new Person(3, "Ana", 21));
            stack.push(new Person(4, "María", 20));
            stack.push(new Person(5, "Victoria", 18));
            stack.push(new Person(6, "Nicole", 19));
            stack.push(new Person(7, "Mateo", 18));
            stack.push(new Person(8, "Nicole", 23));
            stack.push(new Person(9, "Alana", 22));
            stack.push(new Person(10, "Pablo", 19));
            stack.push(new Person(11, "Ana", 18));

            // Mostrar la pila original
            System.out.println("Contenido original:");
            System.out.println(stack);

            // Caso 1: Buscar persona con edad 18 y nombre que empiece con "A"
            ArrayStack auxStack = new ArrayStack(15);
            ArrayStack case1 = new ArrayStack(5);
            ArrayStack case2 = new ArrayStack(10);
            ArrayStack case3 = new ArrayStack(15);

            while (!stack.isEmpty()) {
                Person p = (Person) stack.pop();
                if (p.getAge() == 18 && p.getName().startsWith("A"))
                    case1.push(p);

                //Case 2: name=Nicole, age=19
                if (p.getAge() == 19 && p.getName().equals("Nicole"))
                    case2.push(p);

                //Caso 3: age=entre 20 y 23 años
                if (p.getAge() >= 20 && p.getAge() <= 23)
                    case3.push(p);

                auxStack.push(p);
            }

                // Restaurar la pila original
                while (!auxStack.isEmpty()) {
                    stack.push(auxStack.pop());
                }

                // Mostrar el resultado del caso 1
                System.out.println("Caso 1: Edad = 18 y nombre empieza con 'A'");
                while (!case1.isEmpty()) {
                    System.out.println(case1.pop() + " ");
                }

                // Mostrar el resultado del caso 2
                System.out.println("\nCaso 2: Nombre = Nicole y edad = 19");
                while (!case2.isEmpty()) {
                    System.out.println(case2.pop() + " ");
                }

                // Mostrar el resultado del caso 3
                System.out.println("\nCaso 3: Edad entre 20 y 23 años");
                while (!case3.isEmpty()) {
                    System.out.println(case3.pop() + " ");
                }

                //MOSTRADO FINAL DE LA PILA
            System.out.println(auxStack);

            } catch(StackException e){
                throw new RuntimeException(e);
            }

    }

    @Test
    void ArrayStackTest2() {
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