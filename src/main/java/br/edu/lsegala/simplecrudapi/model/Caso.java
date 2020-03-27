package br.edu.lsegala.simplecrudapi.model;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity(name = "Caso")
public class Caso {
    @Id
    public Long id;
    public String acesso;
    public String clientes;
    public Date dataCriacao;
    public String descricao;
    public String observacoes;
    public String pasta;
    public String responsavel;
    public String titulo;

    public Long getId(){
        return this.id;
    }
}
