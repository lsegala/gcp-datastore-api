package br.edu.lsegala.simplecrudapi.model;

import java.util.stream.Stream;

public enum AccessEnum {
    PUB, PRI;

    @Override
    public String toString() {
        return this.name();
    }

    public static AccessEnum findByName(String name){
        return Stream.of(AccessEnum.values())
                .filter(p -> p.name().equals(name))
                .findFirst()
                .orElse(PUB);
    }
}
