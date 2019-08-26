package com.kay.tdd.args;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchemaTest {

    @Test
    public void should_created_schema_object() {
        String schemaLine = "l:boolean  p:integer d:string";
        Schema schema = new Schema(schemaLine);
        assertThat(schema.size(), is(3));
        assertThat(schema.isContainsLabel("l"), is(Boolean.TRUE));
        assertThat(schema.isContainsLabel("p"), is(Boolean.TRUE));
        assertThat(schema.isContainsLabel("d"), is(Boolean.TRUE));
        assertThat(schema.isContainsLabel("s"), is(Boolean.FALSE));

        assertThat(schema.getLabelType("l"), is("boolean"));
        assertThat(schema.getLabelType("p"), is("integer"));
        assertThat(schema.getLabelType("d"), is("string"));
        assertNull(schema.getLabelType("s"));

        assertThat(schema.getLabelDefault("l"), is(Boolean.TRUE));
        assertThat(schema.getLabelDefault("p"), is(8081));
        assertThat(schema.getLabelDefault("d"), is("/tmp"));
        assertNull(schema.getLabelType("s"));
    }

}