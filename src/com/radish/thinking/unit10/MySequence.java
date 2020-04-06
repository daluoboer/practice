package com.radish.thinking.unit10;

public class MySequence {
    private int next = 0;
    private Object[] myObjs;
    MySequence(int size){
        myObjs = new Object[size];
    }
    public void add(Object o){
        if(next<myObjs.length)
            myObjs[next++] = o;
        else System.out.println("容量已达上限！不能再多啦！");
    }
    private class SequenceSelector implements Selector{
        private int i=0;

        @Override
        public boolean end() {
            return i == myObjs.length;
        }

        @Override
        public Object current() {
            return myObjs[i];
        }

        @Override
        public void next() {
            if(i<myObjs.length) i++;
        }

        public MySequence getSequence(){
            return MySequence.this;
        }
    }
    public SequenceSelector getSelector(){
        return new SequenceSelector();
    }
    public static void main(String[] args) {
        MySequence mySequence = new MySequence(20);
        for(int i=0;i<22;i++){
            //MyString myStr = new MyString("我是第"+(i+1)+"个Object");
            MyStringInner myStr = new MyStringInner("你的"+(i+1)+"个Object");
            mySequence.add(myStr);
        }
        SequenceSelector selector = mySequence.getSelector();
        while(!selector.end()){
            System.out.println(selector.current().toString());
            selector.next();
        }
        System.out.println(selector.getSequence());

    }
}
