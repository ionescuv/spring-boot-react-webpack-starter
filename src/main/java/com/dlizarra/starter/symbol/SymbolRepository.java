package com.dlizarra.starter.symbol;

import com.dlizarra.starter.support.jpa.CustomJpaRepository;
import com.dlizarra.starter.user.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SymbolRepository extends CustomJpaRepository<Symbol, Long> {

    Optional<Symbol> findByShortcut(String shortcut);

}
