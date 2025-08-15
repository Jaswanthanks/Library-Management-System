# 📚 Library Management System (Java)

A beginner-friendly Java console application to manage a small library.  
This project demonstrates **Collections (HashMap, ArrayList)**, **Custom Exceptions**, and **Basic CRUD Operations**.

---

## 🚀 Features
- **Add a Book** — Store book details (ID, title, author) in the library.
- **Remove a Book** — Delete a book from the collection by its ID.
- **Search for a Book** — Look up book details by ID.
- **Borrow a Book** — Move a book from available list to borrowed list.
- **Return a Book** — Add a borrowed book back to the library.
- **Display All Books** — View all currently available books.
- **Exception Handling** — Custom exception `BookNotException` for missing books, plus number format validation.

---

## 🛠 Concepts Covered
- **Java Collections Framework**
  - `HashMap<Integer, Book>` — for storing available books
  - `ArrayList<Book>` — for borrowed books
- **Custom Exceptions**
  - `BookNotException` for missing or unavailable books
- **Basic Input Handling**
  - Using `Scanner` for console input
  - Parsing integers safely with `Integer.parseInt()`
- **Control Flow**
  - Menu-driven program with a `while` loop

---
