
# Acceptance Tests (CLI transcripts)

## A-TEST-01 — Multi-User Borrow/Return
**Seed:** includes “The Great Gatsby”.  
**Flow:**  
1. U1 login → borrow Gatsby → logout  
2. U2 login → sees Gatsby “Checked Out” → logout  
3. U1 login → return Gatsby → logout  
4. U2 login → sees Gatsby “Available” → borrow succeeds  

**Asserts:** menu prompts + statuses after each step.

## A-TEST-02 — Initialization & Authentication
Start: verify exactly 20 books + 3 users, all available.  
Try invalid login → error + retry; then valid login → menu shown → logout.
