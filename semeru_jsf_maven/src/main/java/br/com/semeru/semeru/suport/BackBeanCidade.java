package br.com.semeru.semeru.suport;

import br.com.semeru.semeru.entities.Cidade;
import br.com.semeru.semeru.model.dao.HibernateDAO;
import br.com.semeru.semeru.model.dao.InterfaceDAO;
import br.com.semeru.semeru.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="cidade")
@RequestScoped
public class BackBeanCidade implements Serializable {
    
    private static long serialVersionUID = 1L;
    
    private InterfaceDAO<Cidade> getCidadeDAO(){
        return new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
    }
    
    public List<Cidade> getCidades(){
        return getCidadeDAO().getEntities();
    }
    
}
