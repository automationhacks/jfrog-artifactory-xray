package backend.e2e.flow;

import static io.automationhacks.backend.core.object.Serialization.serialize;

import backend.e2e.assertion.ArtifactoryAssertion;

import io.automationhacks.backend.domain.artifactory.client.repositories.RepositoryClient;
import io.automationhacks.backend.domain.artifactory.model.repositories.CreateRepositoryRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArtifactoryFlow {
    private final Logger logger = LoggerFactory.getLogger(ArtifactoryFlow.class);

    public void createRepositoryInArtifactory(String repoKey) {
        logger.info("Creating repository with key: {}", repoKey);

        var createRepositoryRequest =
                CreateRepositoryRequest.builder()
                        .projectKey("")
                        .rclass("local")
                        .xrayIndex(true)
                        .packageType("docker")
                        .key(repoKey)
                        .build();

        var requestBody = serialize(createRepositoryRequest);
        var client = new RepositoryClient();
        var response = client.createRepository(repoKey, requestBody);

        var assertion = new ArtifactoryAssertion();
        assertion.verifyCreateRepositoryIsSuccessful(repoKey, response);

        var repositoriesResponse = client.getRepositories();
        assertion.verifyLocalRepositoryIsCreated(repoKey, repositoriesResponse);
    }
}
