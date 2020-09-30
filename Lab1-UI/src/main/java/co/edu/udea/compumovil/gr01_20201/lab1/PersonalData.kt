package co.edu.udea.compumovil.gr01_20201.lab1


import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_personal_data.*
import java.sql.Date
import java.util.*

class PersonalData : AppCompatActivity(), DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener {

    var dia =0
    var mes = 0
    var anio = 0
    var diaGuardado = 0
    var mesGuardado = 0
    var anioGuardado = 0
    var siguiente : Button?=null

    var opciones : Spinner?=null
    var arrayAdapter : ArrayAdapter<String>?=null
    var respuesta : TextView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)
        val fechaEditText = findViewById<EditText>(R.id.Fecha)
        val textoNombre = findViewById<EditText>(R.id.editTextTextPersonName)
        val textoApellido = findViewById<EditText>(R.id.editTextTextPersonName2)
        siguiente = findViewById(R.id.btnSiguiente)
        siguiente?.setOnClickListener {
           if (textoNombre.text.equals("")||textoApellido.text.equals("") || fechaEditText.text.equals("") ) {
               Toast.makeText(applicationContext, getString(R.string.ErrorNombres), Toast.LENGTH_LONG).show()
           }
            else {

               val intent = Intent(this, ContactData::class.java)

               startActivity(intent)
           }
        }

       pickDate()

        var opcion = arrayOf(getString(R.string.grado_de_escolaridad),getString(R.string.Primaria), getString(R.string.Secundaria), getString(
            R.string.Universidad), getString(R.string.Otra))

        opciones = findViewById(R.id.spinner)
        arrayAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item,opcion)
        opciones?.adapter = arrayAdapter
        respuesta = findViewById(R.id.opciones)

        opciones?.onItemSelectedListener = this

    }

    private fun getDayTimeCalendar(){
        val calendar = Calendar.getInstance()
        dia = calendar.get(Calendar.DAY_OF_MONTH)
        mes = calendar.get(Calendar.MONTH)
        anio = calendar.get(Calendar.YEAR)
    }

    private fun pickDate(){
        date_Picker.setOnClickListener{
            getDayTimeCalendar()
            DatePickerDialog(this,this,anio,mes,dia).show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        diaGuardado = dayOfMonth
        mesGuardado = month + 1
        anioGuardado = year
        Fecha.setText("$diaGuardado" + "/" + "$mesGuardado" + "/" + "$anioGuardado")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var items:String = parent?.getItemAtPosition(position) as String
        respuesta?.setText(items)
        Toast.makeText(applicationContext, items, Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(applicationContext, getString(R.string.grado_escolaridad), Toast.LENGTH_LONG).show()
    }

    }
