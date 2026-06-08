package in.soft.factory;

import in.soft.dao.EmpDao;
import in.soft.dao.EmpDaoImpl;

public class DaoFactory 
{
	private static EmpDao dao=null;
	
	static 
	{
		dao=new EmpDaoImpl();	
	}
	
	public static EmpDao getEmpDao()
	{
		return dao;
	}

}
