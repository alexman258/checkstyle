package com.puppycrawl.tools.checkstyle.checks.blocks;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.puppycrawl.tools.checkstyle.AbstractModuleTestSupport;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import static com.puppycrawl.tools.checkstyle.checks.blocks.LeadingAsteriskAlignCheck.LEADING_ASTERISK_NOT_ALIGNED;

public class LeadingAsteriskAlignCheckTest extends AbstractModuleTestSupport {
	
	@Override
	protected String getPackageLocation() {
		return "com/puppycrawl/tools/checkstyle/checks/blocks/leadingasteriskalign";
	}
	
	@Test
	public void testLeadingAsteriskAlignGets() {
		LeadingAsteriskAlignCheck check = new LeadingAsteriskAlignCheck();
		int[] expectedRequired = {TokenTypes.BLOCK_COMMENT_BEGIN};
		int[] expectedOther = {TokenTypes.BLOCK_COMMENT_BEGIN, TokenTypes.BLOCK_COMMENT_END};
		
		assertArrayEquals(expectedRequired, check.getRequiredTokens());
		assertArrayEquals(expectedOther, check.getAcceptableTokens());
		assertArrayEquals(expectedOther, check.getDefaultTokens());
	}
	
	@Test
	public void testLeadingAsteriskAlignCheck() throws Exception {
		final DefaultConfiguration checkConfig = 
				createModuleConfig(LeadingAsteriskAlignCheck.class);
		final String[] expected = {
				"17: " + getCheckMessage(LEADING_ASTERISK_NOT_ALIGNED),
				"21: " + getCheckMessage(LEADING_ASTERISK_NOT_ALIGNED),
				"31: " + getCheckMessage(LEADING_ASTERISK_NOT_ALIGNED),
				"32: " + getCheckMessage(LEADING_ASTERISK_NOT_ALIGNED),
				"35: " + getCheckMessage(LEADING_ASTERISK_NOT_ALIGNED)
		};
		
		verify(checkConfig, getPath("LeadingAsteriskAlignTest.java"), expected);
	}

	

}
