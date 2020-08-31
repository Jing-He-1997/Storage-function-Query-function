package stage2;

import java.io.*;
import java.util.*;

public class AOB {
	// Store new sql sentences
	List<String> queries2 = new ArrayList<String>();

	@SuppressWarnings("static-access")
	public AOB(String file1, String file2, String file3, String file4) {

		List<Star> stars = new ArrayList<Star>();
		List<Planet> planets = new ArrayList<Planet>();
		List<Messier> messiers = new ArrayList<Messier>();
		List<String> queries = new ArrayList<String>();

		// Only for the Stars file
		try {

			FileReader fr = new FileReader(file1);
			BufferedReader bf = new BufferedReader(fr);
			String str;
			String[] strs;
			while ((str = bf.readLine()) != null) {
				// intercept the word
				Star star = new Star();
				// delete the extra space
				strs = str.split("\\|");
				star.setNumber(strs[0].trim());
				star.setRa(Double.parseDouble(strs[1].trim()));
				star.setDecl(Double.parseDouble(strs[2].trim()));
				star.setMagn(Double.parseDouble(strs[3].trim()));
				star.setDistance(Double.parseDouble(strs[4].trim()));
				star.setType(strs[5].trim());
				star.setConstellation(strs[6].trim());
				stars.add(star);
			}

			StarDao starDao = new StarDaoImpl();
			starDao.insertStar(stars);

			bf.close();
			fr.close();
		} // Exception situation
		catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
			System.out.println("Run Correct file");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException nfe) {
			System.out.println(nfe);
			System.exit(1);
		}

		try {
			FileReader fr = new FileReader(file2);
			BufferedReader bf = new BufferedReader(fr);
			String str;
			String[] strs;
			while ((str = bf.readLine()) != null) {
				Messier messier = new Messier();
				strs = str.split("\\|");
				messier.setNumber("M" + strs[0].trim());
				messier.setRa(Double.parseDouble(strs[1].trim()));
				messier.setDecl(Double.parseDouble(strs[2].trim()));
				messier.setMagn(Double.parseDouble(strs[3].trim()));
				messier.setDistance(Double.parseDouble(strs[4].trim()));
				messier.setConstellation(strs[5].trim());
				messier.setDescription(strs[6].trim());
				messiers.add(messier);
			}

			for (int i = 0; i < messiers.size(); i++) {
				MessierDao messierDao = new MessierDaoImpl();
				messierDao.insertMessier(messiers.get(i));
			}

			bf.close();
			fr.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
			System.out.println("Run Correct file");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException nfe) {
			System.out.println(nfe);
			System.exit(1);
		}

		try {
			FileReader fr = new FileReader(file3);
			BufferedReader bf = new BufferedReader(fr);
			String str;
			String[] strs;
			while ((str = bf.readLine()) != null) {
				Planet planet = new Planet();
				strs = str.split("\\s+");
				planet.setName(strs[0].trim());
				planet.setRa(Double.parseDouble(strs[1].trim()));
				planet.setDecl(Double.parseDouble(strs[2].trim()));
				planet.setMagn(Double.parseDouble(strs[3].trim()));
				planet.setDistance(Double.parseDouble(strs[4].trim()));
				planet.setAlbedo(Double.parseDouble(strs[5].trim()));
				planets.add(planet);
			}

			for (int i = 0; i < planets.size(); i++) {
				PlanetDao planetDao = new PlanetDaoImpl();
				planetDao.insertPlanet(planets.get(i));
			}

			bf.close();
			fr.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
			System.out.println("Run Correct file");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException nfe) {
			System.out.println(nfe);
			System.exit(1);
		}

		// Get the queries from txt document
		// Change the sql sentences
		try {
			FileReader fr = new FileReader(file4);
			BufferedReader bf = new BufferedReader(fr);
			String str;
			while ((str = bf.readLine()) != null) {
				queries.add(str);
			}

			for (int i = 0; i < queries.size(); i++) {
				StringBuffer sb = new StringBuffer(queries.get(i));
				sb.insert(6, "*from");
				String str1 = new String(sb);
				queries2.add(str1);
				System.out.println(queries2.get(i));
				QueryRunner query = new QueryRunner();
				query.run(queries2.get(i));
			}

			bf.close();
			fr.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
			System.out.println("Run Correct file");
			fnfe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			AOB aob = new AOB(args[0], args[1], args[2], args[3]);
		} catch (

		ArrayIndexOutOfBoundsException iob) {
			System.out.println(iob);
			System.exit(1);
		}

	}
}
