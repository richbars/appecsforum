package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(var usuarios: List<Usuario>) {




    init{
        val usuario = Usuario(
            id = 1,
            name = "Richard Santos",
            email = "richard.santos@email.com"
        )
        usuarios = Arrays.asList(usuario)
    }

    fun searchforID(id: Long): Usuario {
        return usuarios.stream().filter({
                c -> c.id == id
        }).findFirst().get()
    }

}
