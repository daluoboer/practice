package com.radish.thinking.unit12;

import com.radish.thinking.unit7.B;

class BaseballException extends Exception {}
class Foul extends BaseballException{}
class Strike  extends BaseballException{}
abstract class Inning {
    public Inning() throws BaseballException{}
    public void event() throws BaseballException{}
    public abstract void atBat()throws Strike,Foul;
    public void walk(){};
}

class StormException extends Exception{}
class RainedOut extends StormException{}
class PopFoul extends Foul{}

interface Storm{
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm{

    public StormyInning() throws RainedOut,BaseballException {}

    public StormyInning(String s) throws Foul,BaseballException{}

    public void rainHard() throws RainedOut{}
    @Override
    public void event() {
    }

    @Override
    public void atBat() throws PopFoul {

    }

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
        } catch (PopFoul e) {
            e.printStackTrace();
        } catch (RainedOut e) {
            e.printStackTrace();
        } catch (BaseballException e) {
            e.printStackTrace();
        }
        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch (Strike e) {
            e.printStackTrace();
        } catch (Foul e) {
            e.printStackTrace();
        } catch (RainedOut e) {
            e.printStackTrace();
        } catch (BaseballException e) {
            e.printStackTrace();
        }
    }
}
