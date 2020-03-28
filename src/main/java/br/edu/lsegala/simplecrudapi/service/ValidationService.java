package br.edu.lsegala.simplecrudapi.service;

import br.edu.lsegala.simplecrudapi.model.Caso;
import org.springframework.stereotype.Component;

@Component
public class ValidationService {
    public boolean validateFolderLength(String folder){
        return (folder+"").length() <= 40;
    }

    public boolean validateRequiredFields(Caso caso) {
        return  caso.clientes != null && !caso.clientes.isEmpty() &&
                caso.titulo != null && !caso.titulo.isEmpty() &&
                caso.responsavel != null && !caso.responsavel.isEmpty() &&
                caso.dataCriacao != null;
    }
}
