package com.challenge_kotlin.labs08_idnp_roomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.dao.ComentarioDAO
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.dao.FavoritoDAO
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.dao.SitioTuristicoDAO
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.dao.UsuarioDAO
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.model.ComentarioModel
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.model.FavoritoModel
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.model.Sitio_TuristicoModel
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.model.UsuarioModel


@Database(
    entities = [
        ComentarioModel::class,
        UsuarioModel::class,
        FavoritoModel::class,
        Sitio_TuristicoModel::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun comentarioDAO(): ComentarioDAO
    abstract fun usuarioDAO(): UsuarioDAO
    abstract fun favoritoDAO(): FavoritoDAO
    abstract fun sitioTuristicoDAO(): SitioTuristicoDAO

    companion object DatabaseProvider {
        private var database: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (database == null) {
                database = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return database!!
        }
    }
}



