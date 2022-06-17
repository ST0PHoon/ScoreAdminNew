package kr.ac.kopo.ctc.kopo37.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.kopo.ctc.kopo37.domain.ScoreItem;

class ScoreItemDaoTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	private ScoreItemDao scoreItemDao = new ScoreItemDaoImpl();
	
	void testCreate() {
		ScoreItem scoreItemInput = new ScoreItem();
//		scoreItemInput.setId(1);
		scoreItemInput.setName("홍길동");
		scoreItemInput.setStudentId(1);
		scoreItemInput.setKor(100);
		scoreItemInput.setEng(90);
		scoreItemInput.setMat(80);
		
		ScoreItem scoreItemOutput = scoreItemDao.create(scoreItemInput);
		
		assertEquals(scoreItemOutput.getName(), "홍길동");
		assertEquals(scoreItemOutput.getId(), 1);
	}

}
