CREATE DATABASE signin;
\c signin;

CREATE TABLE IF NOT EXISTS users(
 id SERIAL PRIMARY KEY,
 name VARCHAR,
 email VARCHAR,
 registerDate TIMESTAMP,
 password VARCHAR,
 cohortId int,
 modulee VARCHAR,
 role VARCHAR
 );

CREATE TABLE IF NOT EXISTS cohort(
 id SERIAL PRIMARY KEY,
name VARCHAR,
modulee VARCHAR,
startDate TIMESTAMP,
endDate TIMESTAMP
);

CREATE TABLE IF NOT EXISTS attendance(
 id SERIAL PRIMARY KEY,
 datee TIMESTAMP,
 userId VARCHAR,
 cohortId VARCHAR,
 signInTime TIMESTAMP,
 score int,
 attDate VARCHAR,
 deviceId VARCHAR,
 timein VARCHAR,
 lateIn VARCHAR,
 timeout VARCHAR
);

CREATE DATABASE signin_test WITH TEMPLATE signin;
