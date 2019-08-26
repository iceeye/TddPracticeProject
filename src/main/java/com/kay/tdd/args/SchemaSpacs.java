package com.kay.tdd.args;

public class SchemaSpacs {

    private final String label;
    private final String type;

    public SchemaSpacs(String schemaSpac) {
        String[] split = schemaSpac.split(":");
        this.label = split[0];
        this.type = split[1];
    }

    public String getLabel() {
        return this.label;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof SchemaSpacs) {
            SchemaSpacs other = (SchemaSpacs) obj;
            return this.label.equals(other.label) && this.type.equals(other.type);
        }
        return false;
    }
}
