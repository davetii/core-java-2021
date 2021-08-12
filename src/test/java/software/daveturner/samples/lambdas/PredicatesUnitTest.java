package software.daveturner.samples.lambdas;

import org.junit.jupiter.api.Test;
import java.util.function.Predicate;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PredicatesUnitTest {

    @Test
    public void simplePredicateTest() {
        Predicate<Integer> greaterThanTen = i -> (i > 10);
        assertTrue(greaterThanTen.test(15));
        assertFalse(greaterThanTen.test(5));
    }

    @Test
    public void predicateWithAndOrTest() {
        Predicate<Integer> greaterThan10 = i -> (i > 10);
        Predicate<Integer> lessThan20 = i -> (i < 20);
        assertTrue(greaterThan10.and(lessThan20).test(15));
        assertFalse(greaterThan10.and(lessThan20).test(25));
        assertTrue(greaterThan10.or(lessThan20).test(25));
    }

    @Test
    public void predicateWithComplexObject() {
        Predicate<Person> isTall = p -> p.height > 82;
        Person Jalen = new Person("Jalen", "Green", 77);
        Person Cade = new Person("Cade", "Cunningham", 78);
        Person Evan = new Person("Evan", "Mobley", 86);
        assertFalse(isTall.test(Jalen));
        assertFalse(isTall.test(Cade));
        assertTrue(isTall.test(Evan));
    }

}
