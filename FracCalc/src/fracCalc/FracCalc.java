package fracCalc;
import java.util.*;

/*main
 * 	 - set boolean stop to false
 * 		 - if input equals string "quit", then set it to true
 * 	 - create a scanner
 * 	 - create a while loop that continues until the boolean stop is true
 * 		- takes a new input using scanner
 *	 	- call produceAnswer with it's input
 *	 	- print the answer returned from produceAnswer
 *
 *produceAnswer
 *	 - receives: a single line of input String
 *		 - breaks it all into three strings, each stored within a variable
 *			 - operand, operator, and second operand
 *		 - converts user value into whole numbers or mixed fractions (not improper)
 *	 - create an empty string called operand
 *		 - while charAt the input string does not equal +-* and /
 *			 - if index of "_" does not equal -1
 *	 	 	 	- while charAt the input string does not equal "_"
 *		 			- add the charAt that index to the whole number string
 *			 - else
 *			 	- add the charAt index to the operand string
 *	 - create another empty string called operator
 *		 - if charAt input string equals +-* or /
 *			 - add the charAt that index to operator
 *	 - create another empty string called second operand
 *		 - do the same thing as the previous operand thing
 *	 - check for border/special cases (multiplying by 0, negative negatives, divide by 0)
 *outputs: second operand 
 *	 - must be reduced (mixed fractions as needed)
 *
 *
 *
 *program must continue until user says quit, not when the equation is finished
 *
 * 
 */
public class FracCalc {

    public static void main(String[] args) 
    {
    	System.out.println("Please type your equation, or \"quit\" to quit");
        Scanner console = new Scanner(System.in);		/*creates new scanner*/
        boolean stop = false;							/*creates new boolean*/
        while (stop == false) {							/*while loop that continues until stop == true*/
        	String input = console.nextLine();			/*stores input value in string*/
        	String final_num = produceAnswer(input);	/*calls the function with input value as actual parameter*/
        	if (input.equals("quit")) {					/*makes stop = true if the input says "quit"*/
        		stop = true;
        	}
        }
        //System.out.println(final_num);

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) {
    	
    	//parsing into three different strings: frac1, operator, and frac2
    	String parsable_input = input;
    	String frac1 = parsable_input.substring(0,parsable_input.indexOf(" ")+1); //makes frac1 equal to the parsable_input up to the first space
    	parsable_input = input.substring(input.indexOf(" ")+1); //takes frac1 off of parsable_input
    	String operator = parsable_input.substring(0,parsable_input.indexOf(" ")+1); //makes operator equal to parsable_input up to the first space (actually second space of the original, but we cut that one off)
    	parsable_input = parsable_input.substring(parsable_input.indexOf(" ")+1); //takes operator off of parsable_input
    	String frac2 = parsable_input.substring(0, parsable_input.length()); //for now, it only takes two numbers, so frac2 is equal to all of the rest of parsable_input
    	
    	String whole_num1 = wholeFrac(frac1);		//parses frac1 further
    	String numerator1 = numerator(frac1);
    	String denominator1 = denominator(frac1);
    	
    	String whole_num2 = wholeFrac(frac2);		//parses frac2 further
    	String numerator2 = numerator(frac2);
    	String denominator2 = denominator(frac2);
    	
    	String checkpoint2 = "whole:" + whole_num2 + " numerator:" + numerator2 + " denominator:" + denominator2;
    	return checkpoint2;
    }
    
    //finds the whole number
    public static String wholeFrac (String input) {
    	String whole_num = "0";
    	if (input.indexOf("/") == -1) { //if there is no fraction, then the whole thing is the whole number
    		whole_num = input;
    	}
    	if (input.indexOf("_") != -1) { //if the fraction has an underscore, then it has a whole number before the fraction
    		whole_num = input.substring(0,input.indexOf("_"));
    		//whole_num = Integer.parseInt (whole);
    	}
    	return whole_num ;
    }
    
    
    //finds the numerator
    public static String numerator (String input) {
    	String numerator_num = "0";
    	if (input.indexOf("_") != -1) {							//whole number1 gets taken off string
    		input = input.substring(input.indexOf("_")+1);
    	}
    	if (input.indexOf("/") != -1) {
    		numerator_num = input.substring(0, input.indexOf("/"));
    		//numerator_num = Integer.parseInt(numerator);
    		//System.out.println(numerator_num);
    	}
    	return numerator_num;
    }
    
    //finds the denominator
    public static String denominator (String input) {
    	String denominator_num = "1";
    	if(input.indexOf("/") != -1) {
    		input = input.substring(input.indexOf("/")+1);
    		denominator_num = input;
    	}
    	return denominator_num;
    }
    
    
}
