# QE Automation Assignment

## Overview
This repository contains an enterprise-style UI automation framework built as part of a QE assignment.
The framework is designed to demonstrate real-world automation practices rather than simple scripts.

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- Logback (logging)
- Extent Reports (HTML reporting)

## Framework Highlights
- Page Object Model (POM)
- Centralized WebDriver management
- Explicit waits (no hard sleeps)
- Clean logging and reporting

## How to Run
1. Import the project as a Maven project
2. Update the file path in `BaseTest.java` to point to `index.html`
3. Run tests using:
   ```bash
   mvn test
