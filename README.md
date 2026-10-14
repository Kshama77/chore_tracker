# ChoreTracker

A beginner-friendly Java console application to track household chores and completion status.

## Features

- Add a chore and assign it to a person
- View all chores and their statuses
- Mark a chore as completed
- Delete a chore
- View a summary of completed and pending chores
- Basic input validation

## Java concepts used

- Classes and objects
- Variables and data types
- Methods
- `ArrayList`
- `for` loops
- `if/else` statements
- `switch`
- User input with `Scanner`
- Basic exception handling

## Requirements

- Java JDK 8 or later
- A terminal or Java IDE such as IntelliJ IDEA or Eclipse

## Run the app

Open a terminal in the `ChoreTracker` project folder.

Compile the source files:

```bash
javac -d out src/com/kshama/choretracker/*.java
```

Run the application:

```bash
java -cp out com.kshama.choretracker.ChoreTrackerApp
```

## Example menu

```text
1. Add a chore
2. View all chores
3. Mark a chore as completed
4. Delete a chore
5. View completion summary
0. Exit
```

## Notes

This beginner version stores chores in memory while the program is running. Chores are reset when you exit the application.

## Possible improvements

- Save chores to a file
- Add due dates and priorities
- Allow a completed chore to be marked pending again
- Build a graphical interface
