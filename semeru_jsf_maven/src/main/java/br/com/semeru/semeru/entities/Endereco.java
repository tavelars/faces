package br.com.semeru.semeru.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "ENDERECO")
public class Endereco implements Serializable {
    
    public Endereco() {
    }
    
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name="ID_ENDERECO", nullable=false)
    private Integer idEndereco;
    
    @Column(name="BAIRRO", length=80)
    private String bairro;
    
    @Column(name="NOME_LOGRADOURO", length=150, nullable=false)
    private String nomeLogradouro;
    
    @Column(name="CEP", nullable=false, length=9)
    private String cep;
    
    @Column(name="NUMERO", nullable=false)
    private Integer numero;
    
    @Column(name="COMPLEMENTO", nullable=false, length=50)
    private String complemento;
    
    @OneToOne(optional=true, fetch= FetchType.LAZY)
    @ForeignKey(name="PESSOA_ENDERECO")
    @JoinColumn(name="ID_PESSOA", referencedColumnName="ID_PESSOA")
    private Pessoa pessoa;
    
    @ManyToOne(optional=false, fetch= FetchType.LAZY)
    @ForeignKey(name="ENDERECO_TIPO_LOGR")
    @JoinColumn(name="ID_TIPO_LOGRADOURO", referencedColumnName="ID_TIPO_LOGRADOURO")
    private TipoLogradouro tipoLogradouro;
    
    @ManyToOne(optional=false, fetch= FetchType.LAZY)
    @ForeignKey(name="ENDERECO_CIDADE")
    @JoinColumn(name="ID_CIDADE", referencedColumnName="ID_CIDADE")
    private Cidade cidade;
    
    @ManyToOne(optional=false, fetch= FetchType.LAZY)
    @ForeignKey(name="ENDERECO_ESTADO")
    @JoinColumn(name="ID_ESTADO", referencedColumnName="ID_ESTADO")
    private Cidade estado;
    
    @ManyToOne(optional=false, fetch= FetchType.LAZY)
    @ForeignKey(name="ENDERECO_TIPO_END")
    @JoinColumn(name="ID_TIPO_ENDERECO", referencedColumnName="ID_TIPO_ENDERECO")
    private Cidade tipoEndereco;
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Endereco.serialVersionUID = serialVersionUID;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Cidade getEstado() {
        return estado;
    }

    public void setEstado(Cidade estado) {
        this.estado = estado;
    }

    public Cidade getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(Cidade tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.idEndereco != null ? this.idEndereco.hashCode() : 0);
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
        final Endereco other = (Endereco) obj;
        if (this.idEndereco != other.idEndereco && (this.idEndereco == null || !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }
    
    
    
    
}
