package com.example.mysecondapp

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mysecondapp.ui.theme.MySecondAppTheme
import java.time.Year

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        var getAgeView = findViewById<EditText>(R.id.edit_date)
        var resultAgeView = findViewById<TextView>(R.id.result_txt)
        var getAgeBtn = findViewById<Button>(R.id.buGetAge)

        getAgeBtn.setOnClickListener{
            var birthYear = getAgeView.text.toString().toIntOrNull()
            if(birthYear != null){
                var age = calculateAge(birthYear)
                resultAgeView.text = "You are $age years old."
            } else {
                resultAgeView.text = "Please enter a valid birth year."
            }
        }


    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun calculateAge(birthYear: Int): Int{
        var currYear = Year.now().value;
        return currYear - birthYear;
    }
}