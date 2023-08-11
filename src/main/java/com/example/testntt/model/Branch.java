package com.example.testntt.model;


import javax.persistence.*;
import java.time.LocalDate;

/**
 * Класс, представляющий филиал организации.
 * Содержит информацию о наименовании филиала, его почтовом адресе и сведениях о руководителе.
 */
@Entity
public class Branch {
        /**
         * Ссылка на организацию, к которой относится данная сущность.
         */
        @ManyToOne
        @JoinColumn(name = "organization_id")
        private Organization organization;

        /**
         * Уникальный идентификатор филиала.
         */
        @Id
        private Long id;


        /**
         * Наименование филиала.
         */
        private String name;

        /**
         * Почтовый адрес филиала.
         */
        private String postalAddress;

        /**
         * Фамилия руководителя филиала.
         */
        private String directorLastName;

        /**
         * Имя руководителя филиала.
         */
        private String directorFirstName;

        /**
         * Отчество руководителя филиала.
         */
        private String directorMiddleName;

        /**
         * Дата рождения руководителя филиала.
         */
        @Column(name = "branch_director_birth_date")
        private LocalDate directorBirthDate;
}

