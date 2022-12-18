package br.com.alura.forum.controller

import br.com.alura.forum.dto.NovoTopicoDTO
import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import br.com.alura.forum.service.TopicoService
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Retry.Topic
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun list(): List<Topico> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun searchID(@PathVariable id: Long): Topico {
        return service.searchID(id)
    }

    @PostMapping
    fun register(@RequestBody dto: NovoTopicoDTO) {
        service.register(dto)
    }
}
