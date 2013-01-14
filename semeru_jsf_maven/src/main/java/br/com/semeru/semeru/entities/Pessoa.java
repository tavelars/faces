package br.com.semeru.semeru.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

    public Pessoa() {
    }
    private static long serialVersionUID;
    @Id
    @GeneratedValue
    @Column(name = "ID_PESSOA", nullable = false)
    private Integer idPessoa;
    @Column(name = "NOME", nullable = false, length = 200)
    private String nome;
    @Column(name = "EMAIL", nullable = false, length = 200)
    private String email;
    @Column(name = "TELEFONE", nullable = false, length = 15)
    private String telefone;
    @Column(name = "CPF", nullable = false, length = 12)
    private String cpf;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private Date dataNascimento;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_CADASTRO", nullable = false)
    private Date dataCadastro;

    @ManyToOne(optional=false)
    @ForeignKey(name="PESSOA_SEXO")
    private Pessoa pessoa;
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Pessoa.serialVersionUID = serialVersionUID;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
        
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.idPessoa != null ? this.idPessoa.hashCode() : 0);
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
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa && (this.idPessoa == null || !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }
}