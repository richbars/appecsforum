package br.com.alura.forum.dto

data class NovoTopicoForm(
    val title: String,
    val message: String,
    val idCurso: Long,
    val idAuthor: Long
)