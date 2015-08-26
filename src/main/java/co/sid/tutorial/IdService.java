package co.sid.tutorial;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Anis on 8/26/2015.
 */

@Service
public class IdService {

    long seed = 0;
    public IdService(){
        seed = System.currentTimeMillis();
    }

    public String generateId(){
        return UUID.randomUUID().toString();
    }
}
