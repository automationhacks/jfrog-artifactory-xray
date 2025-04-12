# JFrog platform Automation

This framework automates a functional flow allowing a customer to:

1. Create a new local docker repository in artifactory
2. Push a local image to this repository
3. Create a security policy
4. Create a watch and link it with security policy
5. Check Xray catches vulnerabilities and flags them as per security policy

## How to run

Ensure you have docker running on your local and run below command to spin up report portal. 

```cmd
docker-compose -p reportportal up -d --force-recreate
```

Once all your containers are up, You can follow [these steps](https://automationhacks.io/2024-11-22-how-to-setup-report-portal-dashboards-using-attributes) in order to create a project in report portal.

Next, let's run the test using gradle command line

```cmd
./gradlew clean test
```

## Tech stack

This project uses below stack

1. Programming language: Java 17
2. Build tool: Gradle
3. Test framework: TestNG
4. API Automation: Rest Assured, Gson
5. UI Automation: Selenium 4
6. Reporting: Report Portal
7. Assertion: Google truth

## Folder structure

The project is structured in a way that separates the backend and web automation code. Below is the folder structure:

For backend:

- `backend/core`: Contains core classes for API automation, including command execution, constants, environment setup, file management, serialization and utility classes.
- `backend/domain`: Contains domain-specific classes for Artifactory and Xray, including client classes, model classes, and request/response builders.

For web:

- `web/core`: Contains core classes for web automation, including browser constants and driver factory.
- `web/domain`: Contains domain-specific classes for web automation, including page objects and constants.

For tests:

- `backend/e2e`: Contains end-to-end tests for the backend automation, including assertions, flow classes, helper classes, and test classes.
- `resources/test_data`: Contains sample request/response JSON files for backend automation.

For config

- `resources`: Contains configuration files for logging, report portal, and stage properties.

```text
.
├── main
│ ├── java
│ │ └── io
│ │     └── automationhacks
│ │         ├── backend
│ │         │ ├── core
│ │         │ │ ├── api
│ │         │ │ │ ├── APIResponse.java
│ │         │ │ │ └── ReqResBuilder.java
│ │         │ │ ├── command
│ │         │ │ │ └── CmdExec.java
│ │         │ │ ├── constants
│ │         │ │ │ ├── Auth.java
│ │         │ │ │ └── DateTimeConstants.java
│ │         │ │ ├── env
│ │         │ │ │ └── Environment.java
│ │         │ │ ├── file
│ │         │ │ │ └── FileManager.java
│ │         │ │ ├── model
│ │         │ │ │ └── BasicAuth.java
│ │         │ │ ├── object
│ │         │ │ │ └── Serialization.java
│ │         │ │ └── utils
│ │         │ │     ├── DateTimeUtils.java
│ │         │ │     └── StringUtils.java
│ │         │ └── domain
│ │         │     ├── artifactory
│ │         │     │ ├── client
│ │         │     │ │ └── ArtifactoryClient.java
│ │         │     │ ├── constants
│ │         │     │ │ └── Endpoints.java
│ │         │     │ └── model
│ │         │     │     └── repositories
│ │         │     │         ├── CreateRepositoryRequest.java
│ │         │     │         └── get_repositories
│ │         │     │             ├── GetRepositoriesResponse.java
│ │         │     │             └── GetRepositoriesResponseItem.java
│ │         │     └── xray
│ │         │         ├── client
│ │         │         │ └── XrayClient.java
│ │         │         └── model
│ │         │             ├── apply_watch
│ │         │             │ ├── ApplyWatchRequest.java
│ │         │             │ ├── ApplyWatchRequestBuilder.java
│ │         │             │ └── DateRange.java
│ │         │             ├── create_security_policy
│ │         │             │ ├── Actions.java
│ │         │             │ ├── BlockDownload.java
│ │         │             │ ├── CreateSecurityPolicyRequest.java
│ │         │             │ ├── CreateSecurityPolicyRequestBuilder.java
│ │         │             │ ├── Criteria.java
│ │         │             │ └── RulesItem.java
│ │         │             ├── create_watch
│ │         │             │ ├── AssignedPoliciesItem.java
│ │         │             │ ├── CreateWatchRequest.java
│ │         │             │ ├── CreateWatchRequestBuilder.java
│ │         │             │ ├── FiltersItem.java
│ │         │             │ ├── GeneralData.java
│ │         │             │ ├── ProjectResources.java
│ │         │             │ └── ResourcesItem.java
│ │         │             ├── get_violations
│ │         │             │ ├── request
│ │         │             │ │ ├── ArtifactsItem.java
│ │         │             │ │ ├── Filters.java
│ │         │             │ │ ├── GetViolationsRequest.java
│ │         │             │ │ ├── GetViolationsRequestBuilder.java
│ │         │             │ │ ├── Pagination.java
│ │         │             │ │ └── Resources.java
│ │         │             │ └── response
│ │         │             │     ├── ApplicabilityDetailsItem.java
│ │         │             │     ├── ApplicabilityItem.java
│ │         │             │     ├── DetailsItem.java
│ │         │             │     ├── EvidenceItem.java
│ │         │             │     ├── ExtendedInformation.java
│ │         │             │     ├── GetViolationsResponse.java
│ │         │             │     ├── JfrogResearchSeverityReasonsItem.java
│ │         │             │     └── ViolationsItem.java
│ │         │             └── scan_status
│ │         │                 ├── response
│ │         │                 │ ├── Applications.java
│ │         │                 │ ├── Categories.java
│ │         │                 │ ├── ContextualAnalysis.java
│ │         │                 │ ├── Details.java
│ │         │                 │ ├── Exposures.java
│ │         │                 │ ├── Iac.java
│ │         │                 │ ├── Overall.java
│ │         │                 │ ├── Sca.java
│ │         │                 │ ├── ScanStatusResponse.java
│ │         │                 │ ├── Secrets.java
│ │         │                 │ ├── Services.java
│ │         │                 │ └── Violations.java
│ │         │                 └── ScanStatusRequest.java
│ │         ├── Main.java
│ │         └── web
│ │             ├── core
│ │             │ ├── constant
│ │             │ │ └── Browser.java
│ │             │ └── driver
│ │             │     └── DriverFactory.java
│ │             └── domain
│ │                 ├── constants
│ │                 │ └── PageUrls.java
│ │                 └── page_objects
│ │                     ├── common
│ │                     │ └── LoadingPage.java
│ │                     ├── login
│ │                     │ └── LoginPage.java
│ │                     └── xray
│ │                         └── scans_list
│ │                             └── ArtifactsPage.java
│ └── resources
└── test
    ├── java
    │ ├── backend
    │ │ └── e2e
    │ │     ├── assertion
    │ │     │ ├── ArtifactoryAssertion.java
    │ │     │ ├── XrayAssertion.java
    │ │     │ └── XrayUIAssertions.java
    │ │     ├── flow
    │ │     │ ├── ArtifactoryFlow.java
    │ │     │ └── XrayFlow.java
    │ │     ├── helper
    │ │     │ └── TestHelper.java
    │ │     └── tests
    │ │         └── VulnerabilityScanByPolicyTest.java
    │ └── web
    └── resources
        ├── logback.xml
        ├── reportportal.properties
        ├── stage.properties
        └── test_data
            └── xray
                ├── apply_watch
                │ └── apply_watch_request.json
                ├── create_security_policy
                │ └── min_severity_as_high.json
                ├── create_watch
                │ └── create_watch_on_security_policy.json
                ├── get_violations
                │ └── get_violations_request.json
                └── scan_status
                    └── scan_status_request.json
```
