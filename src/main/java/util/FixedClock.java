
package util;

import java.time.LocalDate;

public class FixedClock implements Clock {
    private final LocalDate date;
    public FixedClock(LocalDate date) { this.date = date; }
    @Override
    public LocalDate today() { return date; }

    public static FixedClock of(String isoDate) {
        return new FixedClock(LocalDate.parse(isoDate));
    }
}
