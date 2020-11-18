package factoryes;

import models.Tag;
import org.apache.commons.lang3.RandomStringUtils;

public class TagFactory {
    public Tag createRandomTag(){
        int id = 1 + (int) (Math.random()*9999);
        String name = RandomStringUtils.randomAlphabetic(1,15);
        return new Tag(id, name);
    }
}
