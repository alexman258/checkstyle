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

package com.puppycrawl.tools.checkstyle.checks.blocks;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
//import com.puppycrawl.tools.checkstyle.api.AbstractCheck.FileContext;
import com.puppycrawl.tools.checkstyle.utils.CommonUtil;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * <p>
 * Leading Asterisk {@code LeadingAsteriskAlignCheck} checks that every 
 * Javadoc comment leading asterisk is vertically aligned. 
 * </p>
 */
public class LeadingAsteriskAlignCheck extends AbstractCheck {


	@Override
	public int[] getDefaultTokens() {
		return null;
	}

	@Override
	public int[] getAcceptableTokens() {
		return null;
	}

	@Override
	public final int[] getRequiredTokens() {
		return null;
	}

	
}