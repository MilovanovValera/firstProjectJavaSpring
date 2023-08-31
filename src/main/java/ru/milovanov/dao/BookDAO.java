package ru.milovanov.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.milovanov.models.Book;
import ru.milovanov.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(name, year, author) VALUES(?, ?, ?)", book.getName(), book.getYear(),
                book.getAuthor());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET name=?, year=?, author=? WHERE id=?", updatedBook.getName(),
                updatedBook.getYear(), updatedBook.getAuthor(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }

    public void assignOwner(Person person, int id){
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?", person.getId(), id);
    }
    public void freeOwner(int id){
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?", null, id);
    }

    public Optional<Person> getBookOwner(int id){
        return jdbcTemplate.query("SELECT Person.* FROM Book JOIN Person ON Book.person_id = Person.id WHERE Book.id = ?",
                        new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }
}
