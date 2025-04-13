# JFrog platform API and UI Automation

This framework automates a functional flow allowing a customer to:

1. Create a new local docker repository in artifactory
2. Push a local image to this repository
3. Create a security policy
4. Create a watch and link it with security policy
5. Check Xray catches vulnerabilities and flags them as per security policy
6. Verify the count on UI

## Tech stack

This project uses below tech stack

1. **Programming language**: Java 17
2. **Build tool**: Gradle
3. **Test framework**: TestNG
4. **API Automation**: Rest Assured, Gson
5. **UI Automation**: Selenium 4
6. **Reporting**: Report Portal
7. **Assertion**: Google truth

## Design principles

This framework keeps below simple principles in mind:

1. Keep tests simple and easy to understand and write
2. Don't create heavy abstractions that are difficult to maintain later; always prioritise test authoring speed
3. Leverage underlying frameworks capabilities without wrapping their capabilities into unnecessary abstractions unless
   required
4. Given robust and fast signals on pass/fail metrics and test reliability

## How to run tests?

Ensure you have docker running on your local machine and run below command to spin up report portal. We use this for as
reporting aspects

```cmd
docker-compose -p reportportal up -d --force-recreate
```

Once containers are up

- You can
  follow [these steps](https://automationhacks.io/2024-11-22-how-to-setup-report-portal-dashboards-using-attributes) in
  order to create a project named `jfrog` in report portal or
  watch [this video](https://youtu.be/5qqeDUFuDsw?si=HxlZ5lPq9ydVRTh0)
- After you create a project, you'll need to add the local project API key to `reportportal.properties` file

Next, let's run the test using gradle command line

```cmd
./gradlew test -DincludedGroups=regression --info
```

> Tip: You can run specific test by providing those groups like (`smoke, regression, backend, web_ui`, etc.)

## Folder structure

The project is structured in a way that separates backend and web automation code.

Below is the general folder structure:

### Backend

- `backend/core`: Contains core classes for API automation, including command execution, constants, environment setup,
  file management, serialization and utility classes.
- `backend/domain`: Contains domain-specific classes for Artifactory and Xray, including client classes, model classes,
  and request/response builders.

For web:

- `web/core`: Contains core classes for web automation, including browser constants and driver factory.
- `web/domain`: Contains domain-specific classes for web automation, including page objects and constants.

For tests:

- `backend/e2e`: Contains end-to-end tests for the backend automation, including assertions, flow classes, helper
  classes, and test classes.
- `web/tests`: Contains test classes for web automation, including tests and helpers.
- `resources/test_data`: Contains sample request/response JSON files for backend automation.

For config

- `resources`: Contains configuration files for logging, report portal, and stage properties. Here we assume `stage` is
  the test environment, this can easily be scaled to support different environments by adding property files and a
  toggle in Environment class