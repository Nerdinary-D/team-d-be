package com.dteam.neordinarydteam.domain.bookmark.repository;

import com.dteam.neordinarydteam.domain.bookmark.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {}
