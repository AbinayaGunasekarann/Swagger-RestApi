package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.BloodDonorService;
import com.example.demo.model.Demo1;

@RestController
public class BloodDonorController {
  @Autowired
  BloodDonorService bdService;
	
 	@PostMapping(value="/SaveDonors")
 	public Demo1 saveDemo1(@RequestBody Demo1 s)
 	{
 		return bdService.saveDemo1(s); 
 	}
 	
 	@PutMapping(value="/updateDonors")
 	public Demo1 updateDemo1(@RequestBody Demo1 s)
 	{
 		return bdService.updateDemo1(s);
 	}
 	@DeleteMapping(value="/deleteDonors/{id}")
 	public String deleteDemo1(@PathVariable("id")int id)
 	{
 		bdService.deleteDemo1(id);
 		return "Deleted Successfully";
 	}
 	
 	@GetMapping(value="/fetchDonors/{id}")
     public Optional<Demo1> getDemo1(@PathVariable("id")int id)
     {
     	return bdService.getDemo1byId(id);
     }
 	//sorting
 			@GetMapping("/sortDonors/{field}")
 			
 				public List<Demo1>sortBooks(@PathVariable String field)
 				{
 					return bdService.sortDonors(field);
 				}
 			//Pagination
 			@GetMapping("/PagingDonors/{offset}/{pageSize}")
 			    public List<Demo1>pagingStudents(@PathVariable int offset,@PathVariable int pageSize)
 			    {
 				return bdService.pagingDonors(offset,pageSize);
 			    }
 			//sorting and paging
 			@GetMapping("/pagingAndSortingDonors/{offset}/{pageSize}/{field}")
 			 public List<Demo1> pagingAndSortingDonors(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
 			 {
 				return bdService.pagingAndSortingDonors(offset,pageSize,field);
 			 }
 			
 			//Query
 			@DeleteMapping("/deleteDemo1ByName/{name}")
 			public String deleteDemo1ByName(@PathVariable String name)
 			{
 				int result=bdService.deleteDemo1ByName(name);
 				if(result>0)
 					return "Deleted Successfully";
 				else
 					return "Deleting was unsuccessfull";
 							
 						
 			}
 			@GetMapping("/getDataDonors")
 			public List<Demo1> getDataDonors(@RequestParam String name)
 			{
 				return bdService.getDataDonors(name);
 			}
 			@PostMapping("/saveAll")
 			public Demo1 saveAll(@RequestBody Demo1 d)
 			{
 				return bdService.saveAll(d);
 			}
 			@GetMapping("/fetchAll")
 			public List<Demo1> fetchAll()
 			{
 				return bdService.fetchAll();
 			}

}
