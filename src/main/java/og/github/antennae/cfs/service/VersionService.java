package og.github.antennae.cfs.service;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by nsankaran on 6/23/17.
 */
@Component
public class VersionService {

    Random random = new Random();

    public String version(){
        String result = "" + random.nextInt(10)  + "." + random.nextInt(10) + "." + random.nextInt(10);
        return result;
    }
}
