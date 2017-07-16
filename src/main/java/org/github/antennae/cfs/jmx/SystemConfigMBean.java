package org.github.antennae.cfs.jmx;

/**
 * Created by snambi on 7/15/17.
 */
public interface  SystemConfigMBean {

    public void setThreadCount(int noOfThreads);
    public int getThreadCount();

    public void setName(String name);
    public String getName();
}
