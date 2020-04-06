package com.radish.thinking.unit9;

public class Filter {
    public String name(){
        return getClass().getSimpleName();
    }
    public Waveform process(Waveform input){return input;}
}
