package kr.ac.kopo.ctc.kopo37.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.ac.kopo.ctc.kopo37.domain.ScoreItem;

public class ScoreItemDaoMock implements ScoreItemDao {

	@Override
	public List<ScoreItem> selectAll(int page, int countPerPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScoreItem selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScoreItem> selectName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectNewId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectFirstId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(ScoreItem scoreItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ScoreItem scoreItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}


}
