package org.checkstyle.suppressionxpathfilter.genericwhitespace;

import java.util.Collections;

public class InputGenericWhitespaceStartThree {
    < E> void bad() {//warn
    }
    <E> void good() {
    }
}
