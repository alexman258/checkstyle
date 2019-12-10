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
import com.puppycrawl.tools.checkstyle.api.JavadocTokenTypes;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;
//import com.puppycrawl.tools.checkstyle.api.AbstractCheck.FileContext;
import com.puppycrawl.tools.checkstyle.utils.CommonUtil;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * <p>
 * Leading Asterisk {@code LeadingAsteriskAlignCheck} checks that every 
 * multi-line comment leading asterisk is vertically aligned.  
 * 
 * Javadoc comments have a LeadingAsterisk token that can be compared with the
 * leading asterisk token of every other line in the comment.
 * 
 * Regular block comments do not contain a leading asterisk token. 
 * The leading asterisk is found programmatically and compared with
 * other leading asterisks in the comment block.
 * 
 * </p>
 */
public class LeadingAsteriskAlignCheck extends AbstractCheck {

	/**
	* Ok, left
	* 
	*/
	
	/**
	 * Ok, center
	 * 
	 */
	
	/**
	  * Ok, left
	  * 
	  */
	

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
		return new int[] {TokenTypes.BLOCK_COMMENT_BEGIN, TokenTypes.BLOCK_COMMENT_END};
	}

	@Override
	public final int[] getRequiredTokens() {
		return new int[] {TokenTypes.BLOCK_COMMENT_BEGIN, TokenTypes.BLOCK_COMMENT_END};
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		
		if(ast.getType() == TokenTypes.BLOCK_COMMENT_BEGIN) {
			
			DetailAST firstChild = ast.getFirstChild();
			
			if (firstChild == null) {
				return;
			}
			
			DetailAST secondChild = firstChild.getFirstChild();
			
			if (secondChild.getType() == JavadocTokenTypes.JAVADOC) {
				checkJavadocCommentBlock(ast, ast.getLastChild());
			} else {
				checkRegularCommentBlock(ast, ast.getLastChild());
			}
		}
		
	}
	
	
	/**
	 * 
	 * @param blockBegin The beginning token of the comment block.
	 * @param blockEnd The end token of the comment block
	 */		
	public void checkRegularCommentBlock(DetailAST blockBegin, DetailAST blockEnd) {
		
	}
	
	
	/**
	 * 
	 * @param blockBegin The beginning token of the comment block.
	 * @param blockEnd The end token of the comment block
	 */		  
	public void checkJavadocCommentBlock(DetailAST blockBegin, DetailAST blockEnd) {
		
	}

}