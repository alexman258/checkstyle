package org.checkstyle.suppressionxpathfilter.whitespaceafter;

public class InputWhitespaceAfterTypecast {
    Object bad = (Object)null; //warn
    Object good = (Object) null;
}
