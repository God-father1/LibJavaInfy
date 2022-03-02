package com.infy.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.infy.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	Optional<Book> findById(Integer Id);
	
	 List<Book> findByAuthorName(String authorName);
	@Query("Select b from Book b where price>=:price")
	 List<Book> getBookGreaterThanEqualToPrice(@Param("price") Integer price);
	@Query("Select b from Book b where price<:price")
	 List<Book> getBookByPriceLess(Integer price);
	
	 List<Book> findByPublishedYearBetween(LocalDate from, LocalDate to);
	
	 List<Book> findByPublishedYearAfter(LocalDate date);
	
	 List<Book> getBookByAuthorNameAndPublisher(String authorName,String publisher);
	
	
}	