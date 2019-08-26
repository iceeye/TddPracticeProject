package com.kay.tdd.args;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.valueOf;

public class Args {
    public static final String ARGS_SPLIT_FLAG = "-";
    private final Schema schema;
    private final List<ArgsSpecs> args;

    public Args(Schema schema, String argsLine) {
        this.schema = schema;
        this.args = Arrays.asList(argsLine.split(ARGS_SPLIT_FLAG))
                .stream().filter(arg -> arg != null && arg.length() > 0)
                .map(ArgsSpecs::new).collect(Collectors.toList());
    }

    public Object getLabelValue(String label) {
        if (!schema.isContainsLabel(label)) {
            throw new IllegalArgumentException("The label " + label + " is not contain in the schema.");
        }
        ArgsSpecs argsSpecs = args.stream().filter(arg -> arg.getLabel().equals(label)).findFirst().orElse(null);
        if (argsSpecs == null) {
            throw new IllegalArgumentException("The label " + label + " is illegal.");
        }
        return changeToRealType(argsSpecs.getLabel(), argsSpecs.getValue());
    }

    private Object changeToRealType(String label, String value) {
        if (value == null || value.length() == 0) {
            return schema.getLabelDefault(label);
        }
        String labelType = schema.getLabelType(label);
        switch (labelType) {
            case "boolean":
                return value.equals("true") ? Boolean.TRUE : Boolean.FALSE;
            case "integer":
                return valueOf(value);
            case "string":
                return value;
            default:
                return null;
        }
    }

}
