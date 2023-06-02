package pe.edu.tecsup.app09.contactos

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.tecsup.app09.database.TecsupDatabase

class ContactoRepository(application: Application) {


    private val contactoDAO: ContactoDAO ?= TecsupDatabase.getInstance(application)?.contactoDAO()

    suspend fun  insertNoteWithCoroutines(contacto: Contacto){
        processInsertNote(contacto)
    }

    private suspend fun  processInsertNote(contacto: Contacto ){
        withContext(Dispatchers.Default) {
            contactoDAO?.insert(contacto)
        }
    }

    fun getNotes(): LiveData<List<Contacto>>?{
        return contactoDAO?.getNota()
    }

}