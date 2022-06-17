package kr.ac.kopo.ctc.kopo37.dao;

import java.util.List;

import kr.ac.kopo.ctc.kopo37.domain.ScoreItem;

public interface ScoreItemDao {
	ScoreItem create(ScoreItem scoreItem);
	
	ScoreItem selectOne(int id);
	
	List<ScoreItem> selectAll(int page, int countPerPage);
	
	void insert(ScoreItem scoreItem);
	
	void update(ScoreItem scoreItem);
	
	void delete(ScoreItem scoreItem);
	
}
