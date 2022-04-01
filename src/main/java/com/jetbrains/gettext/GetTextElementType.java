package com.jetbrains.gettext;

import consulo.language.ast.IElementType;
import org.jetbrains.annotations.NonNls;

import javax.annotation.Nonnull;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class GetTextElementType extends IElementType {
  public GetTextElementType(@Nonnull String debugName) {
    super(debugName, GetTextLanguage.INSTANCE);
  }
}
