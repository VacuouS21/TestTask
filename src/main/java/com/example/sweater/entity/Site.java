package com.example.sweater.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
@Data
public class Site {
    public int page;
    public String  totalResults;
    public int totalPages;
    public List<Result> results;
    public int resultsOnPage;
}
