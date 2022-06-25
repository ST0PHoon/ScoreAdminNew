package kr.ac.kopo.ctc.kopo37.service;

import java.sql.SQLException;
import java.util.List;

import kr.ac.kopo.ctc.kopo37.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo37.dto.Pagination;


public interface ScoreItemService {
	
	List<ScoreItem> scoreItemSelectAll(int cPage, int countPerPage) throws ClassNotFoundException, SQLException;
	
	List<ScoreItem> selectScoreItemsByName(String name);
	
	ScoreItem scoreItemSelectById(int id);
	
	void scoreItemInsert(String name, int kor, int eng, int mat);
	
	void scoreItemUpdate(ScoreItem scoreItem);
	
	void scoreItemDelete(int id);
	
	Pagination getPagination(int currentPage, int countPerPage, int pageSize, int totalCount);

}