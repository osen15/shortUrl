package com;

import org.apache.commons.lang3.RandomStringUtils;

public class Demo {

    public static void main(String[] args) {
        String string = RandomStringUtils.random(6, true, true);
        System.out.println(string);

    }
}
