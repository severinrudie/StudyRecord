package y2021.m01.d25

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Pramp_DecryptMessageTest {

    val encryptor = Pramp_DecryptMessage()

    @Test
    fun tc1() {
        assertEquals("dnotq", encryptor.encrypt("crime"))
    }

    @Test
    fun tc2() {
        assertEquals("crime", encryptor.decrypt("dnotq"))
    }
}
