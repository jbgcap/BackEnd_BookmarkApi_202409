package com.bookmarker.api.service;

import com.bookmarker.api.domain.Bookmark;
import com.bookmarker.api.domain.BookmarkRepository;
import com.bookmarker.api.dto.BookmarksDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkRepository repository;

    @Transactional(readOnly = true)
    public BookmarksDTO getBookmarks(Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "id");
        Page<Bookmark> bookmarkPage = repository.findAll(pageable);
        return new BookmarksDTO(bookmarkPage);
    }
    
}