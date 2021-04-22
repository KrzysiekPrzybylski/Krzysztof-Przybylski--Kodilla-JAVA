package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BookCopyRepository extends JpaRepository<BookCopy,Long> {

}
