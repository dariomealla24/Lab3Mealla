package com.example.lab3mealla

data class Persona(
    var nombre: String? = null,
    var apellido: String? = null,
    var telefono: String? = null,
    var imagen: String? = null
) {
    constructor(nombre: String, apellido: String, telefono: String) : this(nombre, apellido, telefono, null)
    override fun toString(): String {
        return nombre ?: ""
    }
}

