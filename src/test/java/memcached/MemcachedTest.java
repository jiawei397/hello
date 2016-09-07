package memcached;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MemcachedTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp-------");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("---------tearDown");
	}

	@Test
	public void testTest() {
		memcached.Test test  = new memcached.Test();
		test.test();
	}

}
