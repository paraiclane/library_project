
# Library CLI — A1 Starter (Java 22 + Maven + JUnit 5)

This repo is a *from-zero* scaffold so you can follow strict TDD without skipping steps.

## 0) Prereqs
- **Java 22 (OpenJDK)** installed: `java -version` should show 22.x.
- **Maven 3.9+**: `mvn -version`.
- **IntelliJ IDEA Community 2025.2+** (or your IDE of choice).
- **Git + GitHub** (commit naming rules below).

> If your Java is older: install Temurin 22 or Oracle JDK 22, then restart the IDE/terminal.

## 1) Clone & open
```bash
git clone <YOUR_GITHUB_REPO_URL> library-cli
cd library-cli
```
Open folder in IntelliJ. When prompted, select **Java 22 SDK**. Maven should auto-import.

## 2) First green build
```bash
mvn -q -DskipTests=false test
```
You should see 1 passing test and several `@Disabled` placeholders.

## 3) Commit conventions
Every change is one of:
- `R-TEST-XX` — add failing unit tests for responsibility XX.
- `R-CODE-XX` — minimal code to pass tests for XX.
- `REFAC` — refactor only, no behavior changes.
- `A-TEST-0N` — end-to-end acceptance test updates.
- `DOCS` — docs only.

**Example**
```
R-TEST-08: RESP_08 list books shows statuses and due dates
```
Then after code:
```
R-CODE-08: Implement RESP-08 in Library.listBooks and BookView
```

## 4) Strict TDD loop (do *not* skip)
1. Pick one responsibility from `RESPONSIBILITIES.md`.
2. Write **one** failing test (`R-TEST-XX`).
3. Write **just enough** production code to pass.
4. `mvn test` must be green.
5. Optional: small `REFAC` commit.
6. Repeat.

## 5) Running the app (manual)
```bash
mvn -q -DskipTests package
java -jar target/library-cli-0.1.0.jar
```
Right now the app only shows a welcome banner; all features arrive via TDD.

## 6) Acceptance tests
Define your CLI transcripts in `src/test/java/acceptance` and wire them as JUnit tests. Start with the provided skeletons in `ACCEPTANCE_TESTS.md`.

## 7) Seed data
The system starts in-memory with **20 books** and **3 users** defined in `Bootstrap.java`. Change titles/authors freely; tests should assert counts and behaviors — not specific titles (except when needed in acceptance tests).

## 8) Responsibility traceability
Keep the table current in `RESPONSIBILITIES.md`. Each row must map to: UC step(s), number of unit tests, and links to test names.

---

## Useful Maven commands
- `mvn test` — run unit tests.
- `mvn -q -Dtest=... test` — run a specific test class.
- `mvn package` — build shaded JAR.
- `mvn -q -DskipTests package` — package without tests.

## Java version troubles?
In IntelliJ: **File → Project Structure → SDKs → Add JDK 22**, then set **Project SDK = 22** and **Language level = 22**.

Good luck — ship small, green commits.
