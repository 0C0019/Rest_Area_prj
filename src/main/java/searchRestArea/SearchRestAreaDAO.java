package searchRestArea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restAreaDbConnection.DbConnection;

public class SearchRestAreaDAO {
	private static SearchRestAreaDAO sraDAO;
	
	private SearchRestAreaDAO() {
		
	}
	
	public static SearchRestAreaDAO getInstance() {
		if(sraDAO == null) {
			sraDAO = new SearchRestAreaDAO();
		}//end if
		return sraDAO;
	}//getInstance
	
	public List<RestAreaNameVO> searchByRaName(String raName) throws SQLException{
		List<RestAreaNameVO> raNameList = new ArrayList<RestAreaNameVO>();
		//1. 드라이버 로딩
		DbConnection dbCon = DbConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dbCon.getConn("jdbc/restarea");
			StringBuilder searchByRaName = new StringBuilder()
					.append("select ra_num, ra_name, addr, tel, latitude, longitude ")
					.append("from rest_area ")
					.append("where ra_name like ?")
					;
			pstmt = con.prepareStatement(searchByRaName.toString());
			pstmt.setString(1, "%" + raName + "%");
			RestAreaNameVO ranVO = null;
			rs = pstmt.executeQuery();
			while(rs.next()) {
				RestAreaNameVO ranVOBuilder = ranVO.builder()
				.raNum(rs.getString("ra_num"))		
				.raName(rs.getString("ra_name"))
				.raAddr(rs.getString("addr"))
				.raTel(rs.getString("tel"))
				.latitude(rs.getDouble("latitude"))
				.longitude(rs.getDouble("longitude"))
				.build();
				raNameList.add(ranVOBuilder);
			}
		} finally {
			dbCon.closeCon(rs, pstmt, con);
		}
		
		return raNameList;
	}
	
	public List<LocationVO> searchByLocation(String locNum) throws SQLException{
		List<LocationVO> locationList = new ArrayList<LocationVO>();
		//1. 드라이버 로딩
		DbConnection dbCon = DbConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dbCon.getConn("jdbc/restarea");
			
			String searchByLocation = "";
			pstmt = con.prepareStatement(searchByLocation);
			pstmt.setString(0, searchByLocation);
			LocationVO locVO = null;
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				locVO = new LocationVO();
				locationList.add(locVO);
			}
		} finally {
			dbCon.closeCon(rs, pstmt, con);
		}
		
		
		return locationList;
	}
	
	public List<RouteVO> searchByRoute(String routeNum) throws SQLException{
		List<RouteVO> routeList = new ArrayList<RouteVO>();
		//1. 드라이버 로딩
		DbConnection dbCon = DbConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dbCon.getConn("jdbc/restarea");
			
			StringBuilder searchByRoute = new StringBuilder()
					.append("select hw.route_num, ra.ra_name, ra.addr, ra.tel, ra.latitude, ra.longitude ")
					.append("from highway hw, rest_area ra ")
					.append("where hw.route_id = ra.route_id and hw.route_id = ?");
			pstmt = con.prepareStatement(searchByRoute.toString());
			pstmt.setString(1, routeNum);
			RouteVO roVO = null;
			rs = pstmt.executeQuery();
			while(rs.next()) {
				RouteVO roVOBuilder = roVO.builder()
						.routeNum(rs.getString("route_num"))
						.raName(rs.getString("ra_name"))
						.raAddr(rs.getString("addr"))
						.raTel(rs.getString("tel"))
						.restAreaLatitude(rs.getDouble("latitude"))
						.restAreaLongitude(rs.getDouble("longitude"))
						.build();
				routeList.add(roVOBuilder);
			}
		} finally {
			dbCon.closeCon(rs, pstmt, con);
		}
		
		return routeList;
	}
}
