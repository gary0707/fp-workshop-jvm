package io.github.ajoz.workshop.fp.java.part_2.exercises.exercise_2;


import io.github.ajoz.workshop.fp.java.tools.Function2;

import java.util.List;

/*
  -- Advanced functions --

  Generalizing the generalization of `sum` and `product` (pun intended).
 */
class Exercise2 {
    /*
      Part 1:

      This function `foo` that we created in the previous exercise
      can now be generalized to work on a List of type A and return
      a type B
     */
    static Integer foo(final List<Integer> list,
                       final Integer initial,
                       final Function2<Integer, Integer, Integer> operator) {
        Integer accumulator = initial;
        for (final Integer element : list) {
            accumulator = operator.apply(accumulator, element);
        }

        return accumulator;
    }

    /*
      Part 2:

      Create a function `bar` that can work on a List<A> and return
      a result of type B
    */

    // hint:
    // - what will be the type of initial value?
    // - what will be the types of arguments for the operator?
    //
    // Question:
    // - how do you think does the order of arguments in the operator
    //   has any meaning?
    static <A, B> B bar(final List<A> list, final B initial, final Function2<A, B, B> operator) {
        B tempHolder = initial;
        for(final A item : list) {
            tempHolder = operator.apply(item, tempHolder);
        }

        return tempHolder;
    }


    /*
      Part 3:

      Implement functions `sum` and `product` with the use of
      the newly created function `bar`
    */


    static Integer sum(final List<Integer> list) {
        return bar(list, 0, (a, b) -> a + b);
    }

    static Integer product(final List<Integer> list) {
        return bar(list, 1, (a, b) -> a * b);
    }
}
