package com.jetbrains.gettext;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import javax.annotation.Nonnull;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class GetTextFile extends PsiFileBase {
  public GetTextFile (FileViewProvider viewProvider) {
    super(viewProvider, GetTextLanguage.INSTANCE);
  }

  @Nonnull
  public FileType getFileType() {
    return GetTextFileType.INSTANCE;
  }

  @Override
  public String toString() {
    return "GNU GetText File";
  }
}

