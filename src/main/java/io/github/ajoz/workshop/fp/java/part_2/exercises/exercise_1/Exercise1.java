package io.github.ajoz.workshop.fp.java.part_2.exercises.exercise_1;

import java.util.List;

import io.github.ajoz.workshop.fp.java.tools.Function2;

/*
  -- Simple functions --

  A simple example of `sum` and `product` and an attempt at generalizing them.

 */
@SuppressWarnings("unused")
class Exercise1 {
    /*
      Part 1:

      Please create a function called `sum` that takes a List of Integers
      and returns the sum of those integers.
      - please consider a case of an empty list
      - passed list will never be null
      - passed list will never have null elements
      - passed list will be finite
      - do not worry about the result of product exceeding the amount the Integer
        type can hold
     */
    static Integer sum(final List<Integer> list) {
        Integer sum = 0;
        for(Integer item : list) {
            sum += item;
        }

        return sum;
    }

    /*
      Part 2:

      Please create a function called `product` that takes a List of Integers
      and returns a product of those integers.
      - please consider a case of an empty list
      - passed list will never be null
      - passed list will never have null elements
      - passed list will be finite
      - do not worry about the result of product exceeding the amount the Integer
        type can hold
     */
    static Integer product(final List<Integer> list) {
        Integer sum = 1;
        for(Integer item : list) {
            sum *= item;
        }

        return sum;
    }

    /*
      Part 3:

      Please look at the implementation of `sum` and `product`
      - can you show the parts that are different?
      - can you show the parts that are the same?
      - can you abstract the code in a way that it can be used for sum and product?
     */

      // for the abstracted function we will use a name `foo`
      // hint:
      // - what arguments do we need to pass to `foo`?
      // - `sum` is using + operator, `product` is using * operator
      //   how can we abstract these two operators?
      // - do not use any conditional statements for this exercise
      public static Integer foo(List<Integer> list, Integer initial, Function2<Integer, Integer, Integer> operator) {
          Integer tempHolder = initial;
          for (final Integer item : list) {
              tempHolder = operator.apply(item, tempHolder);
          }

          return tempHolder;
      }

      // there are unit tests for those two functions in Exercise1Test
      public static Integer fooSum(final List<Integer> list) {
          return foo(list, 0, (a, b) -> a + b);
      }

      public static Integer fooProduct(final List<Integer> list) {
          return foo(list, 1, (a, b) -> a * b);
      }

}
