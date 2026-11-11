import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MyServiceTest {

    @Test
    public void testGetName_validArgument_success() {
        MyService service = new MyService();
        
        String name = service.getName();
        
        Assertions.assertEquals("myService", name);
    }

    @Test
    public void testSetMyEntity_validArgument_success() {
        MyService service = new MyService();
        MyEntity entity = new MyEntity("testEntity");
        
        MyEntity result = service.setMyEntity(entity);
        
        Assertions.assertNotNull(result.getId());
        Assertions.assertEquals("testEntity", result.getName());
        Assertions.assertEquals(result, service.getMyEntity());
    }

    @Test
    public void testGetMyEntity_validArgument_success() {
        MyService service = new MyService();
        
        MyEntity entity = service.getMyEntity();
        
        Assertions.assertNotNull(entity);
        Assertions.assertEquals("first", entity.getName());
        Assertions.assertNotNull(entity.getId());
    }

    @Test
    public void testSetMyEntity_changesEntity_success() {
        MyService service = new MyService();
        MyEntity originalEntity = service.getMyEntity();
        MyEntity newEntity = new MyEntity("second");
        
        MyEntity result = service.setMyEntity(newEntity);
        
        Assertions.assertNotEquals(originalEntity.getId(), result.getId());
        Assertions.assertEquals("second", service.getMyEntity().getName());
    }
}