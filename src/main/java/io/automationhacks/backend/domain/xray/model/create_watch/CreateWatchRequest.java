package io.automationhacks.backend.domain.xray.model.create_watch;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

import java.util.List;

@Data
public class CreateWatchRequest {

    @SerializedName("assigned_policies")
    private List<AssignedPoliciesItem> assignedPolicies;

    @SerializedName("general_data")
    private GeneralData generalData;

    @SerializedName("project_resources")
    private ProjectResources projectResources;
}
