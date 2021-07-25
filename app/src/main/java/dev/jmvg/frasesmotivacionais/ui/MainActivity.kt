package dev.jmvg.frasesmotivacionais.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import dev.jmvg.frasesmotivacionais.R
import dev.jmvg.frasesmotivacionais.infra.MotivationConstants
import dev.jmvg.frasesmotivacionais.infra.SecurityPreferences
import dev.jmvg.frasesmotivacionais.repository.Mock

class MainActivity : AppCompatActivity(), View.OnClickListener {

  private lateinit var mSecurityPreferences: SecurityPreferences
  private var mPhraseFilter : Int = MotivationConstants.PHRASEFILTER.ALL

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)


    val textName = findViewById<TextView>(R.id.textName)

    mSecurityPreferences = SecurityPreferences(this)
    val userName = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
    textName.text = "Olá, $userName"


    findViewById<ImageView>(R.id.imageAll)
      .setColorFilter(ContextCompat.getColor(this, R.color.white))

    handleNewPhrase()


    findViewById<Button>(R.id.buttonNewPhrase).setOnClickListener(this)
    findViewById<ImageView>(R.id.imageAll).setOnClickListener(this)
    findViewById<ImageView>(R.id.imageHappy).setOnClickListener(this)
    findViewById<ImageView>(R.id.imageMorning).setOnClickListener(this)

  }

  override fun onClick(view: View) {
    val id = view.id;
    val listFilter = listOf(R.id.imageAll, R.id.imageHappy, R.id.imageMorning)

    if(id == R.id.buttonNewPhrase){
      handleNewPhrase()
    }else if(id in listFilter){
      handleFilter(id)
    }

  }

  private fun handleFilter(id: Int) {

    val imageAll = findViewById<ImageView>(R.id.imageAll)
    val imageHappy = findViewById<ImageView>(R.id.imageHappy)
    val imageMorning = findViewById<ImageView>(R.id.imageMorning)

    imageAll.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent))
    imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent))
    imageMorning.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent))

      when(id){
        R.id.imageAll -> {
          imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
          mPhraseFilter = MotivationConstants.PHRASEFILTER.ALL
        }
        R.id.imageHappy -> {
          imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
          mPhraseFilter = MotivationConstants.PHRASEFILTER.HAPPY
        }
        R.id.imageMorning -> {
          imageMorning.setColorFilter(ContextCompat.getColor(this, R.color.white))
          mPhraseFilter = MotivationConstants.PHRASEFILTER.MORNING
        }
      }
  }

  private fun handleNewPhrase() {
    findViewById<TextView>(R.id.textPhrase).text = Mock().getPhrase(mPhraseFilter)
  }




}