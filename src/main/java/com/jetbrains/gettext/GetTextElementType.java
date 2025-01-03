package com.jetbrains.gettext;

import consulo.language.ast.IElementType;

import jakarta.annotation.Nonnull;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class GetTextElementType extends IElementType {
  public GetTextElementType(@Nonnull String debugName) {
    super(debugName, GetTextLanguage.INSTANCE);
  }
}
