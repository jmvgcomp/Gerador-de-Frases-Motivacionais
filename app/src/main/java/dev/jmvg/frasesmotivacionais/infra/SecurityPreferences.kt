package dev.jmvg.frasesmotivacionais.infra

import android.content.Context

class SecurityPreferences(context: Context){

  //possui espaço limitado, ideal que seja usado para acessos rapidos na aplicação
  //e dados que não mudarão com frequência, dados pequenos.
  private val mSharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

  fun storeString(key: String, value: String){
    mSharedPreferences.edit().putString(key, value).apply()
  }
  fun getString(key: String){

  }
}