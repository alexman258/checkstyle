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
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.FileContents;
import com.puppycrawl.tools.checkstyle.api.JavadocTokenTypes;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

/**
 * <p>
 * Leading Asterisk {@code LeadingAsteriskAlignCheck} checks that every
 * multi-line comment leading asterisk is vertically aligned.
 * 
 * Javadoc comments have a LeadingAsterisk token that can be compared with the
 * leading asterisk token of every other line in the comment. 
 * For some reason, this leading asterisk column is always 0. So for now,
 * treating javadoc comments identically to regular block comments.
 * 
 * Regular block comments do not contain a leading asterisk token. The leading
 * asterisk is found programmatically and compared with other leading asterisks
 * in the comment block.
 * 
 * </p>
 */
public class LeadingAsteriskAlignCheck extends AbstractCheck {

	/**
	 * Left align.
	 */

	/**
	 * Center align
	 */

	/**
	 * Right align
	 */

	/**
	 * Alignment of leading asterisk. Default is 0. This aligns the asterisks
	 * directly below the first asterisk Other options are -1, and 1. Which either
	 * left aligns, or right aligns all other asterisks.
	 */
	private int alignment = 0;

	public static final String LEADING_ASTERISK_NOT_ALIGNED = "leading.asterisk.misaligned";

	@Override
	public boolean isCommentNodesRequired() {
		return true;
	}

	@Override
	public int[] getDefaultTokens() {
		return getAcceptableTokens();
	}

	@Override
	public int[] getAcceptableTokens() {
		return new int[] { TokenTypes.BLOCK_COMMENT_BEGIN, TokenTypes.BLOCK_COMMENT_END };
	}

	@Override
	public final int[] getRequiredTokens() {
		return new int[] { TokenTypes.BLOCK_COMMENT_BEGIN };
	}

	@Override
	public void visitToken(DetailAST ast) {

		if (ast.getType() == TokenTypes.BLOCK_COMMENT_BEGIN) {
			checkRegularCommentBlock(ast);
		}
	}

	/**
	 * @param blockBegin The beginning token of the comment block.
	 */
	public void checkRegularCommentBlock(DetailAST blockBegin) {
		final FileContents contents = getFileContents();

		int currentLineNum = blockBegin.getLineNo();
		int endLineNum = blockBegin.getLastChild().getLineNo();

		boolean leadingAsteriskAligned = true;

		String lineContents = contents.getLine(currentLineNum);

		// Get the offset of the leading asterisk for the fist line in block comment.
		int offset = lineContents.indexOf('*');

		// Compare the offset of the leading asterisk for every other line in the block
		// comment
		while (currentLineNum <= endLineNum) {
			currentLineNum++;

			lineContents = contents.getLine(currentLineNum);

			if (lineContents.indexOf('*') != (offset + alignment)) {
				log(currentLineNum, LEADING_ASTERISK_NOT_ALIGNED);
			}
		}
	}

	/**
	 * @param align What offset the alignment should have.
	 */
	public void setAlignment(int align) {

		if (align >= -1 && align <= 1) {
			alignment = align;
		} else {
			alignment = 0;
		}
	}

}