package com.challenge_kotlin.labs08_idnp_roomdatabase.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.challenge_kotlin.labs08_idnp_roomdatabase.R

class UsuarioAdapter(
    private val usuario: List<Usuario>,
    private val onEditClick: (Usuario) -> Unit,
    private val onDeleteClick: (Usuario) -> Unit
) : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_list, parent, false)
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuario[position]
        holder.bind(usuario)
    }

    override fun getItemCount(): Int = usuario.size

    inner class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userName: TextView = itemView.findViewById(R.id.userName)
        private val editButton: ImageButton = itemView.findViewById(R.id.editButton)
        private val deleteButton: ImageButton = itemView.findViewById(R.id.deleteButton)

        fun bind(usuario: Usuario) {
            userName.text = usuario.name

            editButton.setOnClickListener { onEditClick(usuario) }
            deleteButton.setOnClickListener { onDeleteClick(usuario) }
        }
    }
}
