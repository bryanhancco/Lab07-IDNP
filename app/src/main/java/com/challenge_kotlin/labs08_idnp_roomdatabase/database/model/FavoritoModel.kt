package com.challenge_kotlin.labs08_idnp_roomdatabase.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.ColumnInfo

@Entity(
    tableName = "Favoritos",
    foreignKeys = [
        ForeignKey(
            entity = UsuarioModel::class,
            parentColumns = ["username"],
            childColumns = ["username"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = SitioTuristico::class,
            parentColumns = ["sitio_id"],
            childColumns = ["sitio_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class FavoritoModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "favorito_id")
    val favoritoId: Long = 0L,

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "sitio_id")
    val sitioId: Long
)
