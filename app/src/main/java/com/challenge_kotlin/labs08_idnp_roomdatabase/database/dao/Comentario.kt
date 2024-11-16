package com.challenge_kotlin.labs08_idnp_roomdatabase.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import androidx.room.Update
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.model.Comentario

@Dao
interface ComentarioDAO {
    @Insert
    suspend fun insertComentario(comentario: Comentario)

    @Update
    suspend fun updateComentario(comentario: Comentario)

    @Delete
    suspend fun deleteComentario(comentario: Comentario)

    @Query("SELECT * FROM Comentarios WHERE comentario_id = :comentarioId")
    suspend fun getComentarioById(comentarioId: Long): Comentario?

    @Query("SELECT * FROM Comentarios WHERE sitio_id = :sitioId")
    suspend fun getComentariosBySitio(sitioId: Long): List<Comentario>
}
