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
@Table(name="TIPO_ENDERECO")
public class TipoEndereco implements Serializable {

    public TipoEndereco() {
    }
          
    private static long serialVersionUID  = 1L;
    @Id
    @GeneratedValue
    @Column(name = "ID_TIPO_ENDERECO")
    private Integer idTipoEndereco;
    
    @Column(name = "DESCRICAO", nullable = false, unique = true, length = 150)
    private String descricao;
    
    @OneToMany(mappedBy="TIPO_ENDERECO", fetch=FetchType.LAZY)
    @ForeignKey(name="TIPO_END_ENDERECO")
    private List<Endereco> enderecos;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        TipoEndereco.serialVersionUID = serialVersionUID;
    }

    public Integer getIdTipoEndereco() {
        return idTipoEndereco;
    }

    public void setIdTipoEndereco(Integer idTipoEndereco) {
        this.idTipoEndereco = idTipoEndereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.idTipoEndereco != null ? this.idTipoEndereco.hashCode() : 0);
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
        final TipoEndereco other = (TipoEndereco) obj;
        if (this.idTipoEndereco != other.idTipoEndereco && (this.idTipoEndereco == null || !this.idTipoEndereco.equals(other.idTipoEndereco))) {
            return false;
        }
        return true;
    }
       
    
    
}
