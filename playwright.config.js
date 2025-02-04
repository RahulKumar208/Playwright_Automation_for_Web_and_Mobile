// @ts-check
import { defineConfig, devices } from '@playwright/test';

export default defineConfig({
  testDir: './tests',
  fullyParallel: true,
  forbidOnly: !!process.env.CI, // If CI is set to true, forbid 'only' in tests
  retries: process.env.CI ? 2 : 0, // Use 2 retries if CI is set, otherwise 0 retries
  workers: process.env.CI ? 1 : undefined, // Use 1 worker in CI, otherwise default
  reporter: 'html',
  use: {
    trace: 'on-first-retry',
    screenshot: 'only-on-failure',  
    video: 'retain-on-failure', 
  },

  projects: [
    {
      name: 'Google Chrome',
      use: { 
        ...devices['Desktop Chrome'], 
        channel: 'chrome',  
        headless: false,    
        viewport: { width: 1280, height: 720 }, // Standard desktop size
      },
    },
    {
      name: 'firefox',
      use: { 
        ...devices['Desktop Firefox'], 
        headless: false,
      },
    },
    {
      name: 'webkit',
      use: { 
        ...devices['Desktop Safari'], 
        headless: false,
      },
    },

    {
      name: 'Pixel 5',
      use: { 
        ...devices['Pixel 5'], 
        headless: false, 
        viewport: { width: 393, height: 851 }, // Exact Pixel 5 viewport
        isMobile: true, // Force mobile behavior
        screen: { width: 393, height: 851 }, // Screen size
        userAgent: 'Mozilla/5.0 (Linux; Android 11; Pixel 5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Mobile Safari/537.36',
      },
    },

    {
      name: 'iPhone 13',
      use: { 
        ...devices['iPhone 13'], 
        headless: false, 
        viewport: { width: 390, height: 844 }, // Exact iPhone 13 viewport
        isMobile: true, // Force mobile behavior
        screen: { width: 390, height: 844 }, // Screen size
        userAgent: 'Mozilla/5.0 (iPhone; CPU iPhone OS 15_0 like Mac OS X) AppleWebKit/537.36 (KHTML, like Gecko) Version/15.0 Mobile/15E148 Safari/537.36',
      },
    },
  ],
});
