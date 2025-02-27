package org.registro;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "autor")
public class Autor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long codigo;

    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;

    public Autor() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                '}';
    }
}
