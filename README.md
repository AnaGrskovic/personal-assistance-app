# personal-assistance-app

Our project is a web application. It is designed to enable users to provide and ask for help, and is geared towards people who need specific assistance with everyday tasks.
The current version implements
- The accounts creation with three roles available (person in need, volunteer, professional in charge)
- The mission creation
- Database handling

*Nota Bene* : Connection to the database may still raise some errors

## Table of Contents

- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
## Getting Started
### Prerequisites
Before you begin, ensure you have the following prerequisites:

- Java 17 or higher
- Maven

### Installation
1. Clone the repository
    ```bash
   git clone https://github.com/AnaGrskovic/personal-assistance-app.git
    ```
2. Checkout to the develop branch where the current working version of the project is located
    ```bash
    git checkout develop 
    ```
4. Build the project
   ```bash
    mvn clean install
    ```
## Usage
1. Run the Spring Boot application:
    ```bash
    java -jar target/personal-assistance-app-0.0.1-SNAPSHOT.jar
    ```

2. Open your browser and go to
