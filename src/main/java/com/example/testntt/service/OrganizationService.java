package com.example.testntt.service;

import com.example.testntt.repository.OrganizationRepository;
import com.example.testntt.model.Organization;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.Predicate;
import java.util.List;


/**
 * Сервис для работы с организациями.
 */
@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    /**
     * Получает список всех организаций.
     *
     * @return список всех организаций
     */
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    /**
     * Получает организацию по ее уникальному идентификатору.
     *
     * @param id уникальный идентификатор организации
     * @return организация с указанным идентификатором
     * @throws EntityNotFoundException если организация с указанным идентификатором не найдена
     */
    public Organization getOrganizationById(Long id) {
        return organizationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Organization not found"));
    }

    /**
     * Создает новую организацию.
     *
     * @param organization объект организации для создания
     * @return созданная организация
     */
    public Organization createOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    /**
     * Обновляет информацию об организации.
     *
     * @param id           уникальный идентификатор организации
     * @param organization объект организации с обновленными данными
     * @return обновленный объект организации
     * @throws EntityNotFoundException если организация с указанным идентификатором не найдена
     */
    public Organization updateOrganization(Long id, Organization organization) {
        Organization existingOrganization = organizationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Organization not found"));

        existingOrganization.setFullName(organization.getFullName());
        existingOrganization.setShortName(organization.getShortName());
        existingOrganization.setInn(organization.getInn());
        existingOrganization.setOgrn(organization.getOgrn());
        existingOrganization.setPostalAddress(organization.getPostalAddress());
        existingOrganization.setLegalAddress(organization.getLegalAddress());
        existingOrganization.setDirectorLastName(organization.getDirectorLastName());
        existingOrganization.setDirectorFirstName(organization.getDirectorFirstName());
        existingOrganization.setDirectorMiddleName(organization.getDirectorMiddleName());
        existingOrganization.setDirectorBirthDate(organization.getDirectorBirthDate());
        existingOrganization.setBranches(organization.getBranches());

        return organizationRepository.save(existingOrganization);
    }

    /**
     * Удаляет организацию по ее уникальному идентификатору.
     *
     * @param id уникальный идентификатор организации
     */
    public void deleteOrganization(Long id) {
        organizationRepository.deleteById(id);
    }
    /**
            * Поиск организаций по поисковой строке.
     *
             * @param searchQuery поисковая строка
     * @return список организаций, удовлетворяющих поисковому запросу
     */
    public List<Organization> searchOrganizations(String searchQuery) {
        return organizationRepository.findAll((root, query, criteriaBuilder) -> {
            String searchWildcard = "%" + searchQuery + "%";

            Predicate fullNamePredicate = criteriaBuilder.like(root.get("fullName"), searchWildcard);
            Predicate shortNamePredicate = criteriaBuilder.like(root.get("shortName"), searchWildcard);
            Predicate innPredicate = criteriaBuilder.like(root.get("inn"), searchWildcard);
            Predicate ogrnPredicate = criteriaBuilder.like(root.get("ogrn"), searchWildcard);
            Predicate postalAddressPredicate = criteriaBuilder.like(root.get("postalAddress"), searchWildcard);
            Predicate legalAddressPredicate = criteriaBuilder.like(root.get("legalAddress"), searchWildcard);
            Predicate directorLastNamePredicate = criteriaBuilder.like(root.get("directorLastName"), searchWildcard);
            Predicate directorFirstNamePredicate = criteriaBuilder.like(root.get("directorFirstName"), searchWildcard);
            Predicate directorMiddleNamePredicate = criteriaBuilder.like(root.get("directorMiddleName"), searchWildcard);

            return criteriaBuilder.or(
                    fullNamePredicate,
                    shortNamePredicate,
                    innPredicate,
                    ogrnPredicate,
                    postalAddressPredicate,
                    legalAddressPredicate,
                    directorLastNamePredicate,
                    directorFirstNamePredicate,
                    directorMiddleNamePredicate

            );
        });
    }

}