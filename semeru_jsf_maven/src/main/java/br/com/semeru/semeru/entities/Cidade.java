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
@Table(name="CIDADE")
public class Cidade implements Serializable{

    public Cidade() {
    }
        
    private static long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "ID_CIDADE", nullable=false)
    private Integer idCidade;
    
    @Column(name = "DESCRICAO", nullable = false, unique = true, length = 150)
    private String descricao;
   
    @OneToMany(mappedBy="cidade", fetch=FetchType.LAZY)
    @ForeignKey(name="END_CIDADE")
    private List<Endereco> enderecos;
    

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + (this.idCidade != null ? this.idCidade.hashCode() : 0);
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
        final Cidade other = (Cidade) obj;
        if (this.idCidade != other.idCidade && (this.idCidade == null || !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Cidade.serialVersionUID = serialVersionUID;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
           
}
