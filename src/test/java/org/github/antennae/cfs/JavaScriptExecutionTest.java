package org.github.antennae.cfs;

import org.github.antennae.cfs.util.JavascriptParser;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by snambi on 7/4/17.
 */
public class JavaScriptExecutionTest {

    static JavascriptParser parser;

    @BeforeClass
    public static void setUp(){
        try {
            parser = new JavascriptParser();
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jsParseTest(){

        try {

            Object json = parser.parse("{\"username\":\"xyz\",\"password\":\"xyz@123\", \"email\":\"xyz@xyz.com\", \"uid\": 1100}");

            System.out.println("JSON: "+ json );
            Assert.assertNotNull(json);

        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
