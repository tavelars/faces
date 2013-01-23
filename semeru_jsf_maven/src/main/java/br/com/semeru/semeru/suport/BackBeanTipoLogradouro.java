package br.com.semeru.semeru.suport;

import br.com.semeru.semeru.entities.TipoLogradouro;
import br.com.semeru.semeru.model.dao.HibernateDAO;
import br.com.semeru.semeru.model.dao.InterfaceDAO;
import br.com.semeru.semeru.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bbTipoLogradouro")
@RequestScoped
public class BackBeanTipoLogradouro implements Serializable {
    
    private static long serialVersionUID = 1L;
    
    private InterfaceDAO<TipoLogradouro> getTipoLogradouroDAO(){
        return new HibernateDAO<TipoLogradouro>(TipoLogradouro.class, FacesContextUtil.getRequestSession());
    }
    
    public List<TipoLogradouro> getTipoLogradouros(){
        return getTipoLogradouroDAO().getEntities();
    }
    
}
