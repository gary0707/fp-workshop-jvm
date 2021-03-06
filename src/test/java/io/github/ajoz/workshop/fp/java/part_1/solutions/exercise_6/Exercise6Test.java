package io.github.ajoz.workshop.fp.java.part_1.solutions.exercise_6;

import io.github.ajoz.workshop.fp.java.tools.Function1;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Exercise6Test {
    @Test
    public void should_generate_hash_for_customer() {
        // given:
        final List<Customer> customers =
                Arrays.asList(
                        new Customer("JUG Łódź!"),
                        new Customer("http://www.juglodz.pl/"),
                        new Customer("https://www.facebook.com/groups/juglodz/"),
                        new Customer("https://groups.google.com/d/forum/lodz-jug"),
                        new Customer("https://www.meetup.com/Java-User-Group-Lodz/")
                );

        // when:
        final Function1<Customer, Hash> tested =
                Exercise6.getCustomerToHash();

        // then:
        for (final Customer customer : customers) {
            final Hash expected = new Hash(
                    (long) String.format("FP Workshop - %s", customer.name).length()
            );
            final Hash actual = tested.apply(customer);
            assertEquals(expected, actual);
        }
    }
}
