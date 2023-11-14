package com.alunoonline.api.service;

import com.alunoonline.api.Dto.PatchNotasRequest;
import com.alunoonline.api.model.MatriculaAluno;
import com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatriculaAlunoService {

    @Autowired
    MatriculaAlunoRepository repository;

    public void create(MatriculaAluno matriculaAluno){
        matriculaAluno.setStatus("MATRICULADO");
        repository.save(matriculaAluno);
    }

    public void MarkPatchMaker(Long id, PatchNotasRequest patchNotasRequest){
        Optional<MatriculaAluno> matriculaAluno = repository.findById(id);

        MatriculaAluno matriculaUpadated = matriculaAluno.get();

        matriculaUpadated.setNota1(patchNotasRequest.getNota1());
        matriculaUpadated.setNota2(patchNotasRequest.getNota2());

        Double media = matriculaUpadated.getNota1() + matriculaUpadated.getNota2() / 2;

        Double mediaParaAprovacao = 7.0;

        if (media >= mediaParaAprovacao){
            matriculaUpadated.setStatus("APROVADO");
        }else{
            matriculaUpadated.setStatus("REPROVADO");
        }

        repository.save(matriculaUpadated);
    }
}
