package com.bookmarker.api.service;

import com.bookmarker.api.domain.Bookmark;
import com.bookmarker.api.domain.BookmarkRepository;
import com.bookmarker.api.dto.BookmarkDTO;
import com.bookmarker.api.dto.BookmarkMapper;
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
    private final BookmarkMapper mapper;

    @Transactional(readOnly = true)
    public BookmarksDTO<?> getBookmarks(Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "id");
        Page<BookmarkDTO> bookmarkPage = repository.findAll(pageable)
                //.map(bookmark -> mapper.toDTO(bookmark));
                .map(mapper::toDTO);
        return new BookmarksDTO<>(bookmarkPage);
    }
    
}