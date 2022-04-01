package com.jetbrains.gettext.parser;

import com.jetbrains.gettext.*;
import consulo.language.ast.ASTNode;
import consulo.language.ast.IElementType;
import consulo.language.ast.IFileElementType;
import consulo.language.ast.TokenSet;
import consulo.language.file.FileViewProvider;
import consulo.language.lexer.Lexer;
import consulo.language.parser.ParserDefinition;
import consulo.language.parser.PsiParser;
import consulo.language.psi.PsiElement;
import consulo.language.psi.PsiFile;
import consulo.language.psi.stub.IStubFileElementType;
import consulo.language.version.LanguageVersion;

import javax.annotation.Nonnull;


/**
 * @author Svetlana.Zemlyanskaya
 */
public class GetTextParserDefinition implements ParserDefinition {
  private static final TokenSet WHITE_SPACE = TokenSet.create(GetTextTokenTypes.WHITE_SPACE);
  private static final TokenSet COMMENT = TokenSet.create(GetTextTokenTypes.COMMENT, GetTextTokenTypes.COMMENT_SYMBOLS);

  @Nonnull
  public Lexer createLexer(LanguageVersion languageVersion) {
    return new _GetTextLexer();
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

