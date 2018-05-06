package com.jetbrains.gettext;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import javax.annotation.Nonnull;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class GetTextElementType extends IElementType {
  public GetTextElementType(@Nonnull @NonNls String debugName) {
    super(debugName, GetTextLanguage.INSTANCE);
  }
}
