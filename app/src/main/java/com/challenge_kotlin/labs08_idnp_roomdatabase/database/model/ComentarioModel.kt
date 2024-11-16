package com.challenge_kotlin.labs08_idnp_roomdatabase.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.ColumnInfo

@Entity(
    tableName = "Comentarios",
    foreignKeys = [
        ForeignKey(
            entity = UsuarioModel::class,
            parentColumns = ["username"],
            childColumns = ["username"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Sitio_TuristicoModel::class,
            parentColumns = ["sitio_id"],
            childColumns = ["sitio_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ComentarioModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "comentario_id")
    val comentarioId: Long = 0L,

    @ColumnInfo(name = "comentario")
    val comentario: String,

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "sitio_id")
    val sitioId: Long,

    @ColumnInfo(name = "num_likes")
    val numLikes: Long
)



