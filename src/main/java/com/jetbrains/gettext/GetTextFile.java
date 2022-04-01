package com.jetbrains.gettext;

import consulo.language.file.FileViewProvider;
import consulo.language.impl.psi.PsiFileBase;
import consulo.virtualFileSystem.fileType.FileType;

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

