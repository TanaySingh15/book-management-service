package com.bookstore.bookmanagementservice.payload.responses;

import java.util.List;

public class AuthorListResponse {
    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalElements;
    private Integer totalPages;
    private boolean lastPage;
    private List<AuthorResponse> pageContent;
}
