 package functionality;

import java.util.ArrayList;
import java.util.List;

import data.IOperatoerDTO;

public class OperatoerDAOMemory implements IOperatoerDAO{

	private List<IOperatoerDTO> data = new ArrayList<IOperatoerDTO>();

	
	@Override
	public IOperatoerDTO getOperatoer(int oprId) throws DALException {
		for (IOperatoerDTO operator : data) {
			if(operator.getID()==oprId)
			{
				return operator;
			}
		}
		return null;
	}

	@Override
	public List<IOperatoerDTO> getOperatoerList() throws DALException {
		return data;
	}

	@Override
	public void createOperatoer(IOperatoerDTO opr) throws DALException {
		data.add(opr);
		//Opdaterer ID efter hvor den blev tilføjet til databasen
		if(opr.getID()==-1)
			opr.setID(getAvailableID());
	}
	private int getAvailableID() throws DALException
	{
		for(int i=0;i<Integer.MAX_VALUE;++i)
		{
			if(getOperatoer(i)==null)
			{
				return i;
			}
		}
		throw new DALException("Ran out of available ID's!");
	}
	@Override
	public void updateOperatoer(IOperatoerDTO opr) throws DALException {
		for (int i = 0; i < data.size(); i++) {
			if(opr.getID()==data.get(i).getID())
			{
				data.remove(i);
				data.add(opr);
			}
		}
	}

	@Override
	public void deleteOperatoer(IOperatoerDTO opr) throws DALException {
		data.remove(opr);
	}

}
