/*
	Hưng Phạm
	SELECT * FROM cmr_user_get_list_consultant_booking(11)
*/
SELECT dropallfunction_byname('cmr_user_get_list_consultant_booking');
CREATE OR REPLACE FUNCTION cmr_user_get_list_consultant_booking
(
	p_user_id INT;
)
RETURNS TABLE(
	"UserId" INT,
	"FullName" VARCHAR
) AS $BODY$
DECLARE 
	v_title_ids INT[];
BEGIN

	RETURN QUERY
	
END;
$BODY$
LANGUAGE plpgsql VOLATILE