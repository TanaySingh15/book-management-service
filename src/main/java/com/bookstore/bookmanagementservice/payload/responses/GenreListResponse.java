package com.bookstore.bookmanagementservice.payload.responses;

import java.util.List;

public class GenreListResponse {
    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalElements;
    private Integer totalPages;
    private boolean lastPage;
    private List<GenreResponse> pageContent;
}
