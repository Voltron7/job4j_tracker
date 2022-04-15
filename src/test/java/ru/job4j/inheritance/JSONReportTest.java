package ru.job4j.inheritance;

import static org.junit.Assert.*;
import org.junit.Test;

public class JSONReportTest {

    @Test
    public void whenTestGenerateMethod() {
        String ln = System.lineSeparator();
        String expected = "{" + ln
                + "\t\"name\" : \"name\"," + ln
                + "\t\"body\" : \"body\"" + ln
                + "}";
        String name = "name";
        String body = "body";
        String result = new JSONReport().generate(name, body);
        assertEquals(expected, result);
    }
}