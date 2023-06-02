package pe.edu.tecsup.app09.contactos

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonDisposableHandle.parent
import pe.edu.tecsup.app09.R

class ContactoViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_contactos, parent, false)) {

        private var textNames : TextView? = null
        private var textPhoneNumber : TextView? = null
        private var textEmail : TextView? = null
        private var textAddress : TextView? = null

        init {
            textNames = itemView.findViewById(R.id.textNames)
            textPhoneNumber = itemView.findViewById(R.id.textPhoneNumber)
            textEmail = itemView.findViewById(R.id.textEmail)
            textAddress = itemView.findViewById(R.id.textAddress)

        }

        fun bind(contacto: Contacto){
            textNames?.text = contacto.nombreApellido
            textPhoneNumber?.text = contacto.telefono
            textEmail?.text = contacto.correo
            textAddress?.text = contacto.direccion
        }


    }
