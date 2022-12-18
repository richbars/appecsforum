package br.com.alura.forum.service

import br.com.alura.forum.dto.NovoTopicoDTO
import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import java.util.*
import kotlin.collections.ArrayList

@Service
class TopicoService(private var sanduba: List<Topico> = ArrayList(), private val cursoService: CursoService, private val usuarioService: UsuarioService) {

    fun list(): List<Topico> {
        return sanduba
    }

    fun searchID(id: Long): Topico {
        return sanduba.stream().filter({
            t -> t.id == id
        }).findFirst().get()
    }

    fun register(dto: NovoTopicoDTO){
        sanduba = sanduba.plus(Topico(
            id = sanduba.size.toLong() + 1,
            title = dto.title,
            message = dto.message,
            course = cursoService.searchforID(dto.idCurso),
            author = usuarioService.searchforID(dto.idAuthor)
            )
        )
    }
}

