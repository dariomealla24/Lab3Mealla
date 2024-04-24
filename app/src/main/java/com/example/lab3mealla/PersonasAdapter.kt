package com.example.lab3mealla

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class PersonasAdapter(context: Context, personasList: List<Persona>) : ArrayAdapter<Persona>(context, 0, personasList) {
    private val ctx: Context = context
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertViewLocal = convertView
        if (convertViewLocal == null) {
            convertViewLocal = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        }
        val img = convertViewLocal!!.findViewById<ImageView>(R.id.imagenPerfil)
        val p = getItem(position)
        Glide.with(ctx)
            .load(p?.imagen)
            .centerCrop()
            .placeholder(R.drawable.usuarioicono)
            .into(img)
        val txtNombre = convertViewLocal.findViewById<TextView>(R.id.txtNombre)
        txtNombre.text = "${p?.nombre} ${p?.apellido}"
        val txtCelular = convertViewLocal.findViewById<TextView>(R.id.txtCelular)
        txtCelular.text = p?.telefono
        return convertViewLocal
    }
}
