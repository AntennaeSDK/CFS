package org.github.antennae.cfs.javscript;

/**
 * All Errors thrown by Javascript are wrapped under JavaScript Exception.
 */
public class JavaScriptException extends Exception {

    public JavaScriptException(String s) {
        super(s);
    }

    public JavaScriptException(String message, Throwable cause){
        super(message, cause);
    }
}
