/*
	Hưng Phạm
	SELECT * FROM get_list_seat_by_bus_id(1)
*/
CREATE OR REPLACE FUNCTION get_list_seat_by_bus_id
(
	p_bus_id INT
)
RETURNS TABLE(
	"SeatId" INT,
	"SeatName" VARCHAR,
	"Price" INT
) AS $BODY$
DECLARE 
	v_title_ids INT[];
BEGIN

	RETURN QUERY
	SELECT
		s."SeatId",
		s."SeatName",
		st."Price"
	FROM "Bus" b INNER JOIN "Seat" s ON b."BusTypeId" = s."BusTypeId"
	INNER JOIN "SeatType" st ON s."SeatTypeId" = st."SeatTypeId"
	WHERE b."BusId" = p_bus_id;
	
END;
$BODY$
LANGUAGE plpgsql VOLATILE