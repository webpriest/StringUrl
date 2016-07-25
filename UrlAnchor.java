import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

/**
 * UrlAnchor.java
 * Purpose: to accept user input with string containing URLs, and format the URLs with anchor tags
 * @author Theophilus Aika
 * @version 1.0 25/07/2016
 * */

public class UrlAnchor {
	private static Scanner inputTxt= new Scanner(System.in);
	
    public static void main(String[] args) {
    	// Accept User input
        System.out.println("Please enter a string containing at least a URL ");
        String originalString = inputTxt.nextLine();
        
        // Output result after passing string through getURL method
        System.out.println(getURL(originalString));
    }
    
    // Method to identify URL pattern and append anchor tags
    public static String getURL(String stringTxt) {
    	Pattern getPattern = Pattern.compile("(?i)\\b((?:https?://|www\\d{0,3}[.]|[a-z0-9.\\-]+[.][a-z]{2,4}/)(?:[^\\s()<>]+|\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\))+(?:\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\)|[^\\s`!()\\[\\]{};:\'\".,<>???“”‘’]))");
        Matcher match = getPattern.matcher(stringTxt); 
       
        if(match.find()){
            if (match.group(1).startsWith("http://")){
                return match.replaceAll("<a href=\"$1\">$1</a>");
            }else{
                return match.replaceAll("<a href=\"http://$1\">$1</a>");
            }   
        }else{
        	// Return formatted string
            return stringTxt;
        }
    }
}