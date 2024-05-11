CREATE OR REPLACE FUNCTION update_bus_total_seat_empty()
RETURNS TRIGGER AS $$
DECLARE
		v_total_seat_empty INT;
		v_bus_id INT;
BEGIN
		
		SELECT B."BusId"
		INTO v_bus_id
		FROM "Reservation" R INNER JOIN "Bus" B ON R."BusId" = B."BusId"
		WHERE R."ReservationId" = NEW."ReservationId";
		WITH tmp AS
		(
			SELECT
        S."SeatId",
        S."SeatName",
        CASE
            WHEN S."SeatId" IN (
                SELECT UNNEST("ListSeatId"::INT[])
                FROM "Invoice" I 
                INNER JOIN "Reservation" R ON I."ReservationId" = R."ReservationId"
                WHERE "IsPayed" = TRUE
                AND R."BusId" = v_bus_id
            ) THEN TRUE
            ELSE FALSE
        END AS "Check"
				FROM "Bus" B 
				INNER JOIN "Seat" S ON B."BusTypeId" = S."BusTypeId"
				WHERE B."BusId" = v_bus_id
		)
		SELECT count(*)
		INTO v_total_seat_empty
		FROM tmp T
		WHERE T."Check" IS FALSE;
		
		UPDATE "Bus"
		SET "TotalSeatEmpty" = v_total_seat_empty
		WHERE "BusId" = v_bus_id;
		RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_total_seat_empty_trigger
AFTER INSERT OR UPDATE ON "Invoice"
FOR EACH ROW
EXECUTE FUNCTION update_bus_total_seat_empty();