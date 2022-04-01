package com.jetbrains.gettext.lang;

import com.jetbrains.gettext.GetTextCompositeElementTypes;
import consulo.language.ast.IElementType;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class MsgctxtCommand extends MsgCommand {
  public MsgctxtCommand() {
  }

  @Override
  public IElementType getCompositeElement() {
    return GetTextCompositeElementTypes.MSGCTXT;
  }

  @Override
  public String getName() {
    return "msgctxt";
  }
}
