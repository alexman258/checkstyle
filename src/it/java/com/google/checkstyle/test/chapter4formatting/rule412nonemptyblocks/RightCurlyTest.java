////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code for adherence to a set of rules.
// Copyright (C) 2001-2019 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
////////////////////////////////////////////////////////////////////////////////

package com.google.checkstyle.test.chapter4formatting.rule412nonemptyblocks;

import static com.puppycrawl.tools.checkstyle.checks.blocks.RightCurlyCheck.MSG_KEY_LINE_ALONE;
import static com.puppycrawl.tools.checkstyle.checks.blocks.RightCurlyCheck.MSG_KEY_LINE_BREAK_BEFORE;
import static com.puppycrawl.tools.checkstyle.checks.blocks.RightCurlyCheck.MSG_KEY_LINE_SAME;

import org.junit.Test;

import com.google.checkstyle.test.base.AbstractGoogleModuleTestSupport;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.blocks.RightCurlyCheck;
import com.puppycrawl.tools.checkstyle.utils.CommonUtil;

public class RightCurlyTest extends AbstractGoogleModuleTestSupport {

    @Override
    protected String getPackageLocation() {
        return "com/google/checkstyle/test/chapter4formatting/rule412nonemptyblocks";
    }

    @Test
    public void testRightCurlyAlone() throws Exception {
        final String[] expected = {
            "20:17: " + getCheckMessage(RightCurlyCheck.class, MSG_KEY_LINE_SAME, "}", 17),
            "32:13: " + getCheckMessage(RightCurlyCheck.class, MSG_KEY_LINE_SAME, "}", 13),
            "79:27: " + getCheckMessage(RightCurlyCheck.class, MSG_KEY_LINE_BREAK_BEFORE, "}", 27),
        };

        final Configuration checkConfig = getModuleConfig("RightCurly", "RightCurlySame");
        final String filePath = getPath("InputRightCurlyOther.java");

        final Integer[] warnList = getLinesWithWarn(filePath);
        verify(checkConfig, filePath, expected, warnList);
    }

    @Test
    public void testRightCurlySame() throws Exception {
        final String[] expected = CommonUtil.EMPTY_STRING_ARRAY;

        final Configuration checkConfig = getModuleConfig("RightCurly", "RightCurlySame");
        final String filePath = getPath("InputRightCurlySame.java");

        final Integer[] warnList = getLinesWithWarn(filePath);
        verify(checkConfig, filePath, expected, warnList);
    }

    @Test
    public void testRightCurlySameAndLiteralDoDefault() throws Exception {
        final String[] expected = {
            "62:9: " + getCheckMessage(RightCurlyCheck.class, MSG_KEY_LINE_SAME, "}", 9),
            "67:13: " + getCheckMessage(RightCurlyCheck.class, MSG_KEY_LINE_SAME, "}", 13),
            "83:9: " + getCheckMessage(RightCurlyCheck.class, MSG_KEY_LINE_SAME, "}", 9),
        };

        final Configuration checkConfig = getModuleConfig("RightCurly", "RightCurlySame");
        final String filePath = getPath("InputRightCurlyDoWhile.java");

        final Integer[] warnList = getLinesWithWarn(filePath);
        verify(checkConfig, filePath, expected, warnList);
    }

    @Test
    public void testRightCurlyAloneOther() throws Exception {
        final String[] expected = {
            "99:5: " + getCheckMessage(RightCurlyCheck.class, MSG_KEY_LINE_ALONE, "}", 5),
            "99:6: " + getCheckMessage(RightCurlyCheck.class, MSG_KEY_LINE_ALONE, "}", 6),
            "110:5: " + getCheckMessage(RightCurlyCheck.class, MSG_KEY_LINE_ALONE, "}", 5),
            "110:6: " + getCheckMessage(RightCurlyCheck.class, MSG_KEY_LINE_ALONE, "}", 6),
            "124:5: " + getCheckMessage(RightCurlyCheck.class, MSG_KEY_LINE_ALONE, "}", 5),
            "124:6: " + getCheckMessage(RightCurlyCheck.class, MSG_KEY_LINE_ALONE, "}", 6),
            "155:6: " + getCheckMessage(RightCurlyCheck.class, MSG_KEY_LINE_ALONE, "}", 6),  
            "157:25: " + getCheckMessage(RightCurlyCheck.class, MSG_KEY_LINE_ALONE, "}", 25),  
            "161:5: " + getCheckMessage(RightCurlyCheck.class, MSG_KEY_LINE_ALONE, "}", 5),
            "161:6: " + getCheckMessage(RightCurlyCheck.class, MSG_KEY_LINE_ALONE, "}", 6),  
        };

        final Configuration checkConfig = getModuleConfig("RightCurly", "RightCurlyAlone");
        final String filePath = getPath("InputRightCurlyOtherAlone.java");

        final Integer[] warnList = getLinesWithWarn(filePath);
        verify(checkConfig, filePath, expected, warnList);
    }

    @Test
    public void testRightCurlyAloneSame() throws Exception {
        final String[] expected = CommonUtil.EMPTY_STRING_ARRAY;

        final Configuration checkConfig = getModuleConfig("RightCurly", "RightCurlyAlone");
        final String filePath = getPath("InputRightCurlySame.java");

        final Integer[] warnList = getLinesWithWarn(filePath);
        verify(checkConfig, filePath, expected, warnList);
    }

    @Test
    public void testRightCurlyAloneSameAndLiteralDo() throws Exception {
        final String[] expected = CommonUtil.EMPTY_STRING_ARRAY;

        final Configuration checkConfig = getModuleConfig("RightCurly", "RightCurlyAlone");
        final String filePath = getPath("InputRightCurlyDoWhileAlone.java");

        final Integer[] warnList = getLinesWithWarn(filePath);
        verify(checkConfig, filePath, expected, warnList);
    }

}
