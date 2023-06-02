package pe.edu.tecsup.app09.contactos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactoAdapter():
    RecyclerView.Adapter<ContactoViewHolder>() {

    private var contactolista= emptyList<Contacto>()

    fun setContacto(contacto: List<Contacto>){
        this.contactolista= contacto
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int{
        return contactolista.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        return ContactoViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        val information : Contacto = contactolista[position]
        holder.bind(information)
    }

    interface  ItemClickListener{

        fun onItemClickListener(contactoItem: Contacto)

    }





}
