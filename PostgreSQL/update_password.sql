-- SELECT * FROM "CourseTemplateItem" ORDER BY "CourseTemplateId", "SessionId", "OrdinalNum"
-- 
-- ================================
-- Author: Hưng Phạm
-- SELECT * FROM update_password(1, '1234', 'abc')
CREATE OR REPLACE FUNCTION update_password(
	p_account_id INT,
	p_pass_old VARCHAR,
	p_pass_new VARCHAR
)
RETURNS TABLE(
	"Id" INT,
	"Message" VARCHAR
) AS $BODY$
DECLARE
	v_id INT;
	v_mess VARCHAR;
BEGIN
	
		IF p_pass_old = (SELECT "Password" FROM "Account" WHERE "AccountId" = p_account_id) THEN
				UPDATE "Account"
				SET "Password" = p_pass_new
				WHERE "AccountId" = p_account_id;
				v_id = p_account_id;
				v_mess = 'Successful';
		ELSE
			v_id := 0;
			v_mess := 'Fail';
		END IF;
	
	RETURN QUERY 
	SELECT v_id, v_mess;
	EXCEPTION WHEN OTHERS THEN
	BEGIN
		v_id := -1;
		v_mess := sqlerrm;
		RETURN QUERY
		SELECT v_id, v_mess;
	END;
END;
$BODY$
LANGUAGE plpgsql;