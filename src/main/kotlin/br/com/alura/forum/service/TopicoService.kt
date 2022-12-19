package br.com.alura.forum.service

import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(private var sanduba: List<Topico> = ArrayList(), private val cursoService: CursoService, private val usuarioService: UsuarioService) {

    fun list(): List<TopicoView> {
        return sanduba.stream().map { t -> TopicoView(
            id = t.id,
            title = t.title,
            message = t.message,
            status = t.status,
            dataCreate = t.dataCreate
        ) }.collect(Collectors.toList())
    }

    fun searchID(id: Long): Topico {
        return sanduba.stream().filter({
            t -> t.id == id
        }).findFirst().get()
    }

    fun register(dto: NovoTopicoForm){
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

