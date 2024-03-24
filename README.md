# Gamer Ranking System

## Overview
The Gamer Ranking System is a robust web application that aims to track and display player rankings across a curated yearly selection of nominated games. Built with Spring Boot, this Java application leverages Thymeleaf for dynamic frontend rendering and a MySQL database for persistent storage, with JDBC serving as the conduit for database connectivity.

## Features
- **Player Profiles**: Maintain detailed player profiles including scores, avatars, and other information.
- **Game Catalog**: A comprehensive list of games nominated each year for tracking player scores.
- **Ranking Leaderboards**: Real-time leaderboards showing player rankings per game and overall rankings per year.
- **Yearly Selections**: The system supports yearly updates for game nominations and player scores.

## Technology Stack
- Spring Boot for the backend.
- Thymeleaf for frontend rendering.
- MySQL as the database.
- JDBC for database connectivity.
- Docker for containerization and easy deployment.

## Getting Started with Docker

### Prerequisites
- Docker installed on your machine.
- Docker Compose (recommended for multi-container setups).

### Running the Application

### Setup
1. Clone the repository:
```
git clone https://github.com/your-username/GamerRankingSystem.git
```

Navigate to the project directory:
```
cd GamerRankingSystem
```

Build and run the application using Docker:
```
docker-compose up --build
```
This command will build the Docker image for the application and start the services defined in docker-compose.yml, including the MySQL database and the application server.

The docker-compose.yml should define both the web application and MySQL database services. Make sure the MySQL service in docker-compose.yml includes the environment variables for database setup, and the web application service is correctly linked to this database service.

The application should now be running on http://localhost:8080.

## Usage
Once the application is running, you can access the web interface through a browser to manage the games, players, and view the rankings.

## Contributing
We welcome contributions to the Gamer Ranking System. If you have suggestions for improvements or bug reports, please open an issue or submit a pull request.

## License
MIT License

## Contact
For any further queries, please reach out to us at on the issues page here on GitHub.

Enjoy gaming and may the best player rank on top!
