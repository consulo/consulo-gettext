package com.jetbrains.gettext;

import consulo.language.Language;
import consulo.language.ast.ASTNode;
import consulo.language.impl.psi.ASTWrapperPsiElement;

import jakarta.annotation.Nonnull;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class GetTextCompositeElement extends ASTWrapperPsiElement {
  public GetTextCompositeElement(@Nonnull ASTNode node) {
    super(node);
  }

  @Nonnull
  public Language getLanguage() {
    return GetTextLanguage.INSTANCE;
  }
}