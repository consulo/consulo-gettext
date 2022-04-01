package com.jetbrains.gettext;

import consulo.language.file.LanguageFileType;
import consulo.localize.LocalizeValue;
import consulo.ui.image.Image;

import javax.annotation.Nonnull;

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
  public LocalizeValue getDescription() {
    return LocalizeValue.localizeTODO("GNU GetText");
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


