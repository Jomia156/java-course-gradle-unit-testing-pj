import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.UUID;

public class MyEntityTest {

    @Test
    public void testMyEntityConstructor_validArgument_success() {
        String expectedName = "testEntity";
        
        MyEntity entity = new MyEntity(expectedName);
        
        Assertions.assertEquals(expectedName, entity.getName());
        Assertions.assertNull(entity.getId());
    }

    @Test
    public void testSetId_validArgument_success() {
        MyEntity entity = new MyEntity("test");
        UUID expectedId = UUID.randomUUID();
        
        entity.setId(expectedId);
        
        Assertions.assertEquals(expectedId, entity.getId());
    }

    @Test
    public void testToString_validArgument_success() {
        MyEntity entity = new MyEntity("test");
        UUID id = UUID.fromString("12345678-1234-1234-1234-123456789012");
        entity.setId(id);
        
        String result = entity.toString();
        
        Assertions.assertTrue(result.contains("MyEntity{"));
        Assertions.assertTrue(result.contains("id=12345678-1234-1234-1234-123456789012"));
        Assertions.assertTrue(result.contains("name='test'"));
    }
}