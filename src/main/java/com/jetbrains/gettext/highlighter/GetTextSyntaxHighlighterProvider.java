package com.jetbrains.gettext.highlighter;

import com.jetbrains.gettext.GetTextFileType;
import consulo.annotation.component.ExtensionImpl;
import consulo.language.editor.highlight.SyntaxHighlighter;
import consulo.language.editor.highlight.SyntaxHighlighterProvider;
import consulo.project.Project;
import consulo.virtualFileSystem.VirtualFile;
import consulo.virtualFileSystem.fileType.FileType;

import jakarta.annotation.Nullable;

/**
 * @author VISTALL
 * @since 02-Jul-22
 */
@ExtensionImpl
public class GetTextSyntaxHighlighterProvider implements SyntaxHighlighterProvider
{
	@Nullable
	@Override
	public SyntaxHighlighter create(FileType fileType, @Nullable Project project, @Nullable VirtualFile virtualFile)
	{
		if(fileType == GetTextFileType.INSTANCE)
		{
			return new GetTextSyntaxHighlighter();
		}
		return null;
	}
}
