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
	"SeatName" VARCHAR
) AS $BODY$
DECLARE 
	
BEGIN

	RETURN QUERY
	SELECT
		S."SeatId",
		S."SeatName"
	FROM "Bus" B INNER JOIN "Seat" S ON B."BusTypeId" = S."BusTypeId"
	WHERE B."BusId" = p_bus_id
	AND S."SeatId" NOT IN (
		SELECT UNNEST("ListSeatId")
		FROM "Invoice" I INNER JOIN "Reservation" R ON I."ReservationId" = R."ReservationId"
		WHERE "IsPayed" = TRUE
		AND R."BusId" = p_bus_id
	);
	
END;
$BODY$
LANGUAGE plpgsql VOLATILE