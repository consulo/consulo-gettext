package com.jetbrains.gettext.parser;

import javax.annotation.Nonnull;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.IStubFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.jetbrains.gettext.GetTextCompositeElementType;
import com.jetbrains.gettext.GetTextFile;
import com.jetbrains.gettext.GetTextLanguage;
import com.jetbrains.gettext.GetTextLexer;
import com.jetbrains.gettext.GetTextTokenTypes;
import consulo.lang.LanguageVersion;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class GetTextParserDefinition implements ParserDefinition {
  private static final TokenSet WHITE_SPACE = TokenSet.create(GetTextTokenTypes.WHITE_SPACE);
  private static final TokenSet COMMENT = TokenSet.create(GetTextTokenTypes.COMMENT, GetTextTokenTypes.COMMENT_SYMBOLS);

  @Nonnull
  public Lexer createLexer(LanguageVersion languageVersion) {
    return new GetTextLexer();
  }

  public PsiParser createParser(LanguageVersion languageVersion) {
    return new GetTextParser();
  }

  public IFileElementType getFileNodeType() {
    return new IStubFileElementType(GetTextLanguage.INSTANCE);
  }

  @Nonnull
  public TokenSet getWhitespaceTokens(LanguageVersion languageVersion) {
    return WHITE_SPACE;
  }

  @Nonnull
  public TokenSet getCommentTokens(LanguageVersion languageVersion) {
    return COMMENT;
  }

  @Nonnull
  public TokenSet getStringLiteralElements(LanguageVersion languageVersion) {
    return GetTextTokenTypes.STRING_LITERALS;
  }

  @Nonnull
  public PsiElement createElement(ASTNode node) {
    final IElementType type = node.getElementType();
    if (type instanceof GetTextCompositeElementType) {
      return GetTextCompositeElementType.createPsiElement(node);
    }
    throw new AssertionError("Unknown type: " + type);
  }

  public PsiFile createFile(FileViewProvider viewProvider) {
    return new GetTextFile(viewProvider);
  }

  public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
    return SpaceRequirements.MAY;
  }
}

