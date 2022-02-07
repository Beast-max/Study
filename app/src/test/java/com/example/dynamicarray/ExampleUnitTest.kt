package com.example.dynamicarray

import com.example.dynamicarray.Api.Api
import junit.framework.Assert
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun `get`(){
        val response = Api.api.getsubs().execute()
        Assert.assertNotNull(response.body())
    }
}