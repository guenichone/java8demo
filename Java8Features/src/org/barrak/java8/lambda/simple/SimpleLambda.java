package org.barrak.java8.lambda.simple;

import java.util.function.Predicate;

/**
 * Test simple lambda expressions, compare with anonymous class.
 *
 * @author Emilien Guenichon <emilien.guenichon@cgi.com>
 */
public class SimpleLambda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Simple lambda of predicate
        testPredicate(s -> s.length() > 3);

        // Like an
        Predicate p1 = y -> false;
        Predicate p2 = new Predicate() {

            @Override
            public boolean test(Object t) {
                return false;
            }
        };

        testPredicate(p1);
        testPredicate(p2);
    }

    public static void testPredicate(Predicate<String> p) {
        System.out.println(p.test("a"));
        System.out.println(p.test("aaaa"));
    }
}
