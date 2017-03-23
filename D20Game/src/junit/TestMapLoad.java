package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import load.LoadMap;
import objects.Matrix;

public class TestMapLoad {

	Matrix singleMap;
	static ArrayList<Matrix> allMaps;
	LoadMap loadMapObj;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		allMaps = new LoadMap().readMap();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	
	@Test
	public void test_notExists() {
		
	assertNull(singleMap);	
		
	}
	
	@Test
	public void test_exists() {
	
	singleMap = allMaps.get(0);	
	assertNotNull(singleMap);	
		
	}


}
