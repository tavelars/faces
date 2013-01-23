package br.com.semeru.semeru.suport;

import br.com.semeru.semeru.entities.Sexo;
import br.com.semeru.semeru.model.dao.HibernateDAO;
import br.com.semeru.semeru.model.dao.InterfaceDAO;
import br.com.semeru.semeru.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bbSexo")
@RequestScoped
public class BackBeanSexo implements Serializable {
    
    private static long serialVersionUID = 1L;
    
    private InterfaceDAO<Sexo> getSexoDAO(){
        return new HibernateDAO<Sexo>(Sexo.class, FacesContextUtil.getRequestSession());
    }
    
    public List<Sexo> getSexos(){
        return getSexoDAO().getEntities();
    }
    
}
