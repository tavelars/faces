package br.com.semeru.semeru.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "SEXO")
public class Sexo implements Serializable {

    public Sexo() {
    }
    private static long serialVersionUID;
    @Id
    @GeneratedValue
    @Column(name = "ID_SEXO")
    private Integer idSexo;
    @Column(name = "DESCRICAO", nullable = false, unique = true, length = 9)
    private String descricao;
    @OneToMany(mappedBy = "SEXO", fetch = FetchType.LAZY)
    @ForeignKey(name = "PESSOA_SEXO")
    private List<Pessoa> pessoas;

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
        
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.idSexo != null ? this.idSexo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sexo other = (Sexo) obj;
        if (this.idSexo != other.idSexo && (this.idSexo == null || !this.idSexo.equals(other.idSexo))) {
            return false;
        }
        return true;
    }
}
