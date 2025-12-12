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

    @Test
    fun validatePassword_numberMissing_isFalse() {
            val numberMissing = RegistrationUtil.validatePassword("Passwords", "Passwords")
            assertThat(numberMissing).isFalse()
    }

    @Test
    fun validatePassword_capitalMissing_isFalse() {
        val capitalMissing = RegistrationUtil.validatePassword("password1", "password1")
        assertThat(capitalMissing).isFalse()
    }

    @Test
    fun validatePassword_tooShort_isFalse(){
        val tooShort = RegistrationUtil.validatePassword("Passwo1","Passwo1")
        assertThat(tooShort).isFalse()
    }

    @Test
    fun validatePassword_matchingPassword_isTrue() {
        val matchingPassword = RegistrationUtil.validatePassword("Password1", "Password1")
        assertThat(matchingPassword).isTrue()
    }

    @Test
    fun validateName_emptyName_isFalse() {
        val emptyName = RegistrationUtil.validateName("")
        assertThat(emptyName).isFalse()
    }

    @Test
    fun validateName_isGood_isTrue() {
        val isGood = RegistrationUtil.validateName("Alex")
        assertThat(isGood).isTrue()
    }

    @Test
    fun validateUserName_emptyUser_isFalse(){
        val emptyUser = RegistrationUtil.validateUsername("")
        assertThat(emptyUser).isFalse()
    }

    @Test
    fun validateUserName_matchesOther_isFalse(){
        val matchesOther = RegistrationUtil.validateUsername("alice")
        assertThat(matchesOther).isFalse()
    }

    @Test
    fun validateUserName_tooShort_isFalse(){
        val tooShort = RegistrationUtil.validateUsername("bo")
        assertThat(tooShort).isFalse()
    }

    @Test
    fun validateUserName_isGood_isTrue(){
        val isGood = RegistrationUtil.validateUsername("Universe84")
        assertThat(isGood).isTrue()
    }

    @Test
    fun validateEmail_isEmpty_isFalse(){
        val isEmpty = RegistrationUtil.validateEmail("")
        assertThat(isEmpty).isFalse()
    }

    @Test
    fun validateEmail_matchesOther_isFalse(){
        val matchesOther = RegistrationUtil.validateEmail("jerry@gmail.com")
        assertThat(matchesOther).isFalse()
    }

    @Test
    fun validateEmail_notFormat_isFalse(){
        val missingUser = RegistrationUtil.validateEmail("@banana.com")
        assertThat(missingUser).isFalse()
    }

    @Test
    fun validateEmail_containsAt_isFalse(){
        val noAt = RegistrationUtil.validateEmail("applebanana.com")
        assertThat(noAt).isFalse()
    }

    @Test
    fun validateEmail_notInList_isFalse(){
        val notIn = RegistrationUtil.validateEmail("itusi@yahoo.com")
        assertThat(notIn).isFalse()
    }

    @Test
    fun validateEmail_isGood_isTrue(){
        val isGood = RegistrationUtil.validateEmail("scooby@gmail.com")
        assertThat(isGood).isTrue()
    }

    @Test
    fun validateEmail_nothingInMiddle_isFalse(){
        val isEmpty = RegistrationUtil.validateEmail("scoopity@.ban")
        assertThat(isEmpty).isFalse()
    }

    @Test
    fun validateEmail_nothingInBack_isFalse(){
        val isEmpty = RegistrationUtil.validateEmail("scoopity@scoob.")
        assertThat(isEmpty).isFalse()
    }

    @Test
    fun validateEmail_noPeriod_isFalse(){
        val noPeriod = RegistrationUtil.validateEmail("email@emailemail")
        assertThat(noPeriod).isFalse()
    }
}