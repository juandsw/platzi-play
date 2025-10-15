package com.platzi.play.persistence.mapper;

import com.platzi.play.domain.State;
import org.mapstruct.Named;

public class StateMapper {

    private StateMapper() {
        throw new IllegalStateException("Utility class");
    }

    @Named("stringToState")
    public static State stringToState(String state) {
        if(state == null) return null;

       return switch (state) {
           case "D" -> State.D;
           case "N" -> State.N;
           default -> null;
       };
    }

    @Named("stateToString")
    public static String stateToString(State state) {
        if(state == null) return null;

        return switch (state) {
            case D -> "D";
            case N -> "N";
        };
    }
}
