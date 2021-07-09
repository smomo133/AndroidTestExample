package test.com.androidtestexample

import android.content.Context
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.android.synthetic.main.activity_main.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private lateinit var appContext: Context

    @Before
    fun setUp(){
        appContext = ApplicationProvider.getApplicationContext<Context>()
    }

    //@Test
    fun useAppContext() {
        // Context of the app under test.
        //val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("test.com.androidtest.robolectricexample", appContext.packageName)
    }

    //@Test
    fun testScenario(){
        //GIVEN
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        //WHEN
        scenario.moveToState(Lifecycle.State.CREATED)
        //THEN
        scenario.onActivity {
            assertEquals(it.mainTextView.text,"something")
        }
    }

    //@Test
    fun inputText(){
        //GIVEN
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        val helloStr = "Hello, World"

        //WHEN
        scenario.moveToState(Lifecycle.State.CREATED)

        //THEN
        scenario.onActivity {
            val textView = it.findViewById<TextView>(R.id.helloTextView)
            textView.setText(helloStr)
            assertEquals(textView.text.toString(), helloStr)
        }
    }
}