package org.checkstyle.suppressionxpathfilter.unnecessarysemicoloninenumeration;

public class InputUnnecessarySemicolonInEnumeration {
}

enum Good {
    One, Two
}

enum Bad {
    Third; //warn
}
