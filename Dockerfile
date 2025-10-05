# Use OpenJDK 17
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Install Maven (for building the project)
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Copy project files
COPY . /app

# Build the project with Maven
RUN mvn clean package

# Default command to run the calculator interactively
# '-it' must be specified when running, Dockerfile cannot force it, but we can use ENTRYPOINT
ENTRYPOINT ["java","-cp","target/Calculator-1.0-SNAPSHOT.jar","calculator.Main"]
