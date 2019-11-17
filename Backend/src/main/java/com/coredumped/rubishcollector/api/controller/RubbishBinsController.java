package com.coredumped.rubishcollector.api.controller;

import com.coredumped.rubishcollector.api.dto.RubbishBinsDto;
import com.coredumped.rubishcollector.api.model.RubbishBins;
import com.coredumped.rubishcollector.api.service.RubbishBinsService;
import com.coredumped.rubishcollector.api.transformer.RubbishBinsTransformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/rubbishbin")
@Slf4j
public class RubbishBinsController {

    private final RubbishBinsService rubbishBinsService;

    @GetMapping("/admin")
    @ResponseStatus(HttpStatus.OK)
    public List<RubbishBinsDto> getRubbishBins(){
        List<RubbishBins> rubbishBins = rubbishBinsService.getRubbishBins();
        return rubbishBins.stream().map(RubbishBinsTransformer::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{fill}")
    @ResponseStatus(HttpStatus.OK)
    public List<RubbishBinsDto> getRubbishBinsByFillEquals(@PathVariable Integer fill){
        List<RubbishBins> rubbishBins = rubbishBinsService.getRubbishBinsByFillEquals(fill);
        return rubbishBins.stream().map(RubbishBinsTransformer::convertToDto).collect(Collectors.toList());
    }

    @PutMapping("/client/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> updateRubbishBinStatus(@RequestBody RubbishBins rubbishBins, @PathVariable Long id){
        return rubbishBinsService.updateRubbishBin(rubbishBins,id);
    }


}
