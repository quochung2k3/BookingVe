/*
	SELECT * FROM check_login_user('pqh29052003@gmail.com', '123')
*/
CREATE OR REPLACE FUNCTION check_login_user
(
	p_user_name VARCHAR,
	p_pass_work VARCHAR
)
RETURNS TABLE (
	"CHECK" BOOL
) AS $BODY$
DECLARE 
	v_check INT;
BEGIN
	SELECT count(*)
	INTO v_check
	FROM "Account"
	WHERE "Username" = p_user_name
	AND "Password" = p_pass_work
	AND "IsActice" IS TRUE;
	
	IF v_check = 1 THEN
		RETURN QUERY
				SELECT TRUE;
	ELSE
		RETURN QUERY
				SELECT FALSE;
	END IF;
	
END;
$BODY$
LANGUAGE plpgsql VOLATILE