package com.challenge_kotlin.labs08_idnp_roomdatabase.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import androidx.room.Update
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.model.UsuarioModel

@Dao
interface UsuarioDAO {

    @Query("SELECT * FROM Usuario")
    suspend fun getAllUsuarios(): List<UsuarioModel>

    @Insert
    suspend fun insertUsuario(usuarioModel: UsuarioModel)

    @Update
    suspend fun updateUsuario(usuarioModel: UsuarioModel)

    @Delete
    suspend fun deleteUsuario(usuarioModel: UsuarioModel)

    @Query("SELECT * FROM Usuario WHERE usuario_id = :usuarioId")
    suspend fun getUsuarioById(usuarioId: Long): UsuarioModel?

    @Query("SELECT * FROM Usuario WHERE name = :name")
    suspend fun getUsuarioByName(name: String): UsuarioModel?
}
