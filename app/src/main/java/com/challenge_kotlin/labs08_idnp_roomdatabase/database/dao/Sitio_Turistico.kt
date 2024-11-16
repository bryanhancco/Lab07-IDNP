package com.challenge_kotlin.labs08_idnp_roomdatabase.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import androidx.room.Update
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.model.SitioTuristico

@Dao
interface SitioTuristicoDAO {

    @Insert
    suspend fun insertSitio(sitioTuristico: SitioTuristico)

    @Update
    suspend fun updateSitio(sitioTuristico: SitioTuristico)

    @Delete
    suspend fun deleteSitio(sitioTuristico: SitioTuristico)

    @Query("SELECT * FROM Sitio_Turistico WHERE sitio_id = :sitioId")
    suspend fun getSitioById(sitioId: Long): SitioTuristico?

    @Query("SELECT * FROM Sitio_Turistico WHERE nombre LIKE :nombre")
    suspend fun searchSitiosByName(nombre: String): List<SitioTuristico>
}
