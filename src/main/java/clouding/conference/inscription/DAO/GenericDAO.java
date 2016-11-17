package clouding.conference.inscription.DAO;

import java.io.Serializable;

public interface GenericDAO <T>{

	public T insertElement(T element);
	public void deleteElement(T element);
	public T updateElement(T element);
	public T getElement(Serializable id);
	public T deleteElement(Serializable id);
	public Boolean existElement(Serializable id);

}
