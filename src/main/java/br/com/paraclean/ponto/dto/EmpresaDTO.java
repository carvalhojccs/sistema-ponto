package br.com.paraclean.ponto.dto;

import br.com.paraclean.ponto.model.Empresa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class EmpresaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String descricao;
    private String cnpj;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;

    public EmpresaDTO(Long id, String descricao, String cnpj, String endereco, String bairro, String cidade, String estado, String telefone) {
        this.id = id;
        this.descricao = descricao;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
    }

    public EmpresaDTO(Empresa entity) {
        id = entity.getId();
        descricao = entity.getDescricao();
        cnpj = entity.getCnpj();
        endereco = entity.getEndereco();
        bairro = entity.getBairro();
        cidade = entity.getCidade();
        estado = entity.getEstado();
        telefone = entity.getTelefone();
    }

    public EmpresaDTO(String descricao, String cnpj, String endereco, String bairro, String cidade, String estado, String telefone) {
        this.descricao = descricao;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
    }
}
