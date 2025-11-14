package org.example.domain;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "TB_ALUNO")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alu_seq")
    @SequenceGenerator(name = "alu_seq", sequenceName = "alu_seq", allocationSize = 1)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "codigo", nullable = false, unique = true)
    private String codigo;

    @OneToOne(mappedBy = "aluno")
    private Matricula matricula;

    @ManyToMany
    @JoinTable(name = "TB_ALUNO_CPU", joinColumns = {
            @JoinColumn(name = "aluno_id", referencedColumnName = "id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "cpu_id", referencedColumnName = "id")
    })
    private List<Computador> computadores;

    public Aluno() {
        this.id = null;
        this.computadores = new ArrayList<>();
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Collection<Computador> getComputadores() {
        return computadores;
    }

    public void setComputadores(List<Computador> computadores) {
        this.computadores = computadores;
    }

    public void add(Computador comp) {
        this.computadores.add(comp);
    }
}
