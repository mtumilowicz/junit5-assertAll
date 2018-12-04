import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * Created by mtumilowicz on 2018-12-04.
 */
class PersonTest {

    @Test
    void constructor() {
        var person = new Person("name", "surname", 10);

        assertAll(
                () -> assertThat(person.name, is("name")),
                () -> assertThat(person.surname, is("surname")),
                () -> assertThat(person.age, is(10))
        );
    }

}