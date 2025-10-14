
package unit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PlaceholdersTest {

    @Test @Disabled("R-TEST-07 pending: list borrower loan count")
    void resp07_displayBorrowerBookCount() {}

    @Test @Disabled("R-TEST-08 pending: list books w/ statuses and due dates")
    void resp08_listBooksShowsStatuses() {}

    @Test @Disabled("R-TEST-13 pending: due date is today + 14 days via Clock")
    void resp13_dueDateIs14DaysFromToday() {}

    @Test @Disabled("A-TEST-01 pending: multi-user borrow/return transcript")
    void acceptanceTest01() {}
}
