import kotlin.test.*

class TestFuncs {
    @Test fun countSymbolTest() {
        val c = countSymbol("XAXAF",'A')
        assertEquals(2,c)
    }
    @Test fun genSecretTest() {
        val res = genSecretPairs()
        assertEquals(SIZE_PAIRS,res.length)
        val count = countSymbol(res,SYMBOLS[0])
        assertEquals(2,count)
    }
    @Test fun stringOfTest() {
        val res = stringOf(3..7)
        assertEquals("34567",res)
    }
    @Test fun validIndexTest() {
        val sut = validIndex('6')
        assertEquals(SIZE_PAIRS>6,sut)
        assertFalse(validIndex('A'))
    }
}