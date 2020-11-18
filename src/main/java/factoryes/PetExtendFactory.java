package factoryes;
import models.*;
import org.apache.commons.lang3.RandomStringUtils;

public class PetExtendFactory {
    public Pet createRandomPet(){
        int id = 1 + (int) (Math.random()*9999);
        String name = RandomStringUtils.randomAlphabetic(1,15);
        Pet.status status = randomEnum(Pet.status.class);
        Category category = new CategoryFactory().createRandomCategory();
        String[] photoUrls = new String[] {RandomStringUtils.randomAlphabetic(1,15),};
        Tag[] tags = new Tag[] {new TagFactory().createRandomTag(),};
        return new Pet(id, name, photoUrls, tags, status, category);
    }

    private static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = 1 + (int) (Math.random()*(clazz.getEnumConstants().length))-1;
        return clazz.getEnumConstants()[x];
    }
}
