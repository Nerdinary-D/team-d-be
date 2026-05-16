package com.dteam.neordinarydteam.domain.bookmark.dto.request;

public final class BookmarkRequest {
    private BookmarkRequest() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public record CreateDTO() {}
}
