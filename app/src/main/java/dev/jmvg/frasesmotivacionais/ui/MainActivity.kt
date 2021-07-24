package dev.jmvg.frasesmotivacionais.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import dev.jmvg.frasesmotivacionais.R
import dev.jmvg.frasesmotivacionais.infra.MotivationConstants
import dev.jmvg.frasesmotivacionais.infra.SecurityPreferences

class MainActivity : AppCompatActivity() {

  private lateinit var mSecurityPreferences: SecurityPreferences

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)


    val textName = findViewById<TextView>(R.id.editText)

    mSecurityPreferences = SecurityPreferences(this)
    textName.text = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)

  }
}