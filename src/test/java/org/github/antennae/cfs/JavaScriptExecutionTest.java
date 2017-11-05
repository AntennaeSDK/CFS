package org.github.antennae.cfs;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.github.antennae.cfs.javscript.JavaScriptException;
import org.github.antennae.cfs.javscript.JavaScriptExecutor;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.script.ScriptException;
import java.net.URISyntaxException;

/**
 * Created by snambi on 7/4/17.
 */
public class JavaScriptExecutionTest {

    static JavaScriptExecutor javaScriptExecutor;


    @BeforeClass
    public static void setUp() throws ScriptException {

        // create the JS engine
        javaScriptExecutor = new JavaScriptExecutor();

    }

    @Test
    public void jsParseTest(){

        try {

            ScriptObjectMirror json = (ScriptObjectMirror) javaScriptExecutor.parse("{\"username\":\"xyz\",\"password\":\"xyz@123\", \"email\":\"xyz@xyz.com\", \"uid\": 1100}");

            System.out.println("JSON: "+ json.getOwnKeys(true) );
            System.out.println("JSON: "+ json.getProto().toString() );

            json.getMember("name");

            JSONObject jsonObject = new JSONObject(json);
            Object name = jsonObject.get("username");

            Assert.assertNotNull(json);

        } catch (ScriptException|NoSuchMethodException|JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jsFuncInvokeTest() throws JavaScriptException {

        String jsonStr = javaScriptExecutor.readFile("test.json");

        javaScriptExecutor.loadJavaScriptFile("ParseFn.js");

        Object result = javaScriptExecutor.function("getHeader", jsonStr);
        System.out.println("Result: "+ result.toString());

        Object items = javaScriptExecutor.function("getItems", jsonStr);
        System.out.println("Items: "+ items);

    }
}
