package br.com.carloscarvalho.demopersistencia

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import br.com.carloscarvalho.demopersistencia.model.Game
import kotlinx.android.synthetic.main.activity_lista.*
import kotlinx.android.synthetic.main.content_lista.*

class ListaActivity : AppCompatActivity() {

    lateinit var listaViewModel: ListaViewModel
    lateinit var gameAdapter: GameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        iniciaViewModel()

        inicializaRecyclerView()

        listaViewModel.games

        listaViewModel.games?.observe(this, Observer<List<Game>>{
            gameAdapter.setList(it!!)
            rvGames.adapter.notifyDataSetChanged()
        })

    }

    private fun inicializaRecyclerView() {
        //Cria a lista na vertical
        rvGames.layoutManager = LinearLayoutManager(this)
        //Inicializa a GameAdapter com uma lista vazia
        gameAdapter = GameAdapter(listOf())
        rvGames.adapter = gameAdapter
    }

    private fun iniciaViewModel() {
        listaViewModel = ViewModelProviders.of( this ).get(ListaViewModel::class.java)

        fab.setOnClickListener {
            NovoGameDialog().show(fragmentManager, "CriarJogo")
        }
    }

    override fun onResume() {
        super.onResume()

        val usuario = getSharedPreferences("meuapp", Context.MODE_PRIVATE).getString("USUARIO", "")

        tvNome.text = usuario
    }
}
