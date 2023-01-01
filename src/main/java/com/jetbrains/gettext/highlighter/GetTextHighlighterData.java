package com.jetbrains.gettext.highlighter;

import consulo.codeEditor.DefaultLanguageHighlighterColors;
import consulo.colorScheme.TextAttributesKey;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class GetTextHighlighterData
{
	public static final TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey("GET_TEXT_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);

	public static final TextAttributesKey KEYWORD = TextAttributesKey.createTextAttributesKey("GET_TEXT_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

	public static final TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey("GET_TEXT_STRING", DefaultLanguageHighlighterColors.STRING);

	public static final TextAttributesKey FLAG = TextAttributesKey.createTextAttributesKey("GET_TEXT_FLAG", DefaultLanguageHighlighterColors.DOC_COMMENT_TAG);

	public static final TextAttributesKey NUMBER = TextAttributesKey.createTextAttributesKey("GET_TEXT_TRANSLATED_NUMBER", DefaultLanguageHighlighterColors.NUMBER);

	public static final TextAttributesKey BRACES = TextAttributesKey.createTextAttributesKey("GET_TEXT_BRACES", DefaultLanguageHighlighterColors.BRACES);

	public static final TextAttributesKey DOTS = TextAttributesKey.createTextAttributesKey("GET_TEXT_DOTS", DefaultLanguageHighlighterColors.DOT);
}
