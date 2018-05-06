package com.jetbrains.gettext;

import javax.annotation.Nonnull;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.tree.ICompositeElementType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class GetTextCompositeElementType extends IElementType implements ICompositeElementType {
  public GetTextCompositeElementType(@Nonnull @NonNls final String debugName) {
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