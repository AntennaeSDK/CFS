package org.github.antennae.cfs.util;

import javax.script.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by snambi on 7/4/17.
 */
public class JavascriptParser {

    ScriptEngineManager scriptEngineManager=null;
    ScriptEngine jsEngine =null;

    public JavascriptParser() throws ScriptException {
        scriptEngineManager = new ScriptEngineManager();
        jsEngine = scriptEngineManager.getEngineByName("JavaScript");

        // Add the JSON function
        String parseFn = "function parseJSON( json ){ var obj = JSON.parse(json); return obj; }";

        jsEngine.eval(parseFn);
    }


    public Object parse( String json ) throws ScriptException, NoSuchMethodException {

        Invocable inv = (Invocable) jsEngine;
        Object result = ((Invocable) jsEngine).invokeFunction("parseJSON", json);

        System.out.println("JSON "+ result);

        return result;
    }

}
