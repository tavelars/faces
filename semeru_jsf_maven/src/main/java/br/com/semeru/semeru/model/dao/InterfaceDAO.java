package br.com.semeru.semeru.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

public interface InterfaceDAO<T> {
    
    public void save(T entity);
    public void update(T entity);
    public void remove(T entity);
    public void merge(T entity);
    public T getEntity(Serializable id);
    public T getEntityByDetachedCriteria(DetachedCriteria criteria);
    public List<T> getEntities();
    public List<T> getListByDetachedCriteria(DetachedCriteria criteria);
}
