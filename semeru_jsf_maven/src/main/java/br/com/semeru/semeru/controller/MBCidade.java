package br.com.semeru.semeru.controller;

import br.com.semeru.semeru.entities.Cidade;
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

@ManagedBean(name = "mbCidade")
@SessionScoped
public class MBCidade implements Serializable {

    public MBCidade() {
    }
    private static long serialVersionUID = 1L;
    private Cidade cidade;
    private List<Cidade> cidades = new ArrayList<Cidade>();

    private InterfaceDAO<Cidade> getCidadeDAO() {
        InterfaceDAO<Cidade> cidadeDAO =
                new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
        return cidadeDAO;
    }

    public String editarCidade() {
        return "//restrict/cadastrar_cidade.faces";
    }

    public String adicionarCidade() {
        if (cidade.getIdCidade() == null || cidade.getIdCidade() == 0) {
            insertCidade();
        } else {
            updateCidade();
        }
        refreshCidades();
        return null;
    }

    public void refreshCidades() {
        cidade = new Cidade();
        //return editarCidade();
    }

    private void insertCidade() {
        getCidadeDAO().save(cidade);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }

    private void updateCidade() {
        getCidadeDAO().update(cidade);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }
    
    public void deleteCidade(){
        getCidadeDAO().remove(cidade);
    }

    public Cidade getCidade() {
        if(cidade == null){
            cidade = new Cidade();
        }
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {
        cidades = getCidadeDAO().getEntities();
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
    
    
    
}
