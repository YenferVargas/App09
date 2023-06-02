package pe.edu.tecsup.app09.contactos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import pe.edu.tecsup.app09.R

class ContactoActvity : AppCompatActivity() {

    private lateinit var contactoViewModel: ContactoViewModel;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos)

        contactoViewModel = run {
            ViewModelProvider(this)[ContactoViewModel::class.java]
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerInformations)

        val adapter = ContactoAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        contactoViewModel.contactos?.observe(this){ contacto ->
            contacto?.let {
                adapter.setContacto(contacto)
            }
        }

        val floatingNota = findViewById<FloatingActionButton>(R.id.floatingInformation)
        floatingNota.setOnClickListener{
            registerAndUpdateNote()
        }


        //layoutManager =  LinearLayoutManager(context)
        //layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.contactos)
        val drawable = resources.getDrawable(R.color.purple_620)
        supportActionBar?.setBackgroundDrawable(drawable)

    }

    private fun registerAndUpdateNote() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_contactos, null)

        val titleAlertNote = "Registrar mis Datos"

        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle(titleAlertNote)

        val mAlertDialog = mBuilder.show()

        val buttonCreate  = mDialogView.findViewById<Button>(R.id.btnCreate)
        val editTextNamesCreate  = mDialogView.findViewById<EditText>(R.id.edtNames)
        val editTextPhoneCreate  = mDialogView.findViewById<EditText>(R.id.edtPhoneNumber)
        val editTextEmailCreate  = mDialogView.findViewById<EditText>(R.id.edtEmail)
        val editTextAddressCreate  = mDialogView.findViewById<EditText>(R.id.edtAddress)

        buttonCreate.setOnClickListener {

            mAlertDialog.dismiss()

            val textNames = editTextNamesCreate.text.toString()
            val textPhone = editTextPhoneCreate.text.toString()
            val textEmail = editTextEmailCreate.text.toString()
            val textAddress = editTextAddressCreate.text.toString()

            var informationVM = Contacto(textNames, textPhone, textEmail, textAddress )
            contactoViewModel.saveContacto(informationVM)

        }


    }

}


