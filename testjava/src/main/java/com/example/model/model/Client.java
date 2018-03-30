package com.example.model.model;

/**
 * Created by liuhanzhi on 18/3/16.
 * 动态代理
 */

public class Client {

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Subject proxy = SubjectDynamicProxy.newProxyInstance(subject);
        proxy.doSomething("Finish");
    }
}
