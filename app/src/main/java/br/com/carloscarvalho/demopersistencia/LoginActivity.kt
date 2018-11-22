package br.com.carloscarvalho.demopersistencia

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences("meuapp", Context.MODE_PRIVATE);

        if( sharedPreferences.getBoolean("MANTER_CONECTADO", false) ){
            proximaTela()
        }

        btConectar.setOnClickListener {

            //Criando uma instancia do sharedpreferences para EDIÇÃO
            val editor = sharedPreferences.edit()
            editor.putBoolean("MANTER_CONECTADO", cbManterconectado.isChecked)
            editor.putString("USUARIO", inputNome.text.toString())
            //Mais correto utilizar APPLY do que COMMIT pois o APPLY o android identifica o melhor
            // momento de comitar sem travar o APP
            editor.apply()
            proximaTela()
        }
    }

    private fun proximaTela() {
        startActivity(Intent(this, ListaActivity::class.java))
        //Se não fizer o finish a tela main permanece em evidencia e não é destruida
        finish()
    }
}
