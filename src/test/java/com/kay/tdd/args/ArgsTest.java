package com.kay.tdd.args;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArgsTest {

    private Schema schema;
    private Args args;

    @Before
    public void setUp() {
        this.schema = new Schema("l:boolean p:integer d:string");
        this.args =  new Args(schema, "-l true -p 8080 -d  /user/log -m");
    }

    @Test
    public void should_get_args_label() {
        setUp();
        assertThat(args.getLabelValue("l"), is(Boolean.TRUE));
        assertThat(args.getLabelValue("p"), is(8080));
        assertThat(args.getLabelValue("d"), is("/user/log"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_schema_is_not_contain_the_label() {
        setUp();
        assertNull(args.getLabelValue("m"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_args_is_not_contain_the_label() {
        setUp();
        assertNull(args.getLabelValue("s"));
    }

    @Test
    public void should_get_args_default_value() {
        setUp();
        args = new Args(schema, "-l -p  -d");
        assertThat(args.getLabelValue("l"), is(Boolean.TRUE));
        assertThat(args.getLabelValue("p"), is(8081));
        assertThat(args.getLabelValue("d"), is("/tmp"));
    }
}
