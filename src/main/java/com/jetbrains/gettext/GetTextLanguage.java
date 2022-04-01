package com.jetbrains.gettext;

import consulo.language.Language;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class GetTextLanguage extends Language {
  public static GetTextLanguage INSTANCE = new GetTextLanguage();

  private GetTextLanguage() {
    super("GetText");
  }
}