package kr.ac.kopo.ctc.kopo37.service;

import java.util.List;

import kr.ac.kopo.ctc.kopo37.dao.ScoreItemDao;
import kr.ac.kopo.ctc.kopo37.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo37.dto.Pagination;

public class ScoreItemServiceImpl implements ScoreItemService {
	private ScoreItemDao scoreItemDao;

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
//		ScoreItem scoreItem = scoreItemDao.selectOne(1);
		Pagination p = new Pagination();

		// 초기 보정
		// currentPage가 1보다 작거나 최대 길이를 초과했을 경우 보정.
		if (currentPage < 1) {
			currentPage = 1;
		}

		// totalCount가 countPerPage * pageSize 보다 작은경우
		if (totalCount < countPerPage * pageSize) {
			countPerPage = totalCount / pageSize + 1;
			if (totalCount % pageSize == 0) {
				countPerPage--;
			}
		}

		// 결과변수 선언
		int PpPageResult = 1;
		int pPageResult;
		int nPageResult;
		int NnPageResult;
		int cPageResult = currentPage;

		// pPageResult 세팅, 예외사항 - 1 아래로 내려갈 수 없음
		pPageResult = (int) Math.floor((double) currentPage / countPerPage);
		// int previousListPage = (currPage/countPerPage) * countPerPage + 1;

		if (pPageResult <= 1) {
			pPageResult = 1;
		} else {
			pPageResult = (pPageResult - 1) * countPerPage + 1;
		}

		// nPageResult 세팅, 예외사항 - 뒤로 넘길수 없으면 마지막 페이지로 가게 설정
		nPageResult = (int)(Math.ceil((double) currentPage/countPerPage)*countPerPage)+1;

		// NnPageResult 세팅, 예외사항 딱 나누어 떨어질 경우의 예외 처리?
		NnPageResult = (int) Math.ceil((double) totalCount / pageSize);

		// 추후 보정
		if (currentPage > NnPageResult) {
			currentPage = NnPageResult;
		}

		p.setPpPage(PpPageResult);
		p.setpPage(pPageResult);
		p.setnPage(nPageResult);
		p.setNnPage(NnPageResult);
		p.setcPage(cPageResult);

		return p;
	}

}
