-- SELECT * FROM "CourseTemplateItem" ORDER BY "CourseTemplateId", "SessionId", "OrdinalNum"
-- 
-- ================================
-- Author: Hưng Phạm
-- SELECT * FROM update_info(1, 'Phạm Quốc Hưng', '0376762125', 'Q9 - TP.HCM')
CREATE OR REPLACE FUNCTION update_info(
	p_user_id INT,
	p_full_name VARCHAR,
	p_sdt VARCHAR,
	p_address VARCHAR
)
RETURNS TABLE(
	"Id" INT,
	"Message" VARCHAR
) AS $BODY$
DECLARE
	v_id INT;
	v_mess VARCHAR;
BEGIN
	
	UPDATE "User"
	SET "FullName" = p_full_name,
			"SDT" = p_sdt,
			"Address" = p_address
	WHERE "UserId" = p_user_id;
	v_id := p_user_id;
	v_mess := 'Successful';
	
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