package org.genspark.customer_claim.controller;

import org.genspark.customer_claim.entity.Document;
import org.genspark.customer_claim.message.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.genspark.customer_claim.service.DocumentService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/document")
public class DocumentController {
    @Autowired
    DocumentService documentService;
    @CrossOrigin
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
   public ResponseEntity<ResponseMessage> uploadDocument(@RequestParam("customerId")int customerId,@RequestParam("document")MultipartFile[] files)
    {
        String message="";
        try {
            for(MultipartFile file : files){
                documentService.createClaimDocument(customerId, file);
                message = message + " Uploaded files successfully: " + file.getOriginalFilename();
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }catch (Exception e)
        {
            message = "Could not upload the file: " + files + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
    @CrossOrigin
    @RequestMapping(value="/getAll",method=RequestMethod.GET)
    public List<Document> getAllClaimDocument()
    {
        return documentService.getAllClaims();
    }
    @CrossOrigin
    @RequestMapping(value = "/{documentId}",method=RequestMethod.GET)
    public Optional<Document> getDocument(@PathVariable(value = "documentId")Long id)
    {
        return documentService.getDocumentById(id);
    }
    @CrossOrigin
    @RequestMapping(value = "/{documentId}",method=RequestMethod.PUT)
    public ResponseEntity<ResponseMessage> updateDocument(@PathVariable("documentId")Long documentId, @RequestParam("customerId")int customerId, @RequestParam("document")MultipartFile file)
    {
        String message="";
        try {
            documentService.updateClaimDocument(documentId,customerId, file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }catch (Exception e)
        {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }

    }
    @CrossOrigin
    @RequestMapping(value="/{documentId}",method=RequestMethod.DELETE)
    public void deleteClaimDocument(@PathVariable("documentId")Long documentId)
    {
        documentService.deleteClaimDocument(documentId);
    }
}
