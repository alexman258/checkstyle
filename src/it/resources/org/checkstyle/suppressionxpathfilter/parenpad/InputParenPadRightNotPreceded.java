package org.checkstyle.suppressionxpathfilter.parenpad;

public class InputParenPadRightNotPreceded{
    void method() {
        if ( false) {//warn
        }
        if ( true ) {
        }
    }
}
