package com.challenge_kotlin.labs08_idnp_roomdatabase.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.model.Favorito

@Dao
interface FavoritoDAO {

    @Insert
    suspend fun insertFavorito(favorito: Favorito)

    @Delete
    suspend fun deleteFavorito(favorito: Favorito)

    @Query("SELECT * FROM Favoritos WHERE usuario_id = :usuarioId")
    suspend fun getFavoritosByUsuario(usuarioId: Long): List<Favorito>

    @Query("SELECT * FROM Favoritos WHERE sitio_id = :sitioId")
    suspend fun getFavoritosBySitio(sitioId: Long): List<Favorito>
}
