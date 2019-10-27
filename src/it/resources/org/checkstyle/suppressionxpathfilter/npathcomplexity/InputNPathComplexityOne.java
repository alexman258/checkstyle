package org.checkstyle.suppressionxpathfilter.npathcomplexity;

public class InputNPathComplexityOne {
    public void test() { //warn
        while (true) {
            if (1 > 0) {

            } else {

            }
        }
    }
}
