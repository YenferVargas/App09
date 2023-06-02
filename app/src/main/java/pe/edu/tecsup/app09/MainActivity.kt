package pe.edu.tecsup.app09

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import pe.edu.tecsup.app09.contactos.ContactoActvity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonVer = findViewById<Button>(R.id.darClick)
        buttonVer.setOnClickListener {
            startActivity(Intent(this, ContactoActvity::class.java))
        }
    }
}