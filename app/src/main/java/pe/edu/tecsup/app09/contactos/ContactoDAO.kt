package pe.edu.tecsup.app09.contactos

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactoDAO {
    @Insert
    fun insert(contacto: Contacto)

    @Update
    fun update(contacto: Contacto)

    @Delete
    fun  delete(contacto: Contacto)

    @Query("SELECT * FROM contacto_table")
    fun getNota(): LiveData<List<Contacto>>
}