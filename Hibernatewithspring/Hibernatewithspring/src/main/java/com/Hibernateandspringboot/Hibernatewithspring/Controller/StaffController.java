package com.Hibernateandspringboot.Hibernatewithspring.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hibernateandspringboot.Hibernatewithspring.Entity.staff;
import com.Hibernateandspringboot.Hibernatewithspring.Service.StaffService;

@RestController
public class StaffController {

	// to get all staff record
	@Autowired
	StaffService tm;
	@GetMapping("all")
     public List<staff> getallemployee() {
		List<staff>team=	tm.getallemployee();
		return team;
	}
     
     //to get record whose staff record 3
     @RequestMapping("secific")
   public  List<staff> specificemployee() {
    	 List<staff> list= tm.specificemployee();
    	 return list;
     }
   
   
   
   //to write a list who is salary gretaer than 20000
   @RequestMapping("max")
   List<staff> Maxsalary() {
	   List<staff> max=   tm.Maxsalary();
	   return max;
   }
   
   //to get the staff having experience between 10 to 20
   @RequestMapping("mini")
  public List<staff> minmax() {
	   List<staff>   minmax= tm.minmax();
	   return minmax;
   }
  
  //write a staff information having max salary.
  @RequestMapping("bigsalary")
  public List<staff> bigsalary() {
	  List<staff> salary=  tm.bigsalary();
	  return salary;
  }
  
  //update a salary for staff whose id is 4
  @RequestMapping("update")
  boolean updatesalary() {
	return  tm.updatesalary();
  }
  
  //to get a staff name whose having experience is minimum (not all info).
  @RequestMapping("minexperience")
  public ArrayList<String> minexperience() {
	  ArrayList<String>al=tm.minexperience();
	  return al;
  }
  
  //write staff whos profile is trainer
  @RequestMapping("onlytrainer")
  public List<staff> trainer() {
	  List<staff> trainer  =tm.trainer();
	  return trainer;
  }
  
  // write staff whos profile not trainer
  @RequestMapping("nottrainer")
  public List<staff> withouttrainer() {
	 return tm.withouttrainer();
  }
  
  
  //to insert a one record of staff
  @PostMapping("addemployee")
 public String addemployee(@RequestBody staff staff) {
	return  tm.addemployee(staff);
	  
  }
    
  
}
