package com.example.notionpainter.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.sql.Timestamp;

@Entity
@Table(name = "passwords")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String hash;
    private String salt;
    @CreatedDate
    private Timestamp createdAt;
    @LastModifiedDate
    private Timestamp modifiedAt;
}