package br.com.alura.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import jakarta.*

data class AtualizacaoTopicoForm(
    @field:NotEmpty var id: Long,
    @field:NotEmpty @field:Size(min = 10, max = 100) val title: String,
    @field:NotEmpty @field:Size(min = 5, max = 300)val message: String,
)