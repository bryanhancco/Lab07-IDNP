package com.challenge_kotlin.labs08_idnp_roomdatabase.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.ColumnInfo
import java.util.*

@Entity(
    tableName = "Comentarios",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["name"],
            childColumns = ["usuario_nombre"],
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
data class Comentario(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "comentario_id")
    val comentarioId: Long = 0L,

    @ColumnInfo(name = "comentario")
    val comentario: String,

    @ColumnInfo(name = "usuario_nombre")
    val usuarioNombre: String,

    @ColumnInfo(name = "sitio_id")
    val sitioId: Long,

    @ColumnInfo(name = "fecha")
    val fecha: Date,

    @ColumnInfo(name = "num_likes")
    val numLikes: Long
)
