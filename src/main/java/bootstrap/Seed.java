package bootstrap;

import services.AuthService;
import services.Library;

public record Seed(AuthService authService, Library library) {}
