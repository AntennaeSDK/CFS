package org.github.antennae.cfs.jmx;

/**
 * Created by snambi on 7/15/17.
 */
public class SystemConfig implements SystemConfigMBean{

    private int threadCount=0;
    private String name;

    public SystemConfig( String name, int count){
        this.name = name;
        this.threadCount = count;
    }

    @Override
    public void setThreadCount(int noOfThreads) {
        this.threadCount = noOfThreads;
    }

    @Override
    public int getThreadCount() {
        return threadCount;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
