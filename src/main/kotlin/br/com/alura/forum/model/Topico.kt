package br.com.alura.forum.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
val current = LocalDateTime.now()
val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
data class Topico(
    var id: Long? = null,
    val title: String,
    val message: String,
    val dataCreate: String = current.format(formatter),
    val course: Curso,
    val author: Usuario,
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val responses: List<Resposta> = ArrayList()
)