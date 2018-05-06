package com.jetbrains.gettext;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import javax.annotation.Nonnull;

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

  @Nonnull
  @SuppressWarnings({ "ConstantConditions", "EmptyMethod" })
  public ASTNode getNode() {
    return super.getNode();
  }

  public String toString() {
    return getNode().getElementType().toString();
  }
}