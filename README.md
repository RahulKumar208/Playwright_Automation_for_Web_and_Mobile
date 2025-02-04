Studydrive Automation Testing

This repository contains an end-to-end test automation suite for the Studydrive platform using Playwright. The tests cover user onboarding, course joining, document uploading, and user interactions on both web and mobile applications.

Features

Automated User Registration: Completes the signup process and selects a university.

Course Joining & Document Upload: Joins a course and uploads a document.

Post Creation & Interaction: Creates a post in a course and adds a comment.

Cross-Browser & Mobile Testing: Runs on Chrome, Firefox, Safari, Android (Pixel 5), and iOS (iPhone 13).

Visual & Functional Assertions: Includes UI validation and backend checks.

Failure Handling: Captures screenshots and videos on test failures.

Technologies Used

Playwright: For browser automation.

Node.js: JavaScript runtime.

GitHub Actions (Optional): For CI/CD integration.

Setup Instructions

Prerequisites

Node.js (>=16.x) installed. (Download)

Playwright installed:

npm install -g playwright

Git installed (Download)

Clone the Repository

git clone https://github.com/RahulKumar208/Playwright_Automation_for_Web_and_Mobile.git
cd Playwright_Automation_for_Web_and_Mobile

Install Dependencies

npm install

Install Playwright Browsers

npx playwright install

Running Tests

Run Tests for Web Browsers

npx playwright test --project="Google Chrome"
npx playwright test --project="firefox"
npx playwright test --project="webkit"

Run Tests for Mobile (Android & iOS)

npx playwright test --project="Pixel 5"
npx playwright test --project="iPhone 13"

Run All Tests

npx playwright test

View Test Reports

After running tests, open the report:

npx playwright show-report

Directory Structure

📂 Playwright_Automation_for_Web_and_Mobile
 ┣ 📂 tests
 ┃ ┗ 📜 studydrive-onboarding.spec.js  # Test script
 ┣ 📜 playwright.config.js             # Playwright settings
 ┣ 📜 package.json                     # Node dependencies
 ┣ 📜 README.md                         # Documentation

Future Enhancements

API Testing: Automate API responses for backend validation.

Performance Testing: Measure page load time & responsiveness.

Parallel Execution in CI/CD: Run tests efficiently using GitHub Actions.

Author

Rahul Kumar
