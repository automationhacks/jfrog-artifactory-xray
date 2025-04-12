package io.automationhacks.backend.domain.xray.model.get_violations.response;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

import java.util.List;

@Data
public class EvidenceItem {

    @SerializedName("column_names")
    private List<String> columnNames;

    @SerializedName("rows")
    private List<List<String>> rows;

    public List<String> getColumnNames() {
        return columnNames;
    }

    public List<List<String>> getRows() {
        return rows;
    }
}
