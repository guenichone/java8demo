package org.barrak.java8.lambda.overload;

import java.util.concurrent.Callable;

/**
 * Overload of method signature, with same or different signature.
 *
 * @author Emilien Guenichon <emilien.guenichon@cgi.com>
 */
public class OverloadInLambda {

    public static void main(String[] args) throws Exception {

        // Identical kind of callable signature (not possible)
        // String s = testOverload(t -> true);
        // Different kind of callable (ok)
        invoke(() -> "done");
        invoke(() -> {
        });
        String res = invoke(() -> "done");
    }

    private static void invoke(Runnable r) {
        System.out.println("Call invoke void");
        r.run();
    }

    private static <T> void invoke(Callable<T> c) throws Exception {
        System.out.println("Call invoke T");
        c.call();
    }

    // Try to comment this, when both methods can match the return is first
    private static String invoke(Parameterless<String> p) {
        System.out.println("Call invoke String");
        return p.test();
    }

    // Not possible as it clash with the last one
//    private static Integer invoke(Parameterless2<String> p) {
//        System.out.println("Call invoke String");
//        return 0;
//    }

    private interface Parameterless<T> {

        T test();
    }

    // Clash with previous
    private interface Parameterless2<T> {

        T test();
    }
}
