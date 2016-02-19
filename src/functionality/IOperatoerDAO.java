package functionality;
import java.util.List;

import data.OperatoerDTO;

public interface IOperatoerDAO {
		class DALException extends Exception
		{
			public DALException(String desc)
			{
				super(desc);
			}
		}
	    OperatoerDTO getOperatoer(int oprId) throws DALException;
	    List<OperatoerDTO> getOperatoerList() throws DALException;
	    void createOperatoer(OperatoerDTO opr) throws DALException;
	    void updateOperatoer(OperatoerDTO opr) throws DALException;
	    void deleteOperatoer(OperatoerDTO opr) throws DALException;
}
