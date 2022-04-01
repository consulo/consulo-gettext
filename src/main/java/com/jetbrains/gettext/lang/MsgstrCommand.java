package com.jetbrains.gettext.lang;

import com.jetbrains.gettext.GetTextCompositeElementTypes;
import com.jetbrains.gettext.GetTextTokenTypes;
import consulo.language.ast.IElementType;
import consulo.language.parser.PsiBuilder;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class MsgstrCommand extends MsgCommand {

  public MsgstrCommand() {
  }

  @Override
  public IElementType getCompositeElement() {
    return GetTextCompositeElementTypes.MSGSTR;
  }

  @Override
  public boolean parse(PsiBuilder builder) {
    return super.parse(builder) || parseBraces(builder);
  }

  private boolean parseBraces(PsiBuilder builder) {
    if (builder.getTokenType() == GetTextTokenTypes.LBRACE) {
      builder.advanceLexer();
      if (builder.getTokenType() == GetTextTokenTypes.NUMBER) {
        if (!checkNumber(builder)) {
          PsiBuilder.Marker marker = builder.mark();
          builder.advanceLexer();
          marker.error("Wrong number format");
        }
        else {
          builder.advanceLexer();
        }
        if (builder.getTokenType() == GetTextTokenTypes.RBRACE) {
          return super.parse(builder);
        }
      }
    }
    return false;
  }

  private static boolean checkNumber(PsiBuilder builder) {
    String number = builder.getTokenText();
    return number != null && !number.isEmpty() && !(number.charAt(0) == '0' && !number.equals("0"));
  }

  @Override
  public boolean isNecessary() {
    return true;
  }

  @Override
  public boolean isMultiple() {
    return true;
  }

  @Override
  public String getName() {
    return "msgstr";
  }
}
