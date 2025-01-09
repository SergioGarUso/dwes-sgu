package org.example.completeapp.repositories;

import org.example.completeapp.entities.Book;
import org.example.completeapp.entities.PhysicalBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhysicalBookRepository extends JpaRepository<PhysicalBook, Long> {
    @Query("SELECT b FROM PhysicalBook b WHERE b.book.title LIKE %?1%")
    List<PhysicalBook> searchByKeyword(String keyword);
}
