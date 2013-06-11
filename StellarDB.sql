create table StellarObject(
  objectID VARCHAR(20) NOT NULL,
	objectName VARCHAR(20),
	CONSTRAINT pk_StellarObject PRIMARY KEY (objectID)
);

create table System(
	systemID   VARCHAR(20) NOT NULL,
	systemName VARCHAR(20),
	systemType VARCHAR(20),
	CONSTRAINT pk_System PRIMARY KEY (systemID)
);

--create table JunctionSystemStars(
	--
--);

create table Star(
	starID VARCHAR(20) NOT NULL,
	clusterID VARCHAR(20) NOT NULL,
	CONSTRAINT pk_Star PRIMARY KEY (starID),
	CONSTRAINT fk_StarObject FOREIGN KEY (starID) REFERENCES StellarObject(objectID),
	CONSTRAINT fk_StarCluster FOREIGN KEY (clusterID) REFERENCES System(systemID)
);

create table Planet(
	planetID VARCHAR(20) NOT NULL,
	parentStarID VARCHAR(20) NOT NULL,
	CONSTRAINT pk_Planet PRIMARY KEY (planetID),
	CONSTRAINT fk_PlanetObject FOREIGN KEY (planetID) REFERENCES StellarObject(objectID),
	CONSTRAINT fk_PlanetStar FOREIGN KEY (parentStarID) REFERENCES Star(starID)
);

create table Satallite(
	satalliteID VARCHAR(20) NOT NULL,
	parentPlanetID VARCHAR(20) NOT NULL,
	CONSTRAINT pk_Satallite PRIMARY KEY (satalliteID),
	CONSTRAINT fk_SatalliteObject FOREIGN KEY (planetID) REFERENCES StellarObject(objectID),
	CONSTRAINT fk_SatallitePlanet FOREIGN KEY (parentStarID) REFERENCES Star(starID)
);

create table Details(
	objectID VARCHAR(20) NOT NULL,
	age	Double,
	dateOfDiscovery Date,
	details VARCHAR(500),
	CONSTRAINT pk_Details PRIMARY KEY (objectID),
	CONSTRAINT fk_DetailsObject FOREIGN KEY (objectID) REFERENCES StellarObject(objectID)
);

DELIMITER $$

DROP TRIGGER IF EXISTS InsertIntoLocation $$

CREATE TRIGGER InsertIntoLocation BEFORE INSERT ON Location FOR EACH ROW BEGIN
  IF new.yPercentFromOrigin > 100.0;
  THEN
    SET new.relationship_level = 100.0;
  END IF;
  IF new.yPercentFromOrigin < 0.00;
  THEN
    SET new.relationship_level = 0.00;
  END IF;
  
END $$

DELIMITER ;

DROP TRIGGER IF EXISTS UpdateIntoLocation $$

CREATE TRIGGER UpdateIntoLocation BEFORE UPDATE ON Location FOR EACH ROW BEGIN
  IF new.yPercentFromOrigin > 100.0;
  THEN
    SET new.relationship_level = 100.0;
  END IF;
  IF new.yPercentFromOrigin < 0.00;
  THEN
    SET new.relationship_level = 0.00;
  END IF;
END $$

DELIMITER ;


create table Location(
	locationID VARCHAR(20) NOT NULL,
	degreeX Double, -- N = 90 S = 270 E = 0 or 360 W = 180 
	yPercentFromOrigin Double,
	CONSTRAINT pf_Location PRIMARY KEY (locationID),
	CONSTRAINT fk_LocationObject FOREIGN KEY (locationID) REFERENCES StellarObject(objectID)
);

create table NorthHemiSphere(
	locationID VARCHAR(20) NOT NULL,
	CONSTRAINT pk_NorthHemiSphere PRIMARY KEY (locationID),
	CONSTRAINT fk_NorthHemiSphere FOREIGN KEY (locationID) REFERENCES Location(locationID),
	CONSTRAINT fk_NorthHemiSphereObject FOREIGN KEY (locationID) REFERENCES StellarObject(objectID)
);

create table SouthHemiSphere(
	locationID VARCHAR(20) NOT NULL,
	CONSTRAINT pk_SouthHemiSphere PRIMARY KEY (locationID),
	CONSTRAINT fk_SouthHemiSphere FOREIGN KEY (locationID) REFERENCES Location(locationID),
	CONSTRAINT fk_SouthHemiSphereObject FOREIGN KEY (locationID) REFERENCES StellarObject(objectID)
);
