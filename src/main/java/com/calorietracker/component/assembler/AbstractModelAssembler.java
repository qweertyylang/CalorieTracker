package com.calorietracker.component.assembler;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractModelAssembler<T, E extends RepresentationModel<?>>
    implements RepresentationModelAssembler<T, E> {

    @NonNull
    public List<E> toModelList(
        @NonNull Iterable<? extends T> entities
    ) {
        List<E> models = new ArrayList<>();

        for (T entity : entities) {
            models.add(toModel(entity));
        }

        return models;
    }
}
