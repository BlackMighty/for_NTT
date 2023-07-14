package com.example.testntt.model;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
/**
 * Объект данных представляет сведения по одной организации.
 */
@Entity
@Data
public class Organization {
        /**
         * Уникальный идентификатор организации.
         */
        @Id
        private Long id;

        /**
         * Полное наименование организации.
         */
        private String fullName;

        /**
         * Краткое наименование организации.
         */
        private String shortName;

        /**
         * ИНН организации.
         */
        private String inn;

        /**
         * ОГРН организации.
         */
        private String ogrn;

        /**
         * Почтовый адрес организации.
         */
        private String postalAddress;

        /**
         * Юридический адрес организации.
         */
        private String legalAddress;

        /**
         * Фамилия генерального директора организации.
         */
        private String directorLastName;

        /**
         * Имя генерального директора организации.
         */
        private String directorFirstName;

        /**
         * Отчество генерального директора организации.
         */
        private String directorMiddleName;

        /**
         * Дата рождения генерального директора организации.
         */
        private String directorBirthDate;

        /**
         * Список филиалов организации.
         */
        @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
        private List<Branch> branches;

}
