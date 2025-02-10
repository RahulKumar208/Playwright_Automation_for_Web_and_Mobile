# Playwright Automation Testing (Web/Mobile) and Appium with Eclipse for Android App Automation

This repository contains an end-to-end test automation suite for the Studydrive platform using **Playwright** for web automation and **Appium** for Android mobile automation. The tests cover user onboarding, course joining, document uploading, and user interactions on both web and mobile applications.

## Features
- **Automated User Registration**: Completes the signup process and selects a university.
- **Course Joining & Document Upload**: Joins a course and uploads a document.
- **Post Creation & Interaction**: Creates a post in a course and adds a comment.
- **Cross-Browser & Mobile Testing**: Runs on Chrome, Firefox, Safari, Android (Pixel 5), and iOS (iPhone 13).
- **Visual & Functional Assertions**: Includes UI validation and backend checks.
- **Failure Handling**: Captures screenshots and videos on test failures.
- **Android Mobile Testing with Appium**: Automates user actions on the Studydrive Android app.

## Technologies Used
### For Web Automation
- **Playwright**: Browser automation
- **Node.js**: JavaScript runtime
- **GitHub Actions (Optional)**: For CI/CD integration

### For Mobile Automation (Android)
- **Appium**: Mobile automation framework
- **Eclipse IDE**: For writing and managing test scripts
- **Appium Inspector**: To inspect UI elements
- **Appium Server**: To execute test cases
- **Android Studio**: To run the mobile app on an emulator or real device
- **Real Android Device**: Connected via USB for testing

## Setup Instructions
### For Web Automation (Playwright)
#### Prerequisites
- Node.js (>=16.x) installed. ([Download](https://nodejs.org/))
- Playwright installed:
  ```bash
  npm install -g playwright


  ##Clone the Repository
git clone https://github.com/RahulKumar208/Playwright_Automation_for_Web_and_Mobile.git
cd Playwright_Automation_for_Web_and_Mobile

##Install Dependencies
npm install

##Install Playwright Browsers
npx playwright install

##Email Registration and Verification
Before running the tests, make sure to provide a valid Gmail address and password for the user registration and email verification process.

1. **Update the Test Script:** In the test script (e.g., studydrive-onboarding.spec.js), update the email_address and password fields with valid credentials for registration:
   const email_address = 'your-email@gmail.com';
    const password = 'your-password';
2. **Email Verification:** After completing the registration, an email will be sent to the provided address. Follow the instructions in the email to verify the account before proceeding with further actions like course joining or document upload.

##Security Note: For security reasons, credentials should never be shared publicly.

##Run Tests for Web Browsers
npx playwright test --project="Google Chrome"
npx playwright test --project="firefox"
npx playwright test --project="webkit"

##Run Tests for Mobile Browsers (Android & iOS)
npx playwright test --project="Pixel 5"
npx playwright test --project="iPhone 13"

##Run All Tests
npx playwright test

##View Test Reports
npx playwright show-report

##For Mobile Automation (Appium - Android)
**Prerequisites**
- Install Java Development Kit (JDK 11+)
- Install Android Studio and set up the Android SDK
- Install Appium Server (Download)
- Install Eclipse IDE
- Install Appium Inspector for element inspection
- Enable USB Debugging on a real Android device

##Clone the Repository
git clone https://github.com/RahulKumar208/Playwright_Automation_for_Web_and_Mobile.git
cd Playwright_Automation_for_Web_and_Mobile

##Setup Appium Server
1. Open Appium Server and start the session.
2. Connect a real Android device via USB.
3. Ensure the Android App (.apk) file is available.

##Run Mobile Tests using Appium
1. Open Eclipse IDE and import the project.
2. Navigate to the StudyDriveTest.java file.
3. Start Appium Server.
4. Run the test script:

mvn test -Dtest=StudyDriveTest

##Directory Structure

📂 Playwright_Automation_for_Web_and_Mobile
 ┣ 📂 tests
 ┃ ┣ 📜 studydrive-onboarding.spec.js      # Playwright Test Script (Web)
 ┃ ┣ 📜 StudyDriveTest.java                # Appium Test Script (Mobile)
 ┣ 📜 playwright.config.js                 # Playwright Settings
 ┣ 📜 pom.xml                              # Maven Config for Appium
 ┣ 📜 package.json                         # Node Dependencies
 ┣ 📜 README.md                            # Documentation

##Future Enhancements
- **API Testing:** Automate API responses for backend validation.
- **Performance Testing**: Measure page load time & responsiveness.
- **Parallel Execution in CI/CD**: Run tests efficiently using GitHub Actions.


