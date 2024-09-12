package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhonebookDAO {
    private Connection connection;

    // 생성자에서 데이터베이스 연결
    public PhonebookDAO() {
        try {
            // JDBC 드라이버 로드 및 연결 설정
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "username", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 전화번호부 입력
    public void insertPhonebook(PhonebookVO vo) {
        String sql = "INSERT INTO phonebook (id, name, hp, memo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, vo.getId());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getHp());
            pstmt.setString(4, vo.getMemo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 전체 출력
    public List<PhonebookVO> getAllPhonebooks() {
        List<PhonebookVO> list = new ArrayList<>();
        String sql = "SELECT * FROM phonebook";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                PhonebookVO vo = new PhonebookVO();
                vo.setId(rs.getInt("id"));
                vo.setName(rs.getString("name"));
                vo.setHp(rs.getString("hp"));
                vo.setMemo(rs.getString("memo"));
                list.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 선택 출력
    public PhonebookVO getPhonebookById(int id) {
        PhonebookVO vo = null;
        String sql = "SELECT * FROM phonebook WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    vo = new PhonebookVO();
                    vo.setId(rs.getInt("id"));
                    vo.setName(rs.getString("name"));
                    vo.setHp(rs.getString("hp"));
                    vo.setMemo(rs.getString("memo"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vo;
    }

    // 모든 항목 검색 출력
    public List<PhonebookVO> searchPhonebooks(String keyword) {
        List<PhonebookVO> list = new ArrayList<>();
        String sql = "SELECT * FROM phonebook WHERE name LIKE ? OR hp LIKE ? OR memo LIKE ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            String searchKeyword = "%" + keyword + "%";
            pstmt.setString(1, searchKeyword);
            pstmt.setString(2, searchKeyword);
            pstmt.setString(3, searchKeyword);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    PhonebookVO vo = new PhonebookVO();
                    vo.setId(rs.getInt("id"));
                    vo.setName(rs.getString("name"));
                    vo.setHp(rs.getString("hp"));
                    vo.setMemo(rs.getString("memo"));
                    list.add(vo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 수정
    public void updatePhonebook(PhonebookVO vo) {
        String sql = "UPDATE phonebook SET name = ?, hp = ?, memo = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, vo.getName());
            pstmt.setString(2, vo.getHp());
            pstmt.setString(3, vo.getMemo());
            pstmt.setInt(4, vo.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 삭제
    public void deletePhonebook(int id) {
        String sql = "DELETE FROM phonebook WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
