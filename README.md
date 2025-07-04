# Task Manager App
The project was created for the purpose of passing the labs in the course “Software Development Automation Tools” and to learn JTE with HTMX.
Its main purpose is to demonstrate the ability to work with Git, developer workflow and CI/CD automation.

## Technologies
- JRE 21
- Spring Boot
- Java Template Engine
- HTMX

## Getting Started

### Prerequisites
In order to build app form source only JRE 21 is required.

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
./mvnw spring-boot:run -Dspring-boot.run.arguments="gg.jte.development-mode=true gg.jte.usePrecompiledTemplates=false"

```

Your application will be available at `http://localhost:8080`.

## CI/CD Workflow – Automatyzacja testów i wdrożenia
Currently there are three avaialable\
- CI &rarr; Verification tests executed when Pull Request is initiatesd\
  ![CI-Pull request verification](https://github.com/K-minski/task-manager/actions/workflows/tm-verification.yaml/badge.svg)
- CD &rarr; Docker container build and push to the DockerHub\
  ![CD-Docker Build and push](https://github.com/K-minski/task-manager/actions/workflows/tm-docker-build.yaml/badge.svg)
- CD &rarr; Deployment to AWS (NOTE: For project purposes triggered manually. Normally would include it in sinlde workflow with Docker Build and push)\
  ![CD-Deploy to AWS](https://github.com/K-minski/task-manager/actions/workflows/tm-deploy.yaml/badge.svg)

## Building for Production

Create a production build:

```bash
./mvnw clean package
```

## Deployment

### Docker Deployment
App can be deployed with single docker run command:
```bash
docker run -p 8080:8080 kminski/task-manager:latest
```

The containerized application can be deployed to any platform that supports Docker, including:

- AWS ECS
- Google Cloud Run
- Azure Container Apps
- Digital Ocean App Platform
- Fly.io
- Railway
