package com.alunoonline.api.Dto;

import com.alunoonline.api.model.Aluno;

public class AlunoView {
    private Long id;
    private String nome;
    private String email;

    public AlunoView(Long id, String nome, String email){
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

    public  AlunoView(Aluno aluno){
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
    }
}
