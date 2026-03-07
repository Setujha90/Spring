package service;

import exception.ValidationException;

public class Validation {

    public static void emailValidation(String email) {

        if(!email.contains("@gmail.com")) {
            throw new ValidationException("Email must contain @gmail.com");
        }
    }

    public static void mobileValidation(String mobile) {

        if(mobile.length() != 10)
            throw new ValidationException("Mobile number must be 10 digits");

        char ch = mobile.charAt(0);

        if(!(ch=='6' || ch=='7' || ch=='8' || ch=='9'))
            throw new ValidationException("Mobile must start with 6,7,8 or 9");
    }

    public static void passwordValidation(String pass) {

        if(pass.length()!=4)
            throw new ValidationException("Password length must be 4");

        boolean upper=false, lower=false, digit=false, special=false;

        for(char c : pass.toCharArray()){

            if(Character.isUpperCase(c))
                upper=true;

            else if(Character.isLowerCase(c))
                lower=true;

            else if(Character.isDigit(c))
                digit=true;

            else
                special=true;
        }

        if(!(upper && lower && digit && special))
            throw new ValidationException(
                    "Password must contain uppercase, lowercase, digit and special character");
    }
}