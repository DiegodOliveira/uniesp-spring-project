package com.alunoonline.api.controler;

import com.alunoonline.api.Dto.PatchNotasRequest;
import com.alunoonline.api.model.MatriculaAluno;
import com.alunoonline.api.service.MatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula-aluno")
public class MatriculaAlunoController {

    @Autowired
    MatriculaAlunoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody MatriculaAluno matriculaAluno){
        service.create(matriculaAluno);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchNotas(
            @RequestBody PatchNotasRequest patchNotasRequest,
            @PathVariable Long id
            ){
        service.MarkPatchMaker(id, patchNotasRequest);
    }

    @PatchMapping("matricula/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setStatusParaTrancado(Long id){
        service.patchStatusParaTrancado(id);
    }
}
