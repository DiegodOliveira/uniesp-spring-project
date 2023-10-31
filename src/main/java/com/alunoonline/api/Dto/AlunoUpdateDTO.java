package com.alunoonline.api.Dto;

import com.alunoonline.api.model.Aluno;

public class AlunoUpdateDTO {
    private Long id;
    private String nome;
    private String email;

    public AlunoUpdateDTO(Long id, String nome, String email){
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Aluno toEntity(Aluno aluno){
        aluno.setId(this.id);
        aluno.setNome(this.nome);
        aluno.setEmail(this.email);
        return aluno;
    }
}
