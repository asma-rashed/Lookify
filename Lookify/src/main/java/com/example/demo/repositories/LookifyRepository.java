package com.example.demo.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.*;

@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long>{
	List<Lookify> findAll();
	
	List<Lookify> findByArtist(String search);
	
	List<Lookify> findTop10ByOrderByRatingDesc();
	
}
