package com.example.ProgrammingLanguage.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Tables;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    /*@ManyToOne
    @JoinColumn(name = "languageId")
    private Language language;*/

    @OneToMany(mappedBy = "language")
    private List<SubTech> subTeches;
}
