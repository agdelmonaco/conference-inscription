package clouding.conference.inscription.DAOHibernate;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import clouding.conference.inscription.DAO.InscriptionDAO;
import clouding.conference.inscription.model.Inscription;

public class InscriptionDAOHibernateJPA extends GenericDAOHibernateJPA<Inscription> implements InscriptionDAO{

	public InscriptionDAOHibernateJPA(Class<Inscription> type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public List<Inscription> listAllInscription() {
		Query consult = this.entityManager.createQuery("SELECT e  FROM Inscription e ");
		consult.setParameter("date", Calendar.getInstance());
		List<Inscription> results = (List<Inscription>)consult.getResultList();
		return results;
		
	}

}
