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

package com.puppycrawl.tools.checkstyle.checks.javadoc;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
//import com.puppycrawl.tools.checkstyle.api.AbstractCheck.FileContext;
import com.puppycrawl.tools.checkstyle.utils.CommonUtil;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * <p>
 * Leading Asterisk {@code LeadingAsteriskAlignCheck} checks that the javadoc
 * has a leading asterisk for all doc comments.
 * </p>
 */
public class LeadingAsteriskAlignCheck extends AbstractCheck {

	/**
	 * The buffer reader.
	 */
	private BufferedReader reader = null;
	
	/**
	 * javadoc comment in file.
	 */
	private boolean javdocComment = false;
	
	public boolean isJavdocComment() {
		return javdocComment;
	}

	public void setJavdocComment(boolean javdocComment) {
		this.javdocComment = javdocComment;
	}

	@Override
	public int[] getDefaultTokens() {
		return getAcceptableTokens();
	}

	@Override
	public int[] getAcceptableTokens() {
		return CommonUtil.EMPTY_INT_ARRAY;
	}

	@Override
	public final int[] getRequiredTokens() {
		return CommonUtil.EMPTY_INT_ARRAY;
	}

	public boolean hasLeadingAsterisk(String fileName) {

		try {
			this.reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			while (line != null) {
				if (line.length() >= 3 && !isJavdocComment()) {
					if (line.substring(0, 3) == "/**") {
						this.setJavdocComment(true);
					}
				} else if (isJavdocComment()) {
					if (line.length() >= 2 && line.substring(0, 2) == "*/") {
						this.setJavdocComment(false);
					} else if (line.charAt(0) == '*') {
						continue;
					} else {
						return false;
					}
				}
				line = reader.readLine();
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
