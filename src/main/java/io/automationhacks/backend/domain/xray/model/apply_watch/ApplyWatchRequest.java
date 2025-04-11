package io.automationhacks.backend.domain.xray.model.apply_watch;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class ApplyWatchRequest {

    @SerializedName("date_range")
    private DateRange dateRange;

    @SerializedName("watch_names")
    private List<String> watchNames;
}
