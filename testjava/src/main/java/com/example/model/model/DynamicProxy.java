package com.example.model.model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by liuhanzhi on 18/3/16.
 */

public class DynamicProxy<T> {

    public static <T> T newProxyInstance(ClassLoader classLoader, Class<?>[] interfaces, InvocationHandler h) {
        return (T) Proxy.newProxyInstance(classLoader, interfaces, h);
    }
}
