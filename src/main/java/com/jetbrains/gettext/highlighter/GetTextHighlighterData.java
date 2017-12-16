package com.jetbrains.gettext.highlighter;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class GetTextHighlighterData
{
	public static final String COMMENT_ID = "GET_TEXT_COMMENT";
	public static final TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey(COMMENT_ID, DefaultLanguageHighlighterColors.LINE_COMMENT);

	public static final String KEYWORD_ID = "GET_TEXT_KEYWORD";
	public static final TextAttributesKey KEYWORD = TextAttributesKey.createTextAttributesKey(KEYWORD_ID, DefaultLanguageHighlighterColors.KEYWORD);

	public static final String STRING_ID = "GET_TEXT_STRING";
	public static final TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey(STRING_ID, DefaultLanguageHighlighterColors.STRING);

	public static final String FLAG_ID = "GET_TEXT_FLAG";
	public static final TextAttributesKey FLAG = TextAttributesKey.createTextAttributesKey(FLAG_ID, DefaultLanguageHighlighterColors.DOC_COMMENT_TAG);

	public static final String NUMBER_ID = "GET_TEXT_TRANSLATED_NUMBER";
	public static final TextAttributesKey NUMBER = TextAttributesKey.createTextAttributesKey(NUMBER_ID, DefaultLanguageHighlighterColors.NUMBER);

	public static final String BRACES_ID = "GET_TEXT_BRACES";
	public static final TextAttributesKey BRACES = TextAttributesKey.createTextAttributesKey(BRACES_ID, DefaultLanguageHighlighterColors.BRACES);

	public static final String DOTS_ID = "GET_TEXT_DOTS";
	public static final TextAttributesKey DOTS = TextAttributesKey.createTextAttributesKey(DOTS_ID, DefaultLanguageHighlighterColors.DOT);
}
