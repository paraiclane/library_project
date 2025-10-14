
package services;

import domain.Borrower;

import java.util.Map;
import java.util.Optional;

public class AuthService {
    private final Map<String, Borrower> borrowers;

    public AuthService(Map<String, Borrower> borrowers) {
        this.borrowers = borrowers;
    }

    public Optional<Borrower> authenticate(String username, String password) {
        var b = borrowers.get(username);
        if (b != null && b.password().equals(password)) {
            return Optional.of(b);
        }
        return Optional.empty();
    }
}
