
package domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Borrower {
    private final String username;
    private final String password;
    private final Set<String> loans = new HashSet<>();
    private final Set<String> holds = new HashSet<>();

    public Borrower(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String username() { return username; }
    public String password() { return password; }
    public Set<String> loans() { return loans; }
    public Set<String> holds() { return holds; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Borrower)) return false;
        Borrower that = (Borrower) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() { return Objects.hash(username); }
}
