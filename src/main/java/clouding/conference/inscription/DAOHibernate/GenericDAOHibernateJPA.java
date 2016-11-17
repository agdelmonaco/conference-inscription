package clouding.conference.inscription.DAOHibernate;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import clouding.conference.inscription.DAO.GenericDAO;


public abstract class GenericDAOHibernateJPA <T> implements GenericDAO <T>  {

	//Attributes
	private Class<T> type ;
	
	
	protected EntityManager entityManager;

	
	//Constructors
	
	public GenericDAOHibernateJPA(Class<T> type){
		super();
		this.setType(type);
		
	}
	
	//Getters
	
	public Class<T> getType(){
		return this.type;
	}
	
	//Setters
	
	public void setType(Class<T> type){
		this.type = type;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.entityManager = em;
	}
	
	
	//Methods
	@Transactional
	public T insertElement(T entity){
		
		this.entityManager.persist(entity);
		return entity;
	}
	
	@Transactional
	public void deleteElement(T entity){
		this.entityManager.remove(entity);		
	}
	
	@Transactional
	public T deleteElement(Serializable id) {
		T entity = this.entityManager.find(this.getType(), id);
		if(entity != null){
			this.deleteElement(entity);
		}
		return entity;
	}
	
	@Transactional
	public T updateElement(T element){
		T entity = this.entityManager.merge(element);		
		return entity;
		
	}
	
	@Transactional
	public T getElement(Serializable id){
		T entity = this.entityManager.find(this.getType(), id);
		return entity;		
	}	

	@Transactional
	public Boolean existElement(Serializable id) {
		T entity = this.entityManager.find(this.getType(), id);
		return (entity != null);
	}
	
	@Transactional
	public List<T> listAll(){
		
		Query consult = this.entityManager.createQuery("SELECT e  FROM " + this.getType().getSimpleName()+ " e");
		List<T> result = (List<T>)consult.getResultList();
		return result;
	
	}
