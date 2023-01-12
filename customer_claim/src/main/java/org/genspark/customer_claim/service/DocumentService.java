package org.genspark.customer_claim.service;
import org.genspark.customer_claim.repository.DocumentRepository;
import org.genspark.customer_claim.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {
    @Autowired
    DocumentRepository claimDocumentRepository;
    public Document createClaimDocument(int customerId, MultipartFile file)throws Exception
    {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Document Document =new Document();
        Document.setDocument(file.getBytes());
        Document.setCustomerId(customerId);
        Document.setName(fileName);
        Document.setType(file.getContentType());
        return claimDocumentRepository.save(Document);
    }
    public List<Document> getAllClaims()
    {
        return claimDocumentRepository.findAll();
    }
    public Optional<Document> getDocumentById(Long id)
    {
        return claimDocumentRepository.findById(id);
    }
    public Document updateClaimDocument(Long documentId, int customerId, MultipartFile file)throws Exception
    {
        Document Document =claimDocumentRepository.findById(documentId).get();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Document.setDocument(file.getBytes());
        Document.setCustomerId(customerId);
        Document.setName(fileName);
        Document.setType(file.getContentType());
        return claimDocumentRepository.save(Document);
    }

    public void deleteClaimDocument(Long documentId) {
        claimDocumentRepository.deleteById(documentId);
    }
}
