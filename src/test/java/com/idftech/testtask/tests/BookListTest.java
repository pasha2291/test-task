package com.idftech.testtask.tests;

import com.idftech.testtask.apisteps.BookSteps;
import com.idftech.testtask.apisteps.ResponseSteps;
import com.idftech.testtask.models.Book;
import com.idftech.testtask.models.BookList;
import com.idftech.testtask.pages.BookStorePage;
import com.idftech.testtask.utils.logger.CustomLogger;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class BookListTest extends BaseTest {

    @Test
    public void uiBookListEqualsApi() {
        CustomLogger.info("Start of a book list test.");

        Response bookListResponse = BookSteps.getBookList();

        CustomLogger.info("Step 1. Assert that API get book list response status code is 200.");
        ResponseSteps.checkStatusCode(bookListResponse, HttpStatus.SC_OK);

        BookList books = ResponseSteps.getObject(bookListResponse, BookList.class);
        List<String> apiBookTitles = books.getBooks()
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());

        BookStorePage bookStorePage = new BookStorePage();
        List<String> uiBookTitles = bookStorePage.getBookTitleList();

        CustomLogger.info("Step 2. Assert that UI book titles list equals to API book titles list.");
        Assert.assertEquals(uiBookTitles, apiBookTitles, "UI book titles list should be equal to API book titles list!");

        CustomLogger.info("End of a book list test.");
    }
}
