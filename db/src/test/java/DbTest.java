import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DbTest {

    @Test
    public void testDbConstructor_validArgument_success() {
        DbSetting dbSetting = new DbSetting("testName", "testPassword");
        
        Db db = new Db(dbSetting);
        
        Assertions.assertEquals(dbSetting, db.getDbSetting());
        Assertions.assertNotNull(db.getMyEntity());
        Assertions.assertEquals("first", db.getMyEntity().getName());
        Assertions.assertNotNull(db.getMyEntity().getId());
    }

    @Test
    public void testSetMyEntity_validArgument_success() {
        DbSetting dbSetting = new DbSetting("test", "pass");
        Db db = new Db(dbSetting);
        MyEntity newEntity = new MyEntity("newEntity");
        
        db.setMyEntity(newEntity);
        
        Assertions.assertEquals(newEntity, db.getMyEntity());
        Assertions.assertEquals("newEntity", db.getMyEntity().getName());
    }

    @Test
    public void testGetDbSetting_validArgument_success() {
        DbSetting expectedSetting = new DbSetting("name", "password");
        Db db = new Db(expectedSetting);
        
        DbSetting actualSetting = db.getDbSetting();
        
        Assertions.assertEquals(expectedSetting, actualSetting);
    }
}