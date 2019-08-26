package com.kay.tdd.args;

import org.junit.Test;

import static org.junit.Assert.*;

public class SchemaSpacsTest {

    @Test
    public void should_get_schema_spacs_label() {
        String schemaSpac = "l:boolean";
        SchemaSpacs schemaSpacs = new SchemaSpacs(schemaSpac);
        assertEquals(schemaSpacs.getLabel(), "l");
        assertEquals(schemaSpacs.getType(), "boolean");
        assertEquals(schemaSpacs, new SchemaSpacs(schemaSpac));
    }

}