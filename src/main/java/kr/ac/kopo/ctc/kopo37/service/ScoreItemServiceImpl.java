package kr.ac.kopo.ctc.kopo37.service;

import java.util.List;

import kr.ac.kopo.ctc.kopo37.dao.ScoreItemDao;
import kr.ac.kopo.ctc.kopo37.dao.ScoreItemDaoImpl;
import kr.ac.kopo.ctc.kopo37.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo37.dto.Pagination;
import kr.ac.kopo.ctc.kopo37.dto.ScoreItemsDto;

public class ScoreItemServiceImpl implements ScoreItemService {
	private ScoreItemDao scoreItemDao = new ScoreItemDaoImpl();
	private final int countPerPage = 10;
	private final int pageSize = 10;

	@Override
	public ScoreItemsDto scoreItemSelectAll(String strCPage) {
		// 현재 페이지 번호 null 체크
		int cPage = 0;
		if (strCPage == null) {
			cPage = 1;
		} else {
			cPage = Integer.parseInt(strCPage);
		}
		
		// 레코드 목록 조회
		ScoreItemsDto scoreItemsDto = new ScoreItemsDto();
		int startRecordNo = (cPage - 1) * countPerPage;
		
		// 페이징 처리
		List<ScoreItem> ScoreItems = scoreItemDao.selectAll(startRecordNo, countPerPage);
		int totalRecordCount = scoreItemDao.selectTotalCount();	// 전체 레코드 수 조회
		Pagination pagination = getPagination(cPage, countPerPage, pageSize, totalRecordCount);
		
		scoreItemsDto.setScoreItems(ScoreItems);
		scoreItemsDto.setPagination(pagination);

		return scoreItemsDto;
	}

	@Override
	public List<ScoreItem> selectScoreItemsByName(String name) {
		return scoreItemDao.selectName(name);
	}

	@Override
	public ScoreItem scoreItemSelectById(int id) {
		return  scoreItemDao.selectOne(id);
	}

	@Override
	public void scoreItemInsert(String name, int kor, int eng, int mat) {
		int newId = scoreItemDao.selectNewId();
		int firstId = scoreItemDao.selectFirstId();
		
		if (firstId != 209901) {
			newId = 209901;
		}
		
		ScoreItem scoreItem = new ScoreItem();
		
		scoreItem.setId(newId);
		scoreItem.setName(name);
		scoreItem.setKor(kor);
		scoreItem.setEng(eng);
		scoreItem.setMat(mat);
	}

	@Override
	public void scoreItemUpdate(ScoreItem scoreItem) {
		scoreItemDao.update(scoreItem);
	}

	@Override
	public void scoreItemDelete(int id) {
		scoreItemDao.delete(id);
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
