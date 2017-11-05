package org.github.antennae.cfs.javscript;

import javax.script.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by snambi on 7/4/17.
 */
public class JavaScriptExecutor {

    ScriptEngineManager scriptEngineManager=null;
    ScriptEngine jsEngine =null;

    public JavaScriptExecutor() throws ScriptException {
        scriptEngineManager = new ScriptEngineManager();
        jsEngine = scriptEngineManager.getEngineByName("JavaScript");
    }


    public Object parse( String json ) throws ScriptException, NoSuchMethodException {

        Invocable inv = (Invocable) jsEngine;
        Object result = ((Invocable) jsEngine).invokeFunction("parseJSON", json);

        //System.out.println("JSON "+ result);

        return result;
    }

    public Object function( String functionName, String args) throws JavaScriptException {

        Invocable invocable = (Invocable) jsEngine;
        Object result = null;
        try {
            result = invocable.invokeFunction(functionName, args);
        } catch (ScriptException|NoSuchMethodException e) {
            throw new JavaScriptException("Unable to execute function:"+ functionName, e);
        }

        return result;
    }

    public void loadJavaScriptFile( String javascriptFileName ) throws JavaScriptException {

        String jsFilePath = null;
        try {
            jsFilePath = findFilePath(javascriptFileName);
        } catch (URISyntaxException e) {
            throw new JavaScriptException("Unable to get file path for "+ javascriptFileName, e);
        }

        String loadScript = "load( \"" + jsFilePath + "\" )";

        try {
            jsEngine.eval(loadScript);
        } catch (ScriptException e) {
            throw new JavaScriptException("Unable to load file "+ javascriptFileName + " in Javascript Engine", e);
        }
    }

    public String findFilePath( String filename ) throws URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource(filename).toURI());
        return path.toFile().getAbsolutePath();
    }

    public String readFile( String filename ) throws JavaScriptException {

        StringBuilder result = new StringBuilder();
        try{
            Stream<String> streams = Files.lines(Paths.get(ClassLoader.getSystemResource(filename).toURI()));
            streams.forEach(result::append);
        } catch (IOException |URISyntaxException e) {
            throw new JavaScriptException("Unable to read file file "+ filename);
        }

        return result.toString();
    }
}
