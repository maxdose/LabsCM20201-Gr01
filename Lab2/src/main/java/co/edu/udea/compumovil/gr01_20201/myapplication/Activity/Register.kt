package co.edu.udea.compumovil.gr01_20201.lab2.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import co.edu.udea.compumovil.gr01_20201.lab2.R



class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val textoNombre = findViewById<EditText>(R.id.Nombres)
        val textoUsuario = findViewById<EditText>(R.id.usuario)
        var siguiente : Button?=null
        siguiente = findViewById(R.id.btnSiguienteRegistro)
        siguiente?.setOnClickListener {
            if (textoNombre.text.equals("")||textoUsuario.text.equals("")  ) {
                Toast.makeText(applicationContext, getString(R.string.ErrorDatos), Toast.LENGTH_LONG).show()
            }
            else {

                val intent = Intent(this, RegisterSecondPart::class.java)

                startActivity(intent)
            }
        }
    }
}


