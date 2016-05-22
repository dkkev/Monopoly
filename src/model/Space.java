package model;

enum Space {
	
	GO (0, "Go"),
	MEDITERRANEAN_AVENUE (1, "Mediterranean Avenue"),
	FIRST_COMMUNITY_CHEST (2, "First Community Chest Space"),
	BALTIC_AVENUE (3, "Baltic Avenue"),
	INCOME_TAX (4, "Income Tax"),
	READING_RAILROAD (5, "Reading Railroad"),
	ORIENTAL_AVENUE (6, "Oriental Avenue"),
	FIRST_CHANCE (7, "First Chance Space"),
	VERMONT_AVENUE (8, "Vermont Avenue"),
	CONNECTICUT_AVENUE (9, "Connecticut Avenue"),
	JAIL (10, "Jail / Just Visiting"),
	ST_CHARLES_PLACE (11, "St. Charles Place"),
	ELECTRIC_COMPANY (12, "Electric Company"),
	STATES_AVENUE (13, "States Avenue"),
	VIRGINIA_AVENUE (14, "Virginia Avenue"),
	PENNSYLVANIA_RAILROAD (15, "Pennsylvania Railroad"),
	ST_JAMES_PLACE (16, "St. James Place"),
	SECOND_COMMUNITY_CHEST (17, "Second Community Chest Space"),
	TENNESSEE_AVENUE (18, "Tennessee Avenue"),
	NEW_YORK_AVENUE (19, "New York Avenue"),
	FREE_PARKING (20, "Free Parking"),
	KENTUCKY_AVENUE (21, "Kentucky Avenue"),
	SECOND_CHANCE (22, "Second Chance Space"),
	INDIANA_AVENUE (23, "Indiana Avenue"),
	ILLINOIS_AVENUE (24, "Illinois Avenue"),
	BO_RAILROAD (25, "B. & O. Railroad"),
	ATLANTIC_AVENUE (26, "Atlantic Avenue"),
	VENTNOR_AVENUE (27, "Ventnor Avenue"),
	WATER_WORKS (28, "Water Works"),
	MARVIN_GARDENS (29, "Marvin Gardens"),
	GO_TO_JAIL (30, "Go to Jail"),
	PACIFIC_AVENUE (31, "Pacific Avenue"),
	NORTH_CAROLINA_AVENUE (32, "North Carolina Avenue"),
	THIRD_COMMUNITY_CHEST (33, "Third Community Chest Space"),
	PENNSYLVANIA_AVENUE (34, "Pennsylvania Avenue"),
	SHORT_LINE (35, "Short Line"),
	THIRD_CHANCE (36, "Third Chance Space"),
	PARK_PLACE (37, "Park Place"),
	LUXURY_TAX (38, "Luxury Tax"),
	BOARDWALK (39, "Boardwalk");
	
	private final int spaceNum;
	private final String spaceName;
	Space(int spaceNum, String spaceName){
		this.spaceNum = spaceNum;
		this.spaceName = spaceName;
	}
	
	final int getSpaceNum(){
		return spaceNum;
	}
	
	final String getSpaceName(){
		return spaceName;
	}
}

/* 
 * List of property strings in case enums need re-generated in a different format  
 * "Go", "Mediterranean Avenue", "First Community Chest", "Baltic Avenue", "Income Tax", "Reading Railroad", "Oriental Avenue", "First Chance", "Vermont Avenue", "Connecticut Avenue", "Jail", "St. Charles Place", "Electric Company", "States Avenue", "Virginia Avenue", "Pennsylvania Railroad", "St. James Place", "Second Community Chest", "Tennessee Avenue", "New York Avenue", "Free Parking", "Kentucky Avenue", "Second Chance", "Indiana Avenue", "Illinois Avenue", "B. & O. Railroad", "Atlantic Avenue", "Ventnor Avenue", "Water Works", "Marvin Gardens", "Go to Jail", "Pacific Avenue", "North Carolina Avenue", "Third Community Chest", "Pennsylvania Avenue", "Short Line", "Third Chance", "Park Place", "Luxury Tax", "Boardwalk"
 */
