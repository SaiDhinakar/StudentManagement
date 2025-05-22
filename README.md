# Student Management System

A simple Java application for managing student records.

## Project Structure

```
StudentManagement/
├── README.md
├── bin/               # Compiled class files
│   ├── Main.class
│   └── lib/
│       └── StudentManagement.class
└── src/               # Source code
    ├── Main.java
    └── lib/
        └── StudentManagement.java
```

## Setup Instructions

1. **Create bin directory** (if it doesn't exist)

   ```
   mkdir -p bin/lib
   ```
2. **Compile the Java source files**

   ```
   javac -d bin src/lib/StudentManagement.java
   javac -d bin -cp bin src/Main.java
   ```
3. **Run the application**

   ```
   java -cp bin Main
   ```

## Features

- Student record management
- Add, update, and delete student information
- View student details

## Development

This project is developed using Java. The main functionality is in the `StudentManagement` class, and the application entry point is in the `Main` class.
