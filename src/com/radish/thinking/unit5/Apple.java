package com.radish.thinking.unit5;

class Apple{
    Apple getPeeled(){
        return Peeler.peel(this);
    }
}
