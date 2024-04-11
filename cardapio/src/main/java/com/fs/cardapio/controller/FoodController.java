package com.fs.cardapio.controller;

import com.fs.cardapio.entity.Food;
import com.fs.cardapio.entity.FoodRepository;
import com.fs.cardapio.entity.dto.FoodRequestDTO;
import com.fs.cardapio.entity.dto.FoodResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {

    private final FoodRepository repository;

    @Operation(summary = "Listando o cardapio", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK quando a listagem for concluida"),
            @ApiResponse(responseCode = "403", description = "Fail por chamar o get")
    })
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

    @Operation(summary = "realizando a publicação de um novo produto", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK quando o produto for cadastrado"),
            @ApiResponse(responseCode = "403", description = "Fail por erro de Syntax")
    })
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void publiFood(@RequestBody FoodRequestDTO data){

        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }

}
