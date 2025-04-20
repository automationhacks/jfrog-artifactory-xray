# JFrog platform API and UI Automation

This framework automates a functional flow allowing a customer to:

1. Create a new local docker repository in artifactory
2. Push a local image to this repository
3. Create a security policy
4. Create a watch and link it with security policy
5. Check Xray catches vulnerabilities and flags them as per security policy
6. Verify the count on UI

You can see the postman collection under:

`/postman` to see relevant API request and responses

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

1. Keep tests simple, easy to understand and write
2. Don't create heavy abstractions that are difficult to maintain later; always prioritise test authoring speed
3. Leverage underlying frameworks capabilities without wrapping their capabilities into unnecessary abstractions unless
   required
4. Provide robust and fast signals on pass/fail metrics and test reliability

## Design patterns used

API

- **Builder pattern**: to prepare request payloads for APIs

UI 

- **Factory pattern**: provide appropriate WebDriver instance for web automation
- **Page Object Model**: to separate page elements and actions from test logic

## Pre setup

### Register your trial in JFrog

Please set up a trial account. Please follow the following steps to take.

#### Step 1: Trial Account Setup

1. Visit the JFrog trial page: https://jfrog.com/start-free/#trialOptions.
2. Select the **14-day** trial option.
3. Choose a signup method

Follow the instructions to complete the setup.

After setup, you’ll receive an email from `service@jfrog.com` with your platform details (URL, username, and password).

> Please note: If you registered using Google, access the platform by logging in with your
> Google account and **setting up an admin user**. Additionally, you will receive
> a platform URL in the format `https://{platform_id}.jfrog.io`. Take note of the
> `platform_id`, as it will be required when pushing a Docker image to the platform.

#### Step 2: Create an Admin User

1. Log in to the JFrog Platform using your Google account.
2. Navigate to the Administration tab in the top menu.
3. Click on User Management in the left-hand menu.
4. Click New User and provide the following details:

- Username: [Choose a username]
- Email: [Provide an email]
- Role: Select Administer Platform.

### Setup reporting stack

Ensure you have docker running on your local machine and run below command to spin up report portal. 

We'll use this for as test reporting and analytics tool.

```cmd
docker-compose -p reportportal up -d --force-recreate
```

Once containers are up

- You can
  follow [these steps](https://automationhacks.io/2024-11-22-how-to-setup-report-portal-dashboards-using-attributes) in
  order to create a project named `jfrog` in report portal or
  watch [this video](https://youtu.be/5qqeDUFuDsw?si=HxlZ5lPq9ydVRTh0)
- After you create a project, you'll need to add the local project API key to `reportportal.properties` file

### Setup credentials

Ensure you add your JFROG platform credentials in `.bash_profile` or `.zshrc` and source it before running the tests

```zsh
# JFrog
export JFROG_USERNAME=""
export JFROG_PASSWORD=""
```

```zsh
source ~/.zshrc
```

Also replace the hostname in `stage.properties`

```text
ARTIFACTORY_HOSTNAME=https://automationhacks.jfrog.io
JFROG_UI=https://automationhacks.jfrog.io/ui
```

## How to run tests?

Next, let's run the test using gradle command line

```cmd
./gradlew test -DincludedGroups=regression --info
```

> Tip: You can run specific test by providing those groups like (`smoke, regression, backend, web_ui`, etc.)

If you run `regression`, it would run 2 tests specified in backend and web packages:

- `src/test/java/backend/e2e/tests/SecurityViolationsPerPolicyAPITest.java`
- `src/test/java/web/tests/SecurityViolationsPerPolicyUITest.java` (does everything done by API test + UI verification)

## Folder structure

The project is structured in a way that separates backend and web automation code.

Below is the general folder structure:

### Backend

- `backend/core`: Contains core classes for API automation, including command execution, constants, environment setup,
  file management, serialization and utility classes.
- `backend/domain`: Contains domain-specific classes for Artifactory and Xray, including client classes, model classes,
  and request/response builders.

### Web

- `web/core`: Contains core classes for web automation, including browser constants and driver factory.
- `web/domain`: Contains domain-specific classes for web automation, including page objects and constants.

### Tests

- `backend/e2e`: Contains end-to-end tests for the backend automation, including assertions, flow classes, helper
  classes, and test classes.
- `web/tests`: Contains test classes for web automation, including tests and helpers.
- `resources/test_data`: Contains sample request/response JSON files for backend automation.

### Config

- `resources`: Contains configuration files for logging, report portal, and stage properties. Here we assume `stage` is
  the test environment, this can easily be scaled to support different environments by adding property files and a
  toggle in Environment class

## Future Enhancement ideas

- Add TestNG listener class to send a slack notification after test run with pass/fail and report portal link
- Add switch in build.gradle to change the environment dynamically
- Add framework utilities (connect to db with connection pooling, queue (rabbitmq, kafka), etc.)
- Refactor API layer to decouple framework from RestAssured and add a layer in between to provide future scalability
