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
@Table(name = "ESTADO")
public class Estado implements Serializable {

    public Estado() {
    }
    private static long serialVersionUID  = 1L;
    @Id
    @GeneratedValue
    @Column(name = "ID_ESTADO")
    private Integer idEstado;
    @Column(name = "DESCRICAO", nullable = false, unique = true, length = 500)
    private String descricao;
    
    @OneToMany(mappedBy="estado", fetch=FetchType.LAZY)
    @ForeignKey(name="ENDERECO_ESTADO")
    private List<Endereco> enderecos;
    

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Estado.serialVersionUID = serialVersionUID;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.idEstado != null ? this.idEstado.hashCode() : 0);
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
        final Estado other = (Estado) obj;
        if (this.idEstado != other.idEstado && (this.idEstado == null || !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }
    
    
}
