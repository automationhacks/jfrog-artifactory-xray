package io.automationhacks.backend.domain.xray.model.create_security_policy;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Actions {

    @SerializedName("mails")
    private List<Object> mails;

    @SerializedName("notify_deployer")
    private boolean notifyDeployer;

    @SerializedName("block_download")
    private BlockDownload blockDownload;

    @SerializedName("webhooks")
    private List<Object> webhooks;

    @SerializedName("fail_build")
    private boolean failBuild;

    @SerializedName("block_release_bundle_distribution")
    private boolean blockReleaseBundleDistribution;

    @SerializedName("block_release_bundle_promotion")
    private boolean blockReleaseBundlePromotion;

    @SerializedName("create_ticket_enabled")
    private boolean createTicketEnabled;

    @SerializedName("notify_watch_recipients")
    private boolean notifyWatchRecipients;
}
