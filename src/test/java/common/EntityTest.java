package common;

import org.junit.Test;

import static org.junit.Assert.*;

public class EntityTest {

    @Test
    public void two_entity_with_same_reference_should_equals() {
        FakeEntity fakeEntity = new FakeEntity(0L);

        assertEquals(fakeEntity, fakeEntity);
    }

    @Test
    public void two_entity_with_same_id_should_equals() {
        assertEquals(
                new FakeEntity(1L),
                new FakeEntity(1L)
        );
    }

    @Test
    public void two_entity_with_different_id_should_not_equals() {
        assertNotEquals(
                new FakeEntity(0L),
                new FakeEntity(1L)
        );
    }

    private static class FakeEntity extends Entity {
        FakeEntity(Long id) {
            setId(id);
        }
    }
}