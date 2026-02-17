package com.azship.shipping.adapter.outbound.persistence.inbound.controller;

import com.azship.shipping.application.usecase.*;
import com.azship.shipping.domain.model.Freight;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/freights")
public class FreightController {

    private final CreateFreightUseCase createFreightUseCase;
    private final SearchFreightUseCase searchFreightUseCase;
    private final GetFreightByIdUseCase getFreightByIdUseCase;
    private final UpdateFreightUseCase updateFreightUseCase;
    private final DeleteFreightUseCase deleteFreightUseCase;


    public FreightController(CreateFreightUseCase createFreightUseCase,
                             SearchFreightUseCase searchFreightUseCase,
                             GetFreightByIdUseCase getFreightByIdUseCase,
                             UpdateFreightUseCase updateFreightUseCase,
                             DeleteFreightUseCase deleteFreightUseCase) {
        this.createFreightUseCase = createFreightUseCase;
        this.searchFreightUseCase = searchFreightUseCase;
        this.getFreightByIdUseCase = getFreightByIdUseCase;
        this.updateFreightUseCase = updateFreightUseCase;
        this.deleteFreightUseCase = deleteFreightUseCase;
    }

    @PostMapping
    public Freight create(@Valid @RequestBody CreateFreightRequest request) {

        return createFreightUseCase.execute(
                request.clientId(),
                request.description(),
                request.properties()
        );
    }

    @PutMapping("/{id}")
    public Freight update(@PathVariable UUID id,
                          @RequestBody UpdateFreightRequest request) {

        return updateFreightUseCase.execute(
                id,
                request.description(),
                request.properties()
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        deleteFreightUseCase.execute(id);
    }


    @GetMapping("/{id}")
    public Freight getById(@PathVariable UUID id) {
        return getFreightByIdUseCase.execute(id);
    }

    @GetMapping
    public Page<Freight> search(
            @RequestParam(required = false, defaultValue = "") String query,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return searchFreightUseCase.execute(
                query,
                PageRequest.of(page, size)
        );
    }



    /*DTO*/
    public record CreateFreightRequest(
            @NotBlank
            String clientId,
            String description,
            Map<String, Object> properties
    ) {}

    public record UpdateFreightRequest(
            String description,
            Map<String, Object> properties
    ) {}
}
