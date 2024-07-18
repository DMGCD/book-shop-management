package com.bookshop.book_shop_management.service.impl;

import com.bookshop.book_shop_management.dto.request.RequestSaveBookDTO;
import com.bookshop.book_shop_management.entity.Author;
import com.bookshop.book_shop_management.entity.Book;
import com.bookshop.book_shop_management.exception.AuthorNotFoundException;
import com.bookshop.book_shop_management.exception.NotFoundException;
import com.bookshop.book_shop_management.reporsitory.AuthorREPO;
import com.bookshop.book_shop_management.reporsitory.BookREPO;
import com.bookshop.book_shop_management.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceIMPL implements BookService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AuthorREPO authorRepo;
    @Autowired
    private BookREPO bookRepo;

    @Override
    public String saveBookDetails(int authorId, List<RequestSaveBookDTO> requestSaveBookDTOok) {
        Optional<Author> author = authorRepo.findById(authorId);

        List<Book> books = new ArrayList<>();
        if (author.isPresent()) {
            for (RequestSaveBookDTO r : requestSaveBookDTOok) {
                Book book = new Book(
                        r.getIsbnId(),
                        r.getCategory(),
                        r.getBookTitle(),
                        author.get().getFirstName(),
                        author.get()

                );
                books.add(book);

            }
            bookRepo.saveAll(books);
            return author.get().getFirstName();
        } else {
            throw new AuthorNotFoundException("Author not Found");
        }

    }
}
