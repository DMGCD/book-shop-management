package com.bookshop.book_shop_management.controller;

import com.bookshop.book_shop_management.dto.request.RequestSaveBookDTO;
import com.bookshop.book_shop_management.service.BookService;
import com.bookshop.book_shop_management.util.StandardResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("api/v1/book-controller")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping(
            path = {"/save-book"},
            params = {"authorId"}
    )
    public ResponseEntity<StandardResponse> saveBookDetails(
            @Valid @RequestBody List<RequestSaveBookDTO> requestSaveBookDTOok,
            @RequestParam(value = "authorId") int authorId
    ) {
        String saved = bookService.saveBookDetails(authorId, requestSaveBookDTOok);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "saved Books of author",
                        saved
                ), HttpStatus.OK
        );
    }

    @GetMapping(
            path = {"/update-book-details"},
            params = {"bookId"}
    )
    public ResponseEntity<StandardResponse> updateBookDetails(@RequestParam(value = "bookId") String bookId) {
        String updated =bookService.updateBookByBookId(bookId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "saved Books of author",
                        "saved"
                ), HttpStatus.OK
        );
    }
}
