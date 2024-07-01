/*
	Hưng Phạm
	SELECT * FROM get_list_place()
*/
CREATE OR REPLACE FUNCTION get_list_place
(

)
RETURNS TABLE(
	"PlaceId" INT,
	"PlaceName" VARCHAR
) AS $BODY$
BEGIN

	RETURN QUERY
	SELECT * FROM "Place";
	
END;
$BODY$
LANGUAGE plpgsql VOLATILE