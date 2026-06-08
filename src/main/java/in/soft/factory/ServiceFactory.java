package in.soft.factory;

import in.soft.services.EmpService;
import in.soft.services.EmpServiceImpl;

public class ServiceFactory 
{
	private static EmpService  service=null;
	
	static
	{
		service=new EmpServiceImpl();
	}
	
	public static EmpService getEmpService()
	{
		return service;
		
	}

}
