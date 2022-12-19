package br.com.alura.forum.controller

import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.model.Topico
import br.com.alura.forum.service.TopicoService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun list(): List<TopicoView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun searchID(@PathVariable id: Long): Topico {
        return service.searchID(id)
    }

    @PostMapping
    fun register(@RequestBody dto: NovoTopicoForm) {
        service.register(dto)
    }
}
