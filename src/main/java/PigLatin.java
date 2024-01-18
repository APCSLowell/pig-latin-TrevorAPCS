import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
    public int findFirstVowel(String sWord) {
        //precondition: sWord is a valid String of length greater than 0.
        //postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
	    // your code goes here
	for(int i = 0; i < sWord.length(); i++){
          char c = sWord.charAt(i);
          if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return i;
          }
        }
        return -1;
    }

    public String pigLatin(String sSentence) {
        //precondition: sWord is a valid String of length greater than 0
        //postcondition: returns the pig latin equivalent of sWord
        // more code should go here
	if(sSentence.substring(sSentence.length() - 1).equals(".") == false){
        	sSentence += " ";
      	}
      	String sentence = "";
      	int wordCount = 1;
      	int wordLength = 0;
      	for(int i = 0; i < sSentence.length(); i++){
        	String end = sSentence.substring(i, i + 1);
        	if(end.equals(" ") || end.equals(".") || end.equals(",")){
            		wordCount++;
            		String word = new String("");
            		String sWord = sSentence.substring(i - wordLength, i);
            		int firstVowelNum = findFirstVowel(sWord);
            		if(sWord.length() == 0){
              			word = "";
            		}
            		else if(sWord.length() >= 2 && sWord.substring(0, 2).equals("qu")){
              			word = sWord.substring(2, sWord.length()) + sWord.substring(0, 2) + "ay";
            		}
            		else if(firstVowelNum == -1) {
              			word = sWord + "ay";
            		}
            		else if(firstVowelNum == 0){
              			word = sWord + "way";
            		}
            		else {
              			word = sWord.substring(firstVowelNum, sWord.length()) + sWord.substring(0, firstVowelNum) + "ay";
            		}
            		sentence += word + end;
           		if(i == sSentence.length() - 1 && sentence.substring(sentence.length()-1) == " "){
              			sentence = sentence.substring(0, sentence.length() - 1);
            		}
            		wordLength = 0;
        	}
        	else{
          		wordLength++;
        	}
      	}
      	return sentence;
    }
}//end PigLatin class
