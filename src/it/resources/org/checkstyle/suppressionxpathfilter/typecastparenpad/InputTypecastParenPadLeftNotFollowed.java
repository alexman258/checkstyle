package org.checkstyle.suppressionxpathfilter.typecastparenpad;

public class InputTypecastParenPadLeftNotFollowed {
    Object bad = (Object )null;//warn
    Object good = ( Object )null;
}
