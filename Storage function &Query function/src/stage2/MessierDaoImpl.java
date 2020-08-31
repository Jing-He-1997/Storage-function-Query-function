package stage2;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MessierDaoImpl implements MessierDao {

	public Connection connection = null;
	public PreparedStatement preparedStatement = null;

	// Insert messier object into mysql table
	@Override
	public void insertMessier(Messier messier) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into messiers(number,ra,decl,magn,distance,constellation,description) values(?,?,?,?,?,?,?)";
			connection = DbConnection.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, messier.getNumber());
			preparedStatement.setDouble(2, messier.getRa());
			preparedStatement.setDouble(3, messier.getDecl());
			preparedStatement.setDouble(4, messier.getMagn());
			preparedStatement.setDouble(5, messier.getDistance());
			preparedStatement.setString(7, messier.getDescription());
			preparedStatement.setString(6, messier.getConstellation());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
