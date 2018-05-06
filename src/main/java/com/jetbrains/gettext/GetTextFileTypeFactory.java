package com.jetbrains.gettext;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import javax.annotation.Nonnull;

/**
 * @author Svetlana.Zemlyanskaya
 */
public class GetTextFileTypeFactory extends FileTypeFactory {
  public void createFileTypes(@Nonnull FileTypeConsumer consumer) {
    consumer.consume(GetTextFileType.INSTANCE, GetTextFileType.INSTANCE.getDefaultExtension());
  }
}
