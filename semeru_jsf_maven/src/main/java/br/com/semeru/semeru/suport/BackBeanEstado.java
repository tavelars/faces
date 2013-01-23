package br.com.semeru.semeru.suport;

import br.com.semeru.semeru.entities.Estado;
import br.com.semeru.semeru.model.dao.HibernateDAO;
import br.com.semeru.semeru.model.dao.InterfaceDAO;
import br.com.semeru.semeru.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bbEstado")
@RequestScoped
public class BackBeanEstado implements Serializable {
    
    private static long serialVersionUID = 1L;
    
    private InterfaceDAO<Estado> getEstadoDAO(){
        return new HibernateDAO<Estado>(Estado.class, FacesContextUtil.getRequestSession());
    }
    
    public List<Estado> getEstados(){
        return getEstadoDAO().getEntities();
    }
    
}
