package br.com.alura.forum.controller

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.model.Topico
import br.com.alura.forum.service.TopicoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
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
    fun register(@RequestBody @Valid form: NovoTopicoForm, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoView> {
        val topicoView = service.register(form)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }
    @PutMapping
    fun update(@RequestBody form: AtualizacaoTopicoForm): ResponseEntity<TopicoView>{
        val topicoView = service.update(form)
        return ResponseEntity.ok(topicoView)

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long){
        service.delete(id)

    }
}
