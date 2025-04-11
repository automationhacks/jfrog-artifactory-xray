package io.automationhacks.backend.domain.xray.model.create_security_policy;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Criteria {

    @SerializedName("fix_version_dependant")
    private boolean fixVersionDependant;

    @SerializedName("malicious_package")
    private boolean maliciousPackage;

    @SerializedName("min_severity")
    private String minSeverity;
}
