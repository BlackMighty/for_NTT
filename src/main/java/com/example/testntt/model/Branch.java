package com.example.testntt.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Класс, представляющий филиал организации.
 * Содержит информацию о наименовании филиала, его почтовом адресе и сведениях о руководителе.
 */
@Entity
public class Branch {
        @ManyToOne
        @JoinColumn(name = "organization_id")
        private Organization organization;

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
        private String directorBirthDate;

}

