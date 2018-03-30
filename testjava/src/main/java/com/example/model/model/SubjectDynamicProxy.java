package com.example.model.model;

import java.lang.reflect.InvocationHandler;

/**
 * Created by liuhanzhi on 18/3/16.
 */

public class SubjectDynamicProxy extends DynamicProxy {

    public static <T> T newProxyInstance(Subject subject) {
        ClassLoader classLoader = subject.getClass().getClassLoader();
        Class<?>[] classes = subject.getClass().getInterfaces();
        InvocationHandler h = new MyInvocationHandler(subject);
        return newProxyInstance(classLoader, classes, h);
    }
}
