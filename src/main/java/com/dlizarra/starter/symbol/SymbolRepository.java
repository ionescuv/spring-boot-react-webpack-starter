package com.dlizarra.starter.symbol;

import com.dlizarra.starter.support.jpa.CustomJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymbolRepository extends CustomJpaRepository<Symbol, Long> {

}
