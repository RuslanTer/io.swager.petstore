package factoryes;

import models.Category;
import models.Pet;
import org.apache.commons.lang3.RandomStringUtils;

public class CategoryFactory {
    public Category createRandomCategory(){
        int id = 1 + (int) (Math.random()*9999);
        String name = RandomStringUtils.randomAlphabetic(1,15);
        return new Category(id, name);
    }
}
