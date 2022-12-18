package br.com.alura.forum.model

import java.time.LocalDate
import java.time.LocalDateTime

data class Topico(
    val id: Long? = null,
    val title: String,
    val message: String,
    val dataCreate: LocalDateTime = LocalDateTime.now(),
    val course: Curso,
    val author: Usuario,
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val responses: List<Resposta> = ArrayList()
)