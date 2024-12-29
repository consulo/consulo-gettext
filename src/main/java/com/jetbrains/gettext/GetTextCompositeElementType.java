package com.jetbrains.gettext;

import consulo.language.ast.ASTNode;
import consulo.language.ast.ICompositeElementType;
import consulo.language.ast.IElementType;
import consulo.language.impl.ast.CompositeElement;
import consulo.language.psi.PsiElement;
import org.jetbrains.annotations.NonNls;

import jakarta.annotation.Nonnull;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class GetTextCompositeElementType extends IElementType implements ICompositeElementType {
  public GetTextCompositeElementType(@Nonnull final String debugName) {
    super(debugName, GetTextLanguage.INSTANCE);
  }

  public static PsiElement createPsiElement(ASTNode node) {
    return new GetTextCompositeElement(node);
  }

  @Nonnull
  public ASTNode createCompositeNode() {
    return new CompositeElement(this);
  }
}