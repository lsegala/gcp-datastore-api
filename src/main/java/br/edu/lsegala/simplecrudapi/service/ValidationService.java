package br.edu.lsegala.simplecrudapi.service;

import org.springframework.stereotype.Component;

@Component
public class ValidationService {
    public boolean validateFolderLength(String folder){
        return (folder+"").length() <= 40;
    }
}
