package br.com.paraclean.ponto.controller;

import br.com.paraclean.ponto.dto.EmpresaDTO;
import br.com.paraclean.ponto.model.Empresa;
import br.com.paraclean.ponto.service.EmpresaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    @ApiOperation(value = "Retorna todas as empresas")
    public ResponseEntity<List<EmpresaDTO>> findAll() {
        List<EmpresaDTO> list = empresaService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<EmpresaDTO> insert(@RequestBody EmpresaDTO dto) {
        dto = empresaService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmpresaDTO> update(@PathVariable(value = "id") Long id, @RequestBody EmpresaDTO dto) {
        EmpresaDTO uodateDto = empresaService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Empresa> deleteById(@PathVariable("id") Long id) throws Exception {
        try{
            empresaService.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return (ResponseEntity<Empresa>) ResponseEntity.ok();
    }

}
