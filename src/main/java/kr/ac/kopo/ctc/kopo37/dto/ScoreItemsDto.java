package kr.ac.kopo.ctc.kopo37.dto;

import java.util.List;

import kr.ac.kopo.ctc.kopo37.dao.ScoreItemDao;
import kr.ac.kopo.ctc.kopo37.domain.ScoreItem;

public class ScoreItemsDto {
	private List<ScoreItem> ScoreItems;
	private Pagination pagination;
	private ScoreItemDao scoreItemDao;
	
	public List<ScoreItem> getScoreItems() {
		return ScoreItems;
	}
	public void setScoreItems(List<ScoreItem> scoreItems) {
		ScoreItems = scoreItems;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public ScoreItemDao getScoreItemDao() {
		return scoreItemDao;
	}

	public void setScoreItemDao(ScoreItemDao scoreItemDao) {
		this.scoreItemDao = scoreItemDao;
	}
	
}
