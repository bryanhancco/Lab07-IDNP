package com.challenge_kotlin.labs08_idnp_roomdatabase.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import androidx.room.Update
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.model.ComentarioModel

@Dao
interface ComentarioDAO {
    @Query("SELECT * FROM Comentarios")
    suspend fun getAllComentarios(): List<ComentarioModel>

    @Insert
    suspend fun insertComentario(comentarioModel: ComentarioModel)

    @Update
    suspend fun updateComentario(comentarioModel: ComentarioModel)

    @Delete
    suspend fun deleteComentario(comentarioModel: ComentarioModel)

    @Query("SELECT * FROM Comentarios WHERE comentario_id = :comentarioId")
    suspend fun getComentarioById(comentarioId: Long): ComentarioModel?

    @Query("SELECT * FROM Comentarios WHERE sitio_id = :sitioId")
    suspend fun getComentariosBySitio(sitioId: Long): List<ComentarioModel>
}
