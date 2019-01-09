package com.dlizarra.starter.allocations;

import com.dlizarra.starter.support.jpa.CustomJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationRepository extends CustomJpaRepository<Allocation, String> {
}
