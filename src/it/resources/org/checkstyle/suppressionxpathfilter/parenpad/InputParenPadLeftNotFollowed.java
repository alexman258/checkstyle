package org.checkstyle.suppressionxpathfilter.parenpad;

public class InputParenPadLeftNotFollowed {
    void method() {
        if (false ) {//warn
        }
        if ( true ) {
        }
    }
}
