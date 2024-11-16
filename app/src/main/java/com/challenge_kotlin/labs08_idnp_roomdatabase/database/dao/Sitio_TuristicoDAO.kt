package com.challenge_kotlin.labs08_idnp_roomdatabase.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import androidx.room.Update
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.model.Sitio_TuristicoModel

@Dao
interface SitioTuristicoDAO {

    @Query("SELECT * FROM Sitio_Turistico")
    suspend fun getAllSitios(): List<Sitio_TuristicoModel>

    @Insert
    suspend fun insertSitio(sitioTuristico: Sitio_TuristicoModel)

    @Update
    suspend fun updateSitio(sitioTuristico: Sitio_TuristicoModel)

    @Delete
    suspend fun deleteSitio(sitioTuristico: Sitio_TuristicoModel)

    @Query("SELECT * FROM Sitio_Turistico WHERE sitio_id = :sitioId")
    suspend fun getSitioById(sitioId: Long): Sitio_TuristicoModel?

    @Query("SELECT * FROM Sitio_Turistico WHERE nombre LIKE :nombre")
    suspend fun searchSitiosByName(nombre: String): List<Sitio_TuristicoModel>
}


