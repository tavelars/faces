package br.com.semeru.semeru.suport;

import br.com.semeru.semeru.entities.TipoEndereco;
import br.com.semeru.semeru.model.dao.HibernateDAO;
import br.com.semeru.semeru.model.dao.InterfaceDAO;
import br.com.semeru.semeru.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bbTipoEndereco")
@RequestScoped
public class BackBeanTipoEndereco implements Serializable {
    
    private static long serialVersionUID = 1L;
    
    private InterfaceDAO<TipoEndereco> getTipoEnderecoDAO(){
        return new HibernateDAO<TipoEndereco>(TipoEndereco.class, FacesContextUtil.getRequestSession());
    }
    
    public List<TipoEndereco> getTipoEnderecos(){
        return getTipoEnderecoDAO().getEntities();
    }
    
}
