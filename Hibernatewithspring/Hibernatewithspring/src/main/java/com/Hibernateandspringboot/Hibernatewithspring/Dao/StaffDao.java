package com.Hibernateandspringboot.Hibernatewithspring.Dao;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Hibernateandspringboot.Hibernatewithspring.Entity.staff;


@Repository
public class StaffDao {

	@Autowired
	SessionFactory sf;
	public List<staff> getallemployee() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(staff.class);
		List<staff>team=	criteria.list();
		session.close();
		return team;
	}
	
	public List<staff> specificemployee() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(staff.class);
		criteria.add(Restrictions.eq("staffid", 3));
		List<staff> list=criteria.list();
		session.close();
		return list;
	
		
	}

	public List<staff> Maxsalary() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(staff.class);
		criteria.add(Restrictions.gt("salary", 20000));
		List<staff> max=criteria.list();
		session.close();
		return max;
		
	}

	public List<staff> minmax() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(staff.class);
		criteria.add(Restrictions.between("experience", 10, 20));
		List<staff> minmax=criteria.list();
		session.close();
		return minmax;
		
	}

	public List<staff> bigsalary() {
       Session session=sf.openSession();
       Criteria criteria=session.createCriteria(staff.class);
       criteria.add(Restrictions.ge("salary",60000 ));
       List<staff> salary=criteria.list();
		session.close();
		return salary;

		
	}

	public boolean updatesalary() {
		Session session=sf.openSession();
		org.hibernate.Transaction tr=session.beginTransaction();
		
		staff staff= new staff();
		staff.setStaffid(4);	
		staff.setExperience(22);
		staff.setName("pankaj");
		staff.setProfile("admin");
		staff.setSalary(50000);
		session.update(staff);
		tr.commit();
		session.close();
		return true;

		
	}

	public ArrayList<String> minexperience() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(staff.class);
		criteria.add(Restrictions.lt("experience", 14));
		List<staff> less=criteria.list();
		ArrayList<String> al= new ArrayList<String>();
		for (staff staff : less) {
            String name=staff.getName();
            al.add(name);
            System.out.println(name);
                
		}
		session.close();
		return al;

  
		
		
	}

	public List<staff> trainer() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(staff.class);
		criteria.add(Restrictions.eq("profile", "trainer"));
		List<staff> trainer=criteria.list();
		session.close();
         return trainer;
		
	}

	public List<staff> withouttrainer() {
   Session session = sf.openSession();
   Criteria criteria =session.createCriteria(staff.class);
   criteria.add(Restrictions.ne("profile", "trainer"));
   List<staff> notequals=criteria.list();
   session.close();
    return notequals;
		
	}

	public String addemployee(staff staff) {
		Session session=sf.openSession();
		org.hibernate.Transaction tr=session.beginTransaction();
		session.save(staff);
		tr.commit();
		session.close();
		return "true";
	}

	
	
	
}