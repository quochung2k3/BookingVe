/*
	Hưng Phạm
	SELECT * FROM get_list_seat_by_bus_id(1)
*/
-- DROP FUNCTION get_list_seat_by_bus_id
CREATE OR REPLACE FUNCTION get_list_seat_by_bus_id
(
    p_bus_id INT
)
RETURNS TABLE(
    "SeatId" INT,
    "SeatName" VARCHAR,
    "Check" BOOL
) AS $BODY$
BEGIN
    RETURN QUERY
    SELECT
        S."SeatId",
        S."SeatName",
        CASE
            WHEN S."SeatId" IN (
                SELECT UNNEST("ListSeatId")
                FROM "Invoice" I 
                INNER JOIN "Reservation" R ON I."ReservationId" = R."ReservationId"
                WHERE "IsPayed" = TRUE
                AND R."BusId" = p_bus_id
            ) THEN TRUE
            ELSE FALSE
        END AS "Check"
    FROM "Bus" B 
    INNER JOIN "Seat" S ON B."BusTypeId" = S."BusTypeId"
    WHERE B."BusId" = p_bus_id;
END;
$BODY$
LANGUAGE plpgsql VOLATILE;