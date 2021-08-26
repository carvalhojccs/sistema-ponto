package br.com.paraclean.ponto.service;

import br.com.paraclean.ponto.dto.EmpresaDTO;
import br.com.paraclean.ponto.model.Empresa;
import br.com.paraclean.ponto.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    @Transactional(readOnly = true)
    public List<EmpresaDTO> findAll() {

        List<Empresa> list = empresaRepository.findAll();
        return list.stream().map(x -> new EmpresaDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public EmpresaDTO insert(EmpresaDTO dto) {
        Empresa empresa = new Empresa(
                null,
                dto.getDescricao(),
                dto.getCnpj(),
                dto.getEndereco(),
                dto.getBairro(),
                dto.getCidade(),
                dto.getEstado(),
                dto.getTelefone());
        empresa = empresaRepository.save(empresa);

        return new EmpresaDTO(empresa);
    }

    @Transactional
    public EmpresaDTO update(Long id, EmpresaDTO dto) {
        if(empresaRepository.findById(id).isPresent()) {
            Empresa empresa = empresaRepository.findById(id).get();

            empresa.setDescricao(dto.getDescricao());
            empresa.setCnpj(dto.getCnpj());
            empresa.setEndereco(dto.getEndereco());
            empresa.setBairro(dto.getBairro());
            empresa.setCidade(dto.getCidade());
            empresa.setEstado(dto.getEstado());
            empresa.setTelefone(dto.getTelefone());

            Empresa updateEmpresa = empresaRepository.save(empresa);
            return  new EmpresaDTO(
                    updateEmpresa.getDescricao(),
                    updateEmpresa.getCnpj(),
                    updateEmpresa.getEndereco(),
                    updateEmpresa.getBairro(),
                    updateEmpresa.getCidade(),
                    updateEmpresa.getEstado(),
                    updateEmpresa.getTelefone());
        } else {
            return null;
        }
    }

    @Transactional
    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }


}
