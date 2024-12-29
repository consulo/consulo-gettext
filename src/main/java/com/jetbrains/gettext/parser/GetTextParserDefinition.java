package com.jetbrains.gettext.parser;

import com.jetbrains.gettext.*;
import consulo.annotation.component.ExtensionImpl;
import consulo.language.Language;
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

import jakarta.annotation.Nonnull;


/**
 * @author Svetlana.Zemlyanskaya
 */
@ExtensionImpl
public class GetTextParserDefinition implements ParserDefinition
{
	private static final TokenSet WHITE_SPACE = TokenSet.create(GetTextTokenTypes.WHITE_SPACE);
	private static final TokenSet COMMENT = TokenSet.create(GetTextTokenTypes.COMMENT, GetTextTokenTypes.COMMENT_SYMBOLS);

	@Nonnull
	@Override
	public Language getLanguage()
	{
		return GetTextLanguage.INSTANCE;
	}

	@Nonnull
	public Lexer createLexer(@Nonnull LanguageVersion languageVersion)
	{
		return new _GetTextLexer();
	}

	@Nonnull
	public PsiParser createParser(@Nonnull LanguageVersion languageVersion)
	{
		return new GetTextParser();
	}

	@Nonnull
	public IFileElementType getFileNodeType()
	{
		return new IStubFileElementType(GetTextLanguage.INSTANCE);
	}

	@Nonnull
	public TokenSet getWhitespaceTokens(@Nonnull LanguageVersion languageVersion)
	{
		return WHITE_SPACE;
	}

	@Nonnull
	public TokenSet getCommentTokens(@Nonnull LanguageVersion languageVersion)
	{
		return COMMENT;
	}

	@Nonnull
	public TokenSet getStringLiteralElements(@Nonnull LanguageVersion languageVersion)
	{
		return GetTextTokenTypes.STRING_LITERALS;
	}

	@Nonnull
	public PsiElement createElement(ASTNode node)
	{
		final IElementType type = node.getElementType();
		if(type instanceof GetTextCompositeElementType)
		{
			return GetTextCompositeElementType.createPsiElement(node);
		}
		throw new AssertionError("Unknown type: " + type);
	}

	@Nonnull
	public PsiFile createFile(@Nonnull FileViewProvider viewProvider)
	{
		return new GetTextFile(viewProvider);
	}

	@Nonnull
	public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right)
	{
		return SpaceRequirements.MAY;
	}
}

