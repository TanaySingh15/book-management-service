package com.bookstore.bookmanagementservice.payload.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BulkDataDto extends BookDto{
    private List<BookDto> books;
}
