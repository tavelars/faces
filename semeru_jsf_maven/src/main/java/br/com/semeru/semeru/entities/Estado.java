package br.com.semeru.semeru.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADO")
public class Estado implements Serializable {

    public Estado() {
    }
    private static long serialVersionUID;
    @Id
    @GeneratedValue
    @Column(name = "ID_ESTADO")
    private Integer idEstado;
    @Column(name = "DESCRICAO", nullable = false, unique = true, length = 500)
    private String descricao;

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
