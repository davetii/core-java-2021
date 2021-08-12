package software.daveturner.samples.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomLambdaUnitTest {

    @Test
    public void transformPersonToPlayer() {
        PersonToPlayer personToPlayer = Player::new;
        Person killian = new Person("Killian", "Hayes", 76);
        Person Cade = new Person("Cade", "Cunningham", 77);
        Player pointGuardKillian = personToPlayer.transform(killian, "pg");
        Player twoGuardKillian = personToPlayer.transform(Cade, "2g");
        Predicate<Player> isPointGuard = p -> p.pos.equals("pg");
        assertTrue(isPointGuard.test(pointGuardKillian));
        assertFalse(isPointGuard.test(twoGuardKillian));
    }
}
