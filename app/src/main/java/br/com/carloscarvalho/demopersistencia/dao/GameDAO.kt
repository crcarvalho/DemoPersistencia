package br.com.carloscarvalho.demopersistencia.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import br.com.carloscarvalho.demopersistencia.model.Game

@Dao
interface GameDAO{

    @Insert
    fun inserir(game: Game)

    @Delete
    fun delete(game: Game)

    @Update
    fun atualizar(game: Game)



    @Query("SELECT * FROM Game")
    fun lerGames(): LiveData<List<Game>>



    @Query("SELECT * FROM Game WHERE id = :codigo")
    fun buscarPorId(codigo: Int): LiveData<List<Game>>

}