package io.automationhacks.backend.domain.xray.model.apply_watch;

import io.automationhacks.backend.core.file.FileManager;
import io.automationhacks.backend.core.object.Serialization;

import java.util.List;

public class ApplyWatchRequestBuilder {
    private final ApplyWatchRequest applyWatchRequest;

    public ApplyWatchRequestBuilder() {
        var body = FileManager.readFile("test_data/xray/apply_watch/apply_watch_request.json");
        applyWatchRequest = Serialization.deserialize(body, ApplyWatchRequest.class);
    }

    public ApplyWatchRequestBuilder withWatchName(String watchName) {
        var watchNames = List.of(watchName);
        this.applyWatchRequest.setWatchNames(watchNames);
        return this;
    }

    public ApplyWatchRequestBuilder withDates(String startDate, String endDate) {
        this.applyWatchRequest.getDateRange().setStartDate(startDate);
        this.applyWatchRequest.getDateRange().setEndDate(endDate);
        return this;
    }

    public ApplyWatchRequest build() {
        return this.applyWatchRequest;
    }
}
