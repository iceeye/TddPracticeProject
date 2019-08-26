package com.kay.tdd.args;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArgsSpecsTest {

    @Test
    public void should_create_args_specs_obj() {
        ArgsSpecs argsSpecs = new ArgsSpecs("l true");
        assertThat(argsSpecs.getLabel(), is("l"));
        assertThat(argsSpecs.getValue(), is("true"));
        assertThat(argsSpecs, is(new ArgsSpecs("l true")));
    }

}