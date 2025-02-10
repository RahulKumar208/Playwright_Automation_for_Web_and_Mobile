Playwright & Appium Automation Testing (Web & Mobile)

This repository contains an end-to-end test automation suite for the Studydrive platform using Playwright for web automation and Appium for Android mobile automation. The tests cover user onboarding, course joining, document uploading, and user interactions on both web and mobile applications.

Features

Automated User Registration: Completes the signup process and selects a university.
Course Joining & Document Upload: Joins a course and uploads a document.
Post Creation & Interaction: Creates a post in a course and adds a comment.
Cross-Browser & Mobile Testing: Runs on Chrome, Firefox, Safari, Android (Pixel 5), and iOS (iPhone 13).
Visual & Functional Assertions: Includes UI validation and backend checks.
Failure Handling: Captures screenshots and videos on test failures.
Android Mobile Testing with Appium: Automates user actions on the Studydrive Android app.
Technologies Used

For Web Automation

Playwright: Browser automation
Node.js: JavaScript runtime
GitHub Actions (Optional): For CI/CD integration
For Mobile Automation (Android)

Appium: Mobile automation framework
Eclipse IDE: For writing and managing test scripts
Appium Inspector: To inspect UI elements
Appium Server: To execute test cases
Android Studio: To run the mobile app on an emulator or real device
Real Android Device: Connected via USB for testing
Setup Instructions

For Web Automation (Playwright)

Prerequisites

Install Node.js (>=16.x) (Download: https://nodejs.org/)
Install Playwright:
sh
Copy
Edit
npm install -g playwright
Clone the Repository

sh
Copy
Edit
git clone https://github.com/RahulKumar208/Playwright_Automation_for_Web_and_Mobile.git  
cd Playwright_Automation_for_Web_and_Mobile  
Install Dependencies

sh
Copy
Edit
npm install
Install Playwright Browsers

sh
Copy
Edit
npx playwright install
Email Registration and Verification

Update the test script (e.g., studydrive-onboarding.spec.js) with a valid Gmail address and password:
js
Copy
Edit
const email_address = 'your-email@gmail.com';
const password = 'your-password';
Verify the account through the received email before proceeding with tests.
Security Note: Do not share credentials publicly.
Run Tests for Web Browsers

sh
Copy
Edit
npx playwright test --project="Google Chrome"  
npx playwright test --project="firefox"  
npx playwright test --project="webkit"  
Run Tests for Mobile Browsers (Android & iOS)

sh
Copy
Edit
npx playwright test --project="Pixel 5"  
npx playwright test --project="iPhone 13"  
Run All Tests

sh
Copy
Edit
npx playwright test
View Test Reports

sh
Copy
Edit
npx playwright show-report
For Mobile Automation (Appium - Android)

Prerequisites

Install Java Development Kit (JDK 11+)
Install Android Studio and set up the Android SDK
Install Appium Server (Download: http://appium.io/)
Install Eclipse IDE
Install Appium Inspector for element inspection
Enable USB Debugging on a real Android device
Clone the Repository

sh
Copy
Edit
git clone https://github.com/RahulKumar208/Playwright_Automation_for_Web_and_Mobile.git  
cd Playwright_Automation_for_Web_and_Mobile  
Setup Appium Server

Open Appium Server and start the session.
Connect a real Android device via USB.
Ensure the Android App (.apk) file is available.
Run Mobile Tests using Appium

Open Eclipse IDE and import the project.
Navigate to the StudyDriveTest.java file.
Start Appium Server.
Run the test script:
sh
Copy
Edit
mvn test -Dtest=StudyDriveTest
Directory Structure

bash
Copy
Edit
📂 Playwright_Automation_for_Web_and_Mobile  
 ┣ 📂 tests  
 ┃ ┣ 📜 studydrive-onboarding.spec.js      # Playwright Test Script (Web)  
 ┃ ┣ 📜 StudyDriveTest.java                 # Appium Test Script (Mobile)  
 ┣ 📜 playwright.config.js                  # Playwright Settings  
 ┣ 📜 pom.xml                                # Maven Config for Appium  
 ┣ 📜 package.json                           # Node Dependencies  
 ┣ 📜 README.md                              # Documentation  
Future Enhancements

API Testing: Automate API responses for backend validation.
Performance Testing: Measure page load time & responsiveness.
Parallel Execution in CI/CD: Run tests efficiently using GitHub Actions.
