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
import kr.ac.kopo.ctc.kopo37.dto.ScoreItemsDto;

class ScoreItemServiceTest {

	private ScoreItemDao scoreItemDao = new ScoreItemDaoMock();
	private ScoreItemService scoreItemService = new ScoreItemServiceImpl();
	private ScoreItemsDto scoreItemDto = new ScoreItemsDto();

	@BeforeEach
	void setUp() throws Exception {
		scoreItemDto.setScoreItemDao(scoreItemDao);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// 페이지 수가 충분하고 일반적인 경우, 첫페이지
	@Test
	void testGetPagination() {
		Pagination p = scoreItemService.getPagination(1, 15, 50, 1025);
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getnPage(), 16);
		assertEquals(p.getNnPage(), 21);
		assertEquals(p.getcPage(), 1);
	}

	// 페이지 수가 충분하고 현재페이지가 음수로 입력된 경우, 음수
	void testGetPagination2() {
		Pagination p = scoreItemService.getPagination(-100, 15, 50, 1025);
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getnPage(), 16);
		assertEquals(p.getNnPage(), 21);
		assertEquals(p.getcPage(), 1);
	}

	// 페이지 수가 충분하고 현재 페이지가 값을 초과한 경우, 초과
	@Test
	void testGetPagination3() {
		Pagination pagination = scoreItemService.getPagination(10000, 15, 50, 1025);
		assertEquals(1, pagination.getPpPage());
		assertEquals(1, pagination.getpPage());
		assertEquals(21, pagination.getnPage());
		assertEquals(21, pagination.getNnPage());
		assertEquals(21, pagination.getcPage());
	}
	// 페이지 수가  충분하고 첫페이지에서 이동, 중간값
	@Test
	void testGetPagination4() {
		Pagination pagination = scoreItemService.getPagination(17, 15, 50, 1025);
		assertEquals(1, pagination.getPpPage());
		assertEquals(1, pagination.getpPage());
		assertEquals(21, pagination.getnPage());
		assertEquals(21, pagination.getNnPage());
		assertEquals(17, pagination.getcPage());
	}
	// 페이지 수가 충분하고 마지막 페이지에서 이동, 마지막
	@Test
	void testGetPagination5() {
		Pagination pagination = scoreItemService.getPagination(21, 15, 50, 1025);
		assertEquals(1, pagination.getPpPage());
		assertEquals(1, pagination.getpPage());
		assertEquals(21, pagination.getnPage());
		assertEquals(21, pagination.getNnPage());
		assertEquals(21, pagination.getcPage());
	}

	// 작성된 글이 극도로 적은 경우, 첫페이지
	@Test
	void testGetPagination6() {
		Pagination pagination = scoreItemService.getPagination(1, 15, 50, 140);
		assertEquals(1, pagination.getPpPage());
		assertEquals(1, pagination.getpPage());
		assertEquals(3, pagination.getnPage());
		assertEquals(3, pagination.getNnPage());
		assertEquals(1, pagination.getcPage());
	}

	// 작성된 글이 극도로 적은 경우, 현재페이지 음수
	@Test
	void testGetPagination7() {
		Pagination pagination = scoreItemService.getPagination(-10, 15, 50, 140);
		assertEquals(1, pagination.getPpPage());
		assertEquals(1, pagination.getpPage());
		assertEquals(3, pagination.getnPage());
		assertEquals(3, pagination.getNnPage());
		assertEquals(1, pagination.getcPage());
	}

	// 작성된 글이 극도로 적은 경우, 현재페이지 범위 초과
	@Test
	void testGetPagination8() {
		Pagination pagination = scoreItemService.getPagination(12, 15, 50, 140);
		assertEquals(1, pagination.getPpPage());
		assertEquals(1, pagination.getpPage());
		assertEquals(3, pagination.getnPage());
		assertEquals(3, pagination.getNnPage());
		assertEquals(3, pagination.getcPage());
	}

	// 작성된 글이 극도로 적은 경우, 15기준이지만 3페이지까지 밖에 없는 경우, 마지막 페이지
	@Test
	void testGetPagination9() {
		Pagination pagination = scoreItemService.getPagination(3, 15, 50, 140);
		assertEquals(1, pagination.getPpPage());
		assertEquals(1, pagination.getpPage());
		assertEquals(3, pagination.getnPage());
		assertEquals(3, pagination.getNnPage());
		assertEquals(3, pagination.getcPage());
	}

	// 작성된 글이 극도로 적은 경우, 페이지 이동, 중간값
	@Test
	void testGetPagination10() {
		Pagination pagination = scoreItemService.getPagination(2, 15, 50, 140);
		assertEquals(1, pagination.getPpPage());
		assertEquals(1, pagination.getpPage());
		assertEquals(3, pagination.getnPage());
		assertEquals(3, pagination.getNnPage());
		assertEquals(2, pagination.getcPage());
	}

}
