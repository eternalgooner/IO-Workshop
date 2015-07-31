import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class IOUtil {

	//this method will open a saved file & return a StringBuffer
	public static StringBuffer OpenFile() throws FileNotFoundException{
		StringBuffer fileContents = new StringBuffer();				//declare new stringbuffer object to hold the text
		JFileChooser chooser = new JFileChooser();					//declare new JFileChooser to give user option to open file
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");			//file types allowed to be opened
		
		chooser.setFileFilter(filter);
		chooser.showOpenDialog(null);								//display an open dialog for user to choose file
		
		File targetFile = chooser.getSelectedFile();				//assigns the selected file to a file
		Scanner scanner = new Scanner(targetFile);					//declares & instantiates our scanner object for reading the file
		while(scanner.hasNextLine())								//check if there is text in the file we're reading
			fileContents.append(scanner.nextLine() + "\r\n");		//takes next line of the text file & appends to our stringBuffer object
		scanner.close();											//close scanner as it keeps scanning until stopped - don't waste resources
		return new StringBuffer(fileContents);						//returns a stringbuffer which will contain text from the file
	}
	
	//this method will save a file passing a String as a parameter
	public static void saveFile(String targetData) throws IOException{
		JFileChooser chooser = new JFileChooser();					//declare jfilechooser to let user choose file
		chooser.showSaveDialog(null);								//shows save dialog box for user to choose save location
		String fileName = chooser.getSelectedFile().toString();		//takes file and converts it to string
		if(!fileName.endsWith(".txt"))fileName += ".txt";			//if filename doesn't end in .txt, add .txt to filename
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(fileName));		//creates writer object
		bWriter.write(targetData);									//writes the string passed in as an argument to the file we specified earlier
		bWriter.close();											//close writer - don't waster resources
	}
}
