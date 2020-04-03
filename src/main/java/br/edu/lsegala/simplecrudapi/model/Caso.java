package br.edu.lsegala.simplecrudapi.model;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Max;
import java.util.Date;

@Entity(name = "Caso")
public class Caso {
    @Id
    public Long id;
    public AccessEnum acesso;
    public String clientes;
    public Date dataCriacao;
    public String descricao;
    public String observacoes;
    @Max(40)
    public String pasta;
    public String responsavel;
    public String titulo;
    public String[] etiqueta;

    public Long getId(){
        return this.id;
    }
}
