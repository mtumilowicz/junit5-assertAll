import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by mtumilowicz on 2018-12-04.
 */
class PersonTest {

    @Test
    void assertAll_constructor_nonNullValues() {
        var person = new Person("name", "surname", 10);

        assertAll(
                () -> assertThat(person.name, is("name")),
                () -> assertThat(person.surname, is("surname")),
                () -> assertThat(person.age, is(10))
        );
    }

    @Test
    void assertAll_block() {
        Person person = new Person("name", "surname", 10);

        assertAll(
                () -> {
                    assertNotNull(person);

                    assertAll(
                            () -> assertThat(person.name, is("name")),
                            () -> assertThat(person.surname, is("surname")),
                            () -> assertThat(person.age, is(11)));
                }
        );
    }


}