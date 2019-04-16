import java.util.*;
import java.io.File; 
import java.io.FileNotFoundException;

public class SpellBound{
	
	public static void main(String[] args){
		
		
		ArrayList<String> vocabFileLines = readVocabFile("beginners vocab list.txt");
		ArrayList<Word> wordQueue = parseLines(vocabFileLines,";");
		
		
		
		for (Word element : wordQueue){
			
			System.out.println("Definition: " + element.showDefinition());
			
			Scanner userInput = new Scanner(System.in);
			
			String userAttempt = userInput.nextLine();
			
			if (userAttempt.equals(element.showWord())){
				
				System.out.println("Correct!");
			}
			
			else{
				
				System.out.println("Wrong.");
			}
			
		}
	}
	
	//A method that reads a txt file and puts each line in an Array List.
	//Input: filename
	//Output: Array List where each entry is one line of the text file
	public static ArrayList<String> readVocabFile(String filename){
		
		ArrayList<String> arrayOfLines = new ArrayList<>();
		int numberOfLines = 0;
		
		try{
			File vocabListFileName = new File(filename);
			Scanner vocabList = new Scanner(vocabListFileName);
			
		
			while (vocabList.hasNext()){
				
				arrayOfLines.add(vocabList.nextLine());
				numberOfLines++;
			}
			
		}
		catch(FileNotFoundException ex){
			
			System.out.println("File not found");
			System.exit(1);
		}
		
		return arrayOfLines;
	}
	
	public static ArrayList<Word> parseLines(ArrayList<String> arrayOfLines, String delimiter){
		
		ArrayList<Word> wordQueue = new ArrayList<>();
		
		for (String line : arrayOfLines){
			
			String[] splitArray = line.split(delimiter,2);
			Word word1 = new Word(splitArray[0], splitArray[1]);
			
			wordQueue.add(word1);
			
		}
		
		return wordQueue;
	}
	
}
	
	
	
	

//Create Word class
class Word{
	
	String word;
	String definition;
	
	Word(String vocabWord, String vocabWordDefinition){
		
		int length = vocabWord.length();
		
		private word = vocabWord;
		private definition = vocabWordDefinition;
		
	}
	
	String showWord(){
		
		return word;
	
	}
	
	String showDefinition(){
		
		return definition;
	}
	
}

