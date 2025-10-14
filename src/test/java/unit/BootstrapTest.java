
package unit;

import bootstrap.Bootstrap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BootstrapTest {

    @Test
    void resp24_boot_has_20_books_and_3_users() {
        var seed = Bootstrap.seed();
        assertEquals(20, seed.library().books().size(), "Should seed exactly 20 books");
        assertEquals(3, seed.library().borrowers().size(), "Should seed exactly 3 borrowers");
    }
}
