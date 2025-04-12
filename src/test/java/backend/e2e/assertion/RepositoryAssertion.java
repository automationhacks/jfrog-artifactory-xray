package backend.e2e.assertion;

import static com.google.common.truth.Truth.assertWithMessage;

import com.google.gson.reflect.TypeToken;

import io.automationhacks.backend.core.api.APIResponse;
import io.automationhacks.backend.core.object.Serialization;
import io.automationhacks.backend.domain.artifactory.model.repositories.get_repositories.GetRepositoriesResponseItem;

import java.lang.reflect.Type;
import java.util.List;

public class RepositoryAssertion {

    public void verifyCreateRepositoryIsSuccessful(String repoKey, APIResponse response) {
        assertWithMessage(
                        "Repository not created successfully for key: %s with response: %s",
                        repoKey, response.getBody())
                .that(response.getStatusCode())
                .isEqualTo(200);
    }

    public void verifyLocalRepositoryIsCreated(String repoKey, APIResponse repositoriesResponse) {
        assertWithMessage(
                        "Repository not found for key: %s with response: %s",
                        repoKey, repositoriesResponse.getBody())
                .that(repositoriesResponse.getStatusCode())
                .isEqualTo(200);

        Type listType = new TypeToken<List<GetRepositoriesResponseItem>>() {}.getType();
        List<GetRepositoriesResponseItem> repositoriesList =
                Serialization.deserialize(repositoriesResponse.getBody(), listType);
        var repository =
                repositoriesList.stream().filter(t -> t.getKey().equals(repoKey)).findFirst();

        assertWithMessage(
                        "Repository not found for key: %s with response: %s",
                        repoKey, repositoriesResponse.getBody())
                .that(repository.isPresent())
                .isTrue();
    }


}
