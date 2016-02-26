package functionality;
import java.util.List;

import data.IOperatoerDTO;

public interface IOperatoerDAO {
		class DALException extends Exception
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = -1718710227140187189L;

			public DALException(String desc)
			{
				super(desc);
			}
		}
	    IOperatoerDTO getOperatoer(int oprId) throws DALException;
	    List<IOperatoerDTO> getOperatoerList() throws DALException;
	    void createOperatoer(IOperatoerDTO opr) throws DALException;
	    void updateOperatoer(IOperatoerDTO opr) throws DALException;
	    void deleteOperatoer(IOperatoerDTO opr) throws DALException;
}
