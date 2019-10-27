package org.checkstyle.suppressionxpathfilter.emptyforiteratorpad;

public class InputEmptyForIteratorPadNotFollowed {
    void method(int bad, int good) {
        for (bad = 0; ++bad < 2;) {//warn
        }
        for (good = 0; ++good < 1; ) {
        }
    }
}
