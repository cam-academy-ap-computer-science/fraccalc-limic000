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
        String input = console.nextLine();			/*stores input value in string*/
        while (stop == false) {							/*while loop that continues until stop == true*/
        	String final_answer = produceAnswer(input);	/*calls the function with input value as actual parameter*/
        	System.out.println(final_answer);
        	System.out.println("Please type your equation, or \"quit\" to quit");
        	input = console.nextLine();
        	if (input.equals("quit")) {					/*makes stop = true if the input says "quit"*/
        		stop = true;
        	}
        }

    }

    public static String produceAnswer(String input) {
    	
    	//parsing into three different strings: frac1, operator, and frac2
    	String parsable_input = input;
    	String frac1 = parsable_input.substring(0,parsable_input.indexOf(" ")); //makes frac1 equal to the parsable_input up to the first space
    	parsable_input = input.substring(input.indexOf(" ")+1); //takes frac1 off of parsable_input
    	String operator = parsable_input.substring(0,parsable_input.indexOf(" ")); //makes operator equal to parsable_input up to the first space (actually second space of the original, but we cut that one off)
    	parsable_input = parsable_input.substring(parsable_input.indexOf(" ")+1); //takes operator off of parsable_input
    	String frac2 = parsable_input.substring(0, parsable_input.length()); //for now, it only takes two numbers, so frac2 is equal to all of the rest of parsable_input
    	
    	//separates frac1 further
    	String whole_num1 = wholeFrac(frac1);		
    	String numerator1 = numerator(frac1);
    	String denominator1 = denominator(frac1);
    	
    	//separates frac2 further
    	String whole_num2 = wholeFrac(frac2);		
    	String numerator2 = numerator(frac2);
    	String denominator2 = denominator(frac2);
    	
    	//parses them all into numbers for later use
    	int w_num1 = Integer.parseInt(whole_num1);
    	int n_1 = Integer.parseInt(numerator1);
    	int d_1 = Integer.parseInt(denominator1);
    	int w_num2 = Integer.parseInt(whole_num2);
    	int n_2 = Integer.parseInt(numerator2);
    	int d_2 = Integer.parseInt(denominator2);
    	
    	String final_answer = "";
    	if (operator.equals("+")) {
    		final_answer = add_calc(w_num1, n_1, d_1, w_num2, n_2, d_2);
    	}
    	if (operator.equals("-")) {
    		final_answer = subtract_calc(w_num1, n_1, d_1, w_num2, n_2, d_2);
    	}
    	if (operator.equals("*")) {
    		final_answer = multiply_calc(w_num1, n_1, d_1, w_num2, n_2, d_2);
    	}
    	if (operator.equals("/")) {
    		final_answer = divide_calc(w_num1, n_1, d_1, w_num2, n_2, d_2);
    	}

    	return final_answer;
    }

	//finds the whole number
    public static String wholeFrac (String input) {
    	String whole_num = "0";
    	if (input.indexOf("/") == -1) { //if there is no fraction, then the whole thing is the whole number
    		whole_num = input;
    	}
    	if (input.indexOf("_") != -1) { //if the fraction has an underscore, then it has a whole number before the fraction
    		whole_num = input.substring(0,input.indexOf("_"));
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
    	}
    	return numerator_num;
    }
    
    //finds the denominator
    public static String denominator (String input) {
    	String denominator_num = "1";
    	if(input.indexOf("/") != -1) {
    		input = input.substring(input.indexOf("/")+1);
    		denominator_num = input.substring(0,input.indexOf("")+1);
    	}
    	return denominator_num;
    }
    
    
    //adding
    public static String add_calc(int w1, int n1, int d1, int w2, int n2, int d2) {
    	//makes it into a mixed fraction
    	int whole_num = 0;
    	int new_n1 = ((w1*d1) + n1) * d2;
    	int new_n2 = ((w2*d2) + n2) * d1;
    	int d_total = d1*d2;
    	int n_total = new_n1 + new_n2;
    	
    	whole_num = (int)(n_total/d_total); //gets the whole number
    	int remainder_numerator = n_total%d_total;
    	n_total = remainder_numerator; //makes the rest equal to the remaining numerator
    	
    	String final_answer = "";
    	
    	if (n_total == 0) { //if there's no fraction part
    		final_answer = Integer.toString(whole_num);
    		return final_answer;
    	}
    	if (whole_num == 0) { //if there's no whole number
    		final_answer = n_total + "/" + d_total;
    		return final_answer;
    	}
    	else {
    		final_answer = whole_num + "_" + n_total + "/" + d_total;
    		return final_answer;
    	}
    }
    
    
    //subtract
    public static String subtract_calc(int w1, int n1, int d1, int w2, int n2, int d2) {
    	//makes them into improper fractions
    	int whole_num = 0;
    	int new_n1 = ((w1*d1) + n1) * d2;
    	int new_n2 = ((w2*d2) + n2) * d1;
    	int d_total = d1*d2;
    	int n_total = new_n1 - new_n2;
    	
    	whole_num = (int)(n_total/d_total); 
    	int remainder_num = n_total%d_total;
    	n_total = remainder_num; 
    	
    	String final_answer = "";
    	
    	if(n_total == 0) { //frac1 and frac2 are the same, then the answer is 0
			final_answer = Integer.toString(whole_num);
			return final_answer;
		}
    	if(whole_num == 0) { //if there is no whole number anymore then it doesn't print it
    		final_answer = n_total + "/" + d_total;
    		return final_answer;
    	}
    	else {
    		final_answer = whole_num + "_" + n_total + "/" + d_total;
    		return final_answer;
    	}
    }
    
    
    //multiply
    public static String multiply_calc(int w1, int n1, int d1, int w2, int n2, int d2) {
    	//makes it into a mixed fraction
    	int whole_num = 0;
    	int new_n1 = (w1*d1) + n1;
    	int new_n2 = (w2*d2) + n2;
    	int n_total = new_n1 * new_n2;
    	int d_total = d1*d2;
    	
    	whole_num = (int)(n_total/d_total);
    	int remainder_num = n_total%d_total;
    	n_total = remainder_num;
    	
    	String final_answer = "";
    	
    	//if one of the values is 0
    	if (n_total == 0) {
    		final_answer = "0";
    		return final_answer;
    	}
    	if (whole_num == 0) {
    		final_answer = n_total + "/" + d_total;
    		return final_answer;
    	}
    	else {
    		final_answer = whole_num + "_" + n_total + "/" + d_total;
    		return final_answer;
    	}
    }
     
  //divide
  public static String divide_calc(int w1, int n1, int d1, int w2, int n2, int d2) {
	  	//mixed fraction
	  	int new_n1 = (w1*d1) + n1;
	  	int new_n2 = (w2*d2) + n2;
    	int new_d2 = new_n2; //dividing fractions is the same as multiplying the reciprocal
    	new_n2 = d2; //switch the denominator to equal the numerator and the numerator to denominator
    	System.out.println(new_n2);
    	int n_total = new_n1 * new_n2;
    	int d_total = d1*new_d2;
    	
    	String final_answer = "";
    	
    	if (d_total == 0){
    		final_answer = "Error, denominators cannot equal 0";
    	}
    	else {
    		int whole_num = (int)(n_total/d_total);
    		int remainder_num = n_total%d_total;
    		n_total = remainder_num;
    		final_answer = whole_num + "_" + n_total + "/" + d_total;
    		if (whole_num == 0) {
    			final_answer = n_total + "/" + d_total;
    		}
    	}
    	return final_answer;
    }
}
