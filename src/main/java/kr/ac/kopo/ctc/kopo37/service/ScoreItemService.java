package kr.ac.kopo.ctc.kopo37.service;

import java.sql.SQLException;
import java.util.List;

import kr.ac.kopo.ctc.kopo37.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo37.dto.Pagination;


public interface ScoreItemService {
	
	List<ScoreItem> scoreItemSelectAll(int cPage, int countPerPage) throws ClassNotFoundException, SQLException;
	
	List<ScoreItem> selectScoreItemsByName(String name);
	
	ScoreItem scoreItemSelectById(int id);
	
	int scoreItemInsert(String name, String kor, String eng, String mat);
	
	void scoreItemUpdate(String name, String id, String kor, String eng, String mat);
	
	void scoreItemDelete(int id);
	
	Pagination getPagination(int currentPage, int countPerPage, int pageSize, int totalCount);

}