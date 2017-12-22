package main;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class FileLoader
{
	private ClassLoader fileLoader;

	public FileLoader()
	{
		fileLoader = this.getClass().getClassLoader();
	}

	public String getFileContents(String fileName)
	{
		InputStream fileStream = fileLoader.getResourceAsStream(fileName);

		if(fileStream == null)
		{
			return "";
		}

		StringBuilder fileContents = new StringBuilder();
		Scanner fileScanner = new Scanner(fileStream);

		while(fileScanner.hasNextLine())
		{
			fileContents.append(fileScanner.nextLine());
			fileContents.append('\n');
		}

		return fileContents.toString();
	}
}
