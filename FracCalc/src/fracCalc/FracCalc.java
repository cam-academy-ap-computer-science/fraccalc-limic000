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
        Scanner console = new Scanner(System.in);		/*creates new scanner*/
        boolean stop = false;							/*creates new boolean*/
        while (stop == false) {							/*while loop that continues until stop == true*/
        	String num_1 = console.nextLine();			/*stores input value in string*/
        	String final_num = produceAnswer(num_1);	/*calls the function with input value as actual parameter*/
        	if (num_1.equals("quit")) {					/*makes stop = true if the input says "quit"*/
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
    	String operand = "";
    	for (int i = 0; i<=input.length(); i++) {
    		while (input.charAt(i) != '*' && input.charAt(i) != '/' && input.charAt(i) != '+' && input.charAt(i) != '-') {
    			operand += input.charAt(i);
    			System.out.println(operand);   			
    		}
    	}
        return "";
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
