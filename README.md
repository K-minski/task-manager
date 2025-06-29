# Sample Task Manager App
Sample Task Manager App built with Spring Boot, JTE and HTMX as tech demo

## Getting Started

### Prerequisites

- JRE 21

### Installation
Clone project from repository:
```
git clone https://github.com/K-minski/task-manager.git
```
Navigate to project folder:
```bash
cd task-manager
```

Install the dependencies:

```bash
./mvnw install
```

### Development

Start the development server with HMR:

```bash
./mvnw spring-boot:run 
```

Your application will be available at `http://localhost:8080`.

## Building for Production

Create a production build:

```bash
./mvnw package
```

## Deployment

### Docker Deployment

To build and run using Docker:

```bash
docker build -t my-app .

# Run the container
docker run -p 3000:3000 my-app
```

The containerized application can be deployed to any platform that supports Docker, including:

- AWS ECS
- Google Cloud Run
- Azure Container Apps
- Digital Ocean App Platform
- Fly.io
- Railway
