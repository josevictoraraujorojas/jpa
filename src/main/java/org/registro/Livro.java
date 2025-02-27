package org.registro;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "livro")
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "lancamento")
    @Temporal(TemporalType.DATE)
    private LocalDate lancamento;

    @Basic
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "editora_id")
    private Editora editora;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "livro_autor",joinColumns = {@JoinColumn(name = "livro_id")},inverseJoinColumns = {@JoinColumn(name = "autor_id")})
    private List<Autor> autores;

    public Livro() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", preco=" + preco +
                ", lancamento=" + lancamento +
                ", editora=" + editora +
                ", autores=" + autores +
                '}';
    }
}
