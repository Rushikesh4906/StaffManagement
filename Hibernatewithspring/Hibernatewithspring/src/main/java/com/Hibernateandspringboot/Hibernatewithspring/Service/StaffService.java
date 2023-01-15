package com.Hibernateandspringboot.Hibernatewithspring.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hibernateandspringboot.Hibernatewithspring.Dao.StaffDao;
import com.Hibernateandspringboot.Hibernatewithspring.Entity.staff;

@Service
public class StaffService {

	@Autowired
	StaffDao dao;
	public List<staff> getallemployee() {
		List<staff>team=dao.getallemployee();
		return team;
	}
	
	public List<staff> specificemployee() {
		List<staff> list=	dao.specificemployee();
		return list;
	}

	

	public List<staff> Maxsalary() {
		List<staff> max=dao.Maxsalary();
		return max;
		
	}

	public List<staff> minmax() {
		List<staff> minmax=	dao.minmax();
		return minmax;
		
	}

	public List<staff> bigsalary() {
	return	dao.bigsalary();
		
	}

	public boolean updatesalary() {
		return dao.updatesalary();
		
	}

	public ArrayList<String> minexperience() {
		ArrayList<String> al=   dao.minexperience();
		return al;
	}

	public List<staff> trainer() {
		List<staff> trainer=  dao.trainer();

		return trainer;
	}

	public List<staff> withouttrainer() {

           return  dao.withouttrainer();
		
	}

	public String addemployee(staff staff) {
		return dao.addemployee(staff);
		
	}

	
	
	

}
