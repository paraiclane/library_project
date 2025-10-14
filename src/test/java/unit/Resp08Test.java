package unit;

import bootstrap.Bootstrap;
import domain.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class Resp08Test {

    @Test
    void listsAllBooksWithStatus() {
        var seed = Bootstrap.seed();
        var lib = seed.library();

        var views = lib.listBooksFor("alice");
        assertEquals(20, views.size());

        var b01 = views.stream().filter(v -> v.id().equals("B01")).findFirst().orElseThrow();
        assertEquals("The Great Gatsby", b01.title());
        assertEquals(Book.Status.AVAILABLE, b01.status());
        assertNull(b01.dueDate());
    }

    @Test
    void showsDueDateWhenCheckedOut() {
        var seed = Bootstrap.seed();
        var lib = seed.library();

        var book = lib.books().get("B01");
        book.setStatus(Book.Status.CHECKED_OUT);
        book.setDueDate(LocalDate.of(2025,10,29));

        var view = lib.listBooksFor("alice").stream()
                .filter(v -> v.id().equals("B01")).findFirst().orElseThrow();

        assertEquals(Book.Status.CHECKED_OUT, view.status());
        assertEquals(LocalDate.of(2025,10,29), view.dueDate());
    }

    @Test
    void holderSeesHeldBookAsAvailableOthersSeeOnHold() {
        var seed = Bootstrap.seed();
        var lib = seed.library();

        var book = lib.books().get("B02");
        book.setStatus(Book.Status.ON_HOLD);
        book.holdQueue().add("alice");

        var forAlice = lib.listBooksFor("alice").stream()
                .filter(v -> v.id().equals("B02")).findFirst().orElseThrow();
        assertEquals(Book.Status.AVAILABLE, forAlice.status());

        var forBob = lib.listBooksFor("bob").stream()
                .filter(v -> v.id().equals("B02")).findFirst().orElseThrow();
        assertEquals(Book.Status.ON_HOLD, forBob.status());
    }
}
