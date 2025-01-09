package org.example.completeapp.services;


import org.example.completeapp.entities.Book;
import org.example.completeapp.entities.PhysicalBook;
import org.example.completeapp.repositories.PhysicalBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhysicalBookService {
    // TODO: Ejercicio 2
    private final PhysicalBookRepository physicalBookRepository;

    // Inyección de dependencias: Spring "inyecta" "inicializa" una instancia de AuthorRepository en el constructor
    // Mejor hacerlo de esta forma
    public PhysicalBookService(PhysicalBookRepository bookRepository) {
        this.physicalBookRepository = bookRepository;
    }

    public List<PhysicalBook> findAll() {
        return physicalBookRepository.findAll();
    }

    public PhysicalBook findById(Long id) {
        return physicalBookRepository.findById(id).orElse(null);
    }

    public PhysicalBook save(PhysicalBook book) {
        return physicalBookRepository.save(book);
    }

    public void deleteById(Long id) {
        physicalBookRepository.deleteById(id);
    }

    public List<PhysicalBook> searchByKeyword(String keyword) {
        return physicalBookRepository.searchByKeyword(keyword);
    }


}
