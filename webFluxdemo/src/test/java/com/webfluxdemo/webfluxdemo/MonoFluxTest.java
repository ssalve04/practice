package com.webfluxdemo.webfluxdemo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

//    @Test
//    public void testMono(){
//        // mono and flux acts as publisher
//        //log() used to print the execution in console
//        Mono<?> monoString = Mono.just("abcd").
//                                then(Mono.error(new RuntimeException("Exception Occurred"))).log();
//
//        // to access the publisher, subscriber need to call the subscriber method from publisher
//        // here monoString is publisher
//        monoString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
//    }


    @Test
    public void testFlux(){

        Flux<String> fluxString= Flux.just("string1","String2","String3")
                                    .concatWithValues("another new string")
                                    .concatWith(Flux.error(new RuntimeException("This is exception")))
                                    .log();

        fluxString.subscribe(System.out::println);

    }

}
