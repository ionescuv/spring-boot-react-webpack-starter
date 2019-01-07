package com.dlizarra.starter.holdings;

import com.dlizarra.starter.support.orika.OrikaBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HoldingController {

    @Autowired
    HoldingService holdingService;

    @Autowired
    private OrikaBeanMapper mapper;

    @RequestMapping(value = "/api/holdings", method = RequestMethod.GET)
    public List<HoldingDto> findAll() {
        List<Holding> holdings = holdingService.getHoldings();
        List<HoldingDto> holdingsDto = new ArrayList<HoldingDto>();
        holdings.forEach(holding -> holdingsDto.add(mapper.map(holding, HoldingDto.class)));
        return holdingsDto;
    }

    @RequestMapping(value = "/api/holdings/{symbol}", method = RequestMethod.GET)
    public HoldingDto findById(@PathVariable String symbol) {
        final Holding holding = holdingService.getHolding(symbol);
        return mapper.map(holding, HoldingDto.class);
    }

    @RequestMapping(value = "/api/holdings", method = RequestMethod.POST)
    public void postHolding(HoldingDto holdingDto) {
        final Holding holding = mapper.map(holdingDto, Holding.class);
        holdingService.createHolding(holding);
    }

    @RequestMapping(value = "/api/holdings/{symbol}", method = RequestMethod.DELETE)
    public void deleteHolding(@PathVariable String symbol) {
        holdingService.deleteHolding(symbol);
    }

    @RequestMapping(value = "/api/holdings/{symbol}", method = RequestMethod.PUT)
    public void updateHolding(@PathVariable String symbol, HoldingDto holdingDto) {
        final Holding holding = mapper.map(holdingDto, Holding.class);
        holdingService.updateHolding(holding);
    }


}
