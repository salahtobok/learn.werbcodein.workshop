package com.webcodein.nativedemo;

/** Stand-in for a class that is only used through reflection at runtime. */
public class MyDynamicClass {

    public MyDynamicClass() {
    }

    public String hello() {
        return "hello from reflection";
    }
}
