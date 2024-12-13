package com.sk.quotesapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "quotes")
@Getter
@Setter
@NoArgsConstructor
public class QuoteItem {

    @Id
    @UuidGenerator
    private String id;

    @Column(unique = true, nullable = false)
    private String quote;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Category category;

}
