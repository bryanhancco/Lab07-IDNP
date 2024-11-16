package com.challenge_kotlin.labs08_idnp_roomdatabase.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.ColumnInfo

@Entity(
    tableName = "Favoritos",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["usuario_id"],
            childColumns = ["usuario_id"],
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
data class Favorito(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "favorito_id")
    val favoritoId: Long = 0L,

    @ColumnInfo(name = "usuario_id")
    val usuarioId: Long,

    @ColumnInfo(name = "sitio_id")
    val sitioId: Long
)
