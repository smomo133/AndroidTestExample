package test.com.androidtestexample

import android.content.Intent
import android.os.Build
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class ExampleUnitTest {

    @Before
    fun setUp(){
        ShadowLog.stream = System.out
    }

    //@Test
    fun testIntent(){
        //Given
        val intent = Intent()
        val controller: ActivityController<MainActivity>
                = Robolectric
            .buildActivity(MainActivity::class.java, intent)
            .setup()
        //When
        controller.pause().stop()
        //Then
        assertEquals(controller.intent, intent)
    }

    @Test
    fun textView_when_click_button(){
        val controller: ActivityController<MainActivity>
                = Robolectric.buildActivity(MainActivity::class.java)
        val activity = controller
            .create()
            .start()
            .resume()
            .visible()
            .get()
        activity.mainButton.performClick()
        assertEquals("Hello World", activity.mainTextView.text)
    }

    @Test
    @Config(qualifiers = "en")
    fun localizedEnglishHello() {
        val controller: ActivityController<MainActivity>
                = Robolectric.buildActivity(MainActivity::class.java)
        val activity = controller
            .create()
            .start()
            .resume()
            .visible()
            .get()
        assertEquals(activity.helloTextView.text.toString(), "Hello")
    }

    @Test
    @Config(qualifiers="ko")
    fun localizedKoreanHello() {
        val controller: ActivityController<MainActivity>
                = Robolectric.buildActivity(MainActivity::class.java)
        val activity = controller
            .create()
            .start()
            .resume()
            .visible()
            .get()
        assertEquals(activity.helloTextView.text.toString(), "안녕하세요")
    }
}