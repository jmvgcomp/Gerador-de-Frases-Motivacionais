package dev.jmvg.frasesmotivacionais

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity(), View.OnClickListener {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)

    val botaoSalvar = findViewById<Button>(R.id.botaoSalvar);
    botaoSalvar.setOnClickListener(this)


  }

  override fun onClick(view: View?) {
    val id = view?.id
    if(id == R.id.botaoSalvar) handleSave();
  }

  private fun handleSave() {
    val name = findViewById<EditText>(R.id.editNomeUsuario).text.toString()
    if(name.isNotBlank()){
      startActivity(Intent(this, MainActivity::class.java))
    }else{
      Toast.makeText(this, "O nome não pode estar vazio :(", Toast.LENGTH_LONG).show()
    }
  }
}