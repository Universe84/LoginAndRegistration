package com.example.loginandregistration

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilUnitTest {

    @Test
    fun validatePassword_emptyPassword_isFalse() {
        val bothEmpty = RegistrationUtil.validatePassword("", "")
        assertThat(bothEmpty).isFalse()
        val firstEmpty = RegistrationUtil.validatePassword("", "Password1")
        assertThat(firstEmpty).isFalse()
        val secondEmpty = RegistrationUtil.validatePassword("Password1", "")
        assertThat(secondEmpty).isFalse()
    }

    fun validatePassword_numberMissing_isFalse() {
            val numberMissing = RegistrationUtil.validatePassword("Passwords", "Passwords")
            assertThat(numberMissing).isFalse()
    }

    fun validatePassword_capitalMissing_isFalse() {
        val capitalMissing = RegistrationUtil.validatePassword("password1", "password1")
        assertThat(capitalMissing).isFalse()
    }

    fun validatePassword_tooShort_isFalse(){
        val tooShort = RegistrationUtil.validatePassword("Passwo1","Passwo1")
        assertThat(tooShort).isFalse()
    }

    fun validatePassword_matchingPassword_isTrue() {
        val matchingPassword = RegistrationUtil.validatePassword("Password1", "Password1")
        assertThat(matchingPassword).isTrue()
    }

    fun validateName_emptyName_isFalse() {
        val emptyName = RegistrationUtil.validateName("")
        assertThat(emptyName).isFalse()
    }

    fun validateName_isGood_isTrue() {
        val isGood = RegistrationUtil.validateName("Alex")
    }

    fun validateUserName_emptyUser_isFalse(){
        val emptyUser = RegistrationUtil.validateUsername("")
        assertThat(emptyUser).isFalse()
    }

    fun validateUserName_matchesOther_isFalse(){
        val matchesOther = RegistrationUtil.validateUsername("alice")
        assertThat(matchesOther).isFalse()
    }

    fun validateUserName_tooShort_isFalse(){
        val tooShort = RegistrationUtil.validateUsername("bo")
        assertThat(tooShort).isFalse()
    }

    fun validateUserName_isGood_isTrue(){
        val isGood = RegistrationUtil.validateUsername("Universe84")
        assertThat(isGood).isTrue()
    }

    fun validateEmail_isEmpty_isFalse(){
        val isEmpty = RegistrationUtil.validateEmail("")
        assertThat(isEmpty).isFalse()
    }

    fun validateEmail_matchesOther_isFalse(){
        val matchesOther = RegistrationUtil.validateEmail("jerry@gmail.com")
        assertThat(matchesOther).isFalse()
    }

    fun validateEmail_notFormat_isFalse(){
        val missingUser = RegistrationUtil.validateEmail("@banana.com")
        assertThat(missingUser).isFalse()
    }


}