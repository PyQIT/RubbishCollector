package com.coredumped.rubishcollector.api.service.implementation;

import com.coredumped.rubishcollector.api.model.RubbishBins;
import com.coredumped.rubishcollector.api.model.enums.RubbishBinState;
import com.coredumped.rubishcollector.api.repository.RubbishBinsRepository;
import com.coredumped.rubishcollector.api.service.RubbishBinsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
