package br.gov.pa.prodepa.treinamentos.concursos.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Estado.
 */
@Entity
@Table(name = "estado")
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sigla")
    private String sigla;

    
    public Estado() {
      super();
    }
    
    public Estado(Long id, String nome, String sigla) {
      super();
      this.id = id;
      this.nome = nome;
      this.sigla = sigla;
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

    public Estado nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public Estado sigla(String sigla) {
        this.sigla = sigla;
        return this;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Estado estado = (Estado) o;
        if(estado.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, estado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Estado{" +
            "id=" + id +
            ", nome='" + nome + "'" +
            ", sigla='" + sigla + "'" +
            '}';
    }
}
