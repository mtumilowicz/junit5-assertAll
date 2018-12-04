# junit5-assertAll
Example of `assertAll` feature of Junit5.

_Reference_: https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions

# project description
* In a grouped by `assertAll` all assertions are 
executed, and any failures will be reported together.
    * success
        ```
        var person = new Person("name", "surname", 10);
        
        assertAll(
                () -> assertThat(person.name, is("name")),
                () -> assertThat(person.surname, is("surname")),
                () -> assertThat(person.age, is(10))
        );
        ```
    * failure
        ```
        var person = new Person("name", "surname", 10);
        
        assertAll(
                () -> assertThat(person.name, is("name1")),
                () -> assertThat(person.surname, is("surname1")),
                () -> assertThat(person.age, is(11))
        );
        ```
        and the report:
        ```
        org.opentest4j.MultipleFailuresError: Multiple Failures (3 failures)
        	
        Expected: is "name1"
             but: was "name"
        	
        Expected: is "surname1"
             but: was "surname"
        	
        Expected: is <11>
             but: was <10>
        ```

* Within a code block, if an assertion fails the
subsequent code in the same block will be skipped.
    * success
        ```
        var person = new Person("name", "surname", 10);
        
        assertAll(
                () -> {
                    assertNotNull(person);
        
                    assertAll(
                            () -> assertThat(person.name, is("name")),
                            () -> assertThat(person.surname, is("surname")),
                            () -> assertThat(person.age, is(10)));
                }
        );
        ```
    * failure
        ```
        Person person = null;
        
        assertAll(
                () -> {
                    assertNotNull(person);
        
                    assertAll(
                            () -> assertThat(person.name, is("name")),
                            () -> assertThat(person.surname, is("surname")),
                            () -> assertThat(person.age, is(10)));
                }
        );
        ```
        and the report:
        ```
        org.opentest4j.MultipleFailuresError: Multiple Failures (1 failure)
        	expected: not <null>
        ```
        so:
        ```
        assertAll(
                  () -> assertThat(person.name, is("name")),
                  () -> assertThat(person.surname, is("surname")),
                  () -> assertThat(person.age, is(10)));
        ```
        **is not evaluated.**