package factoryes;
import models.Category;
import models.Pet;
import org.apache.commons.lang3.RandomStringUtils;

import static org.apache.commons.lang3.RandomStringUtils.*;

public class PetFactory {
    public Pet createRandomPet(){
        int id = 1 + (int) (Math.random()*9999);
        String name = RandomStringUtils.randomAlphabetic(1,15);
        return new Pet(id, name);
    }




}
