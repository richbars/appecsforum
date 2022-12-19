package br.com.alura.forum.dto

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.model.StatusTopico
import java.time.LocalDateTime

data class TopicoView(
    val id: Long?,
    val title: String,
    val message: String,
    val status: StatusTopico,
    val dataCreate: String
    )
