package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dao.donor;
import com.example.demo.model.Demo1;

import jakarta.transaction.Transactional;

@Service
public class BloodDonorService {
	@Autowired
	donor bddao;
	public List<Demo1> getAllDonors()
	{
		List<Demo1> bdList=bddao.findAll();
		return bdList;
		
	}
	public Demo1 saveDemo1(Demo1 s)
	{
		Demo1 obj=bddao.save(s);
		return obj;
	}
	public Demo1 updateDemo1(Demo1 s)
	{
		Demo1 obj=bddao.save(s);
		return obj;
	}
	public void deleteDemo1(int id)
	{
		bddao.deleteById(id);
	}
	public Optional<Demo1> getDemo1byId(int id)
	{
		return bddao.findById(id);
	}
	//Sorting
	public List<Demo1>sortDonors(String field)
	  {
		  return bddao.findAll(Sort.by(field));
	  }
	//Pagination
	 public List<Demo1>pagingDonors(int offset,int pageSize)
	  {
		  Pageable paging=PageRequest.of(offset, pageSize);
		  Page<Demo1> bdData=bddao.findAll(paging);
		  List<Demo1>bdList=bdData.getContent();
		  return bdList;
	  }
	 //Sorting and Pagination
	  public List<Demo1>pagingAndSortingDonors(int offset,int pageSize,String field)
	  {
		  Pageable paging=PageRequest.of(offset, pageSize).withSort(Sort.by(field));
		  Page<Demo1> bd=bddao.findAll(paging);
		  return bd.getContent();	  
	  }
      //Query
	  @Transactional
	  public int deleteDemo1ByName(String name)
	  {
		  return bddao.deleteDemo1ByName(name);
	  }
	
	  public List<Demo1> getDataDonors(String name)
	  {
		  return bddao.getDataDonors(name);
	  }
	  public Demo1 saveAll(Demo1 d)
	  {
		  return bddao.save(d);
	  }
      public List<Demo1> fetchAll()
      {
    	  return bddao.findAll();
      }
}
