package com.jetbrains.gettext.highlighter;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.jetbrains.gettext.GetTextTokenTypes;
import com.jetbrains.gettext._GetTextLexer;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class GetTextSyntaxHighlighter extends SyntaxHighlighterBase {
  private static final Map<IElementType, TextAttributesKey> keys1;

  public GetTextSyntaxHighlighter() {
  }

  @Nonnull
  public Lexer getHighlightingLexer() {
    return new _GetTextLexer();
  }

  static {
    keys1 = new HashMap<IElementType, TextAttributesKey>();

    fillMap(keys1, GetTextTokenTypes.FLAGS, GetTextHighlighterData.FLAG);
    fillMap(keys1, GetTextTokenTypes.COMMENTS, GetTextHighlighterData.COMMENT);
    fillMap(keys1, GetTextTokenTypes.KEYWORDS, GetTextHighlighterData.KEYWORD);
    fillMap(keys1, GetTextTokenTypes.STRING_LITERALS, GetTextHighlighterData.STRING);
    fillMap(keys1, GetTextTokenTypes.BRACES, GetTextHighlighterData.BRACES);
    fillMap(keys1, GetTextTokenTypes.NUMBERS, GetTextHighlighterData.NUMBER);
    keys1.put(GetTextTokenTypes.DOTS, GetTextHighlighterData.DOTS);
    keys1.put(GetTextTokenTypes.BAD_CHARACTER, GetTextHighlighterData.KEYWORD);

  }

  @Nonnull
  public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
    return pack(keys1.get(tokenType));
  }
}