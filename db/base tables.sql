-- user info
create table users ( 
	user_id int NOT NULL AUTO_INCREMENT,
	firstname varchar(50), 
	lastname varchar(50), 
	username varchar(255) NOT NULL, 
	password varchar(255) NOT NULL, 
	date_created datetime DEFAULT CURRENT_TIMESTAMP, 
	date_updated datetime DEFAULT NULL ON UPDATE current_timestamp, 
	date_deleted datetime DEFAULT NULL, 
	PRIMARY KEY ( user_id ) 
);

--  these are localized app themes (managed internally for now)
create table app_themes ( 
	app_theme_id int NOT NULL AUTO_INCREMENT,
	primary_color varchar(20),
	secondary_color varchar(20),
	date_updated datetime DEFAULT NULL ON UPDATE current_timestamp, 
	PRIMARY KEY ( app_theme_id ) 
);
create table user_prefences ( 
	user_prefrence_id int NOT NULL AUTO_INCREMENT,
	user_id int NOT NULL,
	app_theme_id int NOT NULL,
	date_updated datetime DEFAULT NULL ON UPDATE current_timestamp, 
    primary key(user_prefrence_id),
	CONSTRAINT user_id_fk FOREIGN KEY ( user_id ) REFERENCES users(user_id),
	CONSTRAINT app_theme_id_fk FOREIGN KEY ( app_theme_id ) REFERENCES app_themes(app_theme_id)
);

--  these are localized app themes (managed externally)
create table web_themes ( 
	web_theme_id int NOT NULL AUTO_INCREMENT,
	theme varchar(255),
	associated_url varchar(255),
	date_created datetime DEFAULT CURRENT_TIMESTAMP, 
	date_updated datetime DEFAULT NULL ON UPDATE current_timestamp, 
	date_deleted datetime DEFAULT NULL, 
	PRIMARY KEY ( web_theme_id )
);
create table subscriptions ( 
	subscription_id int NOT NULL AUTO_INCREMENT,
	user_id int NOT NULL,
	web_theme_id int NOT NULL,
	date_created datetime DEFAULT CURRENT_TIMESTAMP, 
	date_updated datetime DEFAULT NULL ON UPDATE current_timestamp, 
	date_deleted datetime DEFAULT NULL, 
    primary key(subscription_id),
	FOREIGN KEY ( user_id ) REFERENCES users(user_id),
    CONSTRAINT web_theme_id_fk FOREIGN KEY ( web_theme_id ) REFERENCES web_themes(web_theme_id)
);


