package org.github.antennae.cfs;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.github.antennae.cfs.util.JavascriptParser;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by snambi on 7/4/17.
 */
public class JavaScriptExecutionTest {

    static JavascriptParser parser;
    static String jsonStr=null;
    static String parseFn=null;


    @BeforeClass
    public static void setUp(){

        // create the JS engine
        try {
            parser = new JavascriptParser();
        } catch (ScriptException e) {
            e.printStackTrace();
        }


        // load the JSON from FS
        StringBuilder sb = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("test.json").toURI()))) {

            //stream.forEach(System.out::println);
            stream.forEach(sb::append);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        jsonStr = sb.toString();

        // load the JS function
        StringBuilder sb2 = new StringBuilder();
        try(Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("ParseFn.js").toURI()))){
            stream.forEach(sb2::append);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        parseFn = sb2.toString();

        try {
            parser.addFunction(sb2.toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jsParseTest(){

        try {

            ScriptObjectMirror json = (ScriptObjectMirror) parser.parse("{\"username\":\"xyz\",\"password\":\"xyz@123\", \"email\":\"xyz@xyz.com\", \"uid\": 1100}");

            System.out.println("JSON: "+ json.getOwnKeys(true) );
            System.out.println("JSON: "+ json.getProto().toString() );

            json.getMember("name");

            Assert.assertNotNull(json);

        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jsFuncInvokeTest(){

        try {
            parser.addFunction(parseFn);
        } catch (ScriptException e) {
            e.printStackTrace();
        }


        try {

            Object result = parser.getHeader(jsonStr);

            System.out.println("Result: "+ result.toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
