package com.grading.service;

import com.grading.persistence.entity.DocumentsEntity;
import com.grading.persistence.repository.DocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentsService {

    @Autowired
    private DocumentsRepository documentsRepository;

    @Transactional
    public DocumentsEntity saveDocument(DocumentsEntity document) {
        return documentsRepository.save(document);
    }

    public Optional<DocumentsEntity> findById(UUID id) {
        return documentsRepository.findById(id);
    }

    public List<DocumentsEntity> findAll() {
        return documentsRepository.findAll();
    }

    public void deleteDocument(UUID id) {
    }
}
