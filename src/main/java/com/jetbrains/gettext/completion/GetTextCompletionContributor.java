package com.jetbrains.gettext.completion;

import com.jetbrains.gettext.GetTextLanguage;
import com.jetbrains.gettext.GetTextTokenTypes;
import com.jetbrains.gettext.lang.GetTextFlags;
import consulo.language.Language;
import consulo.language.editor.completion.*;
import consulo.language.editor.completion.lookup.LookupElementBuilder;
import consulo.language.psi.PsiElement;
import consulo.language.psi.PsiWhiteSpace;
import consulo.language.util.ProcessingContext;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

import static consulo.language.pattern.PlatformPatterns.psiElement;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class GetTextCompletionContributor extends CompletionContributor
{
	private final static String[] KEYWORDS = {
			"msgid",
			"msgstr",
			"msgctxt",
			"msgid_plural"
	};

	private final static List<LookupElementBuilder> KEYWORD_LOOKUPS = new ArrayList<LookupElementBuilder>();
	private final static List<LookupElementBuilder> FLAGS_LOOKUPS = new ArrayList<LookupElementBuilder>();

	static
	{
		for(String keyword : KEYWORDS)
		{
			KEYWORD_LOOKUPS.add(LookupElementBuilder.create(keyword));
		}
		for(String flag : GetTextFlags.getAlFlags())
		{
			FLAGS_LOOKUPS.add(LookupElementBuilder.create(flag));
		}
	}

	public GetTextCompletionContributor()
	{
		extend(CompletionType.BASIC, psiElement().withParent(psiElement().withLanguage(GetTextLanguage.INSTANCE)), new GetTextKeywordCompletionContributor());
	}

	private static class GetTextKeywordCompletionContributor implements CompletionProvider
	{
		@Override
		public void addCompletions(@Nonnull CompletionParameters parameters, ProcessingContext context, @Nonnull CompletionResultSet result)
		{
			final PsiElement currElement = parameters.getPosition().getOriginalElement();
			PsiElement prevElement = currElement.getPrevSibling();

			if(currElement.getNode().getElementType() == GetTextTokenTypes.COMMAND || prevElement instanceof PsiWhiteSpace)
			{
				for(LookupElementBuilder builder : KEYWORD_LOOKUPS)
				{
					result.addElement(builder);
				}
				result.stopHere();
				return;
			}

			if(prevElement != null && GetTextTokenTypes.FLAG_LINE.contains(prevElement.getNode().getElementType()))
			{
				for(LookupElementBuilder builder : FLAGS_LOOKUPS)
				{
					result.addElement(builder);
				}
				result.stopHere();
			}
		}
	}

	@Nonnull
	@Override
	public Language getLanguage()
	{
		return GetTextLanguage.INSTANCE;
	}
}
