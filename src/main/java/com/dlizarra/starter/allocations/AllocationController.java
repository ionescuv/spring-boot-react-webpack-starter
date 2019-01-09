package com.dlizarra.starter.allocations;

import com.dlizarra.starter.support.orika.OrikaBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AllocationController {

    @Autowired
    AllocationService allocationService;

    @Autowired
    private OrikaBeanMapper mapper;

    @RequestMapping(value = "/api/allocations", method = RequestMethod.GET)
    public List<AllocationDto> findAll() {
        List<Allocation> allocations = allocationService.getAllocations();
        List<AllocationDto> allocationsDto = new ArrayList<AllocationDto>();
        allocations.forEach(allocation -> allocationsDto.add(mapper.map(allocation, AllocationDto.class)));
        return allocationsDto;
    }

    @RequestMapping(value = "/api/allocations/{symbol}", method = RequestMethod.GET)
    public AllocationDto findById(@PathVariable String symbol) {
        final Allocation allocation = allocationService.getAllocation(symbol);
        return mapper.map(allocation, AllocationDto.class);
    }

    @RequestMapping(value = "/api/allocations", method = RequestMethod.POST)
    public void postAllocation(AllocationDto allocationDto) {
        final Allocation allocation = mapper.map(allocationDto, Allocation.class);
        allocationService.createAllocation(allocation);
    }

    @RequestMapping(value = "/api/allocations/{symbol}", method = RequestMethod.DELETE)
    public void deleteAllocation(@PathVariable String symbol) {
        allocationService.deleteAllocation(symbol);
    }

    @RequestMapping(value = "/api/allocations/{symbol}", method = RequestMethod.PUT)
    public void updateAllocation(@PathVariable String symbol, AllocationDto allocationDto) {
        final Allocation allocation = mapper.map(allocationDto, Allocation.class);
        allocationService.updateAllocation(allocation);
    }


}
