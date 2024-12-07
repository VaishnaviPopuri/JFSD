package HQLOperatations;


import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.hibernate.sql.model.ast.MutatingTableReference;


public class ClientDemo 
{
	public static void main(String args[]) // instead of args[] we can take any other name also
	{
		ClientDemo operations = new ClientDemo();
		operations.addDepartment();
		//operations.deleteDepartment();
		
	}
	public void addDepartment()
	{
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sf=configuration.buildSessionFactory(); 
		Session session=sf.openSession(); 
		
		Transaction t = session.beginTransaction();
		
		Department department = new Department();
		department.setDid(2);
		department.setDname("CSIT");
		department.setDlocation("KLU");
		department.setHODName("ABC");
		session.persist(department);
		t.commit();
		System.out.println("Department Added Successfully");
		session.close();
		sf.close();
	}
	
	public void deleteDepartment()
	{

		Configuration configuration= new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sf=configuration.buildSessionFactory();
		Session session =sf.openSession();
		
		Transaction t= session.beginTransaction();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Department ID :");
		int did = sc.nextInt();
		
		String hql = "delete from Department where id=?1";
		MutationQuery qry = session.createMutationQuery(hql);
		qry.setParameter(1, did);
		int n = qry.executeUpdate();
		t.commit();

		if(n>0)
		{
		 System.out.println("Department Deleted Successfully");	
		}
		else
		{
			System.out.println("Department ID Not Found");
		}
		
		sc.close();
		session.close();
		sc.close();
		
	}
	
	

}
