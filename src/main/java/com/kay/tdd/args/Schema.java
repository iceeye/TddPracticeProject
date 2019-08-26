package com.kay.tdd.args;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Schema {

    public static final String SCHEMA_SPLIT_FLAG = "\\s+";
    private final List<SchemaSpacs> schemaSpacs;

    public Schema(String schemaLine) {
        this.schemaSpacs = Arrays.asList(schemaLine.split(SCHEMA_SPLIT_FLAG))
                .stream().map(SchemaSpacs::new).collect(Collectors.toList());
    }

    public int size() {
        return schemaSpacs.size();
    }

    public Boolean isContainsLabel(String label) {
        SchemaSpacs schemaSpac = schemaSpacs.stream()
                .filter(ss -> ss.getLabel().equals(label)).findFirst().orElse(null);
        return schemaSpac != null;
    }

    public String getLabelType(String label) {
        SchemaSpacs schemaSpac = schemaSpacs.stream()
                .filter(ss -> ss.getLabel().equals(label)).findFirst().orElse(null);
        if (schemaSpac == null) {
            return null;
        }
        return schemaSpac.getType();
    }

    public Object getLabelDefault(String label) {
        String type = getLabelType(label);

        switch (type) {
            case "boolean":
                return Boolean.TRUE;
            case "integer":
                return 8081;
            case "string":
                return "/tmp";
            default:
                return null;
        }
    }
}
