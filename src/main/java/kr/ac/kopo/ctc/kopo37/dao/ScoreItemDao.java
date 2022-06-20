package kr.ac.kopo.ctc.kopo37.dao;

import java.util.List;

import kr.ac.kopo.ctc.kopo37.domain.ScoreItem;

public interface ScoreItemDao {
	
	List<ScoreItem> selectAll(int page, int countPerPage);
	
	ScoreItem selectOne(int id);
	
	List<ScoreItem> selectName(String name);
	
	int selectTotalCount();
	
	int selectNewId();
	
	int selectFirstId();
	
	void insert(ScoreItem scoreItem);
	
	void update(ScoreItem scoreItem);
	
	void delete(int id);
	
}
