package org.example.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_COMPUTADOR")
public class Computador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cpu_seq")
    @SequenceGenerator(name = "cpu_seq", sequenceName = "cpu_seq", allocationSize = 1)
    private Long id;

    @Column(name = "codigo", unique = true, nullable = false)
    private String codigo;

    @Column(name = "descricao", unique = true, nullable = false)
    private String descricao;

    @ManyToMany(mappedBy = "computadores")
    private List<Aluno> alunos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
