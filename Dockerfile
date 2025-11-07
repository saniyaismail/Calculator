# Use OpenJDK 17
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Install Maven (for building the project)
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Copy project files
COPY . /app

# Build the project with Maven
RUN mvn clean package


ENTRYPOINT ["java","-cp","target/Calculator-1.0-SNAPSHOT.jar","calculator.Main"]
