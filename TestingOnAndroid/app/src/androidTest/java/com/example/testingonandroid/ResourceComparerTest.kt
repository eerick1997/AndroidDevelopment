package com.example.testingonandroid

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

class ResourceComparerTest {
    private lateinit var resourceComparer: ResourceComparer

    @Before
    fun setUp() {
        resourceComparer = ResourceComparer()
    }

    @Test
    fun stringResourceSameAsGivenString_returnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "TestingOnAndroid")
        Truth.assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDifferentAsGivenString_returnsFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "FakeNameApp")
        Truth.assertThat(result).isFalse()
    }
}