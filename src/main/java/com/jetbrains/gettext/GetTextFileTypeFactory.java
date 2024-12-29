package com.jetbrains.gettext;

import consulo.annotation.component.ExtensionImpl;
import consulo.virtualFileSystem.fileType.FileTypeConsumer;
import consulo.virtualFileSystem.fileType.FileTypeFactory;

import jakarta.annotation.Nonnull;

/**
 * @author Svetlana.Zemlyanskaya
 */
@ExtensionImpl
public class GetTextFileTypeFactory extends FileTypeFactory
{
	public void createFileTypes(@Nonnull FileTypeConsumer consumer)
	{
		consumer.consume(GetTextFileType.INSTANCE, GetTextFileType.INSTANCE.getDefaultExtension());
	}
}
