package br.com.alura.forum.service

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(private var sanduba: List<Topico> = ArrayList(), private val topicoViewMapper: TopicoViewMapper, private val topicoFormMapper: TopicoFormMapper) {

    fun list(): List<TopicoView> {
        return sanduba.stream().map { t -> topicoViewMapper.map(t) }.collect(Collectors.toList())
    }

    fun searchID(id: Long): Topico {
        return sanduba.stream().filter({
            t -> t.id == id
        }).findFirst().get()
    }

    fun register(form: NovoTopicoForm): TopicoView{

        val sabb = topicoFormMapper.map(form)
        sabb.id = sanduba.size.toLong() + 1
        sanduba = sanduba.plus(sabb)
        return topicoViewMapper.map(sabb)
    }

    fun update(form: AtualizacaoTopicoForm): TopicoView{
        val sandubinha = sanduba.stream().filter({
                t -> t.id == form.id
        }).findFirst().get()
        val topicoAtualizado = Topico(
            id = form.id,
            title = form.title,
            message = form.message,
            author = sandubinha.author,
            course = sandubinha.course,
            responses = sandubinha.responses,
            status = sandubinha.status,
            dataCreate = sandubinha.dataCreate)
        sanduba = sanduba.minus(sandubinha).plus(topicoAtualizado)
        return topicoViewMapper.map(topicoAtualizado)
    }

    fun delete(id: Long) {
        val sandubinha = sanduba.stream().filter({
                t -> t.id == id
        }).findFirst().get()
        sanduba = sanduba.minus(sandubinha)
    }
}

