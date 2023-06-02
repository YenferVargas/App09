package pe.edu.tecsup.app09.contactos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacto_table")
data class Contacto(
    @ColumnInfo(name="nombres_apellidos")
    var nombreApellido:String,
    @ColumnInfo(name = "telefono")
    var telefono:String,
    @ColumnInfo(name = "correo")
    var correo :String,
    @ColumnInfo(name = "direccion")
    var direccion:String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_nombre")
    var nombre_id:Int = 0

}