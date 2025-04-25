package util;


import domain.*;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utility {
    private static final Random random;



    //constructor estatico, inicializador estatico
    static {
        // semilla para el random
        long seed = System.currentTimeMillis();
        random = new Random(seed);
    }


    public static int random(int bound){
        //return (int)Math.floor(Math.random()*bound); //forma 1
        return 1+random.nextInt(bound);
    }

    public static int randomMinMax(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }


    public static void fill(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = random(99);
        }
    }

    public static String format(long n) {
        return new DecimalFormat("###,###,###.##").format(n);
    }

    public static int min(int x, int y) {
        return x<y ? x : y;
    }

    public static int max(int x, int y) {
        return x>y ? x : y;
    }

    public static String show(int[] a) {
        String result="";
        for(int item : a){
            if(item == 0) break; //si es cero es xq no hay mas elementos
            result+=item + " ";
        }
        return result;
    }

    public static int compare(Object a, Object b) {
        switch(instanceOf(a, b)){
            case "Integer":
                Integer int1 = (Integer)a; Integer int2 = (Integer)b;
                return int1 < int2 ? -1 : int1 > int2 ? 1 : 0;

            case "String":
                String str1 = (String)a; String str2 = (String)b;
                return str1.compareTo(str2) < 0 ? -1 : str1.compareTo(str2) > 0 ? 1 : 0;

            case "Character":
                Character ch1 = (Character) a; Character ch2 = (Character) b;
                return ch1.compareTo(ch2) < 0 ? -1 : ch1.compareTo(ch2) > 0 ? 1 : 0;


        }
        return 2; //Unknown
    }

    public static String instanceOf(Object a, Object b){
        if(a instanceof Integer && b instanceof Integer) return "Integer";
        if(a instanceof String && b instanceof String) return "String";
        if(a instanceof Character && b instanceof Character) return "Character";

        return "Unknown";
    }

    public static String dateFormat(Date value){
        return new SimpleDateFormat("dd/MM/yyyy").format(value);
    }

    public static String infixToPostfixConverter(String exp) throws StackException {
        LinkedStack stack = new LinkedStack();
        String expPostFix = "";
        for(char c : exp.toCharArray()) {
            if (Character.isLetterOrDigit(c))
                expPostFix += c; //lo agregamos a la exp postfija
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && compare(stack.peek(), '(') != 0)
                    expPostFix += stack.pop();
                if (!stack.isEmpty() && compare(stack.top(), '(') != 0)
                    return "Invalid expression";
                else if (!stack.isEmpty())
                    stack.pop();
            } else { //es un operador
                while (!stack.isEmpty() && getPriority(c) <= getPriority((char) stack.peek()))
                    expPostFix += stack.pop();
                stack.push(c);
            }
        }
        while(!stack.isEmpty())
            expPostFix+=stack.pop();
        return expPostFix;
    }

    public static String postfixToInfixConverter(String exp) throws StackException {
        LinkedStack expStack = new LinkedStack();  // expresión infix
        LinkedStack evalStack = new LinkedStack();  // calcular el valor
        String infixResult = "";

        for (char c : exp.toCharArray()) {

            // Si el elemento es un operando se agrega a una pila
            if (Character.isDigit(c)) {
                expStack.push(Character.toString(c));
                evalStack.push(Character.getNumericValue(c));

            } else if (isOperator(c)) { // Si el elemento es un operador se extraen dos elementos del tope de la pila
                if (expStack.size() < 2 || evalStack.size() < 2)
                    throw new StackException("Invald PosFix expression");

                // Se crea la expresion
                String op2 = (String) expStack.pop();
                String op1 = (String) expStack.pop();
                String newExpr = "(" + op1 + c + op2 + ")"; //RESULTADO

                //d. El resultado anterior se almacena en el tope de la pila
                expStack.push(newExpr);

                // Se resuelve la expresion
                int val2 = (int) evalStack.pop();
                int val1 = (int) evalStack.pop();
                int result = applyOperator(val1, val2, c);
                evalStack.push(result);
            } else {
                throw new StackException("Invalid character: " + c);
            }
        }

        if (expStack.size() != 1 || evalStack.size() != 1)
            throw new StackException("Invalid expression");

        infixResult = (String) expStack.pop();
        int finalValue = (int) evalStack.pop();

        //retorna el valor del tope de la pila
        return infixResult + " = " + finalValue;
    }


    public static String posFixToPrefix(String exp){
        LinkedStack expStack = new LinkedStack();  


        return "";
    }

    public static String infixToPrefix(String exp) throws StackException {
        LinkedStack resultStack = new LinkedStack();      // Pila para el resultado

        // Paso 1: Invertir expresión y cambiar paréntesis
        LinkedStack reversedExp = new LinkedStack();

        for(char c : exp.toCharArray()) {
            if (c == '(')
                reversedExp.push(')');
            else if (c == ')')
                reversedExp.push('(');
            else
                reversedExp.push(c);
        }

        String reverseString = "";
        while (!reversedExp.isEmpty()){
            reverseString += reversedExp.pop();
        }

        String posFix = infixToPostfixConverter(reverseString);

        for (char ch : posFix.toCharArray())
            resultStack.push(ch);

        String prefixString = "";
        while (!resultStack.isEmpty()){
            prefixString += resultStack.pop();
        }


        return prefixString;
    }


    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int applyOperator(int a, int b, char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> throw new IllegalArgumentException("Operador inválido: " + op);
        };
    }

    private static int getPriority(char operator) {
        switch (operator){
            case '+': case '-': return 1; // prioridad mas baja
            case '*': case '/': return 2; //
            case '^': return 3;
        }
        return -1;
    }

}
