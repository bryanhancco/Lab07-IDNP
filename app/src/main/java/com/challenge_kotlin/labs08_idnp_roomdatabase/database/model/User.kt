package com.challenge_kotlin.labs08_idnp_roomdatabase.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "Usuario")
data class Usuario(
    @PrimaryKey
    @ColumnInfo(name = "usuario_id")
    val usuarioId: Long,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "password")
    val password: String,

    @ColumnInfo(name = "username")
    val username: String
)