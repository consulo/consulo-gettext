package com.jetbrains.gettext;

import javax.annotation.Nonnull;

import com.intellij.openapi.fileTypes.LanguageFileType;
import consulo.ui.image.Image;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class GetTextFileType  extends LanguageFileType {
  public static final GetTextFileType INSTANCE = new GetTextFileType();

  private GetTextFileType() {
    super(GetTextLanguage.INSTANCE);
  }

  @Nonnull
  public String getId() {
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
  public Image getIcon() {
    return GetTextIcons.FILETYPE_ICON;
  }
}


