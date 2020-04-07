package com.radish.concurrents;

import java.text.MessageFormat;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/19
 */

public class ThreadGroupTest {
    public static void main(String[] args) {
        String mainThreadGroupName = Thread.currentThread().getThreadGroup().getName();
        System.out.println(mainThreadGroupName);
        new Thread(()->{},"my thread1").start();

        ThreadGroup myGroup = new ThreadGroup("MyGroup");
        myGroup.setMaxPriority(5);

        Runnable runnable = ()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            String threadGroupName = threadGroup.getName();
            ThreadGroup groupParent = threadGroup.getParent();
            String groupParentName = groupParent.getName();
            ThreadGroup grandpaGroup = groupParent.getParent();
            String grandpaGroupName = grandpaGroup.getName();
            int maxPriority = threadGroup.getMaxPriority();
            int activeCount = myGroup.activeCount();
            System.out.println(MessageFormat.format("{0}<-{1}<-{2}({3})-<{4}",
                    grandpaGroupName,
                    groupParentName,
                    threadGroupName,
                    activeCount,
                    Thread.currentThread().getName()));
        };
        new Thread(myGroup,runnable,"my Thread2").start();
    }
}
