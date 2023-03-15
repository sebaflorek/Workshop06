package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Book;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {

}
