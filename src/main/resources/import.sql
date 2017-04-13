--this will be executed as part of the database initialization process.

--This will insert some data in AddressModel table of 1st schema

INSERT INTO system.ADDRESSMODEL (ID, CITY, NO, STREET ) VALUES (1, 'SURAT', '9876543210' , 'st1' );
INSERT INTO system.ADDRESSMODEL (ID, CITY, NO, STREET ) VALUES (2, 'ADI', '2568974130' , 'st2' );
INSERT INTO system.ADDRESSMODEL (ID, CITY, NO, STREET ) VALUES (3, 'GOA', '4978562310' , 'st3' );
INSERT INTO system.ADDRESSMODEL (ID, CITY, NO, STREET ) VALUES (4, 'ABU', '1234567890' , 'st4' );

--This will insert some data in AddressModel2 table of 2nd schema

INSERT INTO system2.ADDRESSMODEL2 (ID, CITY, NO, STREET ) VALUES (5, 'ST', '3q1561s2' , '4q514236' );
INSERT INTO system2.ADDRESSMODEL2 (ID, CITY, NO, STREET ) VALUES (6, 'AS', 'djkak2ksk' , 'sadjlkwe' );
INSERT INTO system2.ADDRESSMODEL2 (ID, CITY, NO, STREET ) VALUES (7, 'FFD', '23141739812' , 'sdadad' );
INSERT INTO system2.ADDRESSMODEL2 (ID, CITY, NO, STREET ) VALUES (8, 'DDS', 'se90823je' , '135126' );