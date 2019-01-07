package com.dlizarra.starter.holdings;

import com.dlizarra.starter.support.jpa.CustomJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoldingRepository extends CustomJpaRepository<Holding, String> {
}
