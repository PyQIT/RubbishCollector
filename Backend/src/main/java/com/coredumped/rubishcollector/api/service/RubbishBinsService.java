package com.coredumped.rubishcollector.api.service;

import com.coredumped.rubishcollector.api.model.RubbishBins;

import java.util.List;

public interface RubbishBinsService {

    List<RubbishBins> getRubbishBins();
    List<RubbishBins> getRubbishBinsByFillEquals(Integer fill);

}
