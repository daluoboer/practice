package com.radish.thinking.unit18;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class FreezeAlien {
    public static void main(String[] args) throws Exception{
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(new File("X.file")));
        Alien quellek = new Alien();
        out.writeObject(quellek);
    }
}
