package com.cts.testapi.TestApi.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.testapi.TestApi.Entity.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity,Integer>{

	List<BookEntity> findAllByYearOfPublication(Integer yop);

	
}
