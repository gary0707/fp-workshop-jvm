package io.github.ajoz.workshop.fp.java.part_2.exercises.exercise_3;

import io.github.ajoz.workshop.fp.java.tools.Function2;
import io.github.ajoz.workshop.fp.java.tools.Lists;

import java.util.List;

/*
  -- Different kind of fold --

  In the previous exercise we created a function called `bar`. This function
  took a list, an initial value and a two argument function and "folded" the
  list to a single value.

  In most libraries this function is called fold due to how it changes the
  structure of the List. It literally folds all the elements into a single
  value.

  A list can be folded in two different ways. From the left and from the right
  side.

  The implementation which we created is foldLeft.
 */
class Exercise3 {
    /*
      Part 1:

      Let's imagine a simple list: [1, 2, 3].

      We want to fold it from the left side. The initial value will be 0 and
      the operation is plus.

      foldLeft [1, 2, 3] 0 (+)

      Folding from the left would mean that the order of operations looks like:

      direction -->
      (((0 op 1) op 2) op 3)

      This is why this is easily expressed by a loop or a tail recursive call.
     */
    static <A, B> B foldLeft(final List<A> list,
                             final B initial,
                             final Function2<B, A, B> operator) {
        B accumulator = initial;
        for (final A element : list) {
            accumulator = operator.apply(accumulator, element);
        }

        return accumulator;
    }


    /*
      Part 2:

      Now let's think how we can fold the same list: [1, 2, 3] from the right
      side. The order of operations would be:

      direction <--
      (1 op (2 op (3 op 0)))

      Implement foldRight
     */
    static <A, B> B foldRight(final List<A> list,
                              final B initial,
                              final Function2<A, B, B> operator) {
        B tempHolder = initial;
        for (int index = list.size() - 1; index >= 0; index--) {
            tempHolder = operator.apply(list.get(index), tempHolder);
        }

        return tempHolder;
    }

    /*
      Part 3:

      Can we express foldRight in terms of foldLeft?

      Hint:
      - You can use methods from Lists class
     */
    static <A, B> B foldRight2(final List<A> list,
                               final B initial,
                               final Function2<A, B, B> operator) {
        return foldLeft(Lists.reverse(list), initial, operator.flip());
    }
}
