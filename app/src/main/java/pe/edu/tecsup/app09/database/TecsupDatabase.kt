package pe.edu.tecsup.app09.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pe.edu.tecsup.app09.contactos.Contacto
import pe.edu.tecsup.app09.contactos.ContactoDAO
@Database(entities = [Contacto:: class], version = 1)
abstract class TecsupDatabase: RoomDatabase(){

    abstract  fun  contactoDAO() : ContactoDAO
    companion object{
        private  const val DATABASE_NAME = "tecsup_database"
        @Volatile
        private  var INSTANCE: TecsupDatabase? = null

        fun getInstance(context: Context):TecsupDatabase? {
            INSTANCE
                ?: synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TecsupDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                }
            return INSTANCE
        }


    }

}
