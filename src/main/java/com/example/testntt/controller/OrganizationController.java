package com.example.testntt.controller;

import com.example.testntt.service.OrganizationService;
import com.example.testntt.model.Organization;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для работы с организациями.
 */
@RestController
@RequestMapping("/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    /**
     * Конструктор контроллера.
     *
     * @param organizationService сервис для работы с организациями
     */
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    /**
     * Получение списка всех организаций.
     *
     * @return список всех организаций
     */
    @GetMapping
    public List<Organization> getAllOrganizations() {
        return organizationService.getAllOrganizations();
    }

    /**
     * Получение организации по ее идентификатору.
     *
     * @param id идентификатор организации
     * @return организация с указанным идентификатором
     */
    @GetMapping("/{id}")
    public Organization getOrganizationById(@PathVariable Long id) {
        return organizationService.getOrganizationById(id);
    }

    /**
     * Создание новой организации.
     *
     * @param organization информация о новой организации
     * @return созданная организация
     */
    @PostMapping
    public Organization createOrganization(@RequestBody Organization organization) {
        return organizationService.createOrganization(organization);
    }

    /**
     * Обновление информации об организации.
     *
     * @param id            идентификатор организации
     * @param organization  новая информация об организации
     * @return обновленная организация
     */
    @PutMapping("/{id}")
    public Organization updateOrganization(@PathVariable Long id, @RequestBody Organization organization) {
        return organizationService.updateOrganization(id, organization);
    }

    /**
     * Удаление организации.
     *
     * @param id идентификатор организации для удаления
     */
    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
    }
}


