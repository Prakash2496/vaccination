package com.hangarww.vaccination.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AadharCardUtils {
	public static boolean isValidAadharNumber(String aadharNumber)
    {
        // Regex to check valid Aadhar number.
        String regex
            = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
 
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
 
        // If the string is empty
        // return false
        if (aadharNumber == null) {
            return false;
        }
 
        // Pattern class contains matcher() method
        // to find matching between given string
        // and regular expression.
        Matcher m = p.matcher(aadharNumber);
 
        // Return if the string
        // matched the ReGex
        return m.matches();
    }
}
