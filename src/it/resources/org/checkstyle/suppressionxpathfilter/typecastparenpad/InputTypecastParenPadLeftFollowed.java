package org.checkstyle.suppressionxpathfilter.typecastparenpad;

public class InputTypecastParenPadLeftFollowed {
    Object bad = ( Object)null;//warn
    Object good = (Object)null;
}
