package com.alunoonline.api.service;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    AlunoRepository repository;
    // Buscar o aluno no pacote model
    public Aluno create(Aluno aluno){
        return repository.save(aluno);
    }

    public List<Aluno> findAll(){
        return repository.findAll();
    }

    public Optional<Aluno> findById(Long id){
        return repository.findById(id);
    }

    public void patch(Long alunoId, String novoEmail){
        Optional<Aluno> alunoAserEditado = repository.findById(alunoId);
        alunoAserEditado.get().setEmail(novoEmail);
        repository.save(alunoAserEditado.get());
    }

    public void patchNome(Long alunoId, String novoNome){
        Optional<Aluno> nomeAserEditado = repository.findById(alunoId);
        nomeAserEditado.get().setNome(novoNome);
        repository.save(nomeAserEditado.get());
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
