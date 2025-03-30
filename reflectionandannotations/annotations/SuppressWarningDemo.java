package reflectionandannotations.annotations;

import java.util.ArrayList;

public class SuppressWarningDemo {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // ArrayList without generics
        ArrayList list = new ArrayList();

        // Adding different types of elements
        list.add("Java");
        list.add(123);
        list.add(true);

        // Printing the list
        System.out.println("List: " + list);
    }
}

