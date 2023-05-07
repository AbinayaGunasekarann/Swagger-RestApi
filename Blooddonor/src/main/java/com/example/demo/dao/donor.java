package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Demo1;

public interface donor extends JpaRepository<Demo1,Integer> {
	@Modifying
	  @Query("delete from Demo1 d where d.name=?1")
	  public int deleteDemo1ByName(String name);
	  
	
	@Query(value="select * from Demo1 d where d.name=?1",nativeQuery=true)
	public List<Demo1> getDataDonors(String name);
	
	@Query("select d from Demo1 d where d.name=:name")
	public List<Demo1> get(String name);

}
