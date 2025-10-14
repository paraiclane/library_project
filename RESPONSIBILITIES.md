
# Responsibilities (traceable, testable)

Keep this list as your single source of truth. Add links to tests as you implement.

**Given (from assignment): RESP-01..RESP-03** — keep as-is.

## Login / Session
- **RESP-04** Establish session for authenticated borrower (UC-01:4; UC-04).
- **RESP-05** On login, notify borrower of any holds that became available (UC-01:5).
- **RESP-06** Present main menu options post-login (borrow, return, logout) (UC-01:6).

## Borrow workflow
- **RESP-07** Display borrower’s current book count (UC-02:1).
- **RESP-08** Display collection with status + due date; holders see their held book as “Available” (UC-02:2; hold visibility).
- **RESP-09** Select a specific Available book (UC-02:3).
- **RESP-10** Confirm borrow before commit (UC-02:4–5).
- **RESP-11** Verify availability: not checked out, not on another’s hold (UC-02:6).
- **RESP-12** Enforce borrow limit (max 3) (UC-02:7 & 7a).
- **RESP-13** Due date = today + 14 days, via injected clock (UC-02:8).
- **RESP-14** Record borrow; status Checked Out; store due date (UC-02:9–11).
- **RESP-15** From unavailable selection, offer to place hold; validate duplicates/self; allow hold at 3-book limit (UC-02:6a.1–6a.5).
- **RESP-16** Enqueue holds FIFO (hold rules).

## Return workflow
- **RESP-17** List borrower’s current loans with due dates (UC-03:1).
- **RESP-18** Return selected book; clear from borrower; update status (UC-03:2,4–5).
- **RESP-19** If holds exist: mark next as On Hold and flag notification (UC-03:3a.1–3a.4).

## Holds – visibility & eligibility
- **RESP-20** Cannot place hold on Available books (must borrow) (hold rules).
- **RESP-21** Prevent duplicate hold by same borrower (hold rules).
- **RESP-22** Prevent hold if borrower currently has the book checked out (hold rules).

## Logout / Initialization
- **RESP-23** Logout clears session to auth prompt (UC-04:1–3).
- **RESP-24** Boot with exactly 20 books and 3 users; all books Available; all borrowers at 0 loans (UC-01 preconditions).
