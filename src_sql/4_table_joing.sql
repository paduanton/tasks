/*TABLE COLUMNS 
------------------ ------------------------------- ----------------------------- 
SUPPLIER
 SUPPLIER_CODE, SUPPLIER_NAME, CITY 

PART

 CODE_PART, NAME_PART, PRICE 
CAR 
CODE_CAR, NAME_CAR, TYPE 

SUPPLY 
CODE_SUPPLIER, CODE_PIECE, CODE_CAR 

Write an SQL command that is able to query the suppliers located in the city named “VITORIA” that provide the part code 
“MOTOR” for the car coded “KOMBI”, with their respective prices. 

Example: 
SUPPLIER PRICE 
---------------- 
Supplier A 1,000 
Supplier B 1,500
*/
------------------------------------------------------------------------------------------ 


-- DATABASE DUMP:

CREATE TABLE `CAR` (
  `CODE_CAR` int NOT NULL,
  `NAME_CAR` varchar(500) NOT NULL,
  `TYPE` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `CAR` (`CODE_CAR`, `NAME_CAR`, `TYPE`) VALUES
(1, 'KOMBI', 'CAR');


CREATE TABLE `PART` (
  `CODE_PART` int NOT NULL,
  `NAME_PART` varchar(500) NOT NULL,
  `PRICE` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `PART` (`CODE_PART`, `NAME_PART`, `PRICE`) VALUES
(1, 'MOTOR', 1000),
(2, 'MOTOR', 1500);

CREATE TABLE `SUPPLIER` (
  `SUPPLIER_CODE` int UNSIGNED NOT NULL,
  `SUPPLIER_NAME` varchar(500) NOT NULL,
  `CITY` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `SUPPLIER` (`SUPPLIER_CODE`, `SUPPLIER_NAME`, `CITY`) VALUES
(1, 'A', 'VITORIA'),
(2, 'B', 'VITORIA');
CREATE TABLE `SUPPLY` (
  `CODE_SUPPLIER` int NOT NULL,
  `CODE_PIECE` int NOT NULL,
  `CODE_CAR` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `SUPPLY` (`CODE_SUPPLIER`, `CODE_PIECE`, `CODE_CAR`) VALUES
(1, 1, 1),
(2, 2, 1);
ALTER TABLE `CAR`
  ADD PRIMARY KEY (`CODE_CAR`);

ALTER TABLE `PART`
  ADD PRIMARY KEY (`CODE_PART`);

ALTER TABLE `SUPPLIER`
  ADD PRIMARY KEY (`SUPPLIER_CODE`);
COMMIT;

select 
	supplier.SUPPLIER_NAME, part.PRICE 
    from SUPPLY supply 
    left outer join PART part
    	on part.CODE_PART=supply.CODE_PIECE 
    left outer join CAR car
    	on car.CODE_CAR=supply.CODE_CAR
    left outer join SUPPLIER supplier 
    	on supplier.SUPPLIER_CODE=supply.CODE_SUPPLIER
    where 
	    supplier.CITY='VITORIA'
    	AND car.NAME_CAR='KOMBI'
        AND part.NAME_PART='MOTOR';
