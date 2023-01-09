package com.rfindustries.core.utils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class ReactorUtils {

    private ReactorUtils(){
        // NOT implemented
    }

    public static <T> Mono<T> fluxToMono(Flux<T> fluxData){
        Mono<T> result = Mono.empty();

        if(fluxData != null){
            result = fluxData.collect(Collectors.reducing((i1, i2) -> i1))
                    .map(Optional::get);
        }


        return result;
    }

    public static <T> Mono<List<T>> fluxToMonoList(Flux<T> fluxData){
        Mono<List<T>> result = Mono.empty();

        if(fluxData != null){
            result = fluxData.collectList();
        }

        return result;
    }
}
