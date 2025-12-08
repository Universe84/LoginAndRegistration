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


}