package com.infy.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.BookDTO;
import com.infy.entity.Book;
import com.infy.exception.InfyBookException;
import com.infy.repository.BookRepository;
import com.infy.validator.Validator;

@Transactional
@Service(value="bookService")
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public BookDTO getBookDetails(Integer bookId) throws InfyBookException {
		Optional<Book> optional = bookRepository.findById(bookId);
		Book book=optional.orElseThrow(()->new InfyBookException("Service.BOOK_DETAILS_NOT_FOUND"));
		BookDTO bookDTO=new BookDTO();
		bookDTO.setAuthorName(book.getAuthorName());
		bookDTO.setBookId(book.getBookId());
		bookDTO.setIsbn(book.getIsbn());
		bookDTO.setPrice(book.getPrice());
		bookDTO.setPublishedYear(book.getPublishedYear());
		bookDTO.setPublisher(book.getPublisher());
		bookDTO.setTitle(book.getTitle());
		
		return bookDTO;
	}

	@Override
	public void addBook(BookDTO bookDTO) throws InfyBookException {
		Validator.validate(bookDTO);
		Optional<Book> optional= bookRepository.findById(bookDTO.getBookId());
		if(optional.isPresent()) {
			throw new InfyBookException(" Service.BOOK_ALREADY_PRESENT");
		}
		else {
			Book book=new Book();
			book.setAuthorName(bookDTO.getAuthorName());
			book.setBookId(bookDTO.getBookId());
			book.setIsbn(bookDTO.getIsbn());
			book.setPrice(bookDTO.getPrice());
			book.setPublishedYear(bookDTO.getPublishedYear());
			book.setPublisher(bookDTO.getPublisher());
			book.setTitle(bookDTO.getTitle());
			bookRepository.save(book);
		}
	}

	@Override
	public List<BookDTO> getBookByAuthorName(String authorName) throws InfyBookException {
		List<Book> optional=bookRepository.findByAuthorName(authorName);
		List<BookDTO> result=new ArrayList<BookDTO>();
		BookDTO bookDTO;
		if(optional!=null) {
			for(int i=0;i<optional.size();i++) {
				bookDTO=new BookDTO();
				bookDTO.setAuthorName(optional.get(i).getAuthorName());
				bookDTO.setBookId(optional.get(i).getBookId());
				bookDTO.setIsbn(optional.get(i).getIsbn());
				bookDTO.setPrice(optional.get(i).getPrice());
				bookDTO.setPublishedYear(optional.get(i).getPublishedYear());
				bookDTO.setPublisher(optional.get(i).getPublisher());
				bookDTO.setTitle(optional.get(i).getTitle());
				result.add(bookDTO);
			}
		}
		else {
			throw new InfyBookException("Service.BOOK_NOT_FOUND");
		}
		return result;
	}

	@Override
	public List<BookDTO> getBookGreaterThanEqualToPrice(Integer price) throws InfyBookException {
		List<Book> optional = bookRepository.getBookGreaterThanEqualToPrice(price);
		List<BookDTO> result=new ArrayList<BookDTO>();
		BookDTO bookDTO;
		if(optional!=null) {
			for(int i=0;i<optional.size();i++) {
				bookDTO=new BookDTO();
				bookDTO.setAuthorName(optional.get(i).getAuthorName());
				bookDTO.setBookId(optional.get(i).getBookId());
				bookDTO.setIsbn(optional.get(i).getIsbn());
				bookDTO.setPrice(optional.get(i).getPrice());
				bookDTO.setPublishedYear(optional.get(i).getPublishedYear());
				bookDTO.setPublisher(optional.get(i).getPublisher());
				bookDTO.setTitle(optional.get(i).getTitle());
				result.add(bookDTO);
			}
		}
		else {
			throw new InfyBookException("Service.BOOK_NOT_FOUND");
		}
		return result;
	}

	@Override
	public List<BookDTO> getBookLessThanPrice(Integer price) throws InfyBookException {
		List<Book> optional = bookRepository.getBookByPriceLess(price);
		List<BookDTO> result=new ArrayList<BookDTO>();
		BookDTO bookDTO;
		if(optional!=null) {
			for(int i=0;i<optional.size();i++) {
				bookDTO=new BookDTO();
				bookDTO.setAuthorName(optional.get(i).getAuthorName());
				bookDTO.setBookId(optional.get(i).getBookId());
				bookDTO.setIsbn(optional.get(i).getIsbn());
				bookDTO.setPrice(optional.get(i).getPrice());
				bookDTO.setPublishedYear(optional.get(i).getPublishedYear());
				bookDTO.setPublisher(optional.get(i).getPublisher());
				bookDTO.setTitle(optional.get(i).getTitle());
				result.add(bookDTO);
			}
		}
		else {
			throw new InfyBookException("Service.BOOK_NOT_FOUND");
		}
		return result;
	}

	@Override
	public List<BookDTO> bookPublishedBetweenYear(LocalDate startYear, LocalDate endYear) throws InfyBookException {
		List<Book> optional = bookRepository.findByPublishedYearBetween(startYear, endYear);
		List<BookDTO> result=new ArrayList<BookDTO>();
		BookDTO bookDTO;
		if(optional!=null) {
			for(int i=0;i<optional.size();i++) {
				bookDTO=new BookDTO();
				bookDTO.setAuthorName(optional.get(i).getAuthorName());
				bookDTO.setBookId(optional.get(i).getBookId());
				bookDTO.setIsbn(optional.get(i).getIsbn());
				bookDTO.setPrice(optional.get(i).getPrice());
				bookDTO.setPublishedYear(optional.get(i).getPublishedYear());
				bookDTO.setPublisher(optional.get(i).getPublisher());
				bookDTO.setTitle(optional.get(i).getTitle());
				result.add(bookDTO);
			}
		}
		else {
			throw new InfyBookException("Service.BOOK_NOT_FOUND");
		}
		return result;
		
	}

	@Override
	public List<BookDTO> bookPublishedAfterYear(LocalDate year) throws InfyBookException {
		List<Book> optional = bookRepository.findByPublishedYearAfter(year);
		List<BookDTO> result=new ArrayList<BookDTO>();
		BookDTO bookDTO;
		if(optional!=null) {
			for(int i=0;i<optional.size();i++) {
				bookDTO=new BookDTO();
				bookDTO.setAuthorName(optional.get(i).getAuthorName());
				bookDTO.setBookId(optional.get(i).getBookId());
				bookDTO.setIsbn(optional.get(i).getIsbn());
				bookDTO.setPrice(optional.get(i).getPrice());
				bookDTO.setPublishedYear(optional.get(i).getPublishedYear());
				bookDTO.setPublisher(optional.get(i).getPublisher());
				bookDTO.setTitle(optional.get(i).getTitle());
				result.add(bookDTO);
			}
		}
		else {
			throw new InfyBookException("Service.BOOK_NOT_FOUND");
		}
		return result;
	}

	@Override
	public List<BookDTO> getBookByAuthorNameAndPublisher(String authorName, String publisher) throws InfyBookException {
		List<Book> optional = bookRepository.getBookByAuthorNameAndPublisher(authorName, publisher);
		List<BookDTO> result=new ArrayList<BookDTO>();
		BookDTO bookDTO;
		if(optional!=null) {
			for(int i=0;i<optional.size();i++) {
				bookDTO=new BookDTO();
				bookDTO.setAuthorName(optional.get(i).getAuthorName());
				bookDTO.setBookId(optional.get(i).getBookId());
				bookDTO.setIsbn(optional.get(i).getIsbn());
				bookDTO.setPrice(optional.get(i).getPrice());
				bookDTO.setPublishedYear(optional.get(i).getPublishedYear());
				bookDTO.setPublisher(optional.get(i).getPublisher());
				bookDTO.setTitle(optional.get(i).getTitle());
				result.add(bookDTO);
			}
		}
		else {
			throw new InfyBookException("Service.BOOK_NOT_FOUND");
		}
		return result;
	}

	@Override
	public void updateBookPrice(Integer bookId, Integer price) throws InfyBookException {
		Optional<Book> optional=bookRepository.findById(bookId);
		Book book=optional.orElseThrow(()->new InfyBookException("Service.BOOK_NOT_FOUND"));
		book.setPrice(price);
		
		
	}

	@Override
	public void deleteBook(Integer bookId) throws InfyBookException {
		Optional<Book> optional=bookRepository.findById(bookId);
		Book book=optional.orElseThrow(()->new InfyBookException("Service.BOOK_NOT_FOUND"));
		bookRepository.deleteById(bookId);
	}


	
}
