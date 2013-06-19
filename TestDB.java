/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stellar;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
   Tests a database installation by creating and querying
   a sample table. Call this program as
   java -classpath driver_class_path;. TestDB database.properties
*/
public class TestDB 
{
   public static void main(String[] args) throws Exception
   {   
      if (args.length == 0)
      {   
         System.out.println(
               "Usage: java -classpath driver_class_path" 
               + File.pathSeparator 
               + ". TestDB database.properties");
         return;
      }
      else 
         
      
      Connection conn = SimpleDataSource;
      try
      {
          /*
         Statement table1 = conn.createStatement();
         Statement table2 = conn.createStatement();
         Statement table3 = conn.createStatement();
         Statement table4 = conn.createStatement();
         Statement table5 = conn.createStatement();
         Statement table6 = conn.createStatement();
         Statement table7 = conn.createStatement();
         Statement table8 = conn.createStatement();
         Statement table9 = conn.createStatement();
         Statement table10 = conn.createStatement();
         Statement table11 = conn.createStatement();
         Statement table12 = conn.createStatement();
         Statement table13 = conn.createStatement();
         Statement table14 = conn.createStatement();
         Statement table15 = conn.createStatement();
         Statement table16 = conn.createStatement();
         Statement table17 = conn.createStatement();
         Statement table18 = conn.createStatement();
          */
         Statement stat1 = conn.createStatement();
         Statement stat2 = conn.createStatement();
         Statement stat3 = conn.createStatement();
         Statement stat4 = conn.createStatement();
         Statement stat5 = conn.createStatement();
         Statement stat6 = conn.createStatement();
         Statement stat7 = conn.createStatement();
         Statement stat8 = conn.createStatement();
         Statement stat9 = conn.createStatement();
         Statement stat10 = conn.createStatement();
         Statement stat11 = conn.createStatement();
         Statement stat12 = conn.createStatement();
         Statement stat13 = conn.createStatement();
         Statement stat14 = conn.createStatement();
         Statement stat15 = conn.createStatement();
       
         /*
         stat.execute("CREATE TABLE Test (Name CHAR(20))");
         stat.execute("INSERT INTO Test VALUES ('Romeo')");

         ResultSet result = stat.executeQuery("SELECT * FROM Test");
         result.next();
         System.out.println(result.getString("Name"));
         */
          /*
         ResultSet maketable1 = table1.executeQuery("");
         ResultSet maketable2 = table2.executeQuery("");
         ResultSet maketable3 = table3.executeQuery("");
         ResultSet maketable4 = table4.executeQuery("");
         ResultSet maketable5 = table5.executeQuery("");
         ResultSet maketable6 = table6.executeQuery("");
         ResultSet maketable7 = table7.executeQuery("");
         ResultSet maketable8 = table8.executeQuery("");
         ResultSet maketable9 = table9.executeQuery("");
         ResultSet maketable10 = table10.executeQuery("");
         ResultSet maketable11 = table11.executeQuery("");
         ResultSet maketable12 = table12.executeQuery("");
         ResultSet maketable13 = table13.executeQuery("");
         ResultSet maketable14 = table14.executeQuery("");
         ResultSet maketable15 = table15.executeQuery("");
         ResultSet maketable16 = table16.executeQuery("");
         ResultSet maketable17 = table17.executeQuery("");
         ResultSet maketable18 = table18.executeQuery("");
         */
         
         
         ResultSet result1 = stat1.executeQuery("SELECT p.firstName, p.lastName, o.offenseName\n" +
"FROM offenses o INNER JOIN persons p ON o.offenderID = p.personID\n" +
"  		 INNER JOIN druglords dl ON dl.drugLordId = p.personId;");
         ResultSet result2 = stat2.executeQuery("SELECT p.firstName, p.lastName, a.alias\n" +
"FROM persons p INNER JOIN druglords d ON p.personID = d.druglordID\n" +
"			LEFT OUTER JOIN aliases a ON d.druglordID = a.dlId;");
         ResultSet result3 = stat3.executeQuery("SELECT p.firstName, p.lastName, COUNT(subordinateID) AS NUMBER_OF_SUBORDINATES\n" +
"FROM druglords dl INNER JOIN subordinates s ON dl.druglordID = s.druglord\n" +
"			   INNER JOIN persons p ON p.personID = dl.druglordID \n" +
"GROUP BY dl.druglordID;");
         ResultSet result4 = stat4.executeQuery("Select p.firstName, p.lastName\n" +
"From safehouses s RIGHT OUTER JOIN druglords d on d.druglordID = s.sfOwnerID\n" +
"			   INNER JOIN persons p ON d.druglordID = p.personID\n" +
"WHERE s.sfOwnerId IS NULL; ");
         ResultSet result5 = stat5.executeQuery("SELECT p.firstName, p.lastName, l.state, d.withinUS\n" +
"	FROM druglords d INNER JOIN persons p ON p.personID = d.druglordID\n" +
"				  INNER JOIN locations l ON p.location = l.zipcode\n" +
"	WHERE l.state = 'NY' AND d.withinUS = 't';");
         ResultSet result6 = stat6.executeQuery("SELECT per.firstName, per.lastName, l.labAddress, loc.zipcode, loc.city, loc.state, p.productType\n" +
"From laboratories l INNER JOIN labProducts lp on l.labID = lp.labID\n" +
"				INNER JOIN products p on p.productID = lp.productID\n" +
"				INNER JOIN druglords dl ON l.ownerId = dl.druglordID\n" +
"				INNER JOIN persons per ON per.personID = dl.druglordId\n" +
"				INNER JOIN locations loc ON loc.zipcode = l.labLocation\n" +
"WHERE lp.productId = 1;");
         ResultSet result7 = stat7.executeQuery("SELECT p.firstName, p.lastName, sh.sfAddress, sh.sfLocation, l.city, l.state\n" +
"FROM safehouses sh RIGHT OUTER JOIN druglords d ON sh.sfOwnerID = d.druglordID\n" +
"			    INNER JOIN persons p ON p.personID = d.druglordID\n" +
"			    INNER JOIN locations l ON sh.sfLocation = l.zipcode\n" +
"WHERE sh.lastRaid IS NULL;");
         ResultSet result8 = stat8.executeQuery("SELECT NO_OFFENSES.firstName, NO_OFFENSES.lastName, l.city, l.state\n" +
"FROM locations l INNER JOIN (Select *\n" +
"	 		 			From persons p LEFT OUTER JOIN offenses o ON p.personID = o.offenderID\n" +
"	 		 			WHERE o.offenderID IS NULL) AS NO_OFFENSES\n" +
"	 		 			ON l.zipcode = NO_OFFENSES.location\n" +
"WHERE l.state = 'NY'\n" +
"GROUP BY NO_OFFENSES.personID;");
         ResultSet result9 = stat9.executeQuery("SELECT p.firstName, p.lastName, prod.productType, dlp.dlPosQuantityPerGram * prod.pricePerGram AS PROFIT\n" +
"FROM persons p INNER JOIN druglords d ON p.personID = d.druglordID \n" +
"			INNER JOIN dlPossession dlp ON d.druglordID = dlp.dlOwner\n" +
"			INNER JOIN products prod ON dlp.productID = prod.productID\n" +
"WHERE prod.productType = 'Marijuana'AND dlp.dlPosQuantityPerGram >= (SELECT MAX(dlp.dlPosQuantityPerGram) \n" +
"														FROM dlPossession dlp \n" +
"														WHERE dlp.productID = 6);");
         ResultSet result10 = stat10.executeQuery("SELECT firstName, lastName, offenseName, p.address, l.city, l.state, l.zipcode\n" +
"FROM offenses o INNER JOIN persons p ON o.offenderID = p.personID\n" +
"			 INNER JOIN locations l ON l.zipcode = p.location\n" +
"WHERE o.offenseName = 'Theft';");
         ResultSet result11 = stat11.executeQuery("SELECT p.firstName, p.lastName, sub.jobTitle, p.address, loc.city, loc. state, loc.zipcode\n" +
"FROM subordinates sub INNER JOIN persons p ON sub.subordinateID = p.personID\n" +
"				  INNER JOIN locations loc ON loc.zipcode = p.location\n" +
"WHERE sub.jobTitle = 'Transporter' AND loc.state = 'NV';");
         ResultSet result12 = stat12.executeQuery("SELECT CONCAT(p.firstName,' ', p.lastName) AS OWNER, l.labAddress, loc.zipcode, loc.city, loc.state, prod.productType, prod.pricePerGram * lp.labProQuantityPerGram AS PROFIT   \n" +
"FROM laboratories l INNER JOIN labProducts lp ON l.labID = lp.labID\n" +
"				INNER JOIN products prod ON prod.productID = lp.productID\n" +
"				INNER JOIN druglords dl ON l.ownerId = dl.druglordID\n" +
"				INNER JOIN persons p ON p.personID = dl.druglordId\n" +
"				INNER JOIN locations loc ON loc.zipcode = l.labLocation\n" +
"WHERE prod.productType = 'Methamphetamine' AND (prod.pricePerGram * lp.labProQuantityPerGram) >= ALL(SELECT MAX(prod.pricePerGram * lp.labProQuantityPerGram)\n" +
"																				 FROM labProducts lp INNER JOIN products prod ON prod.productID = lp.productID\n" +
"																				 WHERE prod.productType = 'Methamphetamine');");
         ResultSet result13 = stat13.executeQuery("SELECT COUNT(o.offenseName) AS COUNT_OF_PEOPLE_WITH_OFFENSES\n" +
"FROM persons p LEFT OUTER JOIN offenses o ON p.personID = o.offenderID;");
         ResultSet result14 = stat14.executeQuery("SELECT CONCAT(DRUGLORDS_IN_CA.firstName,' ', DRUGLORDS_IN_CA.firstName) AS DRUGLORD, CONCAT(per.firstName,' ', per.lastName) AS SUBORDINATE, per.address, l.city, l.state, l.zipcode\n" +
"FROM subordinates sub INNER JOIN (Select *\n" +
"	 						From locations loc INNER JOIN (Select *\n" +
"						   	 					      From druglords d LEFT OUTER JOIN persons p \n" +
"						   	 						 ON p.personID = d.druglordID) AS DRUG_LORDS ON loc.zipcode = DRUG_LORDS.location		\n" +
"	 						WHERE (loc.state = 'CA')) AS DRUGLORDS_IN_CA ON sub.druglord = DRUGLORDS_IN_CA.druglordID\n" +
"	 			  INNER JOIN persons per ON sub.subordinateID = per.personID\n" +
"	 			  INNER JOIN locations l ON per.location = l.zipcode\n" +
"WHERE(l.state != 'CA');");
         ResultSet result15 = stat15.executeQuery("Select CONCAT(firstName,' ',lastName) AS NAME, pDOB\n" +
"From persons p LEFT OUTER JOIN offenses o ON p.personID = o.offenderID\n" +
"WHERE (o.offenderID IS NULL AND (SELECT YEAR(p.pDOB)) = '1970');");
         
         //stat.execute("DROP TABLE Test");
          /*
          Statement s = conn.createStatement();
          String createtabs = "CREATE TABLE productTypes(\n" +
"	productType	VARCHAR(20)	NOT NULL,\n" +
"	CONSTRAINT pk_product PRIMARY KEY(productType)\n" +
");\n" +
"\n" +
"CREATE TABLE transportation(\n" +
"	transType		VARCHAR(30)	NOT NULL,\n" +
"	CONSTRAINT pk_transType PRIMARY KEY(transType)\n" +
");\n" +
"\n" +
"CREATE TABLE products(\n" +
"	productID		INTEGER		NOT NULL auto_increment,\n" +
"	productType	VARCHAR(20)	NOT NULL,\n" +
"	pricePerGram	DOUBLE		NOT NULL,\n" +
"	CONSTRAINT fk_productName FOREIGN KEY (productType) REFERENCES productTypes(productType),\n" +
"	CONSTRAINT pk_productID PRIMARY KEY (productID),\n" +
"	CONSTRAINT ck_productType UNIQUE (productType)\n" +
");\n" +
"\n" +
"CREATE TABLE states(\n" +
"	name			VARCHAR(2) 	NOT NULL,\n" +
"	CONSTRAINT pk_name PRIMARY KEY (name)\n" +
");\n" +
"\n" +
"CREATE TABLE locations(\n" +
"	zipcode		VARCHAR(10)	NOT NULL,\n" +
"	city			VARCHAR(20)	NOT NULL,\n" +
"	state		VARCHAR(2)	NOT NULL,\n" +
"	CONSTRAINT fk_state FOREIGN KEY (state) REFERENCES states(name),\n" +
"	CONSTRAINT pk_zipcode PRIMARY KEY (zipcode)\n" +
");\n" +
"\n" +
"CREATE TABLE persons (\n" +
"	personID	   	INTEGER 		NOT NULL auto_increment,\n" +
"	firstName    	VARCHAR(20) 	NOT NULL,\n" +
"	lastName     	VARCHAR(20)  	NOT NULL,\n" +
"	pDOB		   	DATE		 	NOT NULL,\n" +
"	location	   	VARCHAR(10)	NOT NULL,			--location is a zipcode of type VARCHAR in case of zip extensions\n" +
"	address	   	VARCHAR(50),  \n" +
"	gender 	   	CHAR(1)      	NOT NULL,\n" +
"	CONSTRAINT genderConstraint check(gender IN ('m', 'f')),\n" +
"	CONSTRAINT pk_PersonID PRIMARY KEY (personID),\n" +
"	CONSTRAINT fk_location FOREIGN KEY(location) REFERENCES locations(zipcode),\n" +
"	CONSTRAINT ck_persons UNIQUE(firstName, lastName, pDOB)\n" +
");\n" +
"\n" +
"CREATE TABLE infoTypes(\n" +
"	infoType		VARCHAR(20)	NOT NULL,\n" +
"	CONSTRAINT pk_infoType PRIMARY KEY(infoType)\n" +
");\n" +
"\n" +
"CREATE TABLE info(\n" +
"	pid			INTEGER		NOT NULL,\n" +
"	infoType		VARCHAR(20)	NOT NULL,\n" +
"	CONSTRAINT fk_informationType FOREIGN KEY (infoType) REFERENCES infoTypes(infoType),\n" +
"	CONSTRAINT fk_pid FOREIGN KEY (pid) REFERENCES persons(personID),\n" +
"	CONSTRAINT pk_info PRIMARY KEY(pid, infoType)\n" +
");\n" +
"\n" +
"CREATE TABLE offenseTypes(\n" +
"	offenseType	VARCHAR(20) 	NOT NULL,\n" +
"	CONSTRAINT pk_offenseType PRIMARY KEY(offenseType)\n" +
");\n" +
"\n" +
"CREATE TABLE offenses(\n" +
"	offenderID	INTEGER		NOT NULL,\n" +
"	offenseName	VARCHAR(20)	NOT NULL,\n" +
"	offenseDate	DATE			NOT NULL,\n" +
"	CONSTRAINT fk_offender FOREIGN KEY (offenderID) REFERENCES persons(personID),\n" +
"	CONSTRAINT fk_offenseName FOREIGN KEY (offenseName) REFERENCES offenseTypes(offenseType),\n" +
"	CONSTRAINT pk_offense PRIMARY KEY(offenderID, offenseName)\n" +
");\n" +
"\n" +
"\n" +
"CREATE TABLE druglords(\n" +
"	druglordID	INTEGER	NOT NULL,\n" +
"	withinUS		CHAR(1)	NOT NULL,\n" +
"	organization	VARCHAR(20),\n" +
"	CONSTRAINT withinUSConstraint check(withinUS IN('t', 'f')),\n" +
"	CONSTRAINT fk_druglordID FOREIGN KEY (druglordID) REFERENCES persons(personID),\n" +
"	CONSTRAINT pk_druglordID PRIMARY KEY (druglordID)\n" +
");\n" +
"\n" +
"CREATE TABLE subordinates(\n" +
"	subordinateID	INTEGER		NOT NULL,\n" +
"	druglord		INTEGER		NOT NULL,\n" +
"	jobTitle		VARCHAR(20)    NOT NULL,\n" +
"	CONSTRAINT titleConstraint check(jobTitle IN ('Safe House Guard', 'Transporter', 'Dealer', 'Body Guard', 'Cook')),\n" +
"	CONSTRAINT fk_subID FOREIGN KEY (subordinateID) REFERENCES persons(personID),\n" +
"	CONSTRAINT fk_dlID FOREIGN KEY (druglord) REFERENCES druglords(druglordID),\n" +
"	CONSTRAINT pk_subID PRIMARY KEY (subordinateID)\n" +
");\n" +
"\n" +
"\n" +
"CREATE TABLE aliases(\n" +
"	dlID			INTEGER     NOT NULL,\n" +
"	alias		VARCHAR(20) NOT NULL,\n" +
"	CONSTRAINT fk_druglord FOREIGN KEY (dlID) REFERENCES druglords(druglordID),\n" +
"	CONSTRAINT pk_alias PRIMARY KEY(dlID, alias)\n" +
");\n" +
"\n" +
"CREATE TABLE laboratories(\n" +
"	ownerID		INTEGER		NOT NULL,\n" +
"	labID		INTEGER		NOT NULL auto_increment,\n" +
"	labRaid		DATE,\n" +
"	labLocation	VARCHAR(10)	NOT NULL,\n" +
"	labAddress	VARCHAR(50)	NOT NULL,\n" +
"	CONSTRAINT fk_ownerID FOREIGN KEY (ownerID) REFERENCES druglords(druglordID),\n" +
"	CONSTRAINT fk_labLocation FOREIGN KEY (labLocation) REFERENCES locations(zipcode),\n" +
"	CONSTRAINT pk_labID PRIMARY KEY (labID)\n" +
");\n" +
"\n" +
"CREATE TABLE safehouses(\n" +
"	sfOwnerID		INTEGER			NOT NULL,\n" +
"	sfID			INTEGER		NOT NULL auto_increment,	\n" +
"	sfLocation	VARCHAR(10)	NOT NULL,\n" +
"	sfAddress		VARCHAR(50)	NOT NULL,\n" +
"	lastRaid		DATE,		\n" +
"	CONSTRAINT fk_sfOwnerID FOREIGN KEY (sfOwnerID) REFERENCES druglords(druglordID),\n" +
"	CONSTRAINT fk_sfLocation FOREIGN KEY (sfLocation) REFERENCES locations(zipcode),\n" +
"	CONSTRAINT pk_sfID PRIMARY KEY (sfID)\n" +
");\n" +
"\n" +
"CREATE TABLE labProducts(\n" +
"	labID		INTEGER		NOT NULL,\n" +
"	productID		INTEGER		NOT NULL,\n" +
"	labProQuantityPerGram	INT,					\n" +
"	CONSTRAINT fk_labID FOREIGN KEY (labID) REFERENCES laboratories(labID),\n" +
"	CONSTRAINT fk_productID FOREIGN KEY (productID) REFERENCES products(productID),\n" +
"	CONSTRAINT pk_labProducts PRIMARY KEY (labID, productID)\n" +
");\n" +
"\n" +
"CREATE TABLE dlPossession(\n" +
"	dlOwner		INT		NOT NULL,\n" +
"	productID		INT		NOT NULL,\n" +
"	dlPosQuantityPerGram	INT,								--dlPosQuantity is quantity of drugs possessed in gram\n" +
"	CONSTRAINT fk_dlOwner FOREIGN KEY (dlOwner) REFERENCES druglords(druglordID),\n" +
"	CONSTRAINT fk_product FOREIGN KEY (productID) REFERENCES products(productID),\n" +
"	CONSTRAINT pk_dlPossession PRIMARY KEY (dlOwner, productID)\n" +
");\n" +
"\n" +
"\n" +
"CREATE TABLE shPossession(\n" +
"	sfID			INT		NOT NULL,\n" +
"	productID		INT		NOT NULL,\n" +
"	sfQuantityPerGram	INT,\n" +
"	sfTransType	VARCHAR(20),	\n" +
"	CONSTRAINT fk_sf FOREIGN KEY (sfID) REFERENCES safehouses(sfID),\n" +
"	CONSTRAINT fk_products FOREIGN KEY (productID) REFERENCES products(productID),\n" +
"	CONSTRAINT pk_shPossession PRIMARY KEY(sfID, productID)\n" +
");";
          s.addBatch(createtabs);
          s.executeBatch();
          */
          //Statement
      }
      finally
      {
         conn.close();
      }
   }
}
