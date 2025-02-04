# Studydrive Automation Testing

This repository contains an end-to-end test automation suite for the Studydrive platform using **Playwright**. The tests cover user onboarding, course joining, document uploading, and user interactions on both web and mobile applications.

## **Features**

- **Automated User Registration**: Completes the signup process and selects a university.
- **Course Joining & Document Upload**: Joins a course and uploads a document.
- **Post Creation & Interaction**: Creates a post in a course and adds a comment.
- **Cross-Browser & Mobile Testing**: Runs on **Chrome**, **Firefox**, **Safari**, **Android (Pixel 5)**, and **iOS (iPhone 13)**.
- **Visual & Functional Assertions**: Includes UI validation and backend checks.
- **Failure Handling**: Captures screenshots and videos on test failures.

## **Technologies Used**

- **Playwright**: For browser automation.
- **Node.js**: JavaScript runtime.
- **GitHub Actions (Optional)**: For CI/CD integration.

## **Setup Instructions**

### **Prerequisites**

- **Node.js** (>=16.x) installed. ([Download](https://nodejs.org/))
- **Playwright** installed:

  ```bash
  npm install -g playwright

### **Clone the Repository**
  git clone https://github.com/RahulKumar208/Playwright_Automation_for_Web_and_Mobile.git
cd Playwright_Automation_for_Web_and_Mobile

### **Install Dependencies**
npm install

### **Install Playwright Browsers**
npx playwright install

### **Install Playwright Browsers**

