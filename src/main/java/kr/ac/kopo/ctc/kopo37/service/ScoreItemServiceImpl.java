package kr.ac.kopo.ctc.kopo37.service;

import java.util.List;

import kr.ac.kopo.ctc.kopo37.dao.ScoreItemDao;
import kr.ac.kopo.ctc.kopo37.dao.ScoreItemDaoImpl;
import kr.ac.kopo.ctc.kopo37.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo37.dto.Pagination;

public class ScoreItemServiceImpl implements ScoreItemService {
	private ScoreItemDao scoreItemDao = new ScoreItemDaoImpl();

	@Override
	public ScoreItemDao getScoreItemDao() {
		return scoreItemDao;
	}

	@Override
	public void setScoreItemDao(ScoreItemDao scoreItemDao) {
		this.scoreItemDao = scoreItemDao;
	}

	@Override
	public ScoreItem create(ScoreItem scoreItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScoreItem selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScoreItem> selectAll(int page, int countPerPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pagination getPagination(int currentPage, int countPerPage, int pageSize, int totalCount) {
		// currPage : 현재 페이지 , countPerPage : 한 페이지에 나올 숫자 목록, pageSize : 한 페이지 목록 수,
		// totalCount : 전체 목록 수
		// 현재 페이지가 1보다 작거나 같으면 > 현재 페이지는 1
		if (currentPage <= 1) {
			currentPage = 1;
		}
		// firstPage : 제일 처음 페이지
		int firstPage = 1;

		// finalPage : 제일 마지막 페이지
		int finalPage = (int) Math.ceil((double) totalCount / pageSize);

		// 현재 페이지가 마지막 페이지보다 크면 > 현재 페이지는 마지막 페이지
		if (currentPage > finalPage) {
			currentPage = finalPage;
		}

		// previousListPage : 앞 숫자 목록의 처음 숫자(<를 누르면 나오는 숫자)
		int previousListPage = (int) Math.floor((double) currentPage / countPerPage);
		// int previousListPage = (currPage/countPerPage) * countPerPage + 1;

		if (previousListPage <= 1) {
			previousListPage = 1;
		} else {
			previousListPage = (previousListPage - 1) * countPerPage + 1;
		}

		// nextListPage : 다음 목록의 처음 숫자 (>를 누르면 나오는 숫자)
		int nextListPage = (int) (Math.ceil((double) currentPage / countPerPage) * countPerPage) + 1;

		if (nextListPage > finalPage) {
			nextListPage = finalPage;
		}
		// 글이 없는경우
		if (totalCount == 0) {
			firstPage = 1;
			previousListPage = 1;
			nextListPage = 1;
			finalPage = 1;
			currentPage = 1;
		}

		Pagination pagination = new Pagination();
		pagination.setPpPage(firstPage);
		pagination.setpPage(previousListPage);
		pagination.setnPage(nextListPage);
		pagination.setNnPage(finalPage);
		pagination.setcPage(currentPage);

		return pagination;
	}
}
