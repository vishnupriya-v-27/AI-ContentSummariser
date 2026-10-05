
# AI Content Summariser  

A production-ready Spring Boot RESTful web service that integrates with Google Gemini AI (`gemini-2.5-flash`) to generate concise, key-point text summaries and estimated reading times.

---

## Features

- **AI-Powered Summarization:** Integrates with Google Gemini API via `RestTemplate` to summarize long-form text into key takeaways.
- **Reading Time Calculation:** Automatically estimates content reading duration based on word count algorithms.
- **Robust Exception Handling:** Gracefully handles API rate limits, invalid input, and HTTP error responses.
- **Clean Architecture:** Built following SOLID principles with strict separation between Controllers, Services, and Data Transfer Objects (DTOs).

---

## Tech Stack

- **Language:** Java 21
- **Framework:** Spring Boot 4.1.1
- **HTTP Client:** Spring `RestTemplate`
- **AI Model:** Google Gemini (`gemini-2.5-flash`)
- **Build Tool:** Maven

---

## Setup & Installation

### Prerequisites

- Java 21 JDK installed
- Maven installed (or use the included Maven Wrapper `./mvnw`)
- A Google Gemini API Key (Get one from [Google AI Studio](https://aistudio.google.com/))

### 1. Clone the Repository

```bash
git clone [https://github.com/vishnupriya-v-27/AI-ContentSummariser.git](https://github.com/vishnupriya-v-27/AI-ContentSummariser.git)
cd AI-ContentSummariser

```

### 2. Configure Environment Variables

Open `src/main/resources/application.properties` and add your Gemini API key:

```properties
server.port=8080
gemini.api.url=[https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent](https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent)
gemini.api.key=YOUR_ACTUAL_GEMINI_API_KEY

```

> **Note:** Never commit actual API keys to GitHub. Ensure `application-local.properties` or environment variables are used in production environments.

### 3. Build & Run

```bash
# Using Maven Wrapper
./mvnw clean spring-boot:run

```

The application will start on `http://localhost:8080`.

---

## API Documentation

### Summarize Text

* **Endpoint:** `POST /api/v1/summarise`
* **Content-Type:** `application/json`

#### Request Body

```json
{
  "text": "Artificial Intelligence is transforming industries globally. By leveraging machine learning models, businesses can automate complex tasks, analyze vast datasets, and deliver personalized user experiences at scale."
}

```

#### Response Body

```json
{
  "summary": "AI is driving industrial transformation through automated workflows and large-scale data analytics.",
  "estimatedReadTimeMinutes": 1
}

```

---

## Project Structure

```text
src/main/java/com/aisummariser/
├── AiSummariserApplication.java     # Spring Boot Entry Point
├── controller/
│   └── SummariseController.java    # REST API Controllers
├── service/
│   └── SummariseService.java       # Business Logic & Gemini Integration
└── dto/
    ├── SummariseRequest.java       # Request Payload Model
    └── SummariseResponse.java      # Response Payload Model

```

---

## License

This project is licensed under the [MIT License](https://www.google.com/search?q=LICENSE).

```

---

### Step-by-Step Instructions to Add `README.md` to GitHub

Run these commands in your Mac terminal:

1. **Create the file locally:**
   ```bash
   cat << 'EOF' > README.md
   # AI Content Summariser REST API

   A production-ready Spring Boot RESTful web service that integrates with Google Gemini AI (`gemini-2.5-flash`) to generate concise, key-point text summaries and estimated reading times.

   ---

   ## Features

   - **AI-Powered Summarization:** Integrates with Google Gemini API via `RestTemplate` to summarize long-form text into key takeaways.
   - **Reading Time Calculation:** Automatically estimates content reading duration based on word count algorithms.
   - **Robust Exception Handling:** Gracefully handles API rate limits, invalid input, and HTTP error responses.
   - **Clean Architecture:** Built following SOLID principles with strict separation between Controllers, Services, and Data Transfer Objects (DTOs).

   ---

   ## Tech Stack

   - **Language:** Java 21
   - **Framework:** Spring Boot 4.1.1
   - **HTTP Client:** Spring `RestTemplate`
   - **AI Model:** Google Gemini (`gemini-2.5-flash`)
   - **Build Tool:** Maven

   ---

   ## Setup & Installation

   ### Prerequisites

   - Java 21 JDK installed
   - Maven installed (or use the included Maven Wrapper `./mvnw`)
   - A Google Gemini API Key (Get one from [Google AI Studio](https://aistudio.google.com/))

   ### 1. Clone the Repository

   ```bash
   git clone [https://github.com/vishnupriya-v-27/AI-ContentSummariser.git](https://github.com/vishnupriya-v-27/AI-ContentSummariser.git)
   cd AI-ContentSummariser

```

### 2. Configure Environment Variables

Open `src/main/resources/application.properties` and add your Gemini API key:

```properties
server.port=8080
gemini.api.url=[https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent](https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent)
gemini.api.key=YOUR_ACTUAL_GEMINI_API_KEY

```

> **Note:** Never commit actual API keys to GitHub. Ensure `application-local.properties` or environment variables are used in production environments.

### 3. Build & Run

```bash
# Using Maven Wrapper
./mvnw clean spring-boot:run

```

The application will start on `http://localhost:8080`.

---

## API Documentation

### Summarize Text

* **Endpoint:** `POST /api/v1/summarise`
* **Content-Type:** `application/json`

#### Request Body

```json
{
  "text": "Artificial Intelligence is transforming industries globally. By leveraging machine learning models, businesses can automate complex tasks, analyze vast datasets, and deliver personalized user experiences at scale."
}

```

#### Response Body

```json
{
  "summary": "AI is driving industrial transformation through automated workflows and large-scale data analytics.",
  "estimatedReadTimeMinutes": 1
}

```

---

## Project Structure

```text
src/main/java/com/aisummariser/
├── AiSummariserApplication.java     # Spring Boot Entry Point
├── controller/
│   └── SummariseController.java    # REST API Controllers
├── service/
│   └── SummariseService.java       # Business Logic & Gemini Integration
└── dto/
    ├── SummariseRequest.java       # Request Payload Model
    └── SummariseResponse.java      # Response Payload Model

```

---

## License

This project is licensed under the [MIT License](https://www.google.com/search?q=LICENSE).
EOF

