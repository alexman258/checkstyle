package org.checkstyle.suppressionxpathfilter.avoidnestedblocks;

public class InputAvoidNestedBlocksVariable {

    void varAssign() {
        int whichIsWhich = 0;
        { // warn
            whichIsWhich = 2;
        }
    }
}
