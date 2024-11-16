package com.challenge_kotlin.labs08_idnp_roomdatabase.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import androidx.room.Update
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.model.Usuario

@Dao
interface UsuarioDAO {

    @Insert
    suspend fun insertUsuario(usuario: Usuario)

    @Update
    suspend fun updateUsuario(usuario: Usuario)

    @Delete
    suspend fun deleteUsuario(usuario: Usuario)

    @Query("SELECT * FROM Usuario WHERE usuario_id = :usuarioId")
    suspend fun getUsuarioById(usuarioId: Long): Usuario?

    @Query("SELECT * FROM Usuario WHERE name = :name")
    suspend fun getUsuarioByName(name: String): Usuario?
}
