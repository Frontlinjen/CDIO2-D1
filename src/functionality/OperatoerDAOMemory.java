 package functionality;

import java.util.ArrayList;
import java.util.List;

import data.IOperatoerDTO;
import utilities.ShuffleBag;

public class OperatoerDAOMemory implements IOperatoerDAO{

	private ShuffleBag<Integer> availableNumbers;
	private List<IOperatoerDTO> data = new ArrayList<IOperatoerDTO>();

	public OperatoerDAOMemory() {
		Integer numbers[] = new Integer[100-11];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i+11;
		}
		availableNumbers = new ShuffleBag<Integer>(numbers);
		
	}
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
		{
			try {
				
				opr.setID(availableNumbers.getNext());
			} catch (Exception e) {
				throw new DALException("User limit reached");
			}
		}
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
