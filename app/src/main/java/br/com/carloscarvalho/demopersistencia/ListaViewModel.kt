package br.com.carloscarvalho.demopersistencia

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import br.com.carloscarvalho.demopersistencia.dao.BancoDeDados
import br.com.carloscarvalho.demopersistencia.model.Game

class ListaViewModel(application: Application): AndroidViewModel(application){

    private val bd = BancoDeDados.getDatabase(application.applicationContext)

    var games: LiveData<List<Game>>? = null

    init {
        games = bd?.gameDAO()?.lerGames()
    }

}