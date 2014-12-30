package org.barrak.java8.lambda.complex;

/**
 * Test complex lambda expressions, different kind of params.
 *
 * @author Emilien Guenichon <emilien.guenichon@cgi.com>
 */
public class ComplexLambda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Simple lambda (undeclared return)
        testMultipleMethods(i -> ++i);

        // Complex lambda (explicit return)
        testMultipleMethods(i -> {
            System.out.println("Complex lambda");
            return ++i;
        });

        // Multiples parameters
        testMultpleParams((a, b) -> a + b);

        // No parameters
        testNoParams(() -> System.out.println("Nothing !"));
    }

    private static void testMultipleMethods(MultipleMethods mm) {
        System.out.println(mm.add(0));
    }

    private static <T> void testMultpleParams(MultipleParams mp) {
        System.out.println(mp.add(1, 2));
    }

    private static void testNoParams(NoParams np) {
        np.nothing();
    }

    private interface MultipleMethods {

        // Only on method is allowed in an interface to become a lambda
        //void test(String s);
        // Primitive type are not allowed
        //int add(int i);
        int add(Integer i);
    }

    private interface MultipleParams {

        int add(Integer a, Integer b);
    }

    private interface NoParams {

        void nothing();
    }
}
