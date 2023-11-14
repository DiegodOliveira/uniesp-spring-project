package com.alunoonline.api.service;

import com.alunoonline.api.model.Professor;
import com.alunoonline.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository repository;

   public Professor create(Professor professor){
       return repository.save(professor);
   }

   public List<Professor> findAll(){
       repository.findAll();
       return repository.findAll();

   }

   public Optional<Professor> findById(Long id){
       return repository.findById(id);
   }

   public void patch(Long professorId, String novoEmail){
       Optional<Professor> professorAserEditado = repository.findById(professorId);
       professorAserEditado.get().setEmail(novoEmail);
       repository.save(professorAserEditado.get());
   }

   public void patchNome(Long professorId, String novoNome){
       Optional<Professor> NomeAserEditado = repository.findById(professorId);
       NomeAserEditado.get().setNome(novoNome);
       repository.save(NomeAserEditado.get());
   }

   public void delete(Long id){
       repository.deleteById(id);
   }


}
