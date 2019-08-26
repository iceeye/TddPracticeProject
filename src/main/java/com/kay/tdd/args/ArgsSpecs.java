package com.kay.tdd.args;

public class ArgsSpecs {

    public static final String ARGS_SPECS_SPLIT_FLAG = "\\s+";
    private final String label;
    private final String value;

    public ArgsSpecs(String arg) {
        String[] split = arg.split(ARGS_SPECS_SPLIT_FLAG);
        this.label = split[0];
        this.value = split.length ==2 ? split[1] : null;
    }

    public String getValue() {
        return this.value;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof ArgsSpecs) {
            ArgsSpecs other = (ArgsSpecs) obj;
            return this.label.equals(other.label) && this.value.equals(other.value);
        }

        return false;
    }
}
