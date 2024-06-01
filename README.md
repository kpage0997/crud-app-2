# crud-app-2
A web application for managing tasks and goals, built with Java, Spring Boot, JPA/Hibernate, MySQL, and ThymeLeaf.

### Getting Started
Clone the repository, set up a PostgreSQL database, update your application.properties with your database credentials, and run the application. To set up the database, create a database named task_manager_db and import the task_manager_db.sql file provided in the repository. Build and run the project using Maven. The application will be available at http://localhost:8080.


### Important Links

- **View a specific goal:** `http://localhost:8080/goals/{goalId} (replace {goalId} with the specific goal ID)`
- **Create a new goal form:** `http://localhost:8080/goals/create`
- **Goals Page:** `http://localhost:8080/goals`
- **Update a goal::** `http://localhost:8080/goals/update/{goalId}`
- **Delete a goal:** `http://localhost:8080/goals/delete/{goalId}`
- **View tasks by status:** `http://localhost:8080/tasks/status/{status} (replace {status} with the specific status)`
- **View a specific task:** `http://localhost:8080/tasks/{taskId} (replace {taskId} with the specific task ID)`
- **Create a new task form:** `http://localhost:8080/tasks/create?goalId={goalId} (replace {goalId} with the specific goal ID)`
- **Update a task:** `http://localhost:8080/tasks/update/{taskId}`
- **Delete a task:** `http://localhost:8080/tasks/delete/{taskId}`


### Features

- Create, update, delete, and view tasks and goals.
- Track progress of goals and tasks.

