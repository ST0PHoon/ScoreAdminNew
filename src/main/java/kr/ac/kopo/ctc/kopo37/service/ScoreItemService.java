package kr.ac.kopo.ctc.kopo37.service;

import java.util.List;

import kr.ac.kopo.ctc.kopo37.dao.ScoreItemDao;
import kr.ac.kopo.ctc.kopo37.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo37.dto.Pagination;
import kr.ac.kopo.ctc.kopo37.dto.ScoreItemsDto;

public interface ScoreItemService {
	
	ScoreItemsDto scoreItemSelectAll(String strCPage);
	
	List<ScoreItem> selectScoreItemsByName(String name);
	
	ScoreItem scoreItemSelectById(int id);
	
	void scoreItemInsert(String name, int kor, int eng, int mat);
	
	void scoreItemUpdate(ScoreItem scoreItem);
	
	void scoreItemDelete(int id);
	
	Pagination getPagination(int currentPage, int countPerPage, int pageSize, int totalCount);

}