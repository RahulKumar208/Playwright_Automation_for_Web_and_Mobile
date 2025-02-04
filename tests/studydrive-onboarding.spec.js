const { test, expect } = require('@playwright/test');

test.describe('Studydrive Onboarding', () => {
  test.beforeEach(async ({ page }) => {
    await page.goto('https://www.studydrive.net/');
  });

  test('Completes the user registration', async ({ page }) => {
    // Handle Cookie Consent
    await page.waitForTimeout(3000); // Wait for cookie banner to appear
    const cookieButton = await page.locator('#usercentrics-cmp-ui').evaluateHandle(el => el.shadowRoot.querySelector('button#accept'));
    await cookieButton.click();
    
    // Click Signup Button
    await page.waitForTimeout(500);
    await page.locator('xpath=(//button[@data-testid="top-bar-guest_btn-signup"])').click();

    
    await page.locator('xpath=//input[@data-testid="auth-form-username-input"]').fill('qatestingautomation5@gmail.com');
    await page.locator('xpath=//input[@data-testid="auth-form-password-input"]').fill('Qwerty123$');

    // Click Register
    await page.locator('xpath=//*[@data-testid="auth-form_btn-register"]').click();

    await page.waitForTimeout(500);

    await expect(page.locator('text=Choose your display name')).toBeVisible();
    await page.locator('xpath=//*[@data-testid="profile-register-lets-go-button"]').click();

    await page.locator('xpath=//button[@data-testid="study-button-type-student"]').click();
    await page.locator('xpath=//input[@placeholder="Enter university name"]').fill('987654321');
    await page.locator('xpath=//*[@class="vs__dropdown-menu"]').locator('text=987654321').click();

    await page.locator('xpath=//*[@data-testid="university-study-selector-major-select"]').locator('text=Mathematics, Computer Sciences & Natural Sciences').click();
    await page.waitForTimeout(500);

    await page.locator('xpath=//*[@data-testid="university-study-selector-program-select"]').click();
    await page.waitForTimeout(1000);  // Allow time for API response
    await page.locator('xpath=//*[@data-testid="university-study-selector-program-select"]').locator('text=Computer Engineering').click();

    await page.locator('xpath=//*[@data-testid="university-study-selector-semester-select"]').locator('text=Winter 2024/25').click();
    await page.locator('xpath=//*[@data-testid="profile-register-continue-button"]').click();

    // Joining Courses
    await page.locator('xpath=//i[@class="btn-icon icon icon-course"]').click();
   // await page.locator('xpath=//*[text()="Courses"]').click();

   await page.locator('xpath=//*[contains(@class,"center font-medium")]//*[@class="btn-icon icon icon-add"]').click({ force: true });
   await page.waitForTimeout(10000);


    await page.locator('xpath=(//*[contains(@class,"rounded") and descendant::*[text()="microeconomics"]])[2]//button').click();
    await expect(page.locator('//*[text()="Joined"]')).toContainText("Joined");
    await page.locator('xpath=(//*[contains(@class,"rounded")]//*[text()="microeconomics"])').click();
    await expect(page.locator('//button[descendant::*[text()="Joined"]]')).toContainText('Joined');

    // Upload file 
    await page.locator('xpath=//*[@class="btn-icon icon icon-add-file"]').click();
    await page.setInputFiles('input[type="file"]', 'cypress/fixtures/studydrive_testing.pdf');

    await page.locator('xpath=//*[@data-testid="input-checkbox" and descendant::*[text()="Upload anonymously"]]') .click();
    await page.locator('xpath=//*[@placeholder="Semester"]').click(); 
    await page.locator('.vs__dropdown-menu').locator('text=Winter 2024/25').click();

    await page.locator('xpath=//*[@placeholder="Document type"]').click(); 
    await page.locator('.vs__dropdown-menu').locator('text=Other').click();

    await page.locator('xpath=//*[@placeholder="Language"]').click(); 
    await page.locator('.vs__dropdown-menu').locator('text=English').click();

    await page.locator('xpath=//*[@placeholder="Enter course name"]').click(); 
    await page.locator('.vs__dropdown-menu').locator('text=microeconomics').click();

    await page.locator('xpath=//input[@placeholder="Add description"]').fill('y');
    await page.locator('xpath=//button//*[text()="Upload and earn rewards"]').click();
    await page.waitForTimeout(8000);
    await page.locator('//*[text()="Proceed to My Documents"]').click();

    await page.locator('xpath=//a[text()="studydrive_testing.pdf"]').click();
    await page.waitForTimeout(500);
    await expect(page.locator('//i[@class="btn-icon icon icon-downloads"]')).toBeVisible();
    await page.locator('//form[descendant::*[text()="Create a post"]]//*[@placeholder="Ask a question..."]').fill('hey?');
    await page.locator('//i[@class="btn-icon icon icon-send"]').click();
    await expect(page.locator('//p[@class="highlight-links" and descendant::*[text()="hey?"]]')).toBeVisible();

    await page.locator('(//*[@class="btn-content"]//i[@class="btn-icon icon icon-more"])[1]').click();
    await page.locator('//a[contains(@class,"active") and descendant::*[text()="Delete"]]') .click();

    await page.locator('//*[@placeholder="Choose an issue"]').click(); 
    await page.locator('.vs__dropdown-menu').locator('text=I no longer wish to share this document').click();

    await page.locator('//*[text()="Continue" and ancestor::*[@data-testid="modal-form-delete-document-submit"]]') .click();
    await page.locator('//*[text()="Delete document"]').click();

    // Logout
    await page.locator('//*[contains(@class,"profileCard")]').click();
    await page.locator('//li[descendant::*[text()="Log out"]]') .click();

  });
});