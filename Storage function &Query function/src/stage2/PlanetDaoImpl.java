package stage2;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PlanetDaoImpl implements PlanetDao {

	public Connection connection;
	public PreparedStatement preparedStatement;
	
	// Insert planet object into mysql table

	public void insertPlanet(Planet planet) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into planets(name,ra,decl,magn,distance,albedo) values(?,?,?,?,?,?)";
			connection = DbConnection.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, planet.getName());
			preparedStatement.setDouble(2, planet.getRa());
			preparedStatement.setDouble(3, planet.getDecl());
			preparedStatement.setDouble(4, planet.getMagn());
			preparedStatement.setDouble(5, planet.getDistance());
			preparedStatement.setDouble(6, planet.getAlbedo());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
