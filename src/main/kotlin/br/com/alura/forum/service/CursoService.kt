package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(var cursos: List<Curso>) {
    init{
        val curso = Curso(
            id = 1,
            name = "Kotlin",
            category = "Programação"
        )
        val curso2 = Curso(
            id = 2,
            name = "HTML e CSS",
            category = "FrontEnd"
        )

        cursos = Arrays.asList(curso, curso2)
    }

    fun searchforID(id: Long): Curso {
        return cursos.stream().filter({
            c -> c.id == id
        }).findFirst().get()
    }
}
