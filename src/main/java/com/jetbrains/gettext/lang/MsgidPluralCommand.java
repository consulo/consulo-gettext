package com.jetbrains.gettext.lang;

import com.jetbrains.gettext.GetTextCompositeElementTypes;
import consulo.language.ast.IElementType;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class MsgidPluralCommand extends MsgCommand {
  public MsgidPluralCommand() {
  }
  @Override
  public IElementType getCompositeElement() {
    return GetTextCompositeElementTypes.MSGID_PLURAL;
  }

  @Override
  public String getName() {
    return "msgid_plural";
  }
}
