package kr.ac.kopo.ctc.kopo37.service;

import java.util.List;

import kr.ac.kopo.ctc.kopo37.dao.ScoreItemDao;
import kr.ac.kopo.ctc.kopo37.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo37.dto.Pagination;

public interface ScoreItemService {
	ScoreItem create(ScoreItem scoreItem);
	ScoreItem selectOne(int id);
	List<ScoreItem> selectAll(int page, int countPerPage);
	Pagination getPagination(int currentPage, int countPerPage, int pageSize, int totalCount);
	ScoreItemDao getScoreItemDao();
	void setScoreItemDao(ScoreItemDao scoreItemDao);

}