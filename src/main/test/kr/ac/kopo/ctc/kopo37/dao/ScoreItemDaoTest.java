package kr.ac.kopo.ctc.kopo37.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.kopo.ctc.kopo37.domain.ScoreItem;

class ScoreItemDaoTest {

	private ScoreItemDao scoreItemDao = new ScoreItemDaoImpl();
	
//	@Test
//	void testinsert() {
//		ScoreItem scoreItemInput = new ScoreItem();
//		scoreItemInput.setName("나연");
//		scoreItemInput.setStudentId(209920);
//		scoreItemInput.setKor(95);
//		scoreItemInput.setEng(100);
//		scoreItemInput.setMat(95);
//		
//		scoreItemDao.insert(scoreItemInput);
//		
//		ScoreItem scoreItemOutput = scoreItemDao.selectOne(209920);
//		
//		assertEquals(scoreItemOutput.getName(), scoreItemInput.getName());
//		assertEquals(scoreItemOutput.getId(), scoreItemInput.getId());
//	}
	
	@Test
	void testDelete() {

		int id = 0;
		
		scoreItemDao.delete(id);
		
		int afterDataLength = scoreItemDao.selectTotalCount();
		
		assertEquals(19, afterDataLength);
	}
//	
//	@Test
//	void testUpdate() {
//		ScoreItem scoreItemInput = new ScoreItem();
//		ScoreItem scoreItemOutput = new ScoreItem();
//		
//		scoreItemInput.setName("나연");
//		scoreItemInput.setStudentId(209901);
//		scoreItemInput.setKor(40);
//		scoreItemInput.setEng(40);
//		scoreItemInput.setMat(40);
//		
//		scoreItemDao.update(scoreItemInput);
//		
//		scoreItemOutput = scoreItemDao.selectOne(209901);
//		
//		assertEquals("나연", scoreItemOutput.getName());
//		assertEquals(209901, scoreItemOutput.getStudentId());
//		assertEquals(40, scoreItemOutput.getKor());
//		assertEquals(40, scoreItemOutput.getEng());
//		assertEquals(40, scoreItemOutput.getMat());
//	}
	
//	@Test
//	void testSelectOne() {
//		ScoreItem scoreItemOutput = new ScoreItem();
//		
//		scoreItemOutput = scoreItemDao.selectOne(209901);
//		
//		assertEquals("나연", scoreItemOutput.getName());
//		assertEquals(209901, scoreItemOutput.getStudentId());
//		assertEquals(40, scoreItemOutput.getKor());
//		assertEquals(40, scoreItemOutput.getEng());
//		assertEquals(40, scoreItemOutput.getMat());
//	}
//	
//	@Test
//	void testSelectAll() {
//		
//		int afterDataLength = scoreItemDao.selectTotalCount();
//		
//		assertEquals(19, afterDataLength);
//	}

}
