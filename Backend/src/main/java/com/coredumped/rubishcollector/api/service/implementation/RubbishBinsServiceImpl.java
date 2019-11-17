package com.coredumped.rubishcollector.api.service.implementation;

import com.coredumped.rubishcollector.api.model.RubbishBins;
import com.coredumped.rubishcollector.api.model.enums.RubbishBinFraction;
import com.coredumped.rubishcollector.api.model.enums.RubbishBinState;
import com.coredumped.rubishcollector.api.model.enums.RubbishBinType;
import com.coredumped.rubishcollector.api.repository.RubbishBinsRepository;
import com.coredumped.rubishcollector.api.service.RubbishBinsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RubbishBinsServiceImpl implements RubbishBinsService {

    private final RubbishBinsRepository rubbishBinsRepository;

    @Override
    public List<RubbishBins> getRubbishBins(){
        return rubbishBinsRepository.getRubbishBinsByCountry(RubbishBinState.POLAND);
    }

    @Override
    public List<RubbishBins> getRubbishBinsByFillEquals(Integer fill){
        return rubbishBinsRepository.getRubbishBinsByFillEquals(fill);
    }

    @Override
    @Transactional
    public ResponseEntity<Object> updateRubbishBin(RubbishBins rubbishBins, Long id){
        Optional<RubbishBins> rubbishBinsOptional = rubbishBinsRepository.findById(id);
        if(!rubbishBinsOptional.isPresent())
            return ResponseEntity.notFound().build();
        rubbishBins.setCity("Kielce");
        rubbishBins.setCountry(RubbishBinState.POLAND);
        rubbishBins.setType(RubbishBinType.MIEJSKI);
        rubbishBins.setFraction(RubbishBinFraction.MIXED);
        rubbishBins.setFill(100);

        rubbishBinsRepository.save(rubbishBins);
        return ResponseEntity.noContent().build();
    }
}
