package kr.ac.kopo.ctc.kopo37.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ctc.kopo37.domain.ScoreItem;

public class ScoreItemDaoImpl implements ScoreItemDao {

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
		List<ScoreItem> results = new ArrayList<>();

		String sql = "SELECT * FROM examtable5";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "kopo37");
				Statement stmt = conn.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					String name = rs.getString(1);
					int studentId = rs.getInt(2);
					int kor = rs.getInt(3);
					int eng = rs.getInt(4);
					int mat = rs.getInt(5);

					ScoreItem scoreItem = new ScoreItem();
					scoreItem.setName(name);
					scoreItem.setStudentId(studentId);
					scoreItem.setKor(kor);
					scoreItem.setEng(eng);
					scoreItem.setMat(mat);

					results.add(scoreItem);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
//			throw new IllegalStateException("db 연결 실패");
		}

		return results;
	}

	@Override
	public void insert(ScoreItem scoreItem) {
		// PreparedStatement 동적 쿼리, INSERT UPDATE DELETE 여러번 할 때 고속
		String sql = "INSERT INTO examtable5  VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "kopo37");
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, scoreItem.getName());
			stmt.setInt(2, scoreItem.getStudentId());
			stmt.setInt(3, scoreItem.getKor());
			stmt.setInt(4, scoreItem.getEng());
			stmt.setInt(5, scoreItem.getMat());
			// 0보다 크면 insert 됨
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new IllegalStateException("insert 실패 " + e.getMessage());
		}
	}

	@Override
	public void update(ScoreItem scoreItem) {
		// PreparedStatement 동적 쿼리, INSERT UPDATE DELETE 여러번 할 때 고속
		String sql = "UPDATE product SET name=?, studentid=?, kor=?, p_category=?, eng=?, mat=?";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "kopo37");
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, scoreItem.getName());
			stmt.setInt(2, scoreItem.getStudentId());
			stmt.setInt(3, scoreItem.getKor());
			stmt.setInt(4, scoreItem.getEng());
			stmt.setInt(5, scoreItem.getMat());

			// 0보다 크면 insert 됨
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new IllegalStateException("update 실패 " + e.getMessage());
		}
	}

	@Override
	public void delete(ScoreItem scoreItem) {
		String sql = "DELETE FORM examtable5 WHERE studentid=?";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "kopo37");
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, scoreItem.getStudentId());
			// 0보다 크면 insert 됨
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new IllegalStateException("delete 실패 " + e.getMessage());
		}
	}

}
