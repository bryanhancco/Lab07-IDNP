package com.challenge_kotlin.labs08_idnp_roomdatabase.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.challenge_kotlin.labs08_idnp_roomdatabase.R
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.AppDatabase
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.dao.UsuarioDAO
import com.challenge_kotlin.labs08_idnp_roomdatabase.database.model.UsuarioModel
import kotlinx.coroutines.launch

class UsuarioFragment : Fragment(R.layout.fragment_user) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var usuarioAdapter: UsuarioAdapter
    private val usuarios = mutableListOf<Usuario>()
    private lateinit var createUserButton: Button

    private lateinit var usuarioDAO: UsuarioDAO

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usuarioDAO = AppDatabase.getDatabase(requireContext()).usuarioDAO()

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        createUserButton = view.findViewById(R.id.createUserButton)
        createUserButton.setOnClickListener {
            showCreateUserDialog()
        }

        loadUsuarios()
    }

    private fun loadUsuarios() {
        lifecycleScope.launch {
            val usuariosList = usuarioDAO.getAllUsuarios()
            usuarios.clear()
            usuarios.addAll(usuariosList.map { usuario ->
                transformToUsuarioList(usuario)
            })

            if (::usuarioAdapter.isInitialized) {
                usuarioAdapter.notifyDataSetChanged()
            } else {
                usuarioAdapter = UsuarioAdapter(usuarios, { usuario ->
                    editUsuario(usuario)
                }, { usuario ->
                    deleteUsuario(usuario)
                })
                recyclerView.adapter = usuarioAdapter
            }
        }
    }

    private fun editUsuario(usuario: Usuario) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Editar Usuario")

        val layout = LinearLayout(requireContext())
        layout.orientation = LinearLayout.VERTICAL

        val nameInput = EditText(requireContext())
        nameInput.hint = "Nombre"
        nameInput.setText(usuario.name)
        val usernameInput = EditText(requireContext())
        usernameInput.hint = "Nombre de Usuario"
        usernameInput.setText(usuario.username)
        val passwordInput = EditText(requireContext())
        passwordInput.hint = "Contraseña"
        passwordInput.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        passwordInput.setText(usuario.password)

        layout.addView(nameInput)
        layout.addView(usernameInput)
        layout.addView(passwordInput)

        builder.setView(layout)

        builder.setPositiveButton("Guardar") { _, _ ->
            val name = nameInput.text.toString()
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (name.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {
                val updatedUser = Usuario(usuario.id, name, username, password)

                lifecycleScope.launch {
                    usuarioDAO.updateUsuario(transformToUsuarioModel(updatedUser))

                    val index = usuarios.indexOfFirst { it.id == usuario.id }
                    if (index != -1) {
                        usuarios[index] = updatedUser
                        usuarioAdapter.notifyItemChanged(index)
                        Toast.makeText(requireContext(), "Usuario actualizado", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(requireContext(), "Por favor ingresa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        builder.setNegativeButton("Cancelar", null)

        builder.show()
    }


    private fun deleteUsuario(usuario: Usuario) {
        lifecycleScope.launch {
            usuarioDAO.deleteUsuario(transformToUsuarioModel(usuario))
            usuarios.remove(usuario)
            usuarioAdapter.notifyDataSetChanged()
            Toast.makeText(requireContext(), "Usuario eliminado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showCreateUserDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Crear Usuario")

        val layout = LinearLayout(requireContext())
        layout.orientation = LinearLayout.VERTICAL
        val nameInput = EditText(requireContext())
        nameInput.hint = "Nombre"
        val usernameInput = EditText(requireContext())
        usernameInput.hint = "Nombre de Usuario"
        val passwordInput = EditText(requireContext())
        passwordInput.hint = "Contraseña"
        passwordInput.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD // Ocultar texto

        layout.addView(nameInput)
        layout.addView(usernameInput)
        layout.addView(passwordInput)

        builder.setView(layout)

        builder.setPositiveButton("Crear") { _, _ ->
            val name = nameInput.text.toString()
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (name.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {
                val newUser = Usuario(usuarios.size.toLong() + 1, name, username, password)

                lifecycleScope.launch {
                    usuarioDAO.insertUsuario(transformToUsuarioModel(newUser))
                    usuarios.add(newUser)
                    usuarioAdapter.notifyDataSetChanged()
                    Toast.makeText(requireContext(), "Usuario creado", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Por favor ingresa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        builder.setNegativeButton("Cancelar", null)
        builder.show()
    }
}
private fun transformToUsuarioModel(usuario: Usuario): UsuarioModel {
    return UsuarioModel(
        username = usuario.username,
        usuarioId = usuario.id,
        name = usuario.name,
        password = usuario.password
    )
}
private fun transformToUsuarioList(usuario: UsuarioModel): Usuario {
    return Usuario(
        id = usuario.usuarioId,
        name = usuario.name,
        username = usuario.username,
        password = usuario.password
    )
}

