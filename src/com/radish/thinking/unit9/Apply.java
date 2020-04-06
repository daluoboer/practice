package com.radish.thinking.unit9;

import java.util.Arrays;
class Processor{
    public String name(){
        return getClass().getSimpleName();
    }
    Object process(Object input){return input;}
}
class Upcase extends Processor {
    @Override
    Object process(Object input) {
        return ((String)input).toUpperCase();
    }
}
class Downcase extends Processor{
    @Override
    Object process(Object input) {
        return ((String)input).toLowerCase();
    }
}
class Spiltter extends Processor{
    @Override
    String process(Object input){
        return Arrays.toString(((String)input).split(" "));
    }
}
public class Apply {
    public static void process(Processor p,Object s){
        System.out.println("Using processor "+p.name());
        System.out.println(p.process(s));
    }
    public static String s = "Disagreement with beliefs is by definition incorrect.";

    public static void main(String[] args) {
        process(new Upcase(),s);
        process(new Downcase(),s);
        process(new Spiltter(),s);
    }
}
