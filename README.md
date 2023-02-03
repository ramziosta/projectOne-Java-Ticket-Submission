# Employee Ticket submission App
### A user-friendly and efficient app designed for employee registration, login, permissions, ticket submission, and approval. The app was developed using Java, Javalin, Maven, Postgres, Redis, and Docker to improve internal processes and streamline data management.

### Technologies Used
1- Java
<br>2- Javalin
<br>3- Maven
<br>4- HTML
<br>5- CSS
<br>6- Postgres
<br>7- SQL
<br>8- Redis
<br>9- Docker

### Features
1- User registration and login
<br>2- Permission system for different user roles
<br>3- Ticket submission and approval system
<br>4- A full CRUD operation of create a ticket, delete, edit,and retrieve a ticket for one user  or all users
<br>5- Backend server implemented with Java, Javalin, and Maven
<br>6- Integration with Postgres database for data storage and retrieval
<br>7- Utilization of Redis for improved scalability
<br>8- Deployment using Docker for efficient data management

The Employee App is designed to be user-friendly and efficient for employees to register, log in, submit tickets, and manage their permissions. The backend server and data storage systems have been optimized for 
improved performance and scalability.

The user can register a new account, and have a status of logged it, or logged out, and if the user is an employee or a manager.
The Employee can retrieve their information and tickets. Submit new ticket, and retrieve one ticket or all tickets.
The Manager can view all tickets for all employees and can approve or deny tickets submitted.


### Downloading and Running the App
To download and run the Employee App, follow these steps:

Clone the repository to your local machine using Git or download the ZIP file
Ensure that you have the following software installed:
Java
Maven
Docker
Postgres
Redis
Navigate to the project directory in your terminal or command prompt
Run the following command to build the Docker image:
Copy code
docker-compose build
Start the Docker containers with the following command:
Copy code
docker-compose up
The app should now be running at http://localhost:8080.
Note: You may need to configure the database and Redis connections to match your local setup. Please consult the documentation for Postgres and Redis for more information.


If you have any questions or feedback, feel free to reach out to me.

MIT License

Copyright (c) 2023 Ramzi Osta 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
