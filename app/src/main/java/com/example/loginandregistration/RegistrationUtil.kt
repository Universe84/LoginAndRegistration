package com.example.loginandregistration

object RegistrationUtil {
    // object keyword makes it so all the functions are
    // static functions
    // use this in the test class for the is username taken test
    // make another similar list for some taken emails
        var existingEmails = listOf("itusi@yahoo.com", "jerry@gmail.com", "daxton@stu.spusd.net", "alex@hotmail.com")
        var existingUsers = listOf("cosmicF", "cosmicY", "bob", "alice")
    //    you can use listOf<type>() instead of making the list & adding individually
    //    List<String> blah = new ArrayList<String>();
    //    blah.add("hi")
    //    blah.add("hello")
    //

    // isn't empty
    // already taken
    // minimum number of characters is 3
    fun validateUsername(username: String) : Boolean {
        return username.length > 2 && !existingUsers.contains(username)
    }

    // make sure meets security requirements (deprecated ones that are still used everywhere)
    // min length 8 chars
    // at least one digit
    // at least one capital letter
    // both passwords match
    // not empty
    fun validatePassword(password : String, confirmPassword: String) : Boolean {
        return (password.equals(confirmPassword) && password.length > 7 && password.any{it.isUpperCase()} && password.any{it.isDigit()})
    }

    // isn't empty
    fun validateName(name: String) : Boolean {
        return name.length > 0
    }

    // isn't empty
    // make sure the email isn't used
    // make sure it's in the proper email format user@domain.tld
    fun validateEmail(email: String) : Boolean {
        return email.length > 0 && !existingEmails.contains(email) && email.contains("@") && email.contains(".") && email.substring(0, email.indexOf("@")).length > 0 && email.substring(email.indexOf("@"), email.indexOf(".")).length > 0 && email.substring(email.indexOf("."), email.length).length > 0)
    }
}
}