package br.com.alura.forum.model

import java.time.LocalDateTime

data class Resposta(
    val id: Long?,
    val message: String,
    val dataCreate: LocalDateTime = LocalDateTime.now(),
    val author: Usuario,
    val topico: Topico,
    val solution: Boolean
)
