package org.checkstyle.suppressionxpathfilter.parenpad;

public class InputParenPadLeftFollowed {
    void method() {
        if ( false) {//warn
        }
        if (true) {
        }
    }
}
