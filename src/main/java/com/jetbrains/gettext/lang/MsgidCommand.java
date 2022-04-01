package com.jetbrains.gettext.lang;

import com.jetbrains.gettext.GetTextCompositeElementTypes;
import consulo.language.ast.IElementType;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class MsgidCommand extends MsgCommand {

  public MsgidCommand() {
  }

  @Override
  public IElementType getCompositeElement() {
    return GetTextCompositeElementTypes.MSGID;
  }

  @Override
  public boolean isNecessary() {
    return true;
  }

  @Override
  public String getName() {
    return "msgid";
  }
}
