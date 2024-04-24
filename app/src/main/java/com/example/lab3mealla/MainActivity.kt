package com.example.lab3mealla
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val personasList = mutableListOf(
            Persona("JOSE", "MORALES", "2313526"),
            Persona("MARIA", "FERNANDEZ", "2343551"),
            Persona("ELENA", "PEÑA", "2343559"),
            Persona("ADOLFO", "CHOQUE", "2343557"),
            Persona("RENE", "PEREZ", "2343554"),
            Persona("WENDY", "JIMENEZ", "2343552"),
            Persona("JHONNY", "COLQUE", "2341556")
        )
        val listView = findViewById<ListView>(R.id.listView)
        listView.choiceMode = ListView.CHOICE_MODE_MULTIPLE  // Habilitar selección múltiple
       // val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, personasList)
        //val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, personasList)
        val arrayAdapter = PersonasAdapter(this, personasList)
        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            // Construir un mensaje mostrando todos los elementos seleccionados
            val checked = listView.checkedItemPositions
            val selectedItems = StringBuilder("Seleccionados:\n")
            for (i in 0 until arrayAdapter.count) {
                if (checked[i]) {
                    val p = arrayAdapter.getItem(i)
                    selectedItems.append(p?.nombre).append("\n")
                }
            }
            Toast.makeText(this, selectedItems.toString(), Toast.LENGTH_LONG).show()
        }
    }
}
