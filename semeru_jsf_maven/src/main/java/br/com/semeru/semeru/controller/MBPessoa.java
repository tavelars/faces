package br.com.semeru.semeru.controller;

import br.com.semeru.semeru.entities.Endereco;
import br.com.semeru.semeru.entities.Pessoa;
import br.com.semeru.semeru.model.dao.HibernateDAO;
import br.com.semeru.semeru.model.dao.InterfaceDAO;
import br.com.semeru.semeru.util.FacesContextUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "mbPessoa")
@SessionScoped
public class MBPessoa implements Serializable {

    private Pessoa pessoa = new Pessoa();
    private Endereco endereco = new Endereco();
    private List<Pessoa> pessoas = new ArrayList<Pessoa>();
    private List<Endereco> enderecos = new ArrayList<Endereco>();
    private static long serialVersionUID = 1L;

    public MBPessoa() {
    }

    private InterfaceDAO<Pessoa> getPessoaDAO() {
        InterfaceDAO<Pessoa> pessoaDAO =
                new HibernateDAO<Pessoa>(Pessoa.class,
                FacesContextUtil.getRequestSession());
        return pessoaDAO;
    }

    private InterfaceDAO<Endereco> getEnderecoDAO() {
        InterfaceDAO<Endereco> enderecoDAO =
                new HibernateDAO<Endereco>(Endereco.class,
                FacesContextUtil.getRequestSession());
        return enderecoDAO;
    }

    private String refreshPessoa() {
        this.endereco = new Endereco();
        this.pessoa = new Pessoa();
        return editarPessoa();
    }

    private String editarPessoa() {
        return "//restrict/cadastrarPessoa.faces";
    }

    public String addPessoa() {
        if (pessoa.getIdPessoa() == null || pessoa.getIdPessoa() == 0) {
            insertPessoa();
        } else {
            updatePessoa();
        }
        refreshPessoa();
        return null;
    }

    private void insertPessoa() {
        getPessoaDAO().save(pessoa);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }

    private void updatePessoa() {
        getPessoaDAO().update(pessoa);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }

    public void deletePessoa() {
        getPessoaDAO().remove(pessoa);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
    }
}