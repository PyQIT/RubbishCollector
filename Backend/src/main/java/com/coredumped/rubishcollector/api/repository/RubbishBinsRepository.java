package com.coredumped.rubishcollector.api.repository;

import com.coredumped.rubishcollector.api.model.RubbishBins;
import com.coredumped.rubishcollector.api.model.enums.RubbishBinState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubbishBinsRepository extends JpaRepository<RubbishBins, Long> {
    List<RubbishBins> getRubbishBinsByCountry(RubbishBinState rubbishBinState);
    List<RubbishBins> getRubbishBinsByFillEquals(Integer fill);
}
