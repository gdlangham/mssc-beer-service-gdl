package dev.gregl.msscbeerservice.web.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class BeerPageList extends PageImpl<BeerDto> {

    public BeerPageList(final List<BeerDto> content, final Pageable pageable, final long total) {
        super(content, pageable, total);
    }

    public BeerPageList(final List<BeerDto> content) {
        super(content);
    }
}
