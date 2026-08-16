package com.employeepayroll.Dto;

import java.util.List;

// Standard response envelope for every paginated endpoint.
public class PageResponseDTO<T> {

    private final List<T> content;
    private final int pageNumber;
    private final int pageSize;
    private final long totalElements;
    private final int totalPages;
    private final boolean last;
    private final String sortBy;
    private final String sortDirection;

    public PageResponseDTO(List<T> content, int pageNumber, int pageSize, long totalElements,
                           int totalPages, boolean last, String sortBy, String sortDirection) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.last = last;
        this.sortBy = sortBy;
        this.sortDirection = sortDirection;
    }

    public List<T> getContent() { return content; }
    public int getPageNumber() { return pageNumber; }
    public int getPageSize() { return pageSize; }
    public long getTotalElements() { return totalElements; }
    public int getTotalPages() { return totalPages; }
    public boolean isLast() { return last; }
    public String getSortBy() { return sortBy; }
    public String getSortDirection() { return sortDirection; }
}
