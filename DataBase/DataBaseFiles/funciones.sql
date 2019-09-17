
CREATE PROCEDURE insertAccord(
IN accNumber VARCHAR(45), IN incorDate DATE, 
IN deadLine DATE, IN sessionDate DATE, IN types
VARCHAR(45), IN observations longtext, IN publics TINYINT(4),
IN notified TINYINT(4), IN states CHAR(1), IN office VARCHAR(45) 
)
BEGIN
INSERT INTO T_ACCORD (ACCNUMBER, INCORDATE, 
DEADLINE, SESSIONDATE, TYPE, OBSERVATIONS, PUBLIC, NOTIFIED,  STATE,
OFFICE) VALUES (accNumber, incorDate, deadLine, sessionDate, types, observations, publics,
notified, states, office);
END;
