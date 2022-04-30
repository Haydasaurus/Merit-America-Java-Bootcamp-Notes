package com.techelevator.exercises;

import java.io.File;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.swing.table.DefaultTableModel;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExercisesTest {

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private static JdbcTemplate jdbcTemplate;
	private static String exerciseFolder;
	private static List<String> exerciseFiles = new ArrayList<>();

	private static SingleConnectionDataSource adminDataSource;
	private static JdbcTemplate adminJdbcTemplate;

	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() throws SQLException {
		adminDataSource = createDatasource("postgres");
		adminJdbcTemplate = new JdbcTemplate(adminDataSource);
		adminJdbcTemplate.update("CREATE DATABASE moviedbtemp;");

		dataSource = createDatasource("moviedbtemp");
		dataSource.setAutoCommit(false); //So we can rollback after each test.

		ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("MovieDBTemp-data.sql"));

		jdbcTemplate = new JdbcTemplate(dataSource);

		exerciseFiles = getExerciseSqlFiles();
		if (exerciseFiles.size() == 0)
		{
			fail("Exercise folder and files not found. Please check that the exercise folder is in the same directory or in a directory above where these tests are running from.");
		}
	}

	@AfterClass
	public static void cleanup() {
		dataSource.destroy();
		adminJdbcTemplate.update("DROP DATABASE moviedbtemp;");
		adminDataSource.destroy();
	}

	@Before
	public void setup() {

	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void exerciseProblem01() {
		int expectedRowsAffected = 1;

		String sqlVerify = "SELECT person_name, birthday FROM person WHERE person_name = 'Lisa Byway';";

		DefaultTableModel dtExpected = new DefaultTableModel();
		dtExpected.addColumn("person_name");
		dtExpected.addColumn("birthday");
		dtExpected.addRow(new Object[] {"Lisa Byway", java.sql.Date.valueOf("1984-04-15")});

		checkAnswerForProblem("01", expectedRowsAffected, sqlVerify, dtExpected);
	}

	@Test
	public void exerciseProblem02() {
		int expectedRowsAffected = 1;

		String sqlVerify = "SELECT title, overview, release_date, length_minutes FROM movie WHERE title = 'Euclidean Pi';";

		DefaultTableModel dtExpected = new DefaultTableModel();
		dtExpected.addColumn("title");
		dtExpected.addColumn("overview");
		dtExpected.addColumn("release_date");
		dtExpected.addColumn("length_minutes");
		dtExpected.addRow(new Object[] {"Euclidean Pi", "The epic story of Euclid as a pizza delivery boy in ancient Greece", java.sql.Date.valueOf("2015-03-14"), 194});

		checkAnswerForProblem("02", expectedRowsAffected, sqlVerify, dtExpected);
	}

	@Test
	public void exerciseProblem03() {
		int expectedRowsAffected = 1;

		String sqlVerify = "SELECT count(*) as count FROM movie_actor WHERE movie_id = 105 AND actor_id = 7036;";

		DefaultTableModel dtExpected = new DefaultTableModel();
		dtExpected.addColumn("count");
		dtExpected.addRow(new Object[] { 1L });

		checkAnswerForProblem("03", expectedRowsAffected, sqlVerify, dtExpected);	}

	@Test
	public void exerciseProblem04() {
		int expectedRowsAffected = 2;

		String sqlVerify = "SELECT (SELECT count(*) FROM genre WHERE genre_name = 'Sports') as genre_count, (SELECT count(*) FROM movie_genre WHERE genre_id IN (SELECT genre_id FROM genre WHERE genre_name = 'Sports') AND movie_id = 7214) as movie_genre_count;";

		DefaultTableModel dtExpected = new DefaultTableModel();
		dtExpected.addColumn("genre_count");
		dtExpected.addColumn("movie_genre_count");
		dtExpected.addRow(new Object[] { 1L, 1L });

		checkAnswerForProblem("04", expectedRowsAffected, sqlVerify, dtExpected);
	}

	@Test
	public void exerciseProblem05() {
		int expectedRowsAffected = 1;

		String sqlVerify = "SELECT title FROM movie WHERE movie_id = 11;";

		DefaultTableModel dtExpected = new DefaultTableModel();
		dtExpected.addColumn("title");
		dtExpected.addRow(new Object[] { "Star Wars: A New Hope" });

		checkAnswerForProblem("05", expectedRowsAffected, sqlVerify, dtExpected);
	}

	@Test
	public void exerciseProblem06() {
		int expectedRowsAffected = 3;

		String sqlVerify = "SELECT overview FROM movie WHERE length_minutes > 210;";

		DefaultTableModel dtExpected = new DefaultTableModel();
		dtExpected.addColumn("overview");
		dtExpected.addRow(new Object[] { "A former Prohibition-era Jewish gangster returns to the Lower East Side of Manhattan over thirty years later, where he once again must confront the ghosts and regrets of his old life. This is a long movie." });
		dtExpected.addRow(new Object[] { "The story of British officer T.E. Lawrence's mission to aid the Arab tribes in their revolt against the Ottoman Empire during the First World War. Lawrence becomes a flamboyant, messianic figure in the cause of Arab unity but his psychological instability threatens to undermine his achievements. This is a long movie." });
		dtExpected.addRow(new Object[] { "Set in Bertolucci's ancestral region of Emilia, the film chronicles the lives of two men during the political turmoils that took place in Italy in the first half of the 20th century. This is a long movie." });

		checkAnswerForProblem("06", expectedRowsAffected, sqlVerify, dtExpected);
	}

	@Test
	public void exerciseProblem07() {
		int expectedRowsAffected = 14;

		String sqlVerify = "SELECT count(*) as actor_count FROM movie_actor WHERE movie_id = 299536;";

		DefaultTableModel dtExpected = new DefaultTableModel();
		dtExpected.addColumn("actor_count");
		dtExpected.addRow(new Object[] { 0L });

		checkAnswerForProblem("07", expectedRowsAffected, sqlVerify, dtExpected);
	}

	@Test
	public void exerciseProblem08() {
		int expectedRowsAffected = 6;

		String sqlVerify = "SELECT (SELECT count(*) FROM movie_actor WHERE actor_id = 37221) as actor_count, (SELECT count(*) FROM person WHERE person_id = 37221) as person_count;";

		DefaultTableModel dtExpected = new DefaultTableModel();
		dtExpected.addColumn("actor_count");
		dtExpected.addColumn("person_count");
		dtExpected.addRow(new Object[] { 0L, 0L });

		checkAnswerForProblem("08", expectedRowsAffected, sqlVerify, dtExpected);
	}

	@Test
	public void exerciseProblem09() {
		int expectedRowsAffected = 16;

		String sqlVerify = "SELECT (SELECT count(*) FROM movie_actor WHERE movie_id = 77) as actor_count, (SELECT count(*) FROM movie_genre WHERE movie_id = 77) as genre_count, (SELECT count(*) FROM movie WHERE movie_id = 77) as movie_count;";

		DefaultTableModel dtExpected = new DefaultTableModel();
		dtExpected.addColumn("actor_count");
		dtExpected.addColumn("genre_count");
		dtExpected.addColumn("movie_count");
		dtExpected.addRow(new Object[] { 0L, 0L, 0L });

		checkAnswerForProblem("09", expectedRowsAffected, sqlVerify, dtExpected);
	}

	@Test
	public void exerciseProblem10() {
		int expectedRowsAffected = 9;

		String sqlVerify = "SELECT biography FROM person WHERE person_id IN (6, 130, 3799, 24343, 24590, 33185, 34027, 74296, 1230989) ORDER BY person_id;";

		DefaultTableModel dtExpected = new DefaultTableModel();
		dtExpected.addColumn("biography");
		dtExpected.addRow(new Object[] { "Anthony Daniels (born 21 February 1946) is an English actor. He is best known for his role as the droid C-3PO in the Star Wars series of films made between 1977 and 2005.\n\nDescription above from the Wikipedia article Anthony Daniels, licensed under CC-BY-SA, full list of contributors on Wikipedia.​ http://www.anthonydaniels.com/" });
		dtExpected.addRow(new Object[] { "From Wikipedia, the free encyclopedia Kenneth George \"Kenny\" Baker (born 24 August 1934) was a British actor and musician, best known as the man inside R2-D2 in the popular Star Wars film series. Description above from the Wikipedia article Kenny Baker, licensed under CC-BY-SA, full list of contributors on Wikipedia. http://www.kennybaker.co.uk" });
		dtExpected.addRow(new Object[] { "William December \"Billy Dee\" Williams Jr. (born April 6, 1937) is an American actor, voice actor, and artist. He is best known as Lando Calrissian in the Star Wars franchise, first in the early 1980s, and nearly forty years later in The Rise of Skywalker (2019), marking one of the longest intervals between onscreen portrayals of a character by the same actor in American film history.\n\nDescription above from the Wikipedia article Billy Dee Williams, licensed under CC-BY-SA, full list of contributors on Wikipedia. http://www.bdwworldart.com/" });
		dtExpected.addRow(new Object[] { "Peter Mayhew (19 May 1944-30 April 2019) was a British-American actor, best known for playing Chewbacca in the Star Wars films.\n\nMayhew was born on 19 May 1944 in Barnes, Surrey, where he was also raised. His height was a product not of gigantism — \"I don't have the big head\" — but of an overactive pituitary gland secondary to a genetic disease called Marfan Syndrome. The overactive pituitary gland was treated successfully in his mid-teens. His peak height was 7 feet 3 inches (2.21 m) http://www.petermayhew.com/" });
		dtExpected.addRow(new Object[] { "Dominique Sanda (born 11 March 1948) is a French actress and former fashion model.\n\nSanda was born as Dominique Marie-Françoise Renée Varaigne in Paris to Lucienne (née Pinchon) and Gérard Sanda. She appeared in such noted European films of the 1970s as Vittorio de Sica's Il Giardino dei Finzi-Contini, Bernardo Bertolucci's The Conformist and Novecento, and Liliana Cavani's Beyond Good and Evil. She also appeared in The Mackintosh Man (with Paul Newman) and Steppenwolf (with Max von Sydow).\n\nShe won the award for Best Actress at the 1976 Cannes Film Festival for her role in the film The Inheritance.\n\nDescription above from the Wikipedia article Dominique Sanda, licensed under CC-BY-SA, full list of contributors on Wikipedia.​ http://www.dominiquesanda.com" });
		dtExpected.addRow(new Object[] { "Jeremy Bulloch (16 February 1945 - 17 December 2020) was an English actor, best known for the role of the bounty hunter Boba Fett in the original Star Wars trilogy. He has appeared in numerous British television and film productions, including James Bond movies, Doctor Who and Robin of Sherwood. http://www.jeremybulloch.com/" });
		dtExpected.addRow(new Object[] { "Stefania Sandrelli (born 5 June 1946 in Viareggio, Province of Lucca) is an Italian actress, famous for her many roles in the commedia all'Italiana, starting from 1960s.\n\nShe was 15 years old when she starred in Divorce, Italian Style, as Marcello Mastroianni's cousin, Angela.\n\nShe was born in Viareggio, Tuscany. She had a long relationship with Italian singer-songwriter Gino Paoli. Their daughter Amanda Sandrelli, born in 1964, is also an actress.\n\nDescription above from the Wikipedia article Stefania Sandrelli, licensed under CC-BY-SA, full list of contributors on Wikipedia. http://www.stefaniasandrelli.net/" });
		dtExpected.addRow(new Object[] { "From Wikipedia, the free encyclopedia\n\nTeller (born Raymond Joseph Teller on February 14, 1948) is an American magician, illusionist, comedian, writer, and the frequently silent half of the comedy magic duo known as Penn & Teller, along with Penn Jillette. He is known for his advocacy of atheism, libertarianism, free-market economics, and scientific skepticism. He legally changed his name from \"Raymond Joseph Teller\" to just \"Teller\". He is an atheist, debunker, skeptic, and Fellow of the Cato Institute (a libertarian think-tank organization which also lists his partner Penn Jillette as a Fellow). The Cato Institute Association is featured prominently in the Penn and Teller Showtime TV series Bullshit!.\n\nDescription above from the Wikipedia article Teller (entertainer), licensed under CC-BY-SA, full list of contributors on Wikipedia. http://pennandteller.net/" });
		dtExpected.addRow(new Object[] { "Michael Vivian Fyfe Pennington is a British director and actor who, together with director Michael Bogdanov, founded the English Shakespeare Company. Although primarily a stage actor, he is best known to wider audiences for his role as Moff Jerjerrod, commanding officer of the Death Star in the film Star Wars Episode VI: Return of the Jedi and as Michael Foot in The Iron Lady, opposite Meryl Streep. http://www.michaelpennington.me.uk/" });

		checkAnswerForProblem("10", expectedRowsAffected, sqlVerify, dtExpected);
	}

	@Test
	public void exerciseProblem11() {
		int expectedRowsAffected = 2;

		String sqlVerify = "SELECT CASE WHEN director_id IS NOT NULL THEN 1 ELSE 0 END as director_set FROM movie WHERE movie_id = 367220;";

		DefaultTableModel dtExpected = new DefaultTableModel();
		dtExpected.addColumn("director_set");
		dtExpected.addRow(new Object[] { 1 });

		checkAnswerForProblem("11", expectedRowsAffected, sqlVerify, dtExpected);
	}

	@Test
	public void exerciseProblem12() {
		int expectedRowsAffected = 6;

		String sqlVerify = "SELECT (SELECT count(*) FROM collection WHERE collection_name = 'Bill Murray Collection') as collection_count, (SELECT count(*) FROM movie m JOIN movie_actor ma ON m.movie_id = ma.movie_id WHERE actor_id = 1532 AND collection_id = (SELECT collection_id FROM collection WHERE collection_name = 'Bill Murray Collection')) as movie_count;";

		DefaultTableModel dtExpected = new DefaultTableModel();
		dtExpected.addColumn("collection_count");
		dtExpected.addColumn("movie_count");
		dtExpected.addRow(new Object[] { 1L, 5L });

		checkAnswerForProblem("12", expectedRowsAffected, sqlVerify, dtExpected);
	}

	private void checkAnswerForProblem(String problemNumber, int expectedRowsAffected, String sqlVerify, DefaultTableModel dtExpected) {
		String sqlActual = getStudentQuery(problemNumber);

		sqlActual = sqlActual.replaceAll("--[^\n]*(\n|$)", "");
		assertFalse("No query found for this exercise. Make sure you've saved your changes to the exercise file.", sqlActual.isBlank());

		//Using batchUpdate because several exercises require multiple statements.
		String[] splitStatements = sqlActual.split(";");
		int actualRowsAffected = Arrays.stream(jdbcTemplate.batchUpdate(splitStatements)).sum();
		assertTrue("Your query didn't affect the expected number of rows.", expectedRowsAffected == actualRowsAffected);

		SqlRowSet sqlRSVerify = jdbcTemplate.queryForRowSet((sqlVerify));

		// compare expected and actual data
		compareData(dtExpected, sqlRSVerify);
	}

	private void compareData(DefaultTableModel dtExpected, SqlRowSet sqlRSVerify) {
			int colCountExpected = dtExpected.getColumnCount();
			List<String> colNamesExpected = new ArrayList<>();

			for (int i = 0; i < colCountExpected; i++) {
				colNamesExpected.add(dtExpected.getColumnName(i));
			}

			sqlRSVerify.last();
			assertEquals("Couldn't find the expected data after running your SQL. Make sure you've spelled everything correctly.",
					dtExpected.getRowCount(), sqlRSVerify.getRow());
			sqlRSVerify.beforeFirst();

			while (sqlRSVerify.next()){
				for (String colNameExpected : colNamesExpected) {
					int colIndex = colNamesExpected.indexOf((colNameExpected));
					int rowIndex = sqlRSVerify.getRow();
					Object valExpected = dtExpected.getValueAt(rowIndex - 1, colIndex);
					Object valVerify = sqlRSVerify.getObject(colNameExpected);
					assertEquals("Data returned doesn't match data expected for row " + rowIndex + " in column '" + colNameExpected + "'.",
						valExpected, valVerify);
				}
			}
	}

	private String getStudentQuery(String problemNumber) {
		String exerciseFilePath = exerciseFiles.stream()
				.filter( item ->  item.startsWith(problemNumber) ).findFirst()
				.orElse(null);
		String sql = "";

		if (exerciseFilePath == null) {
			fail("No exercise file found. Check that the file name begins with " + problemNumber + ".");
		}

		File exerciseFile = new File(exerciseFolder + "/" + exerciseFilePath);
		if (!exerciseFile.exists()) {
			fail("Exercise file doesn't exist.");
		}

		try {
			sql = Files.readString(exerciseFile.toPath());
		}
		catch (Exception e) {
			fail("Exception occurred reading exerciseFile: " + e.getMessage());
		}

		sql = sql.trim();

		return sql;
	}

	private static List<String> getExerciseSqlFiles() {
		String folderToFind = "Exercises";
		String currPath = System.getProperty("user.dir");
		List<String> exerFiles = new ArrayList<>();

		if (currPath.contains("\\")) {
			currPath = currPath.replace("\\", "/");
		}

		while (exerFiles.size() == 0) {
			File directoryPath = new File(currPath);

			if (directoryPath.isDirectory()) {
				File[] directories = directoryPath.listFiles((dir, name) -> name.endsWith(folderToFind));

				if (directories != null && directories.length == 1) {
					File directory = directories[0];

					exerciseFolder = directory.getAbsolutePath();

					File[] tempExerciseFiles = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".sql"));

					for (File ef : tempExerciseFiles) {
						// get just the filenames so that we don't have to hard code the exercise file names and can find just by number and can find just by number
						exerFiles.add(ef.getName());
					}

					break;
				}
				else {
					if (currPath.equals("C:") || currPath.equals("/")) //ran out of locations to check
					{
						break;
					}

					//go up one level
					currPath = currPath.substring(0, currPath.lastIndexOf("/"));
				}
			}
		}

		return exerFiles;
	}

	private static SingleConnectionDataSource createDatasource(String defaultDbName) {
		String host = System.getenv("DB_HOST") != null ? System.getenv("DB_HOST") : "localhost";
		String port = System.getenv("DB_PORT") != null ? System.getenv("DB_PORT") : "5432";
		String dbName = System.getenv("DB_DATABASE") != null ? System.getenv("DB_DATABASE") : defaultDbName;
		String username = System.getenv("DB_USERNAME") != null ? System.getenv("DB_USERNAME") : "postgres";
		String password = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "postgres1";

		String url = String.format("jdbc:postgresql://%s:%s/%s", host, port, dbName);

		SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		return dataSource;
	}
}
