package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByYearOfPublication(Long yearOfPublication);
}
