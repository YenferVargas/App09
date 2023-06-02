package pe.edu.tecsup.app09.contactos

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

import androidx.recyclerview.widget.RecyclerView

class ContactoViewModel(application: Application): AndroidViewModel(application) {

    private val repository = ContactoRepository(application)

    val contactos = repository.getNotes()

    fun saveContacto(contacto: Contacto) {
        viewModelScope.launch {
            repository.insertNoteWithCoroutines(contacto)
        }
    }
}