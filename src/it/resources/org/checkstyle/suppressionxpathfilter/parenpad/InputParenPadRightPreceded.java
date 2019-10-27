package org.checkstyle.suppressionxpathfilter.parenpad;

public class InputParenPadRightPreceded {
    void method() {
        if (false ) {//warn
        }
        if (true) {
        }
    }
}
