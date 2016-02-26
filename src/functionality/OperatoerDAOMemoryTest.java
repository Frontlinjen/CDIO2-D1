package functionality;

import static org.junit.Assert.*;

import org.junit.Test;

import data.OperatoerDTO;
import functionality.IOperatoerDAO.DALException;

public class OperatoerDAOMemoryTest {

	@Test
	public void testGetOperatoer() throws DALException {
		OperatoerDAOMemory a = new OperatoerDAOMemory();
		OperatoerDTO b = new OperatoerDTO(22, "Anton", "AT", 123, "abe");
		a.createOperatoer(b);
		assertTrue(a.getOperatoer(22) != null);
	}

	@Test
	public void testGetOperatoerList() throws DALException {
		OperatoerDAOMemory a = new OperatoerDAOMemory();
		OperatoerDTO b = new OperatoerDTO(22, "Anton", "AT", 123, "abe");
		OperatoerDTO c = new OperatoerDTO(43, "Anton", "AT", 133, "abe");
		a.createOperatoer(b);
		a.createOperatoer(c);
		assertTrue(a.getOperatoerList() != null);
	}

	@Test
	public void testUpdateOperatoer() throws DALException {
		OperatoerDAOMemory a = new OperatoerDAOMemory();
		OperatoerDTO b = new OperatoerDTO(22, "Anton", "AT", 123, "abe");
		OperatoerDTO c = new OperatoerDTO(22, "Kaj", "AT", 123, "abe");
		a.createOperatoer(b);
		a.updateOperatoer(c);
		assertTrue(a.getOperatoer(22).getNavn()=="Kaj");
	}

	@Test
	public void testDeleteOperatoer() throws DALException {
		OperatoerDAOMemory a = new OperatoerDAOMemory();
		OperatoerDTO b = new OperatoerDTO(22, "Anton", "AT", 123, "abe");
		a.createOperatoer(b);
		a.deleteOperatoer(b);
		assertTrue(a.getOperatoer(22)==null);
	}

}
