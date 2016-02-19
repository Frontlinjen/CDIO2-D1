package functionality;

import java.util.List;

import data.IOperatoerDTO;
import data.OperatoerDTO;

public class OperatoerDAOMemory implements IOperatoerDAO{

	private IOperatoerDTO data;
	
	public OperatoerDAOMemory(IOperatoerDTO data){
		this.data = data;
	}
	
	@Override
	public OperatoerDTO getOperatoer(int oprId) throws DALException {
		return null;
	}

	@Override
	public List<OperatoerDTO> getOperatoerList() throws DALException {
		return null;
	}

	@Override
	public void createOperatoer(OperatoerDTO opr) throws DALException {

	}

	@Override
	public void updateOperatoer(OperatoerDTO opr) throws DALException {

	}

	@Override
	public void deleteOperatoer(OperatoerDTO opr) throws DALException {

	}

}
