package casa.loma.game

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class CasaLomaGameTester {

    @BeforeEach
    fun setUp() {
        CasaLomaGame::class.java.getDeclaredMethod("initializeRooms").apply {
            isAccessible = true
            invoke(null)
        }

        CasaLomaGame::class.java.getDeclaredMethod("initializeNPCs").apply {
            isAccessible = true
            invoke(null)
        }
    }

    @Test
    fun `test NPCs are initialized correctly`() {
        val npcs = CasaLomaGame.getNPCsArray()
        assertNotNull(npcs, "NPCs array should not be null")
        assertEquals(4, npcs.size, "Expected 4 NPCs to be initialized")

        val names = npcs.map { it.getName() }
        assertTrue("Alejandro" in names, "Alejandro should be an NPC")
        assertTrue("Bob" in names, "Bob should be an NPC")
        assertTrue("Becky" in names, "Becky should be an NPC")
        assertTrue("Preet" in names, "Preet should be an NPC")
    }

    @Test
    fun `test room initialization`() {
        val roomsField = CasaLomaGame::class.java.getDeclaredField("rooms").apply { isAccessible = true }
        val rooms = roomsField.get(null) as Array<Room>

        assertNotNull(rooms, "Rooms array should not be null")
        assertEquals(10, rooms.size, "Expected 10 rooms to be initialized")

        val roomNames = rooms.map { it.getRoomName() }
        assertTrue("Clock In" in roomNames, "Clock In room should exist")
        assertTrue("Library" in roomNames, "Library room should exist")
    }

    @Test
    fun `test interacting with NPCs in a room`() {
        val method = CasaLomaGame::class.java.getDeclaredMethod("interactWithNPCsInRoom", Int::class.java)
        method.isAccessible = true
        
        assertDoesNotThrow { method.invoke(null, 0) } // Test room 0 (Clock In) without crashing
    }
}
