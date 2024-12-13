package com.sk.quotesapi.entities;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@Entity
@Table(name = "authors")
@Data
public class Author {

    @JsonIgnore
    @Id
    @UuidGenerator
    private String id;
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY)
    private List<QuoteItem> quotes;
}
