package com.example.testntt.repository;

import com.example.testntt.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Репозиторий для работы с организациями.
 * Предоставляет методы для поиска, сохранения, обновления и удаления организаций в базе данных.
 */

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
