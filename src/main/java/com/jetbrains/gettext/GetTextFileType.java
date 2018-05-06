package com.jetbrains.gettext;

import com.intellij.openapi.fileTypes.LanguageFileType;
import javax.annotation.Nonnull;

import javax.swing.*;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class GetTextFileType  extends LanguageFileType {
  public static final GetTextFileType INSTANCE = new GetTextFileType();

  private GetTextFileType() {
    super(GetTextLanguage.INSTANCE);
  }

  @Nonnull
  public String getName() {
    return "GetText";
  }

  @Nonnull
  public String getDescription() {
    return "GNU GetText";
  }

  @Nonnull
  public String getDefaultExtension() {
    return "po";
  }

  @Override
  public Icon getIcon() {
    return GetTextIcons.FILETYPE_ICON;
  }
}


