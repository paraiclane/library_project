package unit;

import bootstrap.Bootstrap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Resp07Test {

    @Test
    void showsCountWhenZero() {
        var seed = Bootstrap.seed();
        var lib = seed.library();
        // Alice has 0 loans in the seed state
        assertEquals(0, lib.getBorrowCount("alice"));
    }

    @Test
    void showsCountWhenThree() {
        var seed = Bootstrap.seed();
        var lib = seed.library();

        // Simulate 3 loans for alice (we’ll replace this with real borrow flow later)
        var alice = lib.borrowers().get("alice");
        alice.loans().add("B01");
        alice.loans().add("B02");
        alice.loans().add("B03");

        assertEquals(3, lib.getBorrowCount("alice"));
    }
}
