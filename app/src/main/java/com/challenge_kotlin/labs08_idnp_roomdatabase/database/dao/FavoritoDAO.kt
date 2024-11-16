package com.challenge_kotlin.labs08_idnp_roomdatabase.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.model.FavoritoModel

@Dao
interface FavoritoDAO {
    @Query("SELECT * FROM Favoritos")
    suspend fun getAllFavoritos(): List<FavoritoModel>

    @Insert
    suspend fun insertFavorito(favoritoModel: FavoritoModel)

    @Delete
    suspend fun deleteFavorito(favoritoModel: FavoritoModel)

    @Query("SELECT * FROM Favoritos WHERE username = :username")
    suspend fun getFavoritosByUsuario(username: String): List<FavoritoModel>

    @Query("SELECT * FROM Favoritos WHERE sitio_id = :sitioId")
    suspend fun getFavoritosBySitio(sitioId: Long): List<FavoritoModel>
}
