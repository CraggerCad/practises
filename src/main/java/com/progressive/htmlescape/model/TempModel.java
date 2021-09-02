package com.progressive.htmlescape.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class TempModel {
    private String name;
    private int id;

    public Optional<TempModel> test(TempModel tempModel) {
        return Optional.ofNullable(tempModel).map(tempModel1 -> {
            this.name = tempModel.name;
            this.id = tempModel.id;
            return this;
        });
    }
}
