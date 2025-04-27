# QR Code Generator

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.4-brightgreen)
![AWS SDK](https://img.shields.io/badge/AWS%20SDK-2.24.12-yellow)
![Google ZXing](https://img.shields.io/badge/Google%20ZXing-3.5.2-blue)
![Docker](https://img.shields.io/badge/Docker-✓-blue)
![Maven](https://img.shields.io/badge/Maven-3.9.6-red)

## Table of Contents

- [How to Use](#how-to-use)
  - [Prerequisites](#prerequisites)
  - [Environment Variables](#environment-variables)
  - [Running the Application](#running-the-application)
    - [Local Development](#local-development)
    - [Docker Deployment](#docker-deployment)
  - [AWS S3 Configuration](#aws-s3-configuration)
- [Application Flow](#application-flow)
- [API Endpoints](#api-endpoints)
- [UML Component Diagram](#uml-component-diagram)
- [License](#license)

A Java 21 and Spring Boot REST application that creates QR codes and stores them in AWS S3. This project demonstrates the integration of  AWS S3 for storage and Google's ZXing library for QR code generation.

## How to Use

This section provides comprehensive instructions for setting up and running the QR Code Generator application.

### Prerequisites

- Java 21 JDK
- Maven
- Docker
- AWS Account with S3 access
- AWS CLI configured with appropriate credentials

### Environment Variables

Create a `.env` file in the project root with the following variables:

```env
AWS_ACCESS_KEY_ID=your_access_key
AWS_SECRET_ACCESS_KEY=your_secret_key
```

### Running the Application

#### Local Development

1. Create the `.env` file as described above
2. Build the project:
   ```bash
   mvn clean package
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

#### Docker Deployment

1. Build the Docker image:
   ```bash
   docker build -t qrcode-generator:1.0 . 
   ```
> Remember to replace the version and image name if you want

2. Run the container:
   ```bash
   docker run --env-file .env -p 8080:8080 qrcode-generator:1.0
   ```

### AWS S3 Configuration

1. Create an S3 bucket in your AWS account
2. Update the `AWS_BUCKET_NAME` in your `.env` file or Docker run command
3. Ensure your AWS credentials have appropriate permissions to access the S3 bucket

## Application Flow

![image](https://github.com/user-attachments/assets/aa7cdb40-3363-48c2-8400-4fea26044d5b)


## API Endpoints

### POST /qr/
Generate a QR code from the provided text and store it in AWS S3. The QR code will be generated as a PNG image with dimensions of 300x300 pixels.

**Parameters**

| Name | Required | Type | Description |
|------|----------|------|-------------|
| `text` | required | string | The text content to be encoded in the QR code. This can be any string value that you want to convert into a QR code. |

**Response**

```json
{
    "url": "https://your-bucket.s3.your-region.amazonaws.com/random-uuid"
}
```

**Error Response**

The API will return a 500 Internal Server Error, if an error occurs during QR code generation or S3 upload. 

**Example Usage**

```bash
curl -X POST http://localhost:8080/qr/ \
     -H "Content-Type: application/json" \
     -d '{"text": "https://example.com"}'
```

**Example in Postman** 

![image](https://github.com/user-attachments/assets/e3bd75ac-bedc-48a8-a0bc-71ce8fb084ba)

**Example QR Code Generated**

![image](https://github.com/user-attachments/assets/ad9a41e0-6c2a-4ce5-8508-7f2ebd0c8e6a)



## UML Component Diagram

This UML diagram illustrates the key components within the com.jesteves.qr package and their relationships, showcasing a layered architecture often associated with Ports and Adapters (Hexagonal Architecture).


![image](https://github.com/user-attachments/assets/3969dcd3-29c5-4dba-9956-6ac5288ba9d5)


## License

This project is licensed under the MIT License - see the LICENSE file for details. 
