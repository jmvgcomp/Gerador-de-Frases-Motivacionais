package dev.jmvg.frasesmotivacionais.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.jmvg.frasesmotivacionais.R
import dev.jmvg.frasesmotivacionais.infra.MotivationConstants
import dev.jmvg.frasesmotivacionais.infra.SecurityPreferences

class SplashActivity : AppCompatActivity(), View.OnClickListener {

  private lateinit var mSecurityPreferences: SecurityPreferences


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)


    mSecurityPreferences = SecurityPreferences(this);

    val botaoSalvar = findViewById<Button>(R.id.botaoSalvar);
    botaoSalvar.setOnClickListener(this)

    verifyName()


  }

  private fun verifyName() {
    val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
    if(name.isNotBlank()){
      startActivity(Intent(this, MainActivity::class.java))
      finish()
    }
  }

  override fun onClick(view: View?) {
    val id = view?.id
    if(id == R.id.botaoSalvar) handleSave();
  }

  private fun handleSave() {
    val name = findViewById<EditText>(R.id.editNomeUsuario).text.toString()
    if(name.isNotBlank()){
      mSecurityPreferences.storeString("name", name)
      startActivity(Intent(this, MainActivity::class.java))
      finish()
    }else{
      Toast.makeText(this, "O nome não pode estar vazio :(", Toast.LENGTH_LONG).show()
    }
  }
}