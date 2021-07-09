package test.com.androidtestexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainButton = findViewById<Button>(R.id.mainButton)
        val mainTextView = findViewById<TextView>(R.id.mainTextView)
        mainButton.setOnClickListener {
            mainTextView.text = "Hello World"
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    companion object{
        val TAG = MainActivity::class.java.simpleName
    }
}