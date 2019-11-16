package com.coredumped.rubishcollector.api.transformer;

import com.coredumped.rubishcollector.api.dto.RubbishBinsDto;
import com.coredumped.rubishcollector.api.model.RubbishBins;
import org.springframework.beans.BeanUtils;

public class RubbishBinsTransformer {

    public static RubbishBinsDto convertToDto(RubbishBins rubbishBins) {
        RubbishBinsDto rubbishBinsDto = new RubbishBinsDto();
        BeanUtils.copyProperties(rubbishBins, rubbishBinsDto);
        return rubbishBinsDto;
    }

    public static RubbishBins convertToEntity(RubbishBinsDto rubbishBinsDto) {
        RubbishBins rubbishBins = new RubbishBins();
        BeanUtils.copyProperties(rubbishBinsDto, rubbishBins);
        return rubbishBins;
    }
}
