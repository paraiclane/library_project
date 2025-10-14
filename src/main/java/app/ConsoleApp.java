
package app;

import bootstrap.Bootstrap;
import services.AuthService;
import services.Library;
import util.SystemClock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleApp {

    private final AuthService auth;
    private final Library library;

    public ConsoleApp(AuthService auth, Library library) {
        this.auth = auth;
        this.library = library;
    }

    public static void main(String[] args) throws IOException {
        var seed = Bootstrap.seed();
        var app = new ConsoleApp(seed.authService(), seed.library());
        app.run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("=== Library CLI ===");
        System.out.println("Type 'exit' to quit.");
        while (true) {
            System.out.print("username: ");
            String u = br.readLine();
            if (u == null || u.equalsIgnoreCase("exit")) break;
            System.out.print("password: ");
            String p = br.readLine();
            var user = auth.authenticate(u, p);
            if (user.isPresent()) {
                System.out.println("Welcome, " + user.get().username() + "!");
                System.out.println("(Menu placeholder — implement via TDD)");
            } else {
                System.out.println("Invalid credentials. Try again.");
            }
        }
        System.out.println("Goodbye.");
    }
}
