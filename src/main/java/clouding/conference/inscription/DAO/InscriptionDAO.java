package clouding.conference.inscription.DAO;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import clouding.conference.inscription.model.Inscription;

public interface InscriptionDAO {

	public Inscription insertElement(Inscription element);
	public void deleteElement(Inscription element);
	public Inscription updateElement(Inscription element);
	public Inscription getElement(Serializable id);
	public Inscription deleteElement(Serializable id);
	public Boolean existElement(Serializable id);
	public List<Inscription> listAll();
	public List<Inscription> listAllInscription();
	
}
