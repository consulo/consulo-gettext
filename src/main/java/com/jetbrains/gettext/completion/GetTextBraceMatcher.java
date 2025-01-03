/*
 * Copyright 2000-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jetbrains.gettext.completion;

import com.jetbrains.gettext.GetTextLanguage;
import com.jetbrains.gettext.GetTextTokenTypes;
import consulo.annotation.component.ExtensionImpl;
import consulo.language.BracePair;
import consulo.language.Language;
import consulo.language.PairedBraceMatcher;
import consulo.language.ast.IElementType;
import consulo.language.psi.PsiFile;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * @author Svetlana.Zemlyanskaya
 */
@ExtensionImpl
public class GetTextBraceMatcher implements PairedBraceMatcher
{
	private static final BracePair[] PAIRS = new BracePair[]{
			new BracePair(GetTextTokenTypes.LBRACE, GetTextTokenTypes.RBRACE, false)
	};

	public BracePair[] getPairs()
	{
		return PAIRS;
	}

	public boolean isPairedBracesAllowedBeforeType(@Nonnull final IElementType lbraceType, @Nullable final IElementType tokenType)
	{
		return true;
	}

	public int getCodeConstructStart(final PsiFile file, int openingBraceOffset)
	{
		return openingBraceOffset;
	}

	@Nonnull
	@Override
	public Language getLanguage()
	{
		return GetTextLanguage.INSTANCE;
	}
}
