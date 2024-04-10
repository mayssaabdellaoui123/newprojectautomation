# Use an official Maven image as the base image for building
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the project files to the working directory
COPY . .

# Copy the config.properties file to the appropriate directory
COPY src/test/resources/configs/config.properties src/test/resources/configs/


# Build the project
RUN mvn clean install -DskipTests


# Install necessary packages
RUN apt-get update && apt-get install -y \
    libglib2.0-0 \
    libnss3 \
    wget \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# Download and install chromedriver
RUN wget https://chromedriver.storage.googleapis.com/94.0.4606.61/chromedriver_linux64.zip \
    && unzip chromedriver_linux64.zip \
    && mv chromedriver /usr/local/bin/ \
    && rm chromedriver_linux64.zip

# Expose any necessary ports
EXPOSE 8080

# Add TestNG JAR to the classpath
ENV CLASSPATH /usr/src/app:/usr/src/app/target/*:/usr/src/app/target/test-classes:/usr/src/app/target/classes:/usr/share/maven/ref/repository/org/testng/testng/7.3.0/*:/usr/share/maven/ref/repository/org/apache/maven/surefire/surefire-testng/2.22.2/*

# Run TestNG tests when the container starts
CMD ["mvn", "clean", "test", "-Dsurefire.suiteXmlFiles=testng.xml"]