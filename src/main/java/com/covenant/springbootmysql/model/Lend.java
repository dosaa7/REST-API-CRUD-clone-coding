package com.covenant.springbootmysql.model;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "lend")
public class Lend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant startOn;
    private Instant dueOn;
    @Enumerated(EnumType.ORDINAL)
    private LendStatus status;
    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonManagedReference
    private Book book;
    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonManagedReference
    private Member member;
}