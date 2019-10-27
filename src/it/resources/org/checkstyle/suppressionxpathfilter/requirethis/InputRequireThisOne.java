package org.checkstyle.suppressionxpathfilter.requirethis;

public class InputRequireThisOne {
    private int age = 23;

    public void changeAge() {
        age = 24; //warn
    }
}
