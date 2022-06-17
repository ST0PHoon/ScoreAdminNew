package kr.ac.kopo.ctc.kopo37.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.kopo.ctc.kopo37.dao.ScoreItemDao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kr.ac.kopo.ctc.kopo37.dao.ScoreItemDao;
import kr.ac.kopo.ctc.kopo37.dao.ScoreItemDaoMock;
import kr.ac.kopo.ctc.kopo37.dto.Pagination;

class ScoreItemServiceTest {

	private ScoreItemDao scoreItemDao = new ScoreItemDaoMock();
	private ScoreItemService scoreItemService = new ScoreItemServiceImpl();
	
	@BeforeEach
	void setUp() throws Exception {
		scoreItemService.setScoreItemDao(scoreItemDao);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testGetPagination() {
		Pagination p = scoreItemService.getPagination(1, 15, 50, 1025);
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getnPage(), 16);
		assertEquals(p.getNnPage(), 21);
		assertEquals(p.getcPage(), 1);
	}

}
