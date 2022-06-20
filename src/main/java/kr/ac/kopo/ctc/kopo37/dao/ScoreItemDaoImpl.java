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
	
	public ScoreItemDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
		} catch (Exception e) {
			throw new IllegalStateException("jdbc 드라이버 로드 실패 : " + e.getMessage());
		}
	}

	@Override
	public List<ScoreItem> selectAll(int page, int countPerPage) {
		List<ScoreItem> results = new ArrayList<>();

		String sql = "SELECT * FROM examtable";
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
	public int selectTotalCount() {
		String sql = "select count(*) from examtable";
		int result = 0;
		try (
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "kopo37");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) {
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}
		
		return result;
	}
	
	@Override
	public ScoreItem selectOne(int id) {
		String sql = "select * from examtable where studentid=?";
		ScoreItem scoreItem = new ScoreItem();

		try (
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "kopo37");
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
			pstmt.setInt(1, id);
			try (ResultSet rset = pstmt.executeQuery();) {
				rset.next();
					scoreItem = new ScoreItem();
					scoreItem.setName(rset.getString("name"));
					scoreItem.setStudentId(rset.getInt("studentid"));
					scoreItem.setKor(rset.getInt("kor"));
					scoreItem.setEng(rset.getInt("eng"));
					scoreItem.setMat(rset.getInt("mat"));
				}
		} catch (Exception e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}
		
		return scoreItem;
	}
	
	@Override
	public List<ScoreItem> selectName(String name) {
		String sql = "select * from examtable where name=?";
		List<ScoreItem> ScoreItems = new ArrayList<ScoreItem>();

		try (
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "kopo37");
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
			pstmt.setString(1, name);
			try (ResultSet rset = pstmt.executeQuery();) {
				while(rset.next()) {
					ScoreItem scoreItem = new ScoreItem();
					scoreItem.setName(rset.getString("name"));
					scoreItem.setStudentId(rset.getInt("studentid"));
					scoreItem.setKor(rset.getInt("kor"));
					scoreItem.setEng(rset.getInt("eng"));
					scoreItem.setMat(rset.getInt("mat"));
					
					ScoreItems.add(scoreItem);
				}
			}
		} catch (Exception e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}
		
		return ScoreItems;
	}

	@Override
	public int selectNewId() {
		String sql = "select studentid+1 from examtable where (studentid+1) not in (select studentid from examtable)";
		int newId = 0;
		try (
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "kopo37");
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
			try (ResultSet rset = pstmt.executeQuery();) {
				rset.next();
				newId = rset.getInt(1);
			}
		} catch (Exception e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}
		
		return newId;
	}
	
	@Override
	public int selectFirstId() {
		String sql = "select studentid from examtable limit 1";
		int firstId = 0;
		try (
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "kopo37");
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
			try (ResultSet rset = pstmt.executeQuery();) {
				rset.next();
				firstId = rset.getInt(1);
			}
		} catch (Exception e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}
		return firstId;
	}
	

	@Override
	public void insert(ScoreItem scoreItem) {
		// PreparedStatement 동적 쿼리, INSERT UPDATE DELETE 여러번 할 때 고속
		String sql = "INSERT INTO examtable  VALUES (?, ?, ?, ?, ?)";
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
		String sql = "UPDATE examtable SET name=?, kor=?, eng=?, mat=? where studentid = ?";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "kopo37");
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, scoreItem.getName());
			stmt.setInt(2, scoreItem.getKor());
			stmt.setInt(3, scoreItem.getEng());
			stmt.setInt(4, scoreItem.getMat());
			stmt.setInt(5, scoreItem.getStudentId());

			// 0보다 크면 insert 됨
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new IllegalStateException("update 실패 " + e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM examtable WHERE studentid=?";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "kopo37");
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, id);
			// 0보다 크면 insert 됨
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new IllegalStateException("delete 실패 " + e.getMessage());
		}
	}

}
