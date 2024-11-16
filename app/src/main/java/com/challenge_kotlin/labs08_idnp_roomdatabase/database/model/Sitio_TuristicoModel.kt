package com.challenge_kotlin.labs08_idnp_roomdatabase.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "Sitio_Turistico")
data class Sitio_TuristicoModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "sitio_id")
    val sitioId: Long = 0L,

    @ColumnInfo(name = "nombre")
    val nombre: String,

    @ColumnInfo(name = "descripcion")
    val descripcion: String,

    @ColumnInfo(name = "imagen_enlace")
    val imagenEnlace: String,

    @ColumnInfo(name = "puntuacion")
    val puntuacion: Float,

    @ColumnInfo(name = "coord_x")
    val coordX: Float,

    @ColumnInfo(name = "coord_y")
    val coordY: Float
)
